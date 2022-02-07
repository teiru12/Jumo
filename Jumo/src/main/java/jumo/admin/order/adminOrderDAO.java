package jumo.admin.order;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("adminOrderDAO")
public class adminOrderDAO {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	//전체 주문리스트
	public List<Map<String, Object>> allList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("order.allList", map);
	}
	
	//주문리스트 	
	public List<Map<String, Object>> orderList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("order.orderList", map);
	}
	
	//주문리스트 검색
	public List<Map<String, Object>> orderListSearch(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("order.orderListSearch", map);
	}
	//주문리스트 상세보기
	public List<Map<String, Object>> selectOrderOId(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("order.selectOrderOId", map);
	}
	//주문 정보 수정 기능
	public List<Map<String, Object>> updateOrderId(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("orderupdateOrderId", map); 
	}
}
