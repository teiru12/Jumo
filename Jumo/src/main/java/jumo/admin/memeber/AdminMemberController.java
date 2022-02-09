package jumo.admin.memeber;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminMemberController {

	@RequestMapping(value = "/memberList.al")
	public String memeberList (Model model) {
		return "admin/member/memberList";
	}
	
	@RequestMapping(value = "/memberList.al", method = RequestMethod.POST)
	public String memberSearch (Model model) {
		return "admin/member/memberList";
	}
	
	@RequestMapping(value = "/memberDetail.al")
	public String memberDetail (Model model) {
		return "admin/member/memberDetail";
	}
	
	@RequestMapping(value = "/memberModify.al")
	public String memberModify (Model model) {
		return "admin/member/memberModify";
	}
	
	@RequestMapping(value = "/memberDelete.al")
	public String memberDelete (Model model) {
		return "admin/member/memberDelete";
	}
	
}
