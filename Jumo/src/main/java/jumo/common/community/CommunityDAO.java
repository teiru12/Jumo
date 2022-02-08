package jumo.common.community;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("communityDAO")
public class CommunityDAO {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	//공지 게시판 리스트
	public List<Map<String, Object>> noticeList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("community.noticeList", map);
	}
	
	
	// 공지 게시판 상세보기
	public Map<String, Object> selectNoticeId(Map<String, Object> map) throws Exception {
		return  sqlSessionTemplate.selectOne("community.selectNoticeId", map);
	}
	
	
	//고객센터 게시판 리스트
	public List<Map<String, Object>>qnaList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("community.qnaList", map);
	}
	
	
	//고객센터 게시판 상세보기
	public Map<String, Object> selectQnaId(Map<String, Object> map) throws Exception {
		return  sqlSessionTemplate.selectOne("community.selectQnaId", map);
	}
	
	
	//고객센터 게시판 글 등록 
	public void insertQna(Map<String,Object> map) throws Exception{
		sqlSessionTemplate.insert("community.insertQna",map);
	}
			
		
		
	
	
}
