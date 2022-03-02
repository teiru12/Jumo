package jumo.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jumo.model.JUMO_EVENT;
import jumo.model.JUMO_POINT;

@Service("eventService")
public class EventServiceImpl implements EventService {

	@Resource(name="eventDAO")
	EventDAO eventDAO;
	
	@Override
	public JUMO_EVENT selectEventId(String email) throws Exception {
		return eventDAO.selectEventId(email);
	}

	@Override
	public List<JUMO_POINT> pointIdListPaging(String email, int START, int END) throws Exception {
		List<JUMO_POINT> list = new ArrayList<JUMO_POINT>();
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("EMAIL", email);
		paramMap.put("START", START);
		paramMap.put("END", END);		
		
		List<Map<String, Object>> mapList = eventDAO.pointIdListPaging(paramMap); 
		
		for(Map<String, Object> map : mapList) {
			JUMO_POINT point = new JUMO_POINT();
		
			point.setPOINT_KEY(Integer.parseInt(String.valueOf(map.get("POINT_KEY"))));
			point.setEMAIL((String) map.get("EMAIL"));
			point.setJUMO_POINT(Integer.parseInt(String.valueOf(map.get("JUMO_POINT"))));
			point.setRULLETDATE((String) map.get("RULLETDATE"));
						
			list.add(point);
		}
		
		return list;
	}

	@Override
	public List<JUMO_POINT> pointIdListSearchPaging(String email, String mindate,
			String maxdate, int START, int END) throws Exception {
		List<JUMO_POINT> list = new ArrayList<JUMO_POINT>();
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("EMAIL", email);
		paramMap.put("MINDATE", mindate);
		paramMap.put("MAXDATE", maxdate);		
		paramMap.put("START", START);
		paramMap.put("END", END);		
		
		List<Map<String, Object>> mapList = eventDAO.pointIdListSearchPaging(paramMap); 

		for(Map<String, Object> map : mapList) {
			JUMO_POINT point = new JUMO_POINT();
			
			point.setPOINT_KEY(Integer.parseInt(String.valueOf(map.get("POINT_KEY"))));
			point.setEMAIL((String) map.get("EMAIL"));
			point.setJUMO_POINT(Integer.parseInt(String.valueOf(map.get("JUMO_POINT"))));
			point.setRULLETDATE((String) map.get("RULLETDATE"));
						
			list.add(point);
		}
		
		return list;
	}
	
	@Override
	public int pointIdCount(String email) throws Exception {
		return Integer.parseInt(String.valueOf(eventDAO.pointIdCount(email))); 
	}
	
	@Override
	public int pointIdSearchCount(String email, String MINDATE,String MAXDATE) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("EMAIL",email);
		paramMap.put("MINDATE",MINDATE);
		paramMap.put("MAXDATE",MAXDATE);
		
		return  Integer.parseInt(String.valueOf(eventDAO.pointIdSearchCount(paramMap))); 
	}
	
	@Override
	// insertPointId : Email 회원 가입시 point 지급시 사용
	public void insertPointId(JUMO_EVENT event) throws Exception {
		eventDAO.insertPointId(event);		
	}

	@Override
	// updatePointId : Email 회원의 point를 수정
	public void updatePointId(JUMO_EVENT event) throws Exception {
		eventDAO.updatePointId(event);		
	}

	@Override
	// updateCouponId : Email 회원의 쿠폰을 수정
	public void updateCouponId(JUMO_EVENT event) throws Exception {
		eventDAO.updateCouponId(event);		
	}	
}