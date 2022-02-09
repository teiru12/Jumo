package jumo.common.order;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jumo.common.member.MyInfoService;
import jumo.model.MemberBean;
import jumo.model.OrderBean;

import jumo.util.MapToBean;

@Controller
public class OrderController {
	
	@Resource(name="orderService")
	private OrderService orderService;
	
	@Resource(name="myInfoService")
	private MyInfoService myInfoService;
	
	
	@RequestMapping("/pOrderForm.al")
	public String pOrderForm (MemberBean member, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();
		
		
		map = myInfoService.selectMemberId(member);
		
		memberBean = MapToBean.mapToMember(map);
		
		model.addAttribute("memberBean", memberBean);
		
		
		return "pOrderForm";
	}
	
	
	@RequestMapping("/basketOrderForm.al")
	public String basketOrderForm (MemberBean member, Model model) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();
	
		
		map = myInfoService.selectMemberId(member);
		
		memberBean = MapToBean.mapToMember(map);
		model.addAttribute("memberBean", memberBean);
		
		return "basketOrderForm";
	}
	
	
	@RequestMapping("/pOrder.al")
	public String pOrder (MemberBean member, Model model) throws Exception {
		OrderBean orderBean = new OrderBean();
		
		orderService.insertOrderBasket(orderBean);
		
		return "/order/pOrder";
	}
	
	
	@RequestMapping("/basketOrder.al")
	public String basksetOrder (OrderBean order, Model model) throws Exception {
		OrderBean orderBean = new OrderBean();
		
		orderService.insertOrderBasket(orderBean);
		
		return "/order/basketOrder";
	}
	
	
	@RequestMapping("/orderResult.al")
	public String orderResult (OrderBean order, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		OrderBean orderBean = new OrderBean();
		
		
		map = orderService.selectOrderOId(order);
		orderBean  = MapToBean.mapToOrder(map);
		
		model.addAttribute("orderBean", orderBean);
		
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<OrderBean> orderBeanList = new ArrayList<OrderBean>();
		
		list = orderService.selectOrderOBNumber(order);
		
		for(Map<String, Object> mapToOrder : list) {
			orderBeanList.add(MapToBean.mapToOrder(mapToOrder));
		}
		
		model.addAttribute("orderBeanList", orderBeanList);
	
		return "orderResult";
	}
}
