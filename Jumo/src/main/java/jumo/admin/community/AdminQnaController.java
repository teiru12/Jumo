package jumo.admin.community;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jumo.model.CommunityBean;
import jumo.model.CommentBean;
import jumo.util.MapToBean;
import jumo.util.validator.CommentValidator;

@Controller
public class AdminQnaController {
	
	@Resource(name="adminCommunityService")
	private AdminCommunityService adminComService;
	
	@RequestMapping(value="/adminQnaList.al")
	public String adminQnaList(Model model) throws Exception {
		
		List<Map<String, Object>> list = adminComService.qnaList();
		List<CommunityBean> qnaList = new ArrayList<CommunityBean>();
		
		for(Map<String, Object> mapObject : list) {
			qnaList.add( MapToBean.mapToCommunity(mapObject) );
		}
		
		model.addAttribute("qnaList", qnaList);
		
		return "adminQnaList";
	}
	
	@RequestMapping(value="/adminQnaDelete.al")
	public String adminQnaDelete(CommunityBean community,
			Model model) throws Exception{
		
		adminComService.deleteCommunityId(community);
		
		return "/admin/community/adminQnaDelete";
	}
	
	@RequestMapping(value="/adminQnaDetail.al")
	public String adminQnaDetail(CommunityBean community,
			CommentBean comment,
			Model model) throws Exception {
		
		Map<String, Object> qnaMap = adminComService.selectQnaId(community);
		List<Map<String, Object>> list = adminComService.commentListId(comment);
	
		CommunityBean qnaBean = MapToBean.mapToCommunity(qnaMap);
		List<CommentBean> comList = new ArrayList<CommentBean>();
		for(Map<String, Object> mapObject : list) {
			comList.add( MapToBean.mapToComment(mapObject) );
		}
		
		model.addAttribute("qnaBean", qnaBean);
		model.addAttribute("comList", comList);		
		
		return "adminQnaDetail";
	}

	@RequestMapping(value="/adminQnaComWrite.al")
	public String adminQnaComWrite(CommentBean comment,	BindingResult result,
			Model model) throws Exception {
		
		// Validator로 유효성 검사
		new CommentValidator().validate(comment, result);
		
		if(result.hasErrors()) {
			return "adminQnaList";
			// adminQnaDetail 페이지로 넘어가기 위해서는 CommunityBean, CommentBean 객체를 넘겨줘야하는데
			// 바로 리턴하면 오류발생
			// 자바 스크립트로 오류체크
			// return "adminQnaDetail";
		}	
		
		adminComService.insertComment(comment);		
		
		return "/admin/community/adminQnaComWrite";
	}

	@RequestMapping(value="/adminQnaComModify.al")
	public String adminQnaComModify(CommentBean comment, BindingResult result, 
			Model model) throws Exception {
		
		// Validator로 유효성 검사
		new CommentValidator().validate(comment, result);
		
		if(result.hasErrors()) {
			return "adminQnaList";
			// adminQnaDetail 페이지로 넘어가기 위해서는 CommunityBean, CommentBean 객체를 넘겨줘야하는데
			// 바로 리턴하면 오류발생
			// 자바 스크립트로 오류체크
			// return "adminQnaDetail";
		}	
		
		adminComService.updateComment(comment);				
		
		return "/admin/community/adminQnaComModify";
	}
	
	@RequestMapping(value="/adminQnaComDelete.al")
	public String adminQnaComDelete(CommentBean comment, Model model) 
			throws Exception {
		
		adminComService.deleteComment(comment);				
		
		return "/admin/community/adminQnaComDelete";
	}
}