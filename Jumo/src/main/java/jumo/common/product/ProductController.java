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
	public String allList(HttpServletRequest request, Model model) throws Exception{
		
		/* 페이징을 위한 변수 */
		int pageSize = 20; // 페이지당 출력할 상품의 수
		int START = 1;
		int END = pageSize;
		int currentPage = 1; // 현재 페이지

		int countProductAll; // 전체 상품의 수
		int pageBlock = 5; // 표시할 페이지의 수
		String url = "allList.al";
		String searchUrl = "";
		
		/* 검색 조건일 경우 사용 변수 */
		// -1, null일 경우 검색 조건에서 빠진다.
		String PKIND = null; // 주류의 종류
		int pDegreeMin = -1; // 도수 최소값
		int pDegreeMax = -1; // 도수 최소값
		int pPriceMin = -1; // 가격 최소값
		int pPriceMax = -1; // 가격 최대값
		String pOrder = null; // 가격순 정렬값, 최소값 정렬(ASC) ROW, 최대값 정렬(DESC) HIGH로 설정
		
		String PSELL = null; // 판매량 순 정렬을 할 때
		String PDATE = null; // 날짜 순 정렬을 할 때
		String searchPrint = ""; // 검색 조건이 있을 경우 출력해줄 메세지
		
		/* 기본 페이지가 아닐 경우 */
		if(request.getParameter("page")!=null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
			START = 1 + pageSize*(currentPage-1); 
			END = pageSize*currentPage;
		}
		
		/* 주종 검색 조건일 경우 */
		if(request.getParameter("PKIND")!=null) {
			PKIND = request.getParameter("PKIND");
			searchPrint += "주종 : " + PKIND + " ";
		}

		/* 도수 검색 조건일 경우 */		
		if(request.getParameter("dMax")!=null) {
			int dMax = Integer.parseInt(request.getParameter("dMax"));
			if(dMax<4) {
				pDegreeMax = dMax*10+10;
				pDegreeMin = dMax*10;				
			} else {
				pDegreeMax = 100; 
				pDegreeMin = 40;			
			}
			searchPrint += "도수 : " + pDegreeMin + "-" + pDegreeMax + " ";
		}
		
		/* 가격 검색 조건일 경우 */	
		if(request.getParameter("pMax")!=null) {
			int pMax = Integer.parseInt(request.getParameter("pMax"));
			
			switch(pMax) {
				case 0:
					pPriceMin = 0;
					pPriceMax = 5000;
					break;
				case 1:
					pPriceMin = 5000;
					pPriceMax = 10000;
					break;
				case 2:
					pPriceMin = 10000;
					pPriceMax = 20000;
					break;
				case 3:
					pPriceMin = 2000;
					pPriceMax = 30000;
					break;
				case 4:
					pPriceMin = 30000;
					pPriceMax = 10000000;
					break;
			}		
			searchPrint += "가격 : " + pPriceMin + "-" + pPriceMax + " ";
		}
		
		pOrder = request.getParameter("pOrder");
		PSELL = request.getParameter("PSELL");
		PDATE = request.getParameter("PDATE");
		
		/* url 값 설정 */
		if(PKIND!=null) {
			searchUrl += "&PKIND=" + PKIND;
		}
		if(request.getParameter("dMax")!=null) {
			searchUrl += "&dMax=" + request.getParameter("dMax");
		}
		if(request.getParameter("pMax")!=null) {
			searchUrl += "&pMax=" + request.getParameter("pMax");			
		}
		if(pOrder!=null) {
			searchUrl += "&pOrder=" + pOrder;
		} else if(PSELL!=null) {
			searchUrl += "&PSELL=" + PSELL; 
		} else if(PDATE!=null) {
			searchUrl += "&PDATE=" + PDATE;
		}

		/* 페이징을 위한 값 계산 */
		if(PKIND!=null || pDegreeMin!=-1 || pDegreeMax!=-1 || pPriceMin!=-1 || pPriceMax!=-1 || pOrder!=null || PSELL!=null || PDATE!=null) {
			// 조건이 있을 경우 조건 검색에 따른 수량 계산
			countProductAll = productService.allListSearchCount(PKIND, pDegreeMin, pDegreeMax, pPriceMin, pPriceMax);
		} else {
			countProductAll = productService.allListCount();			
		}

		// 페이징할 아이템의 총 수, 페이지의 수 ex> 1~5 6~10, 한 페이지에 표시할 아이템의 수, 현재 페이지, 이동주소, 검색시 사용할 주소 입력
		Paging paging = new Paging(countProductAll,	pageBlock,
				pageSize ,currentPage, url, searchUrl);
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if(PKIND!=null || pDegreeMin!=-1 || pDegreeMax!=-1 || pPriceMin!=-1 || pPriceMax!=-1 || pOrder!=null || PSELL!=null || PDATE!=null) {
			// 조건이 있을 경우 조건 검색
			list = productService.allListSearchPaging(PKIND, pDegreeMin, pDegreeMax, pPriceMin, pPriceMax, pOrder, PSELL, PDATE, START, END);
		} else {		
			list = productService.allListPaging(START, END);
		}
		
		List<ProductBean> productBeanList = new ArrayList<ProductBean>();
		for(Map<String, Object> mapObject : list) {
			productBeanList.add(MapToBean.mapToProduct(mapObject));
		}
		
		model.addAttribute("productBeanList", productBeanList);

		/* 페이징을 위한 값 삽입 */
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("paging", paging);
		
		/* 검색 조건 출력을 위한 메세지 삽입 */
		model.addAttribute("searchPrint", searchPrint);
		
		return "allList";
	}
	
	@RequestMapping("/aclList.al")
	public String aclList(HttpServletRequest request, Model model) throws Exception{		
		
		/* 페이징을 위한 변수 */
		int pageSize = 20; // 페이지당 출력할 상품의 수
		int START = 1;
		int END = pageSize;
		int currentPage = 1; // 현재 페이지

		int countProductAll; // 전체 상품의 수
		int pageBlock = 5; // 표시할 페이지의 수
		String url = "aclList.al";
		String searchUrl = "";
		
		/* 검색 조건일 경우 사용 변수 */
		// -1, null일 경우 검색 조건에서 빠진다.
		String PKIND = null; // 주류의 종류
		int pDegreeMin = -1; // 도수 최소값
		int pDegreeMax = -1; // 도수 최소값
		int pPriceMin = -1; // 가격 최소값
		int pPriceMax = -1; // 가격 최대값
		String pOrder = null; // 가격순 정렬값, 최소값 정렬(ASC) ROW, 최대값 정렬(DESC) HIGH로 설정
		
		String PSELL = null; // 판매량 순 정렬을 할 때
		String PDATE = null; // 날짜 순 정렬을 할 때
		String searchPrint = ""; // 검색 조건이 있을 경우 출력해줄 메세지
		
		/* 기본 페이지가 아닐 경우 */
		if(request.getParameter("page")!=null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
			START = 1 + pageSize*(currentPage-1); 
			END = pageSize*currentPage;
		}
		
		/* 주종 검색 조건일 경우 */
		if(request.getParameter("PKIND")!=null) {
			PKIND = request.getParameter("PKIND");
			searchPrint += "주종 : " + PKIND + " ";
		}

		/* 도수 검색 조건일 경우 */		
		if(request.getParameter("dMax")!=null) {
			int dMax = Integer.parseInt(request.getParameter("dMax"));
			if(dMax<4) {
				pDegreeMax = dMax*10+10;
				pDegreeMin = dMax*10;				
			} else {
				pDegreeMax = 100; 
				pDegreeMin = 40;			
			}
			searchPrint += "도수 : " + pDegreeMin + "-" + pDegreeMax + " ";
		}
		
		/* 가격 검색 조건일 경우 */	
		if(request.getParameter("pMax")!=null) {
			int pMax = Integer.parseInt(request.getParameter("pMax"));
			
			switch(pMax) {
				case 0:
					pPriceMin = 0;
					pPriceMax = 5000;
					break;
				case 1:
					pPriceMin = 5000;
					pPriceMax = 10000;
					break;
				case 2:
					pPriceMin = 10000;
					pPriceMax = 20000;
					break;
				case 3:
					pPriceMin = 2000;
					pPriceMax = 30000;
					break;
				case 4:
					pPriceMin = 30000;
					pPriceMax = 10000000;
					break;
			}		
			searchPrint += "가격 : " + pPriceMin + "-" + pPriceMax + " ";
		}
		
		pOrder = request.getParameter("pOrder");
		PSELL = request.getParameter("PSELL");
		PDATE = request.getParameter("PDATE");
		
		/* url 값 설정 */
		if(PKIND!=null) {
			searchUrl += "&PKIND=" + PKIND;
		}
		if(request.getParameter("dMax")!=null) {
			searchUrl += "&dMax=" + request.getParameter("dMax");
		}
		if(request.getParameter("pMax")!=null) {
			searchUrl += "&pMax=" + request.getParameter("pMax");			
		}
		if(pOrder!=null) {
			searchUrl += "&pOrder=" + pOrder;
		} else if(PSELL!=null) {
			searchUrl += "&PSELL=" + PSELL; 
		} else if(PDATE!=null) {
			searchUrl += "&PDATE=" + PDATE;
		}

		/* 페이징을 위한 값 계산 */
		if(PKIND!=null || pDegreeMin!=-1 || pDegreeMax!=-1 || pPriceMin!=-1 || pPriceMax!=-1 || pOrder!=null || PSELL!=null || PDATE!=null) {
			// 조건이 있을 경우 조건 검색에 따른 수량 계산
			countProductAll = productService.aclListSearchCount(PKIND, pDegreeMin, pDegreeMax, pPriceMin, pPriceMax);
		} else {
			countProductAll = productService.aclListCount();			
		}

		// 페이징할 아이템의 총 수, 페이지의 수 ex> 1~5 6~10, 한 페이지에 표시할 아이템의 수, 현재 페이지, 이동주소, 검색시 사용할 주소 입력
		Paging paging = new Paging(countProductAll,	pageBlock,
				pageSize ,currentPage, url, searchUrl);
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if(PKIND!=null || pDegreeMin!=-1 || pDegreeMax!=-1 || pPriceMin!=-1 || pPriceMax!=-1 || pOrder!=null || PSELL!=null || PDATE!=null) {
			// 조건이 있을 경우 조건 검색
			list = productService.aclListSearchPaging(PKIND, pDegreeMin, pDegreeMax, pPriceMin, pPriceMax, pOrder, PSELL, PDATE, START, END);
		} else {		
			list = productService.aclListPaging(START, END);
		}
		
		List<ProductBean> productBeanList = new ArrayList<ProductBean>();
		for(Map<String, Object> mapObject : list) {
			productBeanList.add(MapToBean.mapToProduct(mapObject));
		}
		
		model.addAttribute("productBeanList", productBeanList);

		/* 페이징을 위한 값 삽입 */
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("paging", paging);
		
		/* 검색 조건 출력을 위한 메세지 삽입 */
		model.addAttribute("searchPrint", searchPrint);
		
		return "aclList";
	}
	
	@RequestMapping("/etcList.al")
	public String etcList(HttpServletRequest request, Model model) throws Exception{		
		
		/* 페이징을 위한 변수 */
		int pageSize = 20; // 페이지당 출력할 상품의 수
		int START = 1;
		int END = pageSize;
		int currentPage = 1; // 현재 페이지

		int countProductAll; // 전체 상품의 수
		int pageBlock = 5; // 표시할 페이지의 수
		String url = "aclList.al";
		String searchUrl = "";
		
		/* 검색 조건일 경우 사용 변수 */
		String pOrder = null; // 가격순 정렬값, 최소값 정렬(ASC) ROW, 최대값 정렬(DESC) HIGH로 설정
		String PSELL = null; // 판매량 순 정렬을 할 때
		String PDATE = null; // 날짜 순 정렬을 할 때
		
		/* 기본 페이지가 아닐 경우 */
		if(request.getParameter("page")!=null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
			START = 1 + pageSize*(currentPage-1); 
			END = pageSize*currentPage;
		}
		
		pOrder = request.getParameter("pOrder");
		PSELL = request.getParameter("PSELL");
		PDATE = request.getParameter("PDATE");
		
		/* url 값 설정 */
		if(pOrder!=null) {
			searchUrl += "&pOrder=" + pOrder;
		} else if(PSELL!=null) {
			searchUrl += "&PSELL=" + PSELL; 
		} else if(PDATE!=null) {
			searchUrl += "&PDATE=" + PDATE;
		}

		/* 페이징을 위한 값 계산 */
		countProductAll = productService.etcListCount();			


		// 페이징할 아이템의 총 수, 페이지의 수 ex> 1~5 6~10, 한 페이지에 표시할 아이템의 수, 현재 페이지, 이동주소, 검색시 사용할 주소 입력
		Paging paging = new Paging(countProductAll,	pageBlock,
				pageSize ,currentPage, url, searchUrl);
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if(pOrder!=null || PSELL!=null || PDATE!=null) {
			// 조건이 있을 경우 조건 검색
			list = productService.etcListSearchPaging(pOrder, PSELL, PDATE, START, END);
		} else {		
			list = productService.etcListPaging(START, END);
		}
		
		List<ProductBean> productBeanList = new ArrayList<ProductBean>();
		for(Map<String, Object> mapObject : list) {
			productBeanList.add(MapToBean.mapToProduct(mapObject));
		}
		
		model.addAttribute("productBeanList", productBeanList);

		/* 페이징을 위한 값 삽입 */
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("paging", paging);
		
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
