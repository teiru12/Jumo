package jumo.admin.community;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminQnaController {
	
	@RequestMapping(value="/adminQnaList.al")
	public String adminQnaList(Model model) {
		return "/admin/community/adminQnaList";
	}
	
	@RequestMapping(value="/adminQnaDelete.al")
	public String adminQnaDelete(Model model) {
		return "/admin/community/adminQnaDelete";
	}
	
	@RequestMapping(value="/adminQnaDetail.al")
	public String adminQnaDetail(Model model) {
		return "/admin/community/adminQnaDetail";
	}

	@RequestMapping(value="/adminQnaComWrite.al")
	public String adminQnaComWrite(Model model) {
		return "/admin/community/adminQnaComWrite";
	}

	@RequestMapping(value="/adminQnaComModify.al")
	public String adminQnaComModify(Model model) {
		return "/admin/community/adminQnaComModify";
	}
	
	@RequestMapping(value="/adminQnaComDelete.al")
	public String adminQnaComDelete(Model model) {
		return "/admin/community/adminQnaComDelete";
	}
}