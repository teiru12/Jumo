package jumo.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPageController {
	
	@RequestMapping(value="/adminMainForm.al")
	public String adminMainForm(Model model) {
		return "/admin/adminMainForm";
	}
	
	@RequestMapping(value="/adminMainModify.al")
	public String adminMainModify(Model model) {
		return "/admin/adminMainModify";
	}
}