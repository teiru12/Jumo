package jumo.admin.product;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jumo.model.ProductBean;
import jumo.util.FileUpload;
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
		MultipartFile detail_imageFile1 = request.getFile("image1");
		MultipartFile detail_imageFile2 = request.getFile("image2");
		MultipartFile detail_imageFile3 = request.getFile("image3");
		MultipartFile detail_imageFile4 = request.getFile("image4");
		
		// 상품의 종류가 ETC인 경우 주종과 도수를 null로 설정
		if(product.getPTYPE().equals("ETC")) {
			product.setPKIND(null);
			product.setPDEGREE(-1);
		}
		
		// 마지막에 입력한 상품의 정보로부터 상품번호를 가져온 뒤 (selectPIDMax)
		// 1을 더해서 새로 저장될 파일에 붙여줄 숫자를 구한다.
		int newPID = adminProductService.selectPIDMax() + 1;
		
		// 상품번호를 사용해 메인 이미지를 등록
		String uploadMainImageName = "product-" + newPID +".png";
		
		// 메인 이미지 이름을 product의 PIMAGE에 입력
		product.setPIMAGE(uploadMainImageName);
		
		// 상품 이미지를 입력할 폴더 설정
		String path = request.getSession().getServletContext().getRealPath("/") + File.separator + "img";
		
		FileUpload.fileUpload(main_imageFile, path, uploadMainImageName);
		
		// 만약 상세 이미지가 존재하면 상세 이미지를 등록
		int detailCount = 0; // 상세 이미지 등록 수, 등록할 때마다 1씩 증가, 등록할 때는 +1로 계산해서 등록 
		if(! detail_imageFile1.isEmpty()) {
			String uploadDetailImageName = "product-" + newPID +"-detail" + (detailCount+1) + ".png";
			detailCount++;
			FileUpload.fileUpload(detail_imageFile1, path, uploadDetailImageName);
		} 
		if(! detail_imageFile2.isEmpty()) {
			String uploadDetailImageName = "product-" + newPID +"-detail" + (detailCount+1) + ".png";
			detailCount++;
			FileUpload.fileUpload(detail_imageFile2, path, uploadDetailImageName);
		} 
		if(! detail_imageFile3.isEmpty()) {
			String uploadDetailImageName = "product-" + newPID +"-detail" + (detailCount+1) + ".png";
			detailCount++;
			FileUpload.fileUpload(detail_imageFile3, path, uploadDetailImageName);
		}
		if(! detail_imageFile4.isEmpty()) {
			String uploadDetailImageName = "product-" + newPID +"-detail" + (detailCount+1) + ".png";
			detailCount++;
			FileUpload.fileUpload(detail_imageFile4, path, uploadDetailImageName);
		}		
		
		// DB에 상품 정보 입력
		adminProductService.insertProduct(product);
		
		// 메시지와 url 설정
		model.addAttribute("msg", "상품을 등록하였습니다.");
		model.addAttribute("url", "/adminPList.al");
	   
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