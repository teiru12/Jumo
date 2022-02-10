package jumo.admin.community;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jumo.model.CommunityBean;
import jumo.util.MapToBean;

@Controller
public class AdminReviewController {
	
	@Resource(name="adminCommunityService")
	private AdminCommunityService adminCommunityService;

	@RequestMapping(value="/adminReviewList.al")
	public String adminReviewList(Model model) throws Exception{
		List<Map<String, Object>> list = adminCommunityService.reviewList();
		
		List<CommunityBean> communityBeanList = new ArrayList<CommunityBean>();
		
		for(Map<String,Object> mapObject : list) {
			communityBeanList.add(MapToBean.mapToCommunity(mapObject));
		}
		
		model.addAttribute("communityBeanList", communityBeanList);
		
		return "adminReviewList";
	}
	
	
	@RequestMapping(value="/adminReviewDelete.al")
	public String adminReviewDelete(CommunityBean community, Model model) throws Exception{
		adminCommunityService.deleteCommunityId(community);
		
		return "admin/community/adminReviewDelete";
	}
	
	
}
