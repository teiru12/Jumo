package jumo.admin.product;

import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jumo.model.ProductBean;
import jumo.util.MapToBean;
import jumo.util.validator.ProductValidator;

@Controller
public class AdminProductController {

	@Resource(name="adminProductService")
	private AdminProductService adminProductService;
	
	@RequestMapping(value="/adminPList.al")
	public String adminPList(Model model) throws Exception{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<ProductBean> adminPBeanList = new ArrayList<ProductBean>();
		list = adminProductService.allList(); 
		
		for(Map<String, Object> mapObject : list) {
			adminPBeanList.add(MapToBean.mapToProduct(mapObject));
		}
		
		model.addAttribute("adminPBeanList", adminPBeanList);
		
		
		return "adminPList";
	}
	
	@RequestMapping(value="/adminPWriteForm.al")
	public String adminPWriteForm(Model model) throws Exception {
		return "adminPWriteForm";
	}
	
	@RequestMapping(value="/adminPWrite.al")
	public String adminPWrite(ProductBean product, 
			MultipartHttpServletRequest request,
			Model model) throws Exception {
		
		MultipartFile main_imageFile = request.getFile("main_image");
		MultipartFile detail_imageFile1 = request.getFile("image2");
		MultipartFile detail_imageFile2 = request.getFile("image3");
		MultipartFile detail_imageFile3 = request.getFile("image4");
		MultipartFile detail_imageFile4 = request.getFile("image5");
		
		String mainImageName = main_imageFile.getOriginalFilename();
		String detailName1 = "";
		String detailName2 = "";
		String detailName3 = "";
		String detailName4 = "";
		if(detail_imageFile1 != null) {
			detailName1 = detail_imageFile1.getOriginalFilename();
		}
		if(detail_imageFile2 != null) {		
			detailName2 = detail_imageFile2.getOriginalFilename();
		}
		if(detail_imageFile3 != null) {
			detailName3 = detail_imageFile3.getOriginalFilename();
		}
		if(detail_imageFile4 != null) {
			detailName4 = detail_imageFile4.getOriginalFilename();
		}
		
		System.out.println(mainImageName);
		if(detail_imageFile1 != null) {
			System.out.println(detailName1);
		}
		if(detail_imageFile2 != null) {		
			System.out.println(detailName2);
		}
		if(detail_imageFile3 != null) {
			System.out.println(detailName3);
		}
		if(detail_imageFile4 != null) {
			System.out.println(detailName4);
		}
		
		
		
	
		

		
		// 상품의 종류가 ETC인 경우 주종과 도수를 null로 설정
		if(product.getPTYPE().equals("ETC")) {
			product.setPKIND(null);
			product.setPDEGREE(-1);
		}
		
				
		// 메인 이미지 이름을 product의 PIMAGE에 입력
		product.setPIMAGE(mainImageName);
		
		System.out.println("PNAME : " + product.getPNAME());
		System.out.println("PIMAGE : " + product.getPIMAGE());
		System.out.println("PPRICE : " + product.getPPRICE());
		System.out.println("PSALE : " + product.getPSALE());
		System.out.println("PSTOCK : " + product.getPSTOCK());
		System.out.println("PCOM : " + product.getPCOM());
		System.out.println("PLOC : " + product.getPLOC());
		System.out.println("PDEGREE : " + product.getPDEGREE());
		System.out.println("PKIND : " + product.getPKIND());
		System.out.println("PTYPE : " + product.getPTYPE());
		
		adminProductService.insertProduct(product);
		
		// 마지막에 입력한 상품의 정보로부터 상품번호를 가져옴 (selectProductMax)
		
		// 상품번호를 사용해 메인 이미지를 등록
		
		// 만약 상세 이미지가 존재하면 상세 이미지를 등록
		
		// 메시지와 url 설정
		model.addAttribute("msg", "상품을 등록하였습니다.");
		model.addAttribute("url", "/adminPlist.al");
	   
		return "/admin/product/adminPWrite";
	}
	
	@RequestMapping(value="/adminPModifyForm.al")
	public String adminPModifyForm(Model model, ProductBean product) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		ProductBean productBean = new ProductBean();
		
		map = adminProductService.selectProductId(product);
		
		productBean = MapToBean.mapToProduct(map);
		
		model.addAttribute("productBean", productBean);
		
		return "adminPModifyForm";
	}
	
	@RequestMapping(value="/adminPModify.al")
	public String adminPModify(ProductBean product, BindingResult result,
			Model model) throws Exception {
		
		new ProductValidator().validate(product, result);
		
		if(result.hasErrors()) {
			// /adminPModifyForm.al가 ProductBean을 파라미터로 받아 오류발생 가능성 있음
			return "/adminPModifyForm.al";
		}
		
		adminProductService.updateProduct(product);
		
		return "/admin/product/adminPModify";
	}

	@RequestMapping(value="/adminSellList.al")
	public String adminSellList(Model model) throws Exception {
		
		List<Map<String, Object>> list = adminProductService.allList();
		
		List<ProductBean> sellList = new ArrayList<ProductBean>();
		
		for(Map<String, Object> mapObject : list) {
			sellList.add(MapToBean.mapToProduct(mapObject));
		}
		model.addAttribute("sellList", sellList);
		
		return "adminSellList";
	}	
}