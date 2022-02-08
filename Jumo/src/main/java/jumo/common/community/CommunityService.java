package jumo.common.community;

import java.util.List;
import java.util.Map;

import jumo.model.CommunityBean;
import jumo.model.CommentBean;

public interface CommunityService {

	public List<Map<String, Object>> noticeList();
	
	public Map<String, Object> selectNoticeId(CommunityBean community);
	
	public List<Map<String, Object>> qnaList();
	
	public Map<String, Object> selectQnaMemberId(CommunityBean community);
	
	public Map<String, Object> commentListId(CommentBean comment);
	
	public void insertQna(CommunityBean community);
}