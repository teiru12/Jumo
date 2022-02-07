package jumo.admin.memeber;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("AdminMemberDAO")
public class AdminMemberDAO {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	// 회원 전체목록 불러오기
	public List<Map<String, Object>> memberList(Map<String, Object> map) throws Exception{
		return sqlSessionTemplate.selectList("member.memberList", map);
	}
	
	//회원 검색, 상세보기
	public List<Map<String, Object>> selectMemberId(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("member.selectMemberId", map);
	}
	
	//회원정보 수정
	public Object updateMemberAdmin(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.update("member.updateMemberAdmin", map);
	}
	
	//회원정보 삭제
	public Object deleteMember(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.delete("member.deleteMember", map);
	}
}
