package jumo.admin.community;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jumo.model.CommunityBean;
import jumo.util.MapToBean;

@Controller
public class AdminReviewController {
	
	@Resource(name="adminCommunityService")
	private AdminCommunityService adminCommunityService;

	@RequestMapping(value="/adminReviewList.al")
	public String adminReviewList(
			@RequestParam("START") int START,
			@RequestParam("END") int END,
			Model model) throws Exception{
		List<Map<String, Object>> list = adminCommunityService.reviewListPaging(START, END);
		
		List<CommunityBean> reviewList = new ArrayList<CommunityBean>();
		
		for(Map<String,Object> mapObject : list) {
			reviewList.add(MapToBean.mapToCommunity(mapObject));
		}
		
		model.addAttribute("reviewList", reviewList);
		
		return "adminReviewList";
	}
	
	@RequestMapping(value="/adminReviewDelete.al")
	public String adminReviewDelete(CommunityBean community, Model model) throws Exception{
		adminCommunityService.deleteCommunityId(community);
		return "admin/community/adminReviewDelete";
	}	
}