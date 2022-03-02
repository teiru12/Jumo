package jumo.event;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import jumo.model.JUMO_EVENT;

@Repository("eventDAO")
public class EventDAO {

	@Resource(name="sqlSessionTemplate")
	SqlSessionTemplate sqlSessionTemplate;

	public JUMO_EVENT selectEventId(String email) throws Exception{
		return sqlSessionTemplate.selectOne("event.selectEventId", email);
	}
	
	public List<Map<String,Object>> pointIdListPaging (Map<String,Object> map) throws Exception{
		return sqlSessionTemplate.selectList("event.pointIdListPaging", map);
	}
	
	public List<Map<String,Object>> pointIdListSearchPaging (Map<String,Object> map) throws Exception{
		return sqlSessionTemplate.selectList("event.pointIdListSearchPaging",map);
	}	
	
	public int pointIdCount(String email) throws Exception {
		return sqlSessionTemplate.selectOne("event.pointIdCount",email);
	}
	
	public int pointIdSearchCount(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectOne("event.pointIdSearchCount", map);
	}
	
	// insertPointId : Email 회원 가입시 point 지급시 사용
	public void insertPointId(JUMO_EVENT event) throws Exception {
		sqlSessionTemplate.insert("event.insertPointId", event);
	}	
	
	// updatePointId : Email 회원의 point를 수정
	public void updatePointId(JUMO_EVENT event) throws Exception {
		sqlSessionTemplate.update("event.updatePointId", event);
	}	
	
	// updateCouponId : Email 회원의 쿠폰을 수정
	public void updateCouponId(JUMO_EVENT event) throws Exception {
		sqlSessionTemplate.update("event.updateCouponId", event);
	}	
}