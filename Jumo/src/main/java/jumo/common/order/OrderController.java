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

import jumo.common.basket.BasketService;
import jumo.common.member.MyInfoService;
import jumo.common.product.ProductService;
import jumo.model.MemberBean;
import jumo.model.OrderBean;
import jumo.model.ProductBean;
import jumo.model.BasketBean;

import jumo.util.MapToBean;

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
	public String pOrder(OrderBean order, Model model) throws Exception {
		
		orderService.insertOrderDirect(order);
		
		/* 입력한 주문 번호를 구한다 */
		int OID = orderService.selectOIDMax();
		
		model.addAttribute("msg", "주문을 완료했습니다.");
		model.addAttribute("url", "");
		
		String urlParam = "/orderResult.al?OID=" + OID;
		model.addAttribute("url", urlParam);
		
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
	public String orderResult (HttpServletRequest request, 
			OrderBean order, Model model) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		OrderBean orderBean = new OrderBean();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<OrderBean> orderBeanList = new ArrayList<OrderBean>();
		
		if(order.getOBNUMBER() == 0) {
			// 만약 OBNUMBER가 null일 경우 직접 주문의 결과
			// 파라미터로 넘겨받은 OID를 이용해서 주문정보를 구한다.
			map = orderService.selectOrderOID(order);
			orderBean  = MapToBean.mapToOrder(map);
			
			/* 주문정보의 OMAIL을 이용해서 주문자 정보를 구함*/
			MemberBean member = new MemberBean();
			member.setEMAIL(orderBean.getOMAIL());
			Map<String, Object> mMap = new HashMap<String, Object>();
			mMap = myInfoService.selectMemberId(member);
			MemberBean memberBean = MapToBean.mapToMember(mMap); 			
			
			model.addAttribute("orderBean", orderBean);
			model.addAttribute("memberBean", memberBean);			
		} else {
			// OBNUMBER가 null이 아닐 경우 장바구니 주문의 결과
			// 파라미터로 넘겨받은 OBNUMBER를 이용해 주문정보의 리스트를 구한다.
			list = orderService.selectOrderOBNumber(order);
			for(Map<String, Object> mapToOrder : list) {
				orderBeanList.add(MapToBean.mapToOrder(mapToOrder));
			}
			
			/* orderBeanList의 첫번째 주문정보의 OMAIL을 이용해서 주문자 정보를 구함 */
			MemberBean member = new MemberBean();
			member.setEMAIL(orderBeanList.get(0).getOMAIL());
			Map<String, Object> mMap = new HashMap<String, Object>();
			mMap = myInfoService.selectMemberId(member);
			MemberBean memberBean = MapToBean.mapToMember(mMap);
			
			model.addAttribute("orderBeanList", orderBeanList);
			model.addAttribute("memberBean", memberBean);			
		}		
		return "orderResult";
	}
}