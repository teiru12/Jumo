package jumo.admin.order;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


public interface AdminOrderService {
	
	@Resource(name="sqlSessionTemplate")
	
	//주문리스트
	public List<Map<String, Object>> orderList() throws Exception;
	
	//주문리스트 검색
	public List<Map<String, Object>> orderListSearch(Map<String, Object> map) throws Exception;
	
	//주문리스트 상세보기
	public Map<String, Object> selectOrderOId(Map<String, Object> map) throws Exception;
	
	//주문 정보 수정 기능
	public void updateOrderId(Map<String, Object> map) throws Exception;
}
