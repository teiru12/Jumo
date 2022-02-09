package jumo.common.community;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jumo.model.CommentBean;
import jumo.model.CommunityBean;

@Service("communityService")
public class CommunityServiceImpl implements CommunityService {

	@Resource(name = "communityDAO")
	private CommunityDAO communityDAO;
	
	@Override
	public List<Map<String, Object>> noticeList() throws Exception{
		return communityDAO.noticeList();
	}

	@Override
	public Map<String, Object> selectNoticeId(CommunityBean community) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("CIDX", community.getCIDX());
		
		return communityDAO.selectNoticeId(map);
	}

	@Override
	public List<Map<String, Object>> qnaList() throws Exception {
		return communityDAO.qnaList();
	}

	@Override
	public Map<String, Object> selectQnaId(CommunityBean community) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("CIDX", community.getCIDX());
		
		return communityDAO.selectQnaId(map);
	}

	@Override
	public List<Map<String, Object>> commentListId(CommentBean comment) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("ARTICLEIDX", comment.getARTICLEIDX());
		
		return communityDAO.commentListId(map);
	}

	@Override
	public void insertQna(CommunityBean community) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("CIDX", community.getCTITLE());
		map.put("CWRITER", community.getCWRITER());
		map.put("CCONTENT", community.getCCONTENT());
		
		communityDAO.insertQna(map);
	}
}