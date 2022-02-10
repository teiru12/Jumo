package jumo.common.product;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


@Repository("productDAO")
public class ProductDAO {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Map<String, Object>> selectProductBest()
			throws Exception {
		return sqlSessionTemplate.selectList(
			"product.selectProductBest");
	}
	
	public Map<String, Object> selectProductId(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectOne(
			"product.selectProductId", map);
	}
	
	public List<Map<String, Object>> allList()
			throws Exception {
		return sqlSessionTemplate.selectList(
			"product.allList");
	}

	public List<Map<String, Object>> allListSearch(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectList(
			"product.allListSearch", map);
	}
	
	public List<Map<String, Object>> aclList()
			throws Exception {
		return sqlSessionTemplate.selectList(
			"product.aclList");
	}	
	
	public List<Map<String, Object>> aclListSearch(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectList(
			"product.aclListSearch", map);
	}
	
	public List<Map<String, Object>> etcList()
			throws Exception {
		return sqlSessionTemplate.selectList(
			"product.etcList");
	}	
	
	public List<Map<String, Object>> etcListSearch(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectList(
			"product.etcListSearch", map);
	}
	
	public List<Map<String, Object>> selectReviewProduct(Map<String, Object> map)
			throws Exception {
		return sqlSessionTemplate.selectList(
			"community.selectReviewProduct", map);
	}
	
	public void insertBasket(Map<String, Object> map) 
			throws Exception {
		sqlSessionTemplate.insert("basket.insertBeasket");
	}

	public void insertReview(Map<String, Object> map)
			throws Exception {
		sqlSessionTemplate.insert("community.insertReview");
	}	
}
