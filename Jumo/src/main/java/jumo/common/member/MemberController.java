package jumo.common.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jumo.model.CommunityBean;
import jumo.model.MemberBean;
import jumo.model.OrderBean;

import jumo.util.MapToBean;
import jumo.util.validator.MemberValidator;

@Controller
public class MemberController {
	
	@Resource(name="joinService")
	private JoinService joinService;
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	@Resource(name="myInfoService")
	private MyInfoService myInfoService;

	@RequestMapping(value = "/joinForm.al")
	public String joinForm (Model model) {
	
		return "joinForm";
	}
	
	@RequestMapping(value = "/confirmId.al")
	public String conformId(MemberBean member, Model model) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();
		
		map = joinService.selectMemberId(member);
		
		memberBean = MapToBean.mapToMember(map);
		
		model.addAttribute("memberBean", memberBean);
		
		return "/member/confirmId";
	}
	
	@RequestMapping(value = "/joinSuccess.al")
	public String joinSuccess (MemberBean member, BindingResult result,
			Model model) throws Exception {
		
		new MemberValidator().validate(member, result);
		
		if(result.hasErrors()) {
			return "/joinForm.al";
		}
		
		joinService.insertMember(member);
		
		return "/member/joinSuccess";
	}	
	
	@RequestMapping(value = "/loginForm.al")
	public String loginForm (Model model) throws Exception {
		return "loginForm";
	}
	
	@RequestMapping(value = "/login.al")
	public String login (MemberBean member, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();
		
		map = loginService.selectMemberId(member);
		
		memberBean = MapToBean.mapToMember(map);
		
		model.addAttribute("memberBean", memberBean);
		
		return "/member/login";
	}
	
	@RequestMapping(value = "/logout.al")
	public String logout (Model model) throws Exception {
		return "/member/logout";
	}
	
	@RequestMapping(value = "/findId.al")
	public String findId (Model model) throws Exception {
		return "findId";
	}
	
	@RequestMapping(value = "/findIdResult.al")
	public String findIdResult (MemberBean member, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();
		
		memberBean = MapToBean.mapToMember(map);
		
		map = loginService.selectMemberJumin(member);
		
		model.addAttribute("memberBean", memberBean);
		
		return "findIdResult";
	}
	
	@RequestMapping(value = "/findPw.al")
	public String findPw (Model model) throws Exception {
		return "findPw";
	}
	
	@RequestMapping(value = "/findPwResult.al")
	public String findPwResult (MemberBean member, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();
		
		memberBean = MapToBean.mapToMember(map);
		
		map = loginService.selectMemberJumin(member);
		
		model.addAttribute("memberBean", memberBean);
		
		return "findPwResult";
	}
		
	@RequestMapping(value = "/myPage.al")
	public String myPage (Model model) throws Exception {
		return "myPage";
	}
	
	@RequestMapping(value = "/myInfoModifyForm.al")
	public String myInfoModifyForm (MemberBean member, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
			// memberBean을 세션으로 입력받도록 변환
		MemberBean memberBean = new MemberBean();
		
		memberBean = MapToBean.mapToMember(map);
		
		map = myInfoService.selectMemberId(member);
		
		model.addAttribute("memberBean", memberBean);
		
		return "myInfoModifyForm";
	}
	
	@RequestMapping(value = "/myInfoModify.al")
	public String myInfoModify (MemberBean member, BindingResult result, 
			Model model) throws Exception {
		
		new MemberValidator().validate(member, result);
		
		if(result.hasErrors()) {
			return "/myInfoModifyForm.al";
		}
		
		myInfoService.updateMember(member);
		
		return "/member/myInfoModify";
	}
	
	@RequestMapping(value = "/myInfoDelete.al")
	public String myInfoDelete (MemberBean member, Model model) throws Exception {
		
		myInfoService.deleteMember(member);
		
		return "/member/myInfoDelete";
	}
	
	@RequestMapping(value = "/myInfoQna.al")
	public String myInfoQna (MemberBean member, Model model) throws Exception {
		List<Map<String, Object>> list = myInfoService.selectQnaMemberId(member);
	
		List<CommunityBean> qnaBeanList = new ArrayList<CommunityBean>();
	
		for(Map<String, Object> mapObject : list) {
			qnaBeanList.add(MapToBean.mapToCommunity(mapObject));
		}
	
		model.addAttribute("qnaBeanList", qnaBeanList);
		
		return "myInfoQna";
	}
	
	@RequestMapping(value = "/myInfoReview.al")
	public String myInfoReview (MemberBean member, Model model) throws Exception {
		List<Map<String, Object>> list = myInfoService.selectReviewMemberId(member);
	
		List<CommunityBean> reviewBeanList = new ArrayList<CommunityBean>();

		for(Map<String, Object> mapObject : list) {
			reviewBeanList.add(MapToBean.mapToCommunity(mapObject));
		}

		model.addAttribute("reviewBeanList", reviewBeanList);
		
		return "myInfoReview";
	}
	
	@RequestMapping(value = "/myInfoOrder.al")
	public String myInfoOrder (MemberBean member, Model model) throws Exception {
		List<Map<String, Object>> list = myInfoService.selectOrderMemberId(member);
	
		List<OrderBean> orderBeanList = new ArrayList<OrderBean>();

		for(Map<String, Object> mapObject : list) {
			orderBeanList.add(MapToBean.mapToOrder(mapObject));
		}

		model.addAttribute("orderBeanList", orderBeanList);
		
		return "myInfoOrder";
	}
	
}
