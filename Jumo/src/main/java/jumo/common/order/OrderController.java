package jumo.common.order;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jumo.admin.product.AdminProductService;
import jumo.common.basket.BasketService;
import jumo.common.member.MyInfoService;
import jumo.common.product.ProductService;
import jumo.event.EventService;
import jumo.model.MemberBean;
import jumo.model.OrderBean;
import jumo.model.ProductBean;
import jumo.model.BasketBean;
import jumo.model.JUMO_EVENT;
import jumo.util.MapToBean;

@Controller
public class OrderController {
	
	@Resource(name="orderService")
	private OrderService orderService;
	
	@Resource(name="productService")
	private ProductService productService;
	
	@Resource(name="adminProductService")
	private AdminProductService adminProductService;
	
	@Resource(name="myInfoService")
	private MyInfoService myInfoService;
	
	@Resource(name="basketService")
	private BasketService basketService;
	
	@Resource(name = "eventService")
	private EventService eventService;	
	
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
		
		/* 이벤트 정보를 읽어옴 */
		JUMO_EVENT eventBean = eventService.selectEventId(loginEmail);
		
		model.addAttribute("productBean", productBean);
		model.addAttribute("memberBean", memberBean);
		model.addAttribute("PCOUNT", PCOUNT);
		model.addAttribute("eventBean", eventBean);
		
