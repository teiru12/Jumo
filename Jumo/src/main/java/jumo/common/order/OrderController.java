package jumo.common.order;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jumo.common.member.MyInfoService;
import jumo.model.MemberBean;
import jumo.model.OrderBean;
import jumo.model.BasketBean;

import jumo.util.MapToBean;
import jumo.util.validator.OrderValidator;

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
		
			// memberBean을 세션으로 입력하면 파라미터를 생략할 수 있음
		
		Map<String, Object> map = new HashMap<String, Object>();
		MemberBean memberBean = new MemberBean();
	
		map = myInfoService.selectMemberId(member);
		
		memberBean = MapToBean.mapToMember(map);
		model.addAttribute("memberBean", memberBean);
		
		return "basketOrderForm";
	}
	
	
	@RequestMapping("/pOrder.al")
	public String pOrder (MemberBean member, BindingResult result,
			@RequestParam("oPid") int oPid,
			@RequestParam("oProduct") String oProduct,
			@RequestParam("oCount") int oCount,
			@RequestParam("oPrice") int oPrice,
			@RequestParam("oSale") int oSale,
			@RequestParam("oTotal") int oTotal,
			Model model) throws Exception {
		
		OrderBean orderBean = new OrderBean();
		
		orderBean.setOMAIL(member.getEMAIL());
		orderBean.setOPID(oPid);
		orderBean.setOPRODUCT(oProduct);
		orderBean.setOCOUNT(oCount);
		orderBean.setOPRICE(oPrice);
		orderBean.setOSALE(oSale);
		orderBean.setOTOTAL(oTotal);
		orderBean.setOADDRESS1(member.getADDRESS1());
		orderBean.setOADDRESS2(member.getADDRESS2());

		new OrderValidator().validate(orderBean, result);
		
		if(result.hasErrors()) {
			// basketOrderForm의 MemberBean을 파라미터로 받으면 오류발생 가능성 있음
			return "/basketOrderForm.al";
		}
		
		orderService.insertOrderDirect(orderBean);
		
		return "/order/pOrder";
	}
	
	
	@RequestMapping("/basketOrder.al")
	public String basksetOrder (BasketBean basket, BindingResult result,
			Model model) throws Exception {
		
		int basketNumber = basket.getBNUMBER();
		
		OrderBean orderBasket = new OrderBean();
		orderBasket.setOBNUMBER(basketNumber);
				
		List<Map<String, Object>> list = orderService.selectOrderOBNumber(orderBasket);
		
		List<OrderBean> orderBeanList = new ArrayList<OrderBean>();
		
		for(Map<String, Object> mapObject : list) {
			orderBeanList.add(MapToBean.mapToOrder(mapObject));
		}
		
		// 주문 리스트의 각 주문에 대한 주문을 각각 수행
		for(OrderBean order : orderBeanList) {
			orderService.insertOrderBasket(order);
		}
		
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
