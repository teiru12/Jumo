package jumo.common.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jumo.model.BasketBean;
import jumo.model.CommunityBean;
import jumo.model.ProductBean;

@Controller
public class ProductController {
	
	@Resource(name="productService")
	private ProductService productService;
	
	@RequestMapping("/allList.al")
	public String allList(Model model) throws Exception{
		
		List<Map<String, Object>> list = productService.allList();
		
		List<ProductBean> productBeanList = new ArrayList<ProductBean>();

	
		for(Map<String, Object> mapObject : list) {
		
			productBeanList.add(MapToBean.mapToProduct(mapObject));
		}
		model.addAttribute("productBeanList", productBeanList);
		
		return "/product/allList";
	}
	
	@RequestMapping(value="/allList.al", method=RequestMethod.POST)
	public String allListSearch(
			@RequestParam("pOrder") String pOrder,
			@RequestParam("pDegreeMin") int pDegreeMin,
			@RequestParam("pDegreeMax") int pDegreeMax,
			@RequestParam("pPriceMin") int pPriceMin,
			@RequestParam("pPriceMax") int pPriceMax,
			ProductBean product, Model model) throws Exception{
		
		List<ProductBean> searchList = new ArrayList<ProductBean>();
		
		List<Map<String, Object>> list = productService.allListSearch(
				product, pDegreeMin, pDegreeMax, pPriceMin,
				pPriceMax, pOrder);
		
		for(Map<String, Object> mapObject : list) {
			searchList.add(MapToBean.mapToProduct(mapObject));
		}
		
		model.addAttribute("pOrder", pOrder);
		model.addAttribute("pDegreeMin", pDegreeMin);
		model.addAttribute("pDegreeMax", pDegreeMax);
		model.addAttribute("pPriceMin", pPriceMin);
		model.addAttribute("pPriceMax", pPriceMax);
		
		model.addAttribute("searchList", searchList);
	
		return "/product/allList";
	}
	
	@RequestMapping("/aclList.al")
	public String aclList(ProductBean product, Model model) throws Exception{
		
		List<Map<String, Object>> list = productService.aclList();
		
		List<ProductBean> productBeanList = new ArrayList<ProductBean>();
		
		for(Map<String, Object> mapObject : list) {
			
			productBeanList.add(MapToBean.mapToProduct(mapObject));
		}
		model.addAttribute("productBeanList", productBeanList);
		
		return "/product/aclList";
	}
	
	@RequestMapping(value="/aclList.al", method=RequestMethod.POST)
	public String aclListSearch(
			@RequestParam("pOrder") String pOrder,
			@RequestParam("pDegreeMin") int pDegreeMin,
			@RequestParam("pDegreeMax") int pDegreeMax,
			@RequestParam("pPriceMin") int pPriceMin,
			@RequestParam("pPriceMax") int pPriceMax,
			ProductBean product, Model model) throws Exception{
		
		List<ProductBean> searchList = new ArrayList<ProductBean>();
		
		List<Map<String, Object>> list = productService.aclListSearch(
				product, pDegreeMin, pDegreeMax, pPriceMin,
				pPriceMax, pOrder);
		
		for(Map<String, Object> mapObject : list) {
			searchList.add(MapToBean.mapToProduct(mapObject));
		}
		
		model.addAttribute("pOrder", pOrder);
		model.addAttribute("pDegreeMin", pDegreeMin);
		model.addAttribute("pDegreeMax", pDegreeMax);
		model.addAttribute("pPriceMin", pPriceMin);
		model.addAttribute("pPriceMax", pPriceMax);
		
		model.addAttribute("searchList", searchList);
		return "/product/aclList";
	}
	
	@RequestMapping("/etcList.al")
	public String etcList(ProductBean product, Model model) throws Exception{
		
		List<Map<String, Object>> list = productService.etcList();
		
		List<ProductBean> productBeanList = new ArrayList<ProductBean>();
		
		for(Map<String, Object> mapObject : list) {
			
			productBeanList.add(MapToBean.mapToProduct(mapObject));
		}
		model.addAttribute("productBeanList", productBeanList);
		
		return "/product/etcList";
	}
	
	@RequestMapping(value="/etcList.al", method=RequestMethod.POST)
	public String etcListSearch(
			@RequestParam("pOrder") String pOrder ,
			ProductBean product, Model model) throws Exception{
		
		List<Map<String, Object>> list = productService.etcListSearch(
				product, pOrder);
		List<ProductBean> etcBeanList = new ArrayList<ProductBean>();
		
		for(Map<String, Object> mapObject : list) {
			etcBeanList.add(MapToBean.mapToProduct(mapObject));
		}
		
		model.addAttribute("etcBeanList", etcBeanList);
		return "/product/etcList";
	}
	
	@RequestMapping("/pDetail.al")
	public String pDetail(ProductBean product, CommunityBean community, Model model) throws Exception{
		
		Map<String, Object> map = productService.selectProductId(product);
		ProductBean productBean = new ProductBean();
		
		productBean = MapToBean.mapToProduct(map);		
		
		List<Map<String, Object>> list = productService.selectReviewProduct(community);
		List<CommunityBean> reviewBeanList = new ArrayList<CommunityBean>();

	
		for(Map<String, Object> mapObject : list) {
			reviewBeanList.add(MapToBean.mapToCommunity(mapObject));
		}
		
		model.addAttribute("productBean", productBean);
		model.addAttribute("reviewBeanList", reviewBeanList);
		
		return "/product/pDetail";
	}


	@RequestMapping(value="/putBasket.al", method=RequestMethod.POST)
	public String putBasket(BasketBean basket, Model model) throws Exception{
		
		productService.insertBasket(basket);
		
		return "/product/putBasket";
	}
	
	@RequestMapping("/pReviewForm.al")
	public String pReviewForm(Model model) throws Exception{
		
		return "/product/pReviewForm";
	}
	
	@RequestMapping("/pReview.al")
	public String pReview(CommunityBean community, Model model) throws Exception{
		
		productService.insertReview(community);
		
		return "/product/pReview";
	}

}
