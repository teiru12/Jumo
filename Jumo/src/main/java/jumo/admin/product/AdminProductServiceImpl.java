package jumo.admin.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jumo.model.ProductBean;

@Service("adminProductService")
public class AdminProductServiceImpl implements AdminProductService {

	@Resource(name="adminProductDAO")
	private AdminProductDAO adminProductDAO; 
	
	@Override
	public List<Map<String, Object>> allList() throws Exception {
		return adminProductDAO.allList();
	}

	@Override
	public List<Map<String, Object>> allListKeyWordSearch(String keyword, String isNumber) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("KEYWORD", keyword);
		map.put("ISNUMBER", isNumber);		
						
		return adminProductDAO.allListKeyWordSearch(map);		
	}

	@Override
	public void insertProduct(ProductBean product) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("PNAME", product.getPNAME());
		map.put("PIMAGE", product.getPIMAGE());
		map.put("PPRICE", product.getPPRICE());
		map.put("PSALE", product.getPSALE());
		map.put("PSTOCK", product.getPSTOCK());
		
		map.put("PCOM", product.getPCOM());
		map.put("PLOC", product.getPLOC());
		
		// PDEGREE가 -1이면 null을 입력
		if(product.getPDEGREE() == -1) {
			map.put("PDEGREE", null);
		} else {
			map.put("PDEGREE", product.getPDEGREE());
		}
		
		map.put("PKIND", product.getPKIND());
		map.put("PTYPE", product.getPTYPE());
						
		adminProductDAO.insertProduct(map);		
	}

	@Override
	public Map<String, Object> selectProductId(ProductBean product) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("PID", product.getPID());
						
		return adminProductDAO.selectProductId(map);
	}

	@Override
	public void updateProduct(ProductBean product) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("PNAME", product.getPNAME());
		map.put("PIMAGE", product.getPIMAGE());
		map.put("PPRICE", product.getPPRICE());
		map.put("PSALE", product.getPSALE());
		map.put("PSTOCK", product.getPSTOCK());
		
		map.put("PCOM", product.getPCOM());
		map.put("PLOC", product.getPLOC());
		map.put("PDEGREE", product.getPDEGREE());
		map.put("PKIND", product.getPKIND());
		map.put("PTYPE", product.getPTYPE());
		
		map.put("PID", product.getPID());
						
		adminProductDAO.updateProduct(map);
	}

	@Override
	public void deleteProduct(ProductBean product) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("PID", product.getPID());
						
		adminProductDAO.deleteProduct(map);
	}
}