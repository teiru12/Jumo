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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jumo.event.EventService;
import jumo.model.CommunityBean;
import jumo.model.JUMO_EVENT;
import jumo.model.MemberBean;
import jumo.model.OrderBean;
import jumo.util.MapToBean;
import jumo.util.validator.MemberValidator;

@Controller
public class MemberController {

	@Resource(name = "joinService")
	private JoinService joinService;

	@Resource(name = "loginService")
	private LoginService loginService;

	@Resource(name = "myInfoService")
	private MyInfoService myInfoService;
	
	@Resource(name = "eventService")
	private EventService eventService;

	@RequestMapping(value = "/joinForm.al")
	public String joinForm(Model model) {

		return "joinFormAjax";
	}


	@RequestMapping(value = "/confirmIdAjax.al")
	@ResponseBody
	public Map<String, String> confirmIdAjax(MemberBean member, @RequestBody String message) throws Exception {
		Map<String, String> msg = new HashMap<String, String>();
		
		System.out.println("EMAIL : " + member.getEMAIL());
		
		/*공백을 입력 받았을 경우*/ 
		if (member.getEMAIL().trim().equals("")) {
			msg.put("message", "아이디를 입력해주세요");
			return msg;
		} 

		/* 관리자 아이디를 입력 받았을 경우 */
		 if(member.getEMAIL().trim().equals("ADMIN")) {
			 msg.put("message", "이 아이디는 사용할 수 없습니다.");
			
			 return msg; 
		 }
		
		 Map<String, Object> map = new HashMap<String, Object>();
		map = joinService.selectMemberId(member);		
		
		if(map != null) { 
			// 중복된 아이디 있음 
			msg.put("message", "이미 가입된 아이디입니다.");
		
		} else {
			//중복된 아이디 없음
			msg.put("message", "사용할 수 있는 아이디입니다.");
		}
		
		return msg;
	
	}
	
	@RequestMapping(value = "/confirmId.al")
	public String confirmId(MemberBean member, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		/*공백을 입력 받았을 경우*/ 
		if (member.getEMAIL().trim().equals("")) {
			model.addAttribute("msg", "아이디를 입력해주세요");
			model.addAttribute("url","/joinForm.al");
			return "/member/confirmId";
		}
		 
		
		
		 /* 관리자 아이디를 입력 받았을 경우 */
		 if(member.getEMAIL().trim().equals("ADMIN")) {
			 model.addAttribute("msg", "이 아이디는 사용할 수 없습니다.");
			 model.addAttribute("url", "/joinForm.al");
			 return "/member/confirmId"; 
		 }
		

		map = joinService.selectMemberId(member);

		if(map != null) { // 중복된 아이디 있음 
			model.addAttribute("msg", "이미 가입된 아이디입니다.");
			model.addAttribute("url", "/joinForm.al"); } else { //중복된 아이디 없음
			model.addAttribute("msg", "사용할 수 있는 아이디입니다."); model.addAttribute("url","/joinForm.al"); }

		return "/member/confirmId";
	}
	

	@RequestMapping(value = "/joinSuccess.al")
	public String joinSuccess(MemberBean member, BindingResult result, Model model) throws Exception {

		new MemberValidator().validate(member, result);

		if (result.hasErrors()) {
			// 회원가입 실패
			model.addAttribute("msg", "회원가입에 실패했습니다.");
			model.addAttribute("url", "/joinForm.al");
		}

		Map<String, Object> map = joinService.selectMemberId(member);

		if (map != null) {
			// 중복회원 가입시 실패
			model.addAttribute("msg", "이미 가입된 아이디입니다.");
			model.addAttribute("url", "/joinForm.al");

		} else {
			// 회원가입 성공
			joinService.insertMember(member);
			
			/* 회원가입에 성공했을 경우 포인트 테이블 생성 및 지급 */
			JUMO_EVENT event = new JUMO_EVENT();
			event.setEMAIL(member.getEMAIL());
			event.setJUMO_POINT(5000);
			eventService.insertPointId(event);

			model.addAttribute("msg", "회원가입에 성공했습니다. 포인트 5천 지급되었습니다.");
			model.addAttribute("url", "/loginForm.al");
		}

		return "/member/joinSuccess";
	}

	@RequestMapping(value = "/loginForm.al")
	public String loginForm(Model model) throws Exception {
		return "loginForm";
	}

