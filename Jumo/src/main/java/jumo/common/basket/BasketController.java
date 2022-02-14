package jumo.common.basket;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jumo.model.BasketBean;
import jumo.util.MapToBean;

import jumo.util.validator.BasketValidator;

@Controller
public class BasketController {

	@Resource(name="basketService")
	private BasketService basketService;
	
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
		
		model.addAttribute("basketBeanList", basketBeanList);
		
		return "basketList";
	}
	
	@RequestMapping(value="/basketModify.al")
	public String basketModify(BasketBean basket, BindingResult result,
			Model model) throws Exception {
		
		new BasketValidator().validate(basket, result);
		
		if(result.hasErrors()) {
			// basketList.al이 파라미터로 BasketBean을 받아서 오류가 발생할 수 있음
			// BasketBean을 파라미터로 빼고 메서드 내에서 BasketBean을 생성한 뒤
			// 세션을 이용하여 BEMail값을 저장할 수 있도록 변경 basketBean.setBEMAIL() = request.getSession("EMAIL");
			// basketService.basketList(basketBean);
			return "/basketList.al";
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