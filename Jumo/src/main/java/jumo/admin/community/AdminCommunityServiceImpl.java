package jumo.admin.community;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jumo.model.CommentBean;
import jumo.model.CommunityBean;

@Service("adminCommunityService")
public class AdminCommunityServiceImpl implements AdminCommunityService {

	@Resource(name = "adminCommunityDAO")
	private AdminCommunityDAO adminCommunityDAO;
	
	
	@Override
	public List<Map<String, Object>> noticeList() throws Exception {
		return adminCommunityDAO.noticeList();
	}

	@Override
	public Map<String, Object> selectNoticeId(CommunityBean community) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("CIDX", community.getCIDX());
		
		return adminCommunityDAO.selectNoticeId(map);
	}

	@Override
	public void insertNotice(CommunityBean community) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("CIDX", community.getCTITLE());
		map.put("CWRITER", community.getCWRITER());
		map.put("CCONTENT", community.getCCONTENT());
		
		adminCommunityDAO.insertNotice(map);
	}

	@Override
	public void updateNoticeId(CommunityBean community) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("CIDX", community.getCTITLE());
		map.put("CCONTENT", community.getCCONTENT());
		map.put("CIDX", community.getCIDX());
		
		adminCommunityDAO.updateNoticeId(map);
	}

	@Override
	public List<Map<String, Object>> reviewList() throws Exception {
		return adminCommunityDAO.reviewList();
		
	}

	@Override
	public List<Map<String, Object>> qnaList() throws Exception {
		return adminCommunityDAO.qnaList();
		
	}

	@Override
	public Map<String, Object> selectQnaId(CommunityBean community) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("CIDX", community.getCIDX());
		
		return adminCommunityDAO.selectQnaId(map);
	}

	@Override
	public List<Map<String, Object>> commentListId(CommentBean comment) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("ARTICLEIDX", comment.getARTICLEIDX());
		
		return adminCommunityDAO.commentListId(map);
	}

	@Override
	public void insertComment(CommentBean comment) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("CIDX", comment.getARTICLEIDX());
		map.put("COMMENTWRITER", comment.getCOMMENTWRITER());
		map.put("COMMENTT", comment.getCOMMENTT());
		
		adminCommunityDAO.insertComment(map);
	}

	@Override
	public void updateComment(CommentBean comment) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("COMMENTT", comment.getCOMMENTT());
		map.put("COMENTIDX", comment.getCOMMENTIDX());
		
		adminCommunityDAO.updateComment(map);
	}

	@Override
	public void deleteComment(CommentBean comment) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("COMENTIDX", comment.getCOMMENTIDX());
		
		adminCommunityDAO.deleteComment(map);
		
	}

	@Override
	public void deleteCommunityId(CommunityBean community) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("CIDX", community.getCIDX());
		
		adminCommunityDAO.deleteCommunityId(map);
	}

}