	@RequestMapping(value = "/login.al")
	public String login(MemberBean member, HttpSession session, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();

		map = loginService.selectMemberId(member);

		if (map == null) {
			// 로그인 실패
			model.addAttribute("msg", "회원을 찾을 수 없습니다.");
			model.addAttribute("url", "/loginForm.al");
		} else {
			memberBean = MapToBean.mapToMember(map); // 검색된 회원

			// 비밀번호 체크
			if (member.getPASSWORD().equals(memberBean.getPASSWORD())) {
				// 로그인 성공

				// 정지유무 체크
				if (memberBean.getBLOCK().equals("Y")) {
					model.addAttribute("msg", "정지된 회원입니다.");
					model.addAttribute("url", "/loginForm.al");
					return "/member/login";
				}

				// 세션 등록
				session.setAttribute("EMAIL", memberBean.getEMAIL());

				// 관리자 체크
				if (memberBean.getEMAIL().equals("ADMIN")) {
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
	public String logout(HttpServletRequest request, Model model) throws Exception {

		request.getSession().invalidate();

		model.addAttribute("msg", "로그아웃 하셨습니다.");
		model.addAttribute("url", "/loginForm.al");

		return "/member/logout";
	}

	@RequestMapping(value = "/findId.al")
	public String findId(Model model) throws Exception {
		return "findId";
	}

	@RequestMapping(value = "/findIdResult.al")
	public String findIdResult(MemberBean member, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();

		map = loginService.selectMemberJumin(member);

		if (map == null) {
			model.addAttribute("Find", "notFound");
		} else {
			memberBean = MapToBean.mapToMember(map);

			if (member.getNAME().equals(memberBean.getNAME())) {
				model.addAttribute("memberBean", memberBean);
			} else {
				model.addAttribute("Find", "invalidName");
			}
		}
		return "findIdResult";
	}

	@RequestMapping(value = "/findPw.al")
	public String findPw(Model model) throws Exception {
		return "findPw";
	}

	@RequestMapping(value = "/findPwResult.al")
	public String findPwResult(MemberBean member, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();

		map = loginService.selectMemberJumin(member);

		// 주민번호 일치 여부를 검사
		if (map == null) {
			// 주민번호가 일치하지 않으므로 회원이 검색되지 않음
			model.addAttribute("Find", "notFound");
		} else {
			memberBean = MapToBean.mapToMember(map);
			// 아이디(EMAIL) 일치 여부를 검사
			if (member.getEMAIL().equals(memberBean.getEMAIL())) {
				// 이름 일치 여부를 검사
				if (member.getNAME().equals(memberBean.getNAME())) {
					// 일치한 회원을 찾음
					model.addAttribute("memberBean", memberBean);
				} else {
					// 이름이 일치하지 않음
					model.addAttribute("invalidNAME", "invalidNAME");
				}
			} else {
				// 이메일이 일치하지 않음
				model.addAttribute("invalidEMAIL", "invalidEMAIL");
			}
		}

		model.addAttribute("memberBean", memberBean);

		return "findPwResult";
	}

	@RequestMapping(value = "/myPage.al")
	public String myPage(Model model) throws Exception {
		return "myPage";
	}

	@RequestMapping(value = "/myInfoModifyForm.al")
	public String myInfoModifyForm(Model model, HttpServletRequest request) throws Exception {
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
		return "myInfoModifyForm";
	}

	@RequestMapping(value = "/myInfoModify.al")
	public String myInfoModify(MemberBean member, BindingResult result, Model model) throws Exception {

		new MemberValidator().validate(member, result);

		if (result.hasErrors()) {
			return "/myInfoModifyForm.al";
		}

		myInfoService.updateMember(member);
		model.addAttribute("msg", "회원정보가 수정되었습니다.");
		model.addAttribute("url", "/myInfoModifyForm.al");
		return "/member/myInfoModify";
	}

	@RequestMapping(value = "/myInfoDelete.al")
	public String myInfoDelete(MemberBean member, HttpServletRequest request, BindingResult result, Model model)
			throws Exception {

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
	public String myInfoQna(Model model, HttpServletRequest request) throws Exception {
		String email = (String) request.getSession().getAttribute("EMAIL");
		MemberBean member = new MemberBean();
		member.setEMAIL(email);

		List<Map<String, Object>> list = myInfoService.selectQnaMemberId(member);

		List<CommunityBean> qnaBeanList = new ArrayList<CommunityBean>();

		for (Map<String, Object> mapObject : list) {
			qnaBeanList.add(MapToBean.mapToCommunity(mapObject));
		}

		int qnaCount = list.size();

		model.addAttribute("qnaBeanList", qnaBeanList);
		model.addAttribute("qnaCount", qnaCount);

		return "myInfoQna";
	}

	@RequestMapping(value = "/myInfoReview.al")
	public String myInfoReview(Model model, HttpServletRequest request) throws Exception {
		String email = (String) request.getSession().getAttribute("EMAIL");
		MemberBean member = new MemberBean();
		member.setEMAIL(email);

		List<Map<String, Object>> list = myInfoService.selectReviewMemberId(member);

		List<CommunityBean> reviewBeanList = new ArrayList<CommunityBean>();

		for (Map<String, Object> mapObject : list) {
			reviewBeanList.add(MapToBean.mapToCommunity(mapObject));
		}

		int reviewCount = list.size();

		model.addAttribute("reviewBeanList", reviewBeanList);
		model.addAttribute("reviewCount", reviewCount);

		return "myInfoReview";
	}

	@RequestMapping(value = "/myInfoOrder.al")
	public String myInfoOrder(Model model, HttpServletRequest request) throws Exception {

		String email = (String) request.getSession().getAttribute("EMAIL");
		MemberBean member = new MemberBean();
		member.setEMAIL(email);
		System.out.println(email);

		List<Map<String, Object>> list = myInfoService.selectOrderMemberId(member);
		List<OrderBean> orderBeanList = new ArrayList<OrderBean>();

		for (Map<String, Object> mapObject : list) {
			orderBeanList.add(MapToBean.mapToOrder(mapObject));
		}

		int orderCount = list.size();

		model.addAttribute("orderBeanList", orderBeanList);
		model.addAttribute("orderCount", orderCount);

		return "myInfoOrder";
	}

}