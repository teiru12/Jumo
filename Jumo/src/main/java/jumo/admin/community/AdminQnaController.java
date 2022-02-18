package jumo.admin.community;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jumo.model.CommunityBean;
import jumo.model.CommentBean;
import jumo.util.MapToBean;
import jumo.util.Paging;
import jumo.util.validator.CommentValidator;

@Controller
public class AdminQnaController {
	
	@Resource(name="adminCommunityService")
	private AdminCommunityService adminComService;
	
	@RequestMapping(value="/adminQnaList.al")
	public String adminQnaList(
//			@RequestParam("START") int START,
//			@RequestParam("END") int END,
			Model model) throws Exception {
		
		/* 페이징을 위한 변수 */
		int pageSize = 20; // 페이지당 출력할 공지의 수
		int START = 1;
		int END = pageSize;
		int currentPage = 1; // 현재 페이지

		int qnaListCount; // 전체 공지글의 수
		int pageBlock = 5; // 표시할 페이지의 수
		String url = "qnaList.al";
		String searchUrl = "";
		
		List<Map<String, Object>> list = adminComService.qnaListPaging(START, END);
		List<CommunityBean> qnaList = new ArrayList<CommunityBean>();
		
		for(Map<String, Object> mapObject : list) {
			qnaList.add( MapToBean.mapToCommunity(mapObject) );
		}
		
		qnaListCount = adminComService.qnaListCount();
		
		Paging paging = new Paging(qnaListCount, pageBlock,
		pageSize ,currentPage, url, searchUrl);
		
		/* 페이징을 위한 값 삽입 */
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("paging", paging);
		
		model.addAttribute("qnaList", qnaList);
		
		return "adminQnaList";
	}
	
	@RequestMapping(value="/adminQnaDelete.al")
	public String adminQnaDelete(CommunityBean community,
			Model model) throws Exception{
		
		model.addAttribute("msg", "게시글 삭제가 완료되었습니다.");
		model.addAttribute("url", "/adminNoticeList.al");
		adminComService.deleteCommunityId(community);
		
		return "/admin/community/adminQnaDelete";
	}
	
	@RequestMapping(value="/adminQnaDetail.al")
	public String adminQnaDetail(CommunityBean community,
			CommentBean comment,
			Model model) throws Exception {
		
		Map<String, Object> qnaMap = adminComService.selectQnaId(community);
		comment.setARTICLEIDX(community.getCIDX());
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
	public String adminQnaComWrite(CommentBean comment,
			Model model) throws Exception {	
		
		System.out.println(comment.getARTICLEIDX());
		System.out.println(comment.getCOMMENTIDX());
		System.out.println(comment.getCOMMENTT());
		System.out.println(comment.getCOMMENTWRITER());
		System.out.println(comment.getCOMMENTDATE());
		
		
		model.addAttribute("msg", "댓글 작성이 완료되었습니다.");
		model.addAttribute("url", "/adminQnaDetail.al");
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
		
		model.addAttribute("msg", "댓글 수정이 완료되었습니다.");
		model.addAttribute("url", "/adminNoticeList.al");
		adminComService.updateComment(comment);				
		
		return "/admin/community/adminQnaComModify";
	}
	
	@RequestMapping(value="/adminQnaComDelete.al")
	public String adminQnaComDelete(CommentBean comment, Model model) 
			throws Exception {
		
		model.addAttribute("msg", "댓글 삭제가 완료되었습니다.");
		model.addAttribute("url", "/adminNoticeList.al");
		adminComService.deleteComment(comment);				
		
		return "/admin/community/adminQnaComDelete";
	}
}