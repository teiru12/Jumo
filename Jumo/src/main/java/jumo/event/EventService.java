package jumo.event;

import java.util.List;

import jumo.model.JUMO_EVENT;
import jumo.model.JUMO_POINT;
import jumo.model.Payment;

public interface EventService {
	
	public JUMO_EVENT selectEventId(String email) throws Exception;
	
	public List<JUMO_POINT> pointIdListPaging (String email, int START, int END) throws Exception;
	
	public List<JUMO_POINT> pointIdListSearchPaging (String email,
			String mindate, String maxdate, int START, int END) throws Exception;
	
	public int pointIdCount(String email) throws Exception;
	
	public int pointIdSearchCount(String email, String MINDATE,String MAXDATE) throws Exception;

	// insertPointId : Email 회원 가입시 point 지급시 사용
	public void insertPointId(JUMO_EVENT event) throws Exception;
	
	// updatePointId : Email 회원의 point를 수정
	public void updatePointId(JUMO_EVENT event) throws Exception;	
	
	// updateCouponId : Email 회원의 쿠폰을 수정
	public void updateCouponId(JUMO_EVENT event) throws Exception;
	
	// selectPaymentOID : OID 값으로 결제 정보를 읽어옴
	public Payment selectPaymentOID(int OID) throws Exception;
	
	// selectPaymentOBNUMBER : OBNUMBER 값으로 결제 정보를 읽어옴
	public Payment selectPaymentOBNUMBER(int OBNUMBER) throws Exception;
	
	// insertPayment : 결제 정보를 입력
	public void insertPayment(Payment payment) throws Exception;
}