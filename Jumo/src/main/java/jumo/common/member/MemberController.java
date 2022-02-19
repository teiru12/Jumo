package jumo.common.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		
		map = joinService.selectMemberId(member);
		
		   if(map != null) {
		         // 중복된 아이디 있음
		         model.addAttribute("msg", "이 아이디는 사용하실 수 없습니다.");
		         model.addAttribute("url", "/joinForm.al");
		   } else {
			   //중복된 아이디 없음
			   model.addAttribute("msg", "사용할 수 있는 아이디입니다.");
			   model.addAttribute("url", "/joinForm.al");
		   }
		
		return "/member/confirmId";
	}
	
	@RequestMapping(value = "/joinSuccess.al")
	public String joinSuccess (MemberBean member, BindingResult result,
			Model model) throws Exception {
		
		new MemberValidator().validate(member, result);
		
		if(result.hasErrors()) {
			//회원가입 실패
			model.addAttribute("msg", "회원가입에 실패했습니다.");
			model.addAttribute("url", "/joinForm.al");
		}
	
		Map<String, Object> map = joinService.selectMemberId(member);
		
		if(map != null) {
			//중복회원 가입시 실패
			model.addAttribute("msg", "이미 가입된 아이디입니다.");
			model.addAttribute("url", "/joinForm.al");
			
		} else {
			//회원가입 성공
			joinService.insertMember(member);
			
			model.addAttribute("msg", "회원가입에 성공했습니다.");
			model.addAttribute("url", "/loginForm.al");
		}
		
		return "/member/joinSuccess";
	}
	
	@RequestMapping(value = "/loginForm.al")
	public String loginForm (Model model) throws Exception {
		return "loginForm";
	}
	
	@RequestMapping(value = "/login.al")
	public String login (MemberBean member, HttpSession session, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();
		
		map = loginService.selectMemberId(member);
		
		if(map == null) {
			// 로그인 실패
			model.addAttribute("msg", "회원을 찾을 수 없습니다.");
			model.addAttribute("url", "/loginForm.al");
		} else { 
			memberBean = MapToBean.mapToMember(map); // 검색된 회원

			// 비밀번호 체크
			if(member.getPASSWORD().equals(memberBean.getPASSWORD())) {
				// 로그인 성공
				
				// 정지유무 체크
				if(memberBean.getBLOCK().equals("Y")) {
					model.addAttribute("msg", "정지된 회원입니다.");
					model.addAttribute("url", "/loginForm.al");
					return "/member/login";
				}
				
				// 세션 등록
				session.setAttribute("EMAIL", memberBean.getEMAIL());
				
				// 관리자 체크
				if(memberBean.getEMAIL().equals("ADMIN")) {
					model.addAttribute("url", "/adminMain.al");
				} else {
					model.addAttribute("url", "/main.al");
				}
			} else { 
				// 비밀번호 틀림 
				model.addAttribute("msg", "비밀번호가 틀립니다.");
				model.addAttribute("url", "/loginForm.al");
			}
		}
		return "/member/login";
	}
	
	@RequestMapping(value = "/logout.al")
	public String logout (HttpServletRequest request, Model model) throws Exception {
		
		request.getSession().invalidate();
		
		model.addAttribute("msg", "로그아웃 하셨습니다.");
		model.addAttribute("url", "/loginForm.al");
		
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
		
		map = loginService.selectMemberJumin(member);
		
		  if(map == null) {
			model.addAttribute("Find","notFound");
		  }
		  else {
			  memberBean = MapToBean.mapToMember(map);
	
			  if(member.getNAME().equals(memberBean.getNAME())) {
				  model.addAttribute("memberBean", memberBean);
			  }
			  else {
				  model.addAttribute("Find","invalidName");
			  }
		  }
		return "/member/findIdResult";
	}
	
	@RequestMapping(value = "/findPw.al")
	public String findPw (Model model) throws Exception {
		return "findPw";
	}
	
	@RequestMapping(value = "/findPwResult.al")
	public String findPwResult (MemberBean member, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();
		
		map = loginService.selectMemberJumin(member);
		
		if(map == null) {
			model.addAttribute("Find","notFound");
		  }
		  else {
			  memberBean = MapToBean.mapToMember(map);
	
			  if(member.getEMAIL().equals(memberBean.getEMAIL())) {
				  model.addAttribute("memberBean", memberBean);
			  }
			  else {
				  model.addAttribute("invalidEMAIL","invalidEMAIL");
			  }
			  if(member.getNAME().equals(memberBean.getEMAIL())) {
				  model.addAttribute("memberBean", memberBean);
			  }
			  else {
				  model.addAttribute("invalidNAME","invalidNAME");
			  }
		  }
		
		model.addAttribute("memberBean", memberBean);
		
		return "/member/findPwResult";
	}
		
	@RequestMapping(value = "/myPage.al")
	public String myPage (Model model) throws Exception {
		return "myPage";
	}
	
	@RequestMapping(value = "/myInfoModifyForm.al")
	public String myInfoModifyForm (Model model,
			HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		// member에 세션에서 사용자 아이디를 가져와서 저장
		String email = (String) request.getSession().getAttribute("EMAIL");
		MemberBean member = new MemberBean();
		member.setEMAIL(email);

		// MemberBean에 DB에서 읽어와 저장
		MemberBean memberBean = new MemberBean();
		map = myInfoService.selectMemberId(member);
		memberBean = MapToBean.mapToMember(map);
		
		model.addAttribute("memberBean", memberBean);
		return "member/myInfoModifyForm";
	}
	
	@RequestMapping(value = "/myInfoModify.al")
	public String myInfoModify (MemberBean member, BindingResult result, 
			Model model) throws Exception {
		
		new MemberValidator().validate(member, result);
		
		if(result.hasErrors()) {
			return "/myInfoModifyForm.al";
		}
	
		myInfoService.updateMember(member);
		model.addAttribute("msg", "회원정보가 수정되었습니다.");
		model.addAttribute("url", "/myPage.al");
		return "/member/myInfoModify";
	}
	
	@RequestMapping(value = "/myInfoDelete.al")
	public String myInfoDelete (MemberBean member,HttpServletRequest request, BindingResult result, Model model) throws Exception {

		String LoginId = (String) request.getSession().getAttribute("EMAIL");
		MemberBean loginMember = new MemberBean();
		loginMember.setEMAIL(LoginId);
		Map<String, Object> mapMember = loginService.selectMemberId(loginMember);
		member = MapToBean.mapToMember(mapMember);

		myInfoService.deleteMember(member);
		
		request.getSession().invalidate();
		
		model.addAttribute("msg", "이용해주셔서 감사합니다.");
		model.addAttribute("url", "/main.al");
		return "/member/myInfoDelete";
	}
	
	@RequestMapping(value = "/myInfoQna.al")
	public String myInfoQna (Model model, HttpServletRequest request) throws Exception {
		String email = (String) request.getSession().getAttribute("EMAIL");
	    MemberBean member = new MemberBean();
	    member.setEMAIL(email);


		List<Map<String, Object>> list = myInfoService.selectQnaMemberId(member);
	
		List<CommunityBean> qnaBeanList = new ArrayList<CommunityBean>();
	
		for(Map<String, Object> mapObject : list) {
			qnaBeanList.add(MapToBean.mapToCommunity(mapObject));
		}
		
		int qnaCount = list.size();
	
		model.addAttribute("qnaBeanList", qnaBeanList);
		model.addAttribute("qnaCount", qnaCount);
		
		return "myInfoQna";
	}
	
	@RequestMapping(value = "/myInfoReview.al")
	public String myInfoReview (Model model, HttpServletRequest request) throws Exception {
		String email = (String) request.getSession().getAttribute("EMAIL");
	    MemberBean member = new MemberBean();
	    member.setEMAIL(email);
	    
		List<Map<String, Object>> list = myInfoService.selectReviewMemberId(member);
	
		List<CommunityBean> reviewBeanList = new ArrayList<CommunityBean>();

		for(Map<String, Object> mapObject : list) {
			reviewBeanList.add(MapToBean.mapToCommunity(mapObject));
		}
		
		int reviewCount = list.size();

		model.addAttribute("reviewBeanList", reviewBeanList);
		model.addAttribute("reviewCount", reviewCount);
		
		return "myInfoReview";
	}
	
	@RequestMapping(value = "/myInfoOrder.al")
	public String myInfoOrder (Model model, HttpServletRequest request) throws Exception {
		
		
		String email = (String) request.getSession().getAttribute("EMAIL");
	    MemberBean member = new MemberBean();
	    member.setEMAIL(email);
	    System.out.println(email);
	    
		List<Map<String, Object>> list = myInfoService.selectOrderMemberId(member);
		List<OrderBean> orderBeanList = new ArrayList<OrderBean>();

		for(Map<String, Object> mapObject : list) {
			orderBeanList.add(MapToBean.mapToOrder(mapObject));
		}
		
		int orderCount = list.size();

		model.addAttribute("orderBeanList", orderBeanList);
		model.addAttribute("orderCount", orderCount);
		
		return "myInfoOrder";
	}
	
}