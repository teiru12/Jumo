package jumo.event;

import java.util.List;

import jumo.model.JUMO_EVENT;
import jumo.model.JUMO_POINT;

public interface EventService {
	
	public JUMO_EVENT selectEventId(String email) throws Exception;
	
	public List<JUMO_POINT> pointIdListPaging (String email, int START, int END) throws Exception;
	
	public List<JUMO_POINT> pointIdListSearchPaging (String email,
			String mindate, String maxdate, int START, int END) throws Exception;
	
	public int pointIdCount(String email) throws Exception;
	
	public int pointIdSearchCount(String email, String MINDATE,String MAXDATE) throws Exception;

	// insertPointId : Email 회원 가입시 point 지급시 사용
	public void insertPointId(String email) throws Exception;
	
	// updatePointId : Email 회원의 point를 수정
	public void updatePointId(String email) throws Exception;	
	
	// updateCouponId : Email 회원의 쿠폰을 수정
	public void updateCouponId(String email) throws Exception;
}