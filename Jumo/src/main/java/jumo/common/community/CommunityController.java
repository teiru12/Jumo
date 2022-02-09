package jumo.common.community;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jumo.model.CommunityBean;
import jumo.util.MapToBean;

@Controller
public class CommunityController {
	
	@Resource(name="communityService")
	private CommunityService communityService;


	@RequestMapping(value="/noticeList.al")
	public String noticeList(Model model) throws Exception {
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<CommunityBean> noticeBeanList = new ArrayList<CommunityBean>();
		list = communityService.noticeList(); 
	    
		for(Map<String, Object> mapObject : list) {
			noticeBeanList.add(MapToBean.mapToCommunity(mapObject));
		}
		
		model.addAttribute("noticeBeanList", noticeBeanList);
		
		return "community/noticeList";
	}


	@RequestMapping(value="/noticeDetail.al")
	public String noticeDetail(CommunityBean community, Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		CommunityBean communityBean = new CommunityBean();
		
		map = communityService.selectNoticeId(community);
		
		communityBean = MapToBean.mapToCommunity(map);
		model.addAttribute("communityBean", communityBean);
		
		return "community/noticeDetail";
	}
	
	
	@RequestMapping(value="/qnaList.al")
	public String qnaList(Model model) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<CommunityBean> qnaBeanList = new ArrayList<CommunityBean>();
		list = communityService.qnaList();
		
		
		for(Map<String, Object> mapObject : list) {
			 qnaBeanList.add(	 MapToBean.mapToCommunity(mapObject) ); 
		}		
		
		model.addAttribute("qnaBeanList", qnaBeanList);
		
		return "community/qnaList";
	}
	
	
	@RequestMapping(value="/qnaDetail.al")
	public String qnaDetail(Model model, CommunityBean community) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		CommunityBean communityBean = new CommunityBean();
		
		map = communityService.selectQnaId(community);
		
		communityBean = MapToBean.mapToCommunity(map);
		
		model.addAttribute("communityBean", communityBean);
		
		return "community/qnaDetail";
	}
	
	
	@RequestMapping(value="/qnaForm.al")
	public String qnaForm(Model model) {
		return "community/qnaForm";
	}
	
	
	@RequestMapping(value="/qna.al")
	public String qna(Model model, CommunityBean community)throws Exception {
		CommunityBean communityBean = new CommunityBean();
		
		communityService.insertQna(communityBean);
		
		return "community/qna";
	}
}