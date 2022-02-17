package jumo.common.basket;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jumo.common.product.ProductService;
import jumo.model.BasketBean;
import jumo.model.ProductBean;
import jumo.util.MapToBean;

@Controller
public class BasketController {

	@Resource(name="basketService")
	private BasketService basketService;
	
	@Resource(name="productService")
	private ProductService productService;
	
	@RequestMapping(value="/basketList.al")
	public String basketList(BasketBean basket, HttpServletRequest request, Model model) throws Exception {
		
		// basket에 세션에서 사용자 아이디를 가져와서 저장
		String email = (String) request.getSession().getAttribute("EMAIL");
		basket.setBEMAIL(email);
		
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
		
		
		model.addAttribute("basketBeanList", basketBeanList);
		model.addAttribute("Size", basketBeanList.size());
		model.addAttribute("proInfoList", proInfoList);
		
		return "basketList";
	}
	
	@RequestMapping(value="/basketModify.al")
	public String basketModify(BasketBean basket, HttpServletRequest request,
			Model model) throws Exception {
		
		  Map<String, Object> map = basketService.selectBasketBIDX(basket);
		  BasketBean basketInfo = MapToBean.mapToBasket(map);
		
		  ProductBean product = new ProductBean(); 
		  product.setPID(basketInfo.getBID());
		  Map<String, Object> mapProduct = productService.selectProductId(product);
		  ProductBean productInfo = MapToBean.mapToProduct(mapProduct);
		  
		  if(basket.getBCOUNT() > productInfo.getPSTOCK()) {
		model.addAttribute("msg", "재고 수량보다 많은 상품을 장바구니에 담을 수 없습니다."); 
		  return "/basket/basketModify";
		  }
		  
		  if(basket.getBCOUNT() <= 0) {
		model.addAttribute("msg", "장바구니에 상품을 담을 수 없습니다."); 
		  return "/basket/basketModify";
		  }
		 
		  basketService.updateBasket(basket);	 	
		return "/basket/basketModify";
	}
	
	@RequestMapping(value="/basketDelete.al")
	public String basketDelete(BasketBean basket, Model model) throws Exception {
		
		basketService.deleteBasket(basket);
		
		return "/basket/basketDelete";
	}
	
}