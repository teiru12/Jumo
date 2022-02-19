package jumo.common.order;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jumo.common.basket.BasketService;
import jumo.common.member.MyInfoService;
import jumo.common.product.ProductService;
import jumo.model.MemberBean;
import jumo.model.OrderBean;
import jumo.model.ProductBean;
import jumo.model.BasketBean;

import jumo.util.MapToBean;
import jumo.util.validator.OrderValidator;

@Controller
public class OrderController {
	
	@Resource(name="orderService")
	private OrderService orderService;
	
	@Resource(name="productService")
	private ProductService productService;
	
	@Resource(name="myInfoService")
	private MyInfoService myInfoService;
	
	@Resource(name="basketService")
	private BasketService basketService;
	
	
	@RequestMapping("/pOrderForm.al")
	public String pOrderForm (ProductBean product, HttpServletRequest request, Model model) throws Exception {
		/* PID를 넘겨받아 상품 정보를 읽어옴 */
		Map<String, Object> pMap = new HashMap<String, Object>();
		ProductBean productBean = new ProductBean();
		pMap = productService.selectProductId(product);
		productBean = MapToBean.mapToProduct(pMap);
		
		/* 로그인한 사용자의 정보를 세션을 이용해서 읽어옴 */
		String loginEmail = (String) request.getSession().getAttribute("EMAIL");
		MemberBean member = new MemberBean();
		member.setEMAIL(loginEmail);
		Map<String, Object> mMap = new HashMap<String, Object>();
		mMap = myInfoService.selectMemberId(member);
		MemberBean memberBean = MapToBean.mapToMember(mMap); 
		
		/* 주문 수량 정보를 읽어옴 */
		String PCOUNT = request.getParameter("PCOUNT");
		
		model.addAttribute("productBean", productBean);
		model.addAttribute("memberBean", memberBean);
		model.addAttribute("PCOUNT", PCOUNT);
		
		return "pOrderForm";
	}
	
	
	@RequestMapping("/basketOrderForm.al")
	public String basketOrderForm (BasketBean basket, Model model) throws Exception {
		
		List<Map<String, Object>> list = basketService.basketList(basket); 
		List<BasketBean> basketBeanList = new ArrayList<BasketBean>();
		for(Map<String, Object> mapObject : list) {
			basketBeanList.add(MapToBean.mapToBasket(mapObject));
		}
		
		model.addAttribute("basketBeanList",basketBeanList);
		
		
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
