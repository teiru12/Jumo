package jumo.admin.community;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;


public class AdminCommunityDAO  {

	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	 
	
	//관리자 공지 게시판 리스트
	public List<Map<String, Object>> noticeList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("community.noticeList", map);
	}
	
	
	//관리자 공지 게시판 상세보기
	public Map<String, Object> selectNoticeId(Map<String, Object> map) throws Exception {
		return  sqlSessionTemplate.selectOne("community.selectNoticeId", map);
	}
	
	
	//관리자 공지사항 글 등록
	public void insertNotice(Map<String,Object> map) throws Exception{
		sqlSessionTemplate.insert("community.insertNotice",map);
	}
	
	
	//관리자 공지사항 수정 
	public void updateNoticeId(Map<String,Object> map) throws Exception{
		sqlSessionTemplate.update("community.updateNoticeId",map);
	}
	
	
	//관리자 고객후기 게시판 리스트
	public List<Map<String, Object>>reviewList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("community.reviewList", map);
	}
		
	
	//관리자 고객센터 게시판 리스트
	public List<Map<String, Object>>qnaList(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("community.qnaList", map);
	}
	
	
	//관리자 고객센터 게시판 상세보기
	public Map<String, Object> selectQnaId(Map<String, Object> map) throws Exception {
		return  sqlSessionTemplate.selectOne("community.selectQnaId", map);
	}
	
	
	//관리자 고객센터 댓글 보기
	public List<Map<String, Object>>commentListId(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("community.commentListId", map);
	}
	
	
	//관리자 고객센터 댓글 입력
	public void insertComment(Map<String,Object> map) throws Exception{
		sqlSessionTemplate.insert("community.insertComment",map);
	}
	
	
	//관리자 고객센터 댓글 수정
	public void updateComment(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.update("community.updateComment", map);
	}
	
	
	//관리자 고객센터 댓글 삭제
	public void deleteComment(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.delete("community.deleteComment", map);
	}
	
	
	
	//관리자 상품 후기 리스트
	public List<Map<String, Object>>selectReviewProduct(Map<String, Object> map) throws Exception {
		return sqlSessionTemplate.selectList("community.selectReviewProduct", map);
	}
	
	
	//관리자 공지,후기 삭제 기능
	public void deleteCommunityId(Map<String, Object> map) throws Exception {
		sqlSessionTemplate.delete("community.deleteCommunityId", map);
	}
	
	
	
}
