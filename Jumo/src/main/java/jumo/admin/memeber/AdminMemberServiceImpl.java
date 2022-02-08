package jumo.admin.memeber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jumo.model.MemberBean;

@Service("adminMemberService")
public class AdminMemberServiceImpl implements AdminMemberService {

	@Resource(name = "adminMemberDAO")
	private AdminMemberDAO adminMemberDAO;

	@Override
	public Map<String, Object> selectMemberId(MemberBean member) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("EMAIL", member.getEMAIL());
		
		return adminMemberDAO.selectMemberId(map);
	}

	@Override
	public List<Map<String, Object>> memberList() throws Exception {
		return adminMemberDAO.memberList();
	}

	@Override
	public void updateMemberAdmin(MemberBean member) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("RANK", member.getRANK());
		map.put("BLOCK", member.getBLOCK());
		map.put("ADDRESS1", member.getADDRESS1());
		map.put("ADDRESS2", member.getADDRESS2());
		map.put("POSTCODE", member.getPOSTCODE());
		map.put("PHONE", member.getPHONE());
		map.put("MOBILE", member.getMOBILE());
		
		map.put("EMAIL", member.getEMAIL());
		
		adminMemberDAO.updateMemberAdmin(map);
	}

	@Override
	public void deleteMember(MemberBean member) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("EMAIL", member.getEMAIL());
		
		adminMemberDAO.deleteMember(map);
		
	}
	
	
}
