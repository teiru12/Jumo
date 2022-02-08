package jumo.common.order;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jumo.model.OrderBean;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Resource(name="orderDAO")
	private OrderDAO orderDAO;

	@Override
	public void insertOrderDirect(OrderBean order) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("OMAIL", order.getOMAIL());
		map.put("OPID", order.getOPID());
		map.put("OPRODUCT", order.getOPRODUCT());
		map.put("OSALE", order.getOSALE());
		map.put("OTOTAL", order.getOTOTAL());
		map.put("OADDRESS1", order.getOADDRESS1());
		map.put("OADDRESS2", order.getOADDRESS2());
		
		orderDAO.insertOrderDirect(map);
	}

	@Override
	public Map<String, Object> selectMemberId(OrderBean order) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("OMAIL", order.getOMAIL());
		return orderDAO.selectMemberId(map);
	}

	@Override
	public void insertOrderBasket(OrderBean order) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("OBNUMBER", order.getOBNUMBER());
		map.put("OMAIL", order.getOMAIL());
		map.put("OPID", order.getOPID());
		map.put("OPRODUCT", order.getOPRODUCT());
		map.put("OSALE", order.getOSALE());
		map.put("OTOTAL", order.getOTOTAL());
		map.put("OADDRESS1", order.getOADDRESS1());
		map.put("OADDRESS2", order.getOADDRESS2());
		
		orderDAO.insertOrderBasket(map);
	}

	@Override
	public Map<String, Object> selectOrderOId(OrderBean order) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("OID", order.getOID());
		return orderDAO.selectOrderOId(map);

	}

	@Override
	public Map<String, Object> selectOrderOBNumber(OrderBean order) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("OBNUMBER", order.getOBNUMBER());
		return orderDAO.selectOrderOBNUMBER(map);
	}
	

}
