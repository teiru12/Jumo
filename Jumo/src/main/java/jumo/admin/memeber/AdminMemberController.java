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
		
		System.out.println(member.getEMAIL());
		System.out.println(member.getADDRESS1());
		System.out.println(member.getADDRESS2());
		System.out.println(member.getPOSTCODE());
		System.out.println(member.getBLOCK());
		System.out.println(member.getRANK());
		System.out.println(member.getPHONE());
		System.out.println(member.getMOBILE());
		
		adminMemberService.updateMemberAdmin(member);
		
		model.addAttribute("msg", "회원정보가 수정되었습니다.");
		model.addAttribute("url", "/memberList.al");
		return "admin/member/memberModify";
	}
	
	@RequestMapping(value = "/memberDelete.al")
	public String memberDelete (Model model, HttpServletRequest request, MemberBean member) throws Exception {
		
		String memberData = (String)request.getAttribute("EMAIL");
		MemberBean memberBean = new MemberBean();
		memberBean.setEMAIL(memberData);
		Map<String, Object> memberId = adminMemberService.selectMemberId(memberBean);
		member = MapToBean.mapToMember(memberId);
		
		adminMemberService.deleteMember(member);
		
		return "admin/member/memberDelete";
	}
	
}
