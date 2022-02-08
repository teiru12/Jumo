package jumo.common.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jumo.common.community.CommunityDAO;
import jumo.model.BasketBean;
import jumo.model.CommunityBean;
import jumo.model.ProductBean;


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
		
		map.put("PDEGREEMIN", product.getPDEGREE());
		map.put("PDEGREEMAX", product.getPDEGREE());
		map.put("PPRICEMIN", product.getPPRICE());
		map.put("PPRICEMAX", product.getPPRICE());
		
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
		
		map.put("PDEGREEMIN", product.getPDEGREE());
		map.put("PDEGREEMAX", product.getPDEGREE());
		map.put("PPRICEMIN", product.getPPRICE());
		map.put("PPRICEMAX", product.getPPRICE());
		
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
		
		map.put("PSELL", product.getPSALE());
		map.put("PPRICE", product.getPPRICE());
		map.put("PDATE", product.getPDATE());
		map.put("PORDER",PORDER);
		
		return productDAO.etcListSearch(map);
	}

	@Override
	public List<Map<String, Object>> selectReviewProduct(CommunityBean community) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("CTYPE",community.getCTYPE());
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
		map.put("CDATE", community.getCDATE());
		map.put("PID",community.getPID());
		map.put("CCOUNT", community.getCCOUNT());
		map.put("CCONTENT", community.getCCONTENT());
		map.put("CTYPE", community.getCTYPE());
		
		productDAO.insertReview(map);
	}
	
}
