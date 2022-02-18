package jumo.admin.memeber;

import java.util.List;
import java.util.Map;

import jumo.model.MemberBean;

public interface AdminMemberService {

	public Map<String, Object> selectMemberId(MemberBean member) throws Exception;
	
	public List<Map<String, Object>> memberList() throws Exception;
		
	public void updateMemberAdmin(MemberBean member) throws Exception;
	
	public void deleteMember(MemberBean member) throws Exception;	
	
	public List<Map<String, Object>> memberListPaging(int START, int END) throws Exception;
	
	public int memberCount() throws Exception;
}