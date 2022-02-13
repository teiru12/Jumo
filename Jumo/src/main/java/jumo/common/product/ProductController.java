package jumo.common.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jumo.model.BasketBean;
import jumo.model.CommunityBean;
import jumo.model.ProductBean;
import jumo.util.MapToBean;
import jumo.util.validator.BasketValidator;
import jumo.util.validator.CommunityValidator;
import jumo.util.Paging;

@Controller
public class ProductController {
	
	@Resource(name="productService")
	private ProductService productService;
	
	@RequestMapping("/allList.al")
	public String allList(
			HttpServletRequest request,
			Model model) throws Exception{
		/* 페이징을 위한 변수 */
		int pageSize = 2; // 페이지당 출력할 상품의 수
		int START = 1;
		int END = pageSize;
		int currentPage = 1; // 현재 페이지

		int countProductAll; // 전체 상품의 수
		int pageBlock = 5; // 표시할 페이지의 수
		
		/* 기본 페이지가 아닐 경우 */
		if(request.getParameter("page")!=null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
			START = 1 + pageSize*(currentPage-1); 
			END = pageSize*currentPage;
		}
		
		List<Map<String, Object>> list = productService.allListPaging(START, END);
		List<ProductBean> productBeanList = new ArrayList<ProductBean>();
		for(Map<String, Object> mapObject : list) {
			productBeanList.add(MapToBean.mapToProduct(mapObject));
		}
		
		model.addAttribute("productBeanList", productBeanList);
		
		/* 페이징을 위한 값 계산 */
		countProductAll = productService.allListCount();
		
		Paging paging = new Paging(countProductAll,	pageBlock,
				pageSize ,currentPage, "allList.al");

		/* 페이징을 위한 값 삽입 */
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("paging", paging);
		
		return "allList";
	}
	
	@RequestMapping(value="/allList.al", method=RequestMethod.POST)
	public String allListSearch(
			@RequestParam("pOrder") String pOrder,
			@RequestParam("pDegreeMin") int pDegreeMin,
			@RequestParam("pDegreeMax") int pDegreeMax,
			@RequestParam("pPriceMin") int pPriceMin,
			@RequestParam("pPriceMax") int pPriceMax,
			@RequestParam("START") int START,
			@RequestParam("END") int END,
			ProductBean product, Model model) throws Exception{
		
		List<ProductBean> searchList = new ArrayList<ProductBean>();
		
		List<Map<String, Object>> list = productService.allListSearchPaging(
				product, pDegreeMin, pDegreeMax, pPriceMin,
				pPriceMax, pOrder, START, END);
		
		for(Map<String, Object> mapObject : list) {
			searchList.add(MapToBean.mapToProduct(mapObject));
		}
		
		model.addAttribute("pOrder", pOrder);
		model.addAttribute("pDegreeMin", pDegreeMin);
		model.addAttribute("pDegreeMax", pDegreeMax);
		model.addAttribute("pPriceMin", pPriceMin);
		model.addAttribute("pPriceMax", pPriceMax);
		
		model.addAttribute("searchList", searchList);
	
		return "allList";
	}
	
	@RequestMapping("/aclList.al")
	public String aclList(ProductBean product,
			@RequestParam("START") int START,
			@RequestParam("END") int END,
			Model model) throws Exception{
		
		List<Map<String, Object>> list = productService.aclListPaging(START, END);
		
		List<ProductBean> productBeanList = new ArrayList<ProductBean>();
		
		for(Map<String, Object> mapObject : list) {
			productBeanList.add(MapToBean.mapToProduct(mapObject));
		}
		model.addAttribute("productBeanList", productBeanList);
		
		return "aclList";
	}
	
	@RequestMapping(value="/aclList.al", method=RequestMethod.POST)
	public String aclListSearch(
			@RequestParam("pOrder") String pOrder,
			@RequestParam("pDegreeMin") int pDegreeMin,
			@RequestParam("pDegreeMax") int pDegreeMax,
			@RequestParam("pPriceMin") int pPriceMin,
			@RequestParam("pPriceMax") int pPriceMax,
			@RequestParam("START") int START,
			@RequestParam("END") int END,
			ProductBean product, Model model) throws Exception{
		
		List<ProductBean> searchList = new ArrayList<ProductBean>();
		
		List<Map<String, Object>> list = productService.aclListSearchPaging(
				product, pDegreeMin, pDegreeMax, pPriceMin,
				pPriceMax, pOrder, START, END);
		
		for(Map<String, Object> mapObject : list) {
			searchList.add(MapToBean.mapToProduct(mapObject));
		}
		
		model.addAttribute("pOrder", pOrder);
		model.addAttribute("pDegreeMin", pDegreeMin);
		model.addAttribute("pDegreeMax", pDegreeMax);
		model.addAttribute("pPriceMin", pPriceMin);
		model.addAttribute("pPriceMax", pPriceMax);
		
		model.addAttribute("searchList", searchList);
		return "aclList";
	}
	
	@RequestMapping("/etcList.al")
	public String etcList(ProductBean product, 
			@RequestParam("START") int START,
			@RequestParam("END") int END,
			Model model) throws Exception{
		
		List<Map<String, Object>> list = productService.etcListPaging(START, END);
		
		List<ProductBean> productBeanList = new ArrayList<ProductBean>();
		
		for(Map<String, Object> mapObject : list) {
			
			productBeanList.add(MapToBean.mapToProduct(mapObject));
		}
		model.addAttribute("productBeanList", productBeanList);
		
		return "etcList";
	}
	
	@RequestMapping(value="/etcList.al", method=RequestMethod.POST)
	public String etcListSearch(
			@RequestParam("pOrder") String pOrder ,
			@RequestParam("START") int START,
			@RequestParam("END") int END,
			ProductBean product, Model model) throws Exception{
		
		List<Map<String, Object>> list = productService.etcListSearchPaging(
				product, pOrder, START, END);
		List<ProductBean> etcBeanList = new ArrayList<ProductBean>();
		
		for(Map<String, Object> mapObject : list) {
			etcBeanList.add(MapToBean.mapToProduct(mapObject));
		}
		
		model.addAttribute("etcBeanList", etcBeanList);
		return "etcList";
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
		
		return "pDetail";
	}


	@RequestMapping(value="/putBasket.al", method=RequestMethod.POST)
	public String putBasket(BasketBean basket, BindingResult result,
			Model model) throws Exception{
		
		new BasketValidator().validate(basket, result);
		
		if(result.hasErrors()) {
			return "/allList.al";
			// pDetail 페이지로 넘어가기 위해서는 ProductBean, CommunityBean 객체를 넘겨줘야하는데
			// 바로 리턴하면 오류발생
			// 자바 스크립트로 오류체크
			// return "pDetail";
		}
		
		productService.insertBasket(basket);
		
		return "/product/putBasket";
	}
	
	@RequestMapping("/pReviewForm.al")
	public String pReviewForm(Model model) throws Exception{
		
		return "pReviewForm";
	}
	
	@RequestMapping("/pReview.al")
	public String pReview(CommunityBean community, BindingResult result,
			Model model) throws Exception{
		
		new CommunityValidator().validate(community, result);
		
		if(result.hasErrors()) {
			return "pReviewForm";
		}
		
		productService.insertReview(community);
		
		return "/product/pReview";
	}

}
