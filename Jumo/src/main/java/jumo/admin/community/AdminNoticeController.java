package jumo.admin.community;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminNoticeController {


	@RequestMapping(value="/adminNoticeList.al")
	public String adminNoticeList(Model model) {
		return "admin/community/adminNoticeList";
	}
	
	@RequestMapping(value="/adminNoticeWriteForm.al")
	public String adminNoticeWriteForm(Model model) {
		return "admin/community/adminNoticeWriteForm";
	}
	
	
	@RequestMapping(value="/adminNoticeWrite.al")
	public String adminNoticeWrite(Model model) {
		return "admin/community/adminNoticeWrite";
	}
	
	
	@RequestMapping(value="/adminNoticeModifyForm.al")
	public String adminNoticeModifyForm(Model model) {
		return "admin/community/adminNoticeModifyForm";
	}
	
	
	@RequestMapping(value="/adminNoticeModify.al")
	public String adminNoticeModify(Model model) {
		return "admin/community/adminNoticeModify";
	}
	
	
	@RequestMapping(value="/adminNoticeDelete.al")
	public String adminNoticeDelete(Model model) {
		return "admin/community/adminNoticeDelete";
	}
	
	
	@RequestMapping(value="/adminNoticeDetail.al")
	public String adminNoticeDetail(Model model) {
		return "admin/community/adminNoticeDetail";
	}
	
	
	
}
