package jumo.common.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
	
	@RequestMapping("/allList.al")
	public String allList(Model model) throws Exception{
		
		return "/product/allList";
	}
	
	@RequestMapping(value="/allList.al", method=RequestMethod.POST)
	public String allListSearch(Model model) throws Exception{
		
		return "/product/allList";
	}
	
	@RequestMapping("/aclList.al")
	public String aclList(Model model) throws Exception{
		
		return "/product/aclList";
	}
	
	@RequestMapping(value="/aclList.al", method=RequestMethod.POST)
	public String aclListSearch(Model model) throws Exception{
		
		return "/product/aclList";
	}
	
	@RequestMapping("/etcList.al")
	public String etcList(Model model) throws Exception{
		
		return "/product/etcList";
	}
	
	@RequestMapping(value="/etcList.al", method=RequestMethod.POST)
	public String etcListSearch(Model model) throws Exception{
		
		return "/product/etcList";
	}
	
	@RequestMapping("/pDetail.al")
	public String pDetail(Model model) throws Exception{
		
		return "/product/pDetail";
	}

	@RequestMapping(value="/putBasket.al", method=RequestMethod.POST)
	public String putBasket(Model model) throws Exception{
		
		return "/product/putBasket";
	}
	
	@RequestMapping("/pReviewForm.al")
	public String pReviewForm(Model model) throws Exception{
		
		return "/product/pReviewForm";
	}
	
	@RequestMapping("/pReview.al")
	public String pReview(Model model) throws Exception{
		
		return "/product/pReview";
	}

}
