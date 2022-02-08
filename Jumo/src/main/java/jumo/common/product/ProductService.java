package jumo.common.product;

import java.util.List;
import java.util.Map;

import jumo.model.BasketBean;
import jumo.model.CommunityBean;
import jumo.model.ProductBean;

public interface ProductService {
	
	public Map<String, Object> selectProductId(ProductBean product) throws Exception;

	public List<Map<String, Object>> allList() throws Exception;

	public List<Map<String, Object>> allListSearch(ProductBean product, int PDEGREEMIN, int PDEGREEMAX) throws Exception;

	public List<Map<String, Object>> aclList() throws Exception;

	public List<Map<String, Object>> aclListSearch(ProductBean product, int PDEGREEMIN, int PDEGREEMAX) throws Exception;

	public List<Map<String, Object>> etcList() throws Exception;

	public List<Map<String, Object>> etcListSearch(ProductBean product) throws Exception;

	public Map<String, Object> selectReviewMemberId(CommunityBean community) throws Exception;

	public void insertBasket(BasketBean basket) throws Exception;

	public void insertReview(CommunityBean community) throws Exception;
}//으딜
