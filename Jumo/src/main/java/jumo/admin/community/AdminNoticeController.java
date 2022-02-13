package jumo.admin.community;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jumo.model.CommunityBean;
import jumo.util.MapToBean;
import jumo.util.validator.CommunityValidator;

@Controller
public class AdminNoticeController {

	@Resource(name="adminCommunityService")
	private AdminCommunityService adminComService;

	@RequestMapping(value="/adminNoticeList.al")
	public String adminNoticeList(
			@RequestParam("START") int START,
			@RequestParam("END") int END,
			Model model) throws Exception {
		List<Map<String, Object>> list = adminComService.noticeListPaging(START, END);
		List<CommunityBean> noticeList = new ArrayList<CommunityBean>();
		
		for(Map<String, Object> mapObject : list) {
			noticeList.add( MapToBean.mapToCommunity(mapObject) );
		}

		model.addAttribute("noticeList", noticeList);
		
		return "adminNoticeList";
	}
	
	@RequestMapping(value="/adminNoticeWriteForm.al")
	public String adminNoticeWriteForm(Model model) {
		return "adminNoticeWriteForm";
	}
	
	
	@RequestMapping(value="/adminNoticeWrite.al")
	public String adminNoticeWrite(CommunityBean community, BindingResult result,
			Model model) throws Exception {
		
		// Validator로 유효성 검사
		new CommunityValidator().validate(community, result);
		
		if(result.hasErrors()) {
			return "adminNoticeWriteForm";
		}		
		
		adminComService.insertNotice(community);
		
		return "admin/community/adminNoticeWrite";
	}
	
	
	@RequestMapping(value="/adminNoticeModifyForm.al")
	public String adminNoticeModifyForm(CommunityBean community, Model model)
			throws Exception {
		
		Map<String, Object> noticeMap = adminComService.selectNoticeId(community);
		CommunityBean noticeBean = MapToBean.mapToCommunity(noticeMap);
		
		model.addAttribute("noticeBean", noticeBean);		
		
		return "adminNoticeModifyForm";
	}
	
	
	@RequestMapping(value="/adminNoticeModify.al")
	public String adminNoticeModify(CommunityBean community, BindingResult result,
			Model model) throws Exception {
		
		// Validator로 유효성 검사
		new CommunityValidator().validate(community, result);
		
		if(result.hasErrors()) {
			return "adminNoticeList";
			// adminNoticeModifyForm 페이지로 넘어가기 위해서는 CommunityBean 객체를 넘겨줘야하는데
			// 바로 리턴하면 오류발생
			// 자바 스크립트로 오류체크
			// return "adminNoticeModifyForm";
		}	
		
		adminComService.updateNoticeId(community);
		
		return "admin/community/adminNoticeModify";
	}
	
	
	@RequestMapping(value="/adminNoticeDelete.al")
	public String adminNoticeDelete(CommunityBean community, Model model)
			throws Exception {
		
		adminComService.deleteCommunityId(community);
		
		return "admin/community/adminNoticeDelete";
	}
	
	
	@RequestMapping(value="/adminNoticeDetail.al")
	public String adminNoticeDetail(CommunityBean community, Model model)
			throws Exception {
		
		Map<String, Object> noticeMap = adminComService.selectNoticeId(community);
		CommunityBean noticeBean = MapToBean.mapToCommunity(noticeMap);
		
		model.addAttribute("noticeBean", noticeBean);	
		
		return "adminNoticeDetail";
	}
	
}