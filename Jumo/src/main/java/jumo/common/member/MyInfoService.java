package jumo.common.member;

import java.util.List;
import java.util.Map;

import org.springframework.core.annotation.Order;

import jumo.model.MemberBean;
import jumo.model.CommunityBean;
import jumo.model.OrderBean;

public interface MyInfoService {

	public Map<String, Object> selectMemberId(MemberBean member) throws Exception;
	
	public void updateMember(MemberBean member) throws Exception;
	
	public void deleteMember(MemberBean member) throws Exception;
	
	public List<Map<String,Object>> selectQnaMemberId(CommunityBean community) throws Exception;
	
	public List<Map<String,Object>> selectReviewMemberId(CommunityBean community) throws Exception;
	
	public List<Map<String,Object>> selectOrderMemberId(OrderBean order) throws Exception;
}
