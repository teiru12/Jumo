package jumo.admin.order;

import javax.annotation.Resource;

import org.apache.maven.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AdminOrderController {

	@Resource(name="adminOrderService")
	private AdminOrderService adminOrderService;
	
	@RequestMapping(value="/adminOrderList.al", method=RequestMethod.POST)
	public String adminOrderList (Model model) {
		return "/admin/order/adminOrderList";
	}
	@RequestMapping("/adminOrderDetail.al")
	public String adminOrderDetail (Model model) {
		return "/admin/order/adminOrderDetail";
	}
	@RequestMapping("/adminOrderModify.al")
	public String adminOrderModify (Model model) {
		return "/admin/order/adminOrderModify";
	}
	
}

