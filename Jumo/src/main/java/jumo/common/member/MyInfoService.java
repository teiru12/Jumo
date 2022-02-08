package jumo.common.member;

import java.util.List;
import java.util.Map;

import jumo.model.MemberBean;
import jumo.model.CommunityBean;
import jumo.model.OrderBean;

public interface MyInfoService {

	public Map<String, Object> selectMemberId(MemberBean member) throws Exception;
	
	public void updateMember(MemberBean member) throws Exception;
	
	public void deleteMember(MemberBean member) throws Exception;
	
	public List<Map<String,Object>> selectQnaMemberId(MemberBean member) throws Exception;
	
	public List<Map<String,Object>> selectReviewMemberId(MemberBean member) throws Exception;
	
	public List<Map<String,Object>> selectOrderMemberId(MemberBean member) throws Exception;
}
