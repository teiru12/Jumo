package jumo.admin.memeber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
	public String memberModify (MemberBean member, BindingResult result)
			throws Exception {

		new MemberValidator().validate(member, result);
		
		if(result.hasErrors()) {
			return "./memberList.al";
		}
		
		adminMemberService.updateMemberAdmin(member);
		
		return "admin/member/memberModify";
	}
	
	@RequestMapping(value = "/memberDelete.al")
	public String memberDelete (Model model, MemberBean member) throws Exception {
		
		adminMemberService.deleteMember(member);
		
		return "admin/member/memberDelete";
	}
	
}
