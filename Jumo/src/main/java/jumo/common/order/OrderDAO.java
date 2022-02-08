package jumo.common.order;

import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("orderDAO")
public class OrderDAO {
		
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	//상품 바로 구매 기능	
	public void insertOrderDirect(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.insert("order.insertOrderDirect", map);
	}
	
	//장바구니 상품 구매 폼
	public Map<String, Object> selectMemberId(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("order.selectMemberId", map);
	}
	
	//장바구니 상품 구매 기능
	public void insertOrderBasket(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.insert("order.insertOrderBasket", map);
	}
	
	//상품 구매 결과(selectOrderOId)
	public Map<String, Object> selectOrderOId(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("order.selectOrderOId", map);
	}
	
	//상품 구매 결과(selectOrderOBNumber)
	public Map<String, Object> selectOrderOBNumber(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("order.selectOrderOBNumber", map);
	}
	
}
