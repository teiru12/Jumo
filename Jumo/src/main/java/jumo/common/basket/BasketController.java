package jumo.common.basket;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasketController {

	@RequestMapping(value="/basketList.al")
	public String basketList(Model model) {
		return "/basket/basketList";
	}
	
	@RequestMapping(value="/basketModify.al")
	public String basketModify(Model model) {
		return "/basket/basketModify";
	}
	
	@RequestMapping(value="/basketDelete.al")
	public String basketDelete(Model model) {
		return "/basket/basketDelete";
	}
	
}