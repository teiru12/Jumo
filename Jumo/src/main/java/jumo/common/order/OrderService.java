package jumo.common.order;

import java.util.Map;

import jumo.model.OrderBean;

public interface OrderService {
	
	   //상품 바로 구매 기능
	   public void insertOrderDirect(OrderBean order) throws Exception;
	    
	   //장바구니 상품 구매 폼
	   public Map<String, Object> selectMemberId(OrderBean order) throws Exception;
	   
	   //장바구니 상품 구매 기능
	   public void insertOrderBasket(OrderBean order) throws Exception;
	   
	   //상품 구매 결과(selectOrderOId)
	   public Map<String, Object> selectOrderOId(OrderBean order) throws Exception;
	   
	   //상품 구매 결과(selectOrderOBNumber)
	   public Map<String, Object> selectOrderOBNumber(OrderBean order) throws Exception;
}