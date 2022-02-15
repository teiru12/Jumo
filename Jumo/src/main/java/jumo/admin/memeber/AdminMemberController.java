package jumo.admin.memeber;

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
import org.springframework.web.bind.annotation.RequestMethod;

import jumo.model.MemberBean;
import jumo.util.MapToBean;
import jumo.util.validator.MemberValidator;

@Controller
public class AdminMemberController {

	@Resource(name="adminMemberService")
	private AdminMemberService adminMemberService;
	
	@RequestMapping(value = "/memberList.al")
	public String memberList (Model model) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<MemberBean> memberBeanList = new ArrayList<MemberBean>();
		list = adminMemberService.memberList(); 
		
		for(Map<String, Object> mapObject : list) {
			memberBeanList.add(MapToBean.mapToMember(mapObject));
		}
		
		model.addAttribute("memberBeanList", memberBeanList);
		
		return "memberList";
	}
	
	@RequestMapping(value = "/memberList.al", method = RequestMethod.POST)
	public String memberSearch (MemberBean member, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();
		
		map = adminMemberService.selectMemberId(member);
		
		memberBean = MapToBean.mapToMember(map);
		
		model.addAttribute("memberBean", memberBean);

		return "memberList";
	}
	
	@RequestMapping(value = "/memberDetail.al")
	   public String memberDetail (MemberBean member, Model model) throws Exception {
	      Map<String, Object> map = new HashMap<String, Object>();
	      MemberBean memberBean = new MemberBean();
	      
	      map = adminMemberService.selectMemberId(member);
	      memberBean = MapToBean.mapToMember(map);
	      
	      model.addAttribute("memberBean", memberBean);
	      
	      return "memberDetail";
	   }
	 
	@RequestMapping(value = "/memberModify.al")
	public String memberModify (MemberBean member, Model model)
			throws Exception {
		
		// BlOCK값이 체크가 되지 않으면 null로 입력되어 넘어오게 된다.
		// 따라서 BlOCK을 하지 않음을 설정하기 위해 "N"값을 입력하여 넘겨준다.
		// 체크가 되었을 경우 "Y"값이 넘어오게 된다.
		if(member.getBLOCK() == null) {
			member.setBLOCK("N");
		}
		
		adminMemberService.updateMemberAdmin(member);
		
		model.addAttribute("msg", member.getEMAIL() + "회원의 정보가 수정되었습니다.");
		model.addAttribute("url", "/memberList.al");
		return "admin/member/memberModify";
	}
	
	@RequestMapping(value = "/memberDelete.al")
	public String memberDelete (Model model, MemberBean member) throws Exception {
		
		// 선택한 계정을 삭제하기 위해서 파라미터로 계정의 이메일값을 입력해 MemberBean으로 받는다.
		
		adminMemberService.deleteMember(member);
		
		model.addAttribute("msg", member.getEMAIL() + "회원이 삭제 되었습니다.");
		model.addAttribute("url", "/memberList.al");
		
		return "admin/member/memberDelete";
	}
}