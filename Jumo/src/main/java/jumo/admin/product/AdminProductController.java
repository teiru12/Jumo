package jumo.admin.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jumo.model.ProductBean;
import jumo.util.MapToBean;

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
	
	@RequestMapping(value="/adminPList.al", method=RequestMethod.POST)
	public String adminPListSearch(
			@RequestParam("keyword") String keyword ,
			@RequestParam("isNumber") String isNumber ,Model model) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<ProductBean> adminPsearchList = new ArrayList<ProductBean>();
		
		list= adminProductService.allListKeyWordSearch(keyword, isNumber);
		
		for(Map<String, Object> mapObject : list) {
			adminPsearchList.add(MapToBean.mapToProduct(mapObject));
		}
		
		model.addAttribute("adminPsearchList", adminPsearchList);
		
		return "adminPList";
	}

	@RequestMapping(value="/adminPWriteForm.al")
	public String adminPWriteForm(Model model) throws Exception {
		return "adminPWriteForm";
	}
	
	@RequestMapping(value="/adminPWrite.al")
	public String adminPWrite(ProductBean product, Model model) throws Exception {
		
		adminProductService.insertProduct(product);
		
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
	public String adminPModify(Model model, ProductBean product) throws Exception {
		
		adminProductService.updateProduct(product);
		
		return "/admin/product/adminPModify";
	}

	@RequestMapping(value="/adminSellList.al")
	public String adminSellList(Model model) throws Exception {
		
		List<Map<String, Object>> list = adminProductService.allList();
		
		List<ProductBean> productBeanList = new ArrayList<ProductBean>();
		
		for(Map<String, Object> mapObject : list) {
			productBeanList.add(MapToBean.mapToProduct(mapObject));
		}
		model.addAttribute("productBeanList", productBeanList);
		
		return "adminSellList";
	}	
}