package jumo.common.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jumo.model.BasketBean;
import jumo.model.CommunityBean;
import jumo.model.ProductBean;

@Service("productService")
public class ProductServiceImpl implements ProductService{
	
	@Resource(name="productDAO")
	private ProductDAO productDAO;
	
	@Override
	public Map<String, Object> selectProductId(ProductBean product) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("PID", product.getPID());
		
		return productDAO.selectProductId(map);
	}
	
	@Override
	public List<Map<String, Object>> allList() throws Exception{
		
		return productDAO.allList();
	}
	
	@Override
	public List<Map<String, Object>> allListSearch(ProductBean product, int PDEGREEMIN, int PDEGREEMAX, int PPRICEMIN, int PPRICEMAX, String PORDER)
			throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("PKIND",product.getPKIND());
		
		map.put("PDEGREEMIN", PDEGREEMIN);
		map.put("PDEGREEMAX", PDEGREEMAX);
		map.put("PPRICEMIN", PPRICEMIN);
		map.put("PPRICEMAX", PPRICEMAX);
		
		map.put("PSELL", product.getPSELL());
		map.put("PPRICE", product.getPPRICE());
		map.put("PDATE", product.getPDATE());
		map.put("PORDER", PORDER);
		
		return productDAO.allListSearch(map);	
	}

	@Override
	public List<Map<String, Object>> aclList() throws Exception {
		
		return productDAO.aclList();
	}

	@Override
	public List<Map<String, Object>> aclListSearch(ProductBean product, int PDEGREEMIN, int PDEGREEMAX, int PPRICEMIN, int PPRICEMAX, String PORDER)
			throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("PKIND",product.getPKIND());
		
		map.put("PDEGREEMIN", PDEGREEMIN);
		map.put("PDEGREEMAX", PDEGREEMAX);
		map.put("PPRICEMIN", PPRICEMIN);
		map.put("PPRICEMAX", PPRICEMAX);
		
		map.put("PSELL", product.getPSELL());
		map.put("PPRICE", product.getPPRICE());
		map.put("PDATE", product.getPDATE());
		map.put("PORDER", PORDER);
		
		return productDAO.aclListSearch(map);
	}

	@Override
	public List<Map<String, Object>> etcList() throws Exception {
		
		return productDAO.etcList();
	}

	@Override
	public List<Map<String, Object>> etcListSearch(ProductBean product, String PORDER) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("PSELL", product.getPSELL());
		map.put("PPRICE", product.getPPRICE());
		map.put("PDATE", product.getPDATE());
		map.put("PORDER",PORDER);
		
		return productDAO.etcListSearch(map);
	}

	@Override
	public List<Map<String, Object>> selectReviewProduct(CommunityBean community) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("PID", community.getPID());
		
		return productDAO.selectReviewProduct(map);
	}

	@Override
	public void insertBasket(BasketBean basket) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("BNAME", basket.getBNAME());
		map.put("BID", basket.getBID());
		map.put("BPRICE", basket.getBPRICE());
		map.put("BSALE", basket.getBSALE());
		map.put("BEMAIL", basket.getBEMAIL());
		map.put("BECOUNT", basket.getBCOUNT());
		
		productDAO.insertBasket(map);
		
	}

	@Override
	public void insertReview(CommunityBean community) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("CTITLE", community.getCTITLE());
		map.put("CWRITER",community.getCWRITER());
		map.put("PID",community.getPID());
		map.put("CCOUNT", community.getCCOUNT());
	
		productDAO.insertReview(map);
	}
	
	/* 페이징 */
	
	@Override
	public List<Map<String, Object>> allListPaging(int START, int END) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("START", START);
		map.put("END", END);
		
		return productDAO.allListPaging(map);
	}

	@Override
	public List<Map<String, Object>> allListSearchPaging(ProductBean product, int PDEGREEMIN, int PDEGREEMAX, int PPRICEMIN, int PPRICEMAX, String PORDER, int START, int END)
			throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("PKIND",product.getPKIND());
		
		map.put("PDEGREEMIN", PDEGREEMIN);
		map.put("PDEGREEMAX", PDEGREEMAX);
		map.put("PPRICEMIN", PPRICEMIN);
		map.put("PPRICEMAX", PPRICEMAX);
		
		map.put("PSELL", product.getPSELL());
		map.put("PPRICE", product.getPPRICE());
		map.put("PDATE", product.getPDATE());
		map.put("PORDER", PORDER);
		
		map.put("START",START);
		map.put("END",END);
		
		return productDAO.allListSearchPaging(map);	
	}
	
	@Override
	public List<Map<String, Object>> aclListPaging(int START, int END) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("START",START);
		map.put("END",END);
		
		return productDAO.aclListPaging(map);
	}
	
	@Override
	public List<Map<String, Object>> aclListSearchPaging(ProductBean product, int PDEGREEMIN, int PDEGREEMAX, int PPRICEMIN, int PPRICEMAX, String PORDER, int START, int END)
			throws Exception {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("PKIND",product.getPKIND());
		
		map.put("PDEGREEMIN", PDEGREEMIN);
		map.put("PDEGREEMAX", PDEGREEMAX);
		map.put("PPRICEMIN", PPRICEMIN);
		map.put("PPRICEMAX", PPRICEMAX);
		
		map.put("PSELL", product.getPSELL());
		map.put("PPRICE", product.getPPRICE());
		map.put("PDATE", product.getPDATE());
		map.put("PORDER", PORDER);
		
		map.put("START",START);
		map.put("END",END);
		
		return productDAO.aclListSearchPaging(map);
	}
	
	@Override
	public List<Map<String, Object>> etcListPaging(int START, int END) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("START",START);
		map.put("END",END);
		
		return productDAO.etcListPaging(map);
	}
	
	@Override
	public List<Map<String, Object>> etcListSearchPaging(ProductBean product, String PORDER, int START, int END) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("PSELL", product.getPSALE());
		map.put("PPRICE", product.getPPRICE());
		map.put("PDATE", product.getPDATE());
		map.put("PORDER",PORDER);
		
		map.put("START",START);
		map.put("END",END);
		
		return productDAO.etcListSearchPaging(map);
	}
	
	@Override
	public int allListCount() throws Exception {
		Map<String,Object> mapCount = productDAO.allListCount();
		return Integer.parseInt(String.valueOf(mapCount.get("COUNT")));
	}
	
	@Override
	public int allListSearchCount(ProductBean product, int PDEGREEMIN, int PDEGREEMAX, int PPRICEMIN, int PPRICEMAX) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("PKIND",product.getPKIND());
		
		map.put("PDEGREEMIN", PDEGREEMIN);
		map.put("PDEGREEMAX", PDEGREEMAX);
		map.put("PPRICEMIN", PPRICEMIN);
		map.put("PPRICEMAX", PPRICEMAX);
		
		Map<String,Object> mapCount = productDAO.allListSearchCount(map);
		return Integer.parseInt(String.valueOf(mapCount.get("COUNT")));
	}
	
	@Override
	public int aclListCount() throws Exception {
		Map<String,Object> mapCount = productDAO.aclListCount();
		return Integer.parseInt(String.valueOf(mapCount.get("COUNT")));
	}
	
	@Override
	public int aclListSearchCount(ProductBean product, int PDEGREEMIN, int PDEGREEMAX, int PPRICEMIN, int PPRICEMAX) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("PKIND",product.getPKIND());
		
		map.put("PDEGREEMIN", PDEGREEMIN);
		map.put("PDEGREEMAX", PDEGREEMAX);
		map.put("PPRICEMIN", PPRICEMIN);
		map.put("PPRICEMAX", PPRICEMAX);
		
		Map<String,Object> mapCount = productDAO.aclListSearchCount(map);
		return Integer.parseInt(String.valueOf(mapCount.get("COUNT")));
	}
	
	@Override
	public int etcListCount() throws Exception {
		Map<String,Object> mapCount = productDAO.etcListCount();
		return Integer.parseInt(String.valueOf(mapCount.get("COUNT")));
	}
}