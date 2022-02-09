package jumo.common.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping(value = "/joinForm.al")
	public String joinForm (Model model) {
		return "member/joinForm";
	}
	
	@RequestMapping(value = "/confirmId.al")
	public String conformId (Model model) {
		return "member/confirmId";
	}
	
	@RequestMapping(value = "/joinSuccess.al")
	public String joinSuccess (Model model) {
		return "member/joinSuccess";
	}
	
	@RequestMapping(value = "/loginForm.al")
	public String loginForm (Model model) {
		return "member/loginForm";
	}
	
	@RequestMapping(value = "/login.al")
	public String login (Model model) {
		return "member/login";
	}
	
	@RequestMapping(value = "/logout.al")
	public String logout (Model model) {
		return "member/logout";
	}
	
	@RequestMapping(value = "/findId.al")
	public String findId (Model model) {
		return "member/findId";
	}
	
	@RequestMapping(value = "/findIdResult.al")
	public String findIdResult (Model model) {
		return "member/findIdResult";
	}
	
	@RequestMapping(value = "/findPw.al")
	public String findPw (Model model) {
		return "member/findPw";
	}
	
	@RequestMapping(value = "/findPwResult.al")
	public String findPwResult (Model model) {
		return "member/findPwResult";
	}
	
	@RequestMapping(value = "/myPage.al")
	public String myPage (Model model) {
		return "member/myPage";
	}
	
	@RequestMapping(value = "/myInfoModifyForm.al")
	public String myInfoModifyForm (Model model) {
		return "member/myInfoModifyForm";
	}
	
	@RequestMapping(value = "/myInfoModify.al")
	public String myInfoModify (Model model) {
		return "member/myInfoModify";
	}
	
	@RequestMapping(value = "/myInfoDelete.al")
	public String myInfoDelete (Model model) {
		return "member/myInfoDelete";
	}
	
	@RequestMapping(value = "/myInfoQna.al")
	public String myInfoQna (Model model) {
		return "member/myInfoQna";
	}
	
	@RequestMapping(value = "/myInfoReview.al")
	public String myInfoReview (Model model) {
		return "member/myInfoReview";
	}
	
	@RequestMapping(value = "/myInfoOrder.al")
	public String myInfoOrder (Model model) {
		return "member/myInfoOrder";
	}
	
	
}
