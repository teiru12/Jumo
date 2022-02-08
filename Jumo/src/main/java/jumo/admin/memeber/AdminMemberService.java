package jumo.admin.memeber;

import java.util.List;
import java.util.Map;

import jumo.model.MemberBean;

public interface AdminMemberService {

	public Map<String, Object> selectMemberId(MemberBean member);
	
	public List<Map<String, Object>> memberList();
		
	public void updateMemberAdmin(MemberBean member);
	
	public void deleteMember(MemberBean member);	
}