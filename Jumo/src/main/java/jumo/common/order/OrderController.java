package jumo.common.order;

import javax.annotation.Resource;

import org.apache.maven.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jumo.admin.order.AdminOrderService;

@Controller
public class OrderController {
	
	@Resource(name="adminOrderService")
	private AdminOrderService adminOrderService;
	
	@RequestMapping("/pOrderForm.al")
	public String pOrderForm (Model model) {
		return "/order/pOrderForm";
	}
	@RequestMapping("/basketOrderForm.al")
	public String basketOrderForm (Model model) {
		return "/order/basketOrderForm";
	}
	@RequestMapping("/pOrder.al")
	public String pOrder (Model model) {
		return "/order/pOrder";
	}
	@RequestMapping("/basketOrder.al")
	public String basksetOrder (Model model) {
		return "/order/basketOrder"; // 오타
	}
	@RequestMapping("/orderResult.al")
	public String orderResult (Model model) {
		return "/order/orderResult";
	}
}
