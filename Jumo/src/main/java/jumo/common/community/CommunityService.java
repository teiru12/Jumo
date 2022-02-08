package jumo.common.community;

import java.util.List;
import java.util.Map;

import jumo.model.CommunityBean;
import jumo.model.CommentBean;

public interface CommunityService {

	public List<Map<String, Object>> noticeList() throws Exception;
	
	public Map<String, Object> selectNoticeId(CommunityBean community) throws Exception;
	
	public List<Map<String, Object>> qnaList() throws Exception;
	
	public Map<String, Object> selectQnaMemberId(CommunityBean community) throws Exception;
	
	public List<Map<String, Object>> commentListId(CommentBean comment) throws Exception;
	
	public void insertQna(CommunityBean community) throws Exception;
}