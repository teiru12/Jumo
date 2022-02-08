package jumo.admin.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jumo.model.OrderBean;

@Service("adminOrderService")
public class AdminOrderServiceImpl implements AdminOrderService{

	@Resource(name="adminOrderDAO")
	private AdminOrderDAO adminorderDAO; // 대소문자 고치기
	
	@Override
	public List<Map<String, Object>> orderList() throws Exception {
		return adminorderDAO.orderList();
	}

	@Override
	public List<Map<String, Object>> orderListSearch(String keyword, String oStatus) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("KEYWORD", keyword);
		map.put("OSTATUS", oStatus);
		return adminorderDAO.orderListSearch(null);
	}

	@Override
	public Map<String, Object> selectOrderOId(OrderBean order) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("OID", order.getOID());
		return adminorderDAO.selectOrderOId(map);
	}

	@Override
	public void updateOrderId(OrderBean order) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("OSTATUS", order.getOSTATUS());
		map.put("OID", order.getOID());
		adminorderDAO.updateOrderId(map);
	}
	
	

}
