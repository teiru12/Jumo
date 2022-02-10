package jumo.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminPageController {
	
	@RequestMapping(value="/adminMainForm.al")
	public String adminMainForm(Model model) {
		return "adminMainForm";
	}
	
	@RequestMapping(value="/adminMainModify.al")
	public String adminMainModify(
			@RequestParam("fileName1") String fileName1,
			@RequestParam("fileName2") String fileName2,
			@RequestParam("fileName3") String fileName3,
			@RequestParam("fileName4") String fileName4,
			@RequestParam("fileUrl1") String fileUrl1,
			@RequestParam("fileUrl2") String fileUrl2,
			@RequestParam("fileUrl3") String fileUrl3,
			@RequestParam("fileUrl4") String fileUrl4,
			Model model) {
		
		model.addAttribute("fileName1", fileName1);
		model.addAttribute("fileName2", fileName2);
		model.addAttribute("fileName3", fileName3);
		model.addAttribute("fileName4", fileName4);
		
		model.addAttribute("fileUrl1", fileUrl1);
		model.addAttribute("fileUrl2", fileUrl2);
		model.addAttribute("fileUrl3", fileUrl3);
		model.addAttribute("fileUrl4", fileUrl4);
		
		return "/admin/adminMainModify";
	}
}