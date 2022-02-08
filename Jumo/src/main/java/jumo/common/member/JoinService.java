package jumo.common.member;

import java.util.Map;

import jumo.model.MemberBean;

public interface JoinService {

	public Map<String, Object> selectMemberId(MemberBean member) throws Exception;
	
	public void insertMember(MemberBean member) throws Exception;
}