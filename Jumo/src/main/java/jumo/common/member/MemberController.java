package jumo.common.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jumo.model.CommunityBean;
import jumo.model.MemberBean;
import jumo.model.OrderBean;

import jumo.util.MapToBean;

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
	
		return "member/joinForm";
	}
	
	@RequestMapping(value = "/confirmId.al")
	public String conformId(MemberBean member, Model model) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();
		
		map = joinService.selectMemberId(member);
		
		memberBean = MapToBean.mapToMember(map);
		
		return "member/confirmId";
	}
	
	@RequestMapping(value = "/joinSuccess.al")
	public String joinSuccess (MemberBean member, Model model) throws Exception {
		
		joinService.insertMember(member);
		
		return "member/joinSuccess";
	}
	
	
	
	@RequestMapping(value = "/loginForm.al")
	public String loginForm (Model model) throws Exception {
		return "member/loginForm";
	}
	
	@RequestMapping(value = "/login.al")
	public String login (MemberBean member, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();
		
		map = loginService.selectMemberId(member);
		
		memberBean = MapToBean.mapToMember(map);
		
		return "member/login";
	}
	
	@RequestMapping(value = "/logout.al")
	public String logout (Model model) throws Exception {
		return "member/logout";
	}
	
	@RequestMapping(value = "/findId.al")
	public String findId (Model model) throws Exception {
		return "member/findId";
	}
	
	@RequestMapping(value = "/findIdResult.al")
	public String findIdResult (MemberBean member, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();
		
		memberBean = MapToBean.mapToMember(map);
		
		map = loginService.selectMemberJumin(member);
		
		return "member/findIdResult";
	}
	
	@RequestMapping(value = "/findPw.al")
	public String findPw (Model model) throws Exception {
		return "member/findPw";
	}
	
	@RequestMapping(value = "/findPwResult.al")
	public String findPwResult (MemberBean member, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();
		
		memberBean = MapToBean.mapToMember(map);
		
		map = loginService.selectMemberJumin(member);
		
		return "member/findPwResult";
	}
		
	@RequestMapping(value = "/myPage.al")
	public String myPage (Model model) throws Exception {
		return "member/myPage";
	}
	
	@RequestMapping(value = "/myInfoModifyForm.al")
	public String myInfoModifyForm (MemberBean member, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();
		
		memberBean = MapToBean.mapToMember(map);
		
		map = myInfoService.selectMemberId(member);
		
		return "member/myInfoModifyForm";
	}
	
	@RequestMapping(value = "/myInfoModify.al")
	public String myInfoModify (MemberBean member, Model model) throws Exception {
		
		myInfoService.updateMember(member);
		
		return "member/myInfoModify";
	}
	
	@RequestMapping(value = "/myInfoDelete.al")
	public String myInfoDelete (MemberBean member, Model model) throws Exception {
		
		myInfoService.deleteMember(member);
		
		return "member/myInfoDelete";
	}
	
	@RequestMapping(value = "/myInfoQna.al")
	public String myInfoQna (MemberBean member, Model model) throws Exception {
		List<Map<String, Object>> list = myInfoService.selectQnaMemberId(member);
	
		List<CommunityBean> qnaBeanList = new ArrayList<CommunityBean>();
	
		for(Map<String, Object> mapObject : list) {
			qnaBeanList.add(MapToBean.mapToCommunity(mapObject));
		}
	
		model.addAttribute("qnaBeanList", qnaBeanList);
		
		return "member/myInfoQna";
	}
	
	@RequestMapping(value = "/myInfoReview.al")
	public String myInfoReview (MemberBean member, Model model) throws Exception {
		List<Map<String, Object>> list = myInfoService.selectReviewMemberId(member);
	
		List<CommunityBean> reviewBeanList = new ArrayList<CommunityBean>();

		for(Map<String, Object> mapObject : list) {
			reviewBeanList.add(MapToBean.mapToCommunity(mapObject));
		}

		model.addAttribute("reviewBeanList", reviewBeanList);
		
		return "member/myInfoReview";
	}
	
	@RequestMapping(value = "/myInfoOrder.al")
	public String myInfoOrder (MemberBean member, Model model) {
		List<Map<String, Object>> list = myInfoService.selectOrderMemberId(member);
	
		List<OrderBean> orderBeanList = new ArrayList<OrderBean>();

		for(Map<String, Object> mapObject : list) {
			orderBeanList.add(MapToBean.mapToOrder(mapObject));
		}

		model.addAttribute("orderBeanList", orderBeanList);
		
		return "member/myInfoOrder";
	}
	
}
