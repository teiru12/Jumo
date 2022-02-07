package jumo.common.order;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("OrderDAO")
public class OrderDAO {
		
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	//상품 바로 구매 기능	
	public List<Map<String, Object>> insertOrderDirect(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("order.insertOrderDirect", map);
	}
	
	//장바구니 상품 구매 폼
	public List<Map<String, Object>> selectMemberId(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("order.selectMemberId", map);
	}
	
	//장바구니 상품 구매 기능
	public List<Map<String, Object>> insertOrderBasket(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("order.insertOrderBasket", map);
	}
	
	//상품 구매 결과(selectOrderOId)
	public List<Map<String, Object>> selectOrderOId(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("order.selectOrderOId", map);
	}
	
	//상품 구매 결과(selectOrderOBNumber)
	public List<Map<String, Object>> selectOrderOBNumber(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("order.selectOrderOBNumber", map);
	}
	
}
