package jumo.admin.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminProductController {

	@RequestMapping(value="/adminPList.al")
	public String adminPList(Model model) {
		return "/admin/product/adminPList";
	}
	
	@RequestMapping(value="/adminPList.al", method=RequestMethod.POST)
	public String adminPListSearch(Model model) {
		return "/admin/product/adminPList";
	}

	@RequestMapping(value="/adminPWriteForm.al")
	public String adminPWriteForm(Model model) {
		return "/admin/product/adminPWriteForm";
	}
	
	@RequestMapping(value="/adminPWrite.al")
	public String adminPWrite(Model model) {
		return "/admin/product/adminPWrite";
	}
	
	@RequestMapping(value="/adminPModifyForm.al")
	public String adminPModifyForm(Model model) {
		return "/admin/product/adminPModifyForm";
	}
	
	@RequestMapping(value="/adminPModify.al")
	public String adminPModify(Model model) {
		return "/admin/product/adminPModify";
	}

	@RequestMapping(value="/adminSellList.al")
	public String adminSellList(Model model) {
		return "/admin/product/adminSellList";
	}		
}