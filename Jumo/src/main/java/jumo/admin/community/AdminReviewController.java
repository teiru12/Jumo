package jumo.admin.community;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminReviewController {

	@RequestMapping(value="/adminReviewList.al")
	public String adminReviewList(Model model) {
		return "admin/community/adminReviewList";
	}
	
	
	@RequestMapping(value="/adminReviewDelete.al")
	public String adminReviewDelete(Model model) {
		return "admin/community/adminReviewDelete";
	}
	
	
}
