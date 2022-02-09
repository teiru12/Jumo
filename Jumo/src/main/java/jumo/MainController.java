package jumo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value="/main.al")
	public String main_layout(Model model) {
		return "main_layout";
	}
	
	@RequestMapping(value="/adminMain.al")
	public String adminMain(Model model) {
		return "adminMain";
	}
}