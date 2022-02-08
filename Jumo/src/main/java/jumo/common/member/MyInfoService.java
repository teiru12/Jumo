package jumo.common.member;

import java.util.List;
import java.util.Map;

import jumo.model.MemberBean;
import jumo.model.CommunityBean;

public interface MyInfoService {

	public Map<String, Object> selectMemberId(MemberBean member);
	
	public void updateMember(MemberBean member);
	
	public void deleteMember(MemberBean member);
	
	public List<Map<String,Object>> selectQnaMemberId(CommunityBean community);
	
	public List<Map<String,Object>> selectReviewMemberId(CommunityBean community);
	
	public List<Map<String,Object>> selectOrderMemberId(CommunityBean community);
}
