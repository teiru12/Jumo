package jumo.admin.order;

import java.util.List;
import java.util.Map;

import jumo.model.OrderBean;

public interface AdminOrderService {
	
	//주문리스트
	public List<Map<String, Object>> orderList() throws Exception;
	    
	//주문리스트 검색
	public List<Map<String, Object>> orderListSearch(String keyword, String oStatus) throws Exception;
	   
	//주문리스트 상세보기
	public Map<String, Object> selectOrderOId(OrderBean order) throws Exception;
	   
	//주문 정보 수정 기능
	public void updateOrderId(OrderBean order) throws Exception;
}