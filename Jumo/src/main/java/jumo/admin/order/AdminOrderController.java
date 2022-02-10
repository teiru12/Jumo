package jumo.admin.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jumo.model.OrderBean;
import jumo.util.MapToBean;


@Controller
public class AdminOrderController {

	@Resource(name="adminOrderService")
	private AdminOrderService adminOrderService;
	
	@RequestMapping("/adminOrderList.al")
	public String adminOrderList (Model model) throws Exception{
		
		List<Map<String, Object>> list = adminOrderService.orderList();
		
		List<OrderBean> orderBeanList = new ArrayList<OrderBean>();
		
		for(Map<String, Object> mapObject : list) {
			orderBeanList.add(MapToBean.mapToOrder(mapObject));
		}
		
		model.addAttribute("orderBeanList", orderBeanList);
		
		return "adminOrderList";
	}
	

	@RequestMapping(value="/adminOrderList.al", method=RequestMethod.POST)
	public String adminOrderListSearch (@RequestParam("keyword") String keyword,
			@RequestParam("oStatus") String oStatus, Model model) throws Exception {
		List<Map<String, Object>> list = adminOrderService.orderListSearch(keyword, oStatus);
		
		List<OrderBean> searchList = new ArrayList<OrderBean>();
		
		for(Map<String, Object> mapObject : list) {
			searchList.add(MapToBean.mapToOrder(mapObject));
		}
		
		model.addAttribute("searchList", searchList);
		model.addAttribute("oStatus", oStatus);
		model.addAttribute("keyword", keyword);
		
		return "adminOrderList";
	}
	
	@RequestMapping("/adminOrderDetail.al")
	public String adminOrderDetail (OrderBean order, Model model) throws Exception{
		Map<String, Object> map = adminOrderService.selectOrderOId(order);
		
		OrderBean orderBean = new OrderBean();
		
		orderBean = MapToBean.mapToOrder(map);
		
		model.addAttribute("orderBean", orderBean);
		
		return "adminOrderDetail";
	}
	@RequestMapping("/adminOrderModify.al")
	public String adminOrderModify (OrderBean order, Model model) throws Exception{
		adminOrderService.updateOrderId(order);
		
		return "/admin/order/adminOrderModify";
	}
	
}