		return "pOrderForm";
	}
	
	
	@RequestMapping("/basketOrderForm.al")
	public String basketOrderForm (BasketBean basket,HttpServletRequest request, Model model) throws Exception {
		
		List<Map<String, Object>> list = basketService.basketList(basket); 
		List<BasketBean> basketBeanList = new ArrayList<BasketBean>();
		for(Map<String, Object> mapObject : list) {
			basketBeanList.add(MapToBean.mapToBasket(mapObject));
		} 
		
		List<ProductBean> proInfoList = new ArrayList<ProductBean>();
		for(BasketBean basPro : basketBeanList) {
			
			ProductBean pro = new ProductBean();
			pro.setPID(basPro.getBID());			
			Map<String, Object> proInfoMap = productService.selectProductId(pro);
			ProductBean proInfo = MapToBean.mapToProduct(proInfoMap);
			
			proInfoList.add(proInfo);			
		}

		String loginEmail = (String) request.getSession().getAttribute("EMAIL");
		MemberBean member = new MemberBean();
		member.setEMAIL(loginEmail);
		Map<String, Object> mMap = new HashMap<String, Object>();
		mMap = myInfoService.selectMemberId(member);
		MemberBean memberBean = MapToBean.mapToMember(mMap);
		
		String BCOUNT = request.getParameter("BCOUNT");
		
		model.addAttribute("basketBeanList",basketBeanList);
		model.addAttribute("Size", basketBeanList.size());
		model.addAttribute("memberBean", memberBean);
		model.addAttribute("proInfoList", proInfoList);
		model.addAttribute("BCOUNT", BCOUNT);
		
		return "basketOrderForm";
	}
	
	@RequestMapping("/pOrder.al")
	public String pOrder(HttpServletRequest request, OrderBean order, Model model) throws Exception {
		
		String pointStr = request.getParameter("point");
		String coupon = request.getParameter("coupon"); 
		
		
		
		
		orderService.insertOrderDirect(order);
		
		/* 주문 후 주문한 수량만큼 product의 stock을 감소 : 재고 감소 */
		// OPID = PID이므로 OPID를 이용해 상품 정보를 읽어온다.
		ProductBean pro = new ProductBean();
		pro.setPID(order.getOPID());
		Map<String, Object> proMap = productService.selectProductId(pro);
		ProductBean infoPro = MapToBean.mapToProduct(proMap); // infoPro는 PID의 값을 가지는 상품 정보
		
		// 읽어온 상품 정보의 stock을 변경
		// infoPro의 PSTOCK - order의 OCOUNT
		int changedStock = infoPro.getPSTOCK() - order.getOCOUNT();
		infoPro.setPSTOCK(changedStock);
		
		// 바뀐 상품 정보를 이용해서 상품 정보를 업데이트
		adminProductService.updateProduct(infoPro);
		
		/* 입력한 주문 번호를 구한다 */
		int OID = orderService.selectOIDMax();
		
		model.addAttribute("msg", "주문을 완료했습니다.");
		
		String urlParam = "/orderResult.al?OID=" + OID;
		model.addAttribute("url", urlParam);
		
		return "/order/pOrder";
	}
	
	
	@RequestMapping("/basketOrder.al")
	public String basksetOrder (OrderBean order, HttpServletRequest request,
			Model model) throws Exception {
		//사용자 이메일을 세션으로 가져온다.
		BasketBean basket = new BasketBean();
		String email = (String) request.getSession().getAttribute("EMAIL");
		basket.setBEMAIL(email);
		
		//장바구니 리스트를 사용자 이메일을 이용해서 가져온다.
		List<Map<String,Object>> list = basketService.basketList(basket);
		List<BasketBean> basketBeanList = new ArrayList<BasketBean>();
		  
		for(Map<String, Object> mapObject : list) {
			basketBeanList.add(MapToBean.mapToBasket(mapObject));
		}
		
		//장바구니 리스트의 크기만큼 루프를 돌면서 주문
		// orderBean에는 주문 정보가 들어있으므로 orderBean을 사용해서 insertOrderBasket
		
		boolean checkOBNUMBER = false; int OBNUMBER = -1; 
		for(BasketBean infoBasket :	basketBeanList) {
		  
			if(checkOBNUMBER == false) {
				OBNUMBER= infoBasket.getBNUMBER();
				checkOBNUMBER= true;
			}
		 		
			// 3. 장바구니 리스트의 정보를 insert를 할 때 사용할 orderBean에 입력 - 컨트롤러
			//BNUMBER->OBNUMBER, BNAME-> OPRODUCT, BID-> OPID, BPRICE-> OPRICE
			//BSALE->OSALE, BEMAIL->OMAIL, BCOUNT->OCOUNT
		
			order.setOBNUMBER(infoBasket.getBNUMBER());
			order.setOPRODUCT(infoBasket.getBNAME()); 
			order.setOPID(infoBasket.getBID());
			order.setOPRICE(infoBasket.getBPRICE());
			order.setOSALE(infoBasket.getBSALE());
			order.setOMAIL(infoBasket.getBEMAIL());
			order.setOCOUNT(infoBasket.getBCOUNT());

			// 장바구니 주문 폼에서 넘어오는 값들 (따로 설정할 필요없음) - jsp
			// ONAME:받는사람정보, OTOTAL:상품가격*수량, OMOBILE, OPOSTCODE, OADDRESS1, OADDRESS2
			// orderBean에는 주문 정보가 들어있으므로 
			// orderBean을 사용해서 insertOrderBasket
			orderService.insertOrderBasket(order); 
			
			/* 주문 후 주문한 수량만큼 product의 stock을 감소 : 재고 감소 */
			// OPID = PID이므로 OPID를 이용해 상품 정보를 읽어온다.
			ProductBean pro = new ProductBean();
			pro.setPID(order.getOPID());
			Map<String, Object> proMap = productService.selectProductId(pro);
			ProductBean infoPro = MapToBean.mapToProduct(proMap); // infoPro는 PID의 값을 가지는 상품 정보

			// 읽어온 상품 정보의 stock을 변경
			// infoPro의 PSTOCK - order의 OCOUNT
			int changedStock = infoPro.getPSTOCK() - order.getOCOUNT();
			infoPro.setPSTOCK(changedStock);
			
			// 바뀐 상품 정보를 이용해서 상품 정보를 업데이트
			adminProductService.updateProduct(infoPro);
		}
		
		model.addAttribute("msg", "주문을 완료했습니다.");
		String urlParam = "/orderResult.al?OBNUMBER=" + OBNUMBER;
		model.addAttribute("url", urlParam);
			 
		return "/order/basketOrder";
	}
	
	@RequestMapping("/orderResult.al")
	public String orderResult (HttpServletRequest request, 
			OrderBean order, Model model) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		OrderBean orderBean = new OrderBean();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<OrderBean> orderBeanList = new ArrayList<OrderBean>();
		
		System.out.println("order.getOBNUMBER : " + order.getOBNUMBER());
		
		if(order.getOBNUMBER() == 0) {
			// 만약 OBNUMBER가 null일 경우 직접 주문의 결과
			// 파라미터로 넘겨받은 OID를 이용해서 주문정보를 구한다.
			map = orderService.selectOrderOId(order);
			orderBean  = MapToBean.mapToOrder(map);
			
			/* 주문정보의 OMAIL을 이용해서 주문자 정보를 구함*/
			MemberBean member = new MemberBean();
			member.setEMAIL(orderBean.getOMAIL());
			Map<String, Object> mMap = new HashMap<String, Object>();
			mMap = myInfoService.selectMemberId(member);
			MemberBean memberBean = MapToBean.mapToMember(mMap); 			
			
			model.addAttribute("result","direct");
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
			
			model.addAttribute("result","basket");
			model.addAttribute("orderBeanList", orderBeanList);
			model.addAttribute("memberBean", memberBean);			
		}		
		return "orderResult";
	}
}