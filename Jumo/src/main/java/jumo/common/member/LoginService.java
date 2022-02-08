package jumo.common.member;

import java.util.Map;

import jumo.model.MemberBean;

public interface LoginService {

	public Map<String, Object> selectMemberId(MemberBean member);
	
	public Map<String,Object> selectMemberJumin(MemberBean member);
}
