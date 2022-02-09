package jumo.common.community;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommunityController {


	@RequestMapping(value="/noticeList.al")
	public String noticeList(Model model) {
		return "community/noticeList";
	}
	
	
	@RequestMapping(value="/noticeDetail.al")
	public String noticeDetail(Model model) {
		return "community/noticeDetail";
	}
	
	
	@RequestMapping(value="/qnaList.al")
	public String qnaList(Model model) {
		return "community/qnaList";
	}
	
	
	@RequestMapping(value="/qnaDetail.al")
	public String qnaDetail(Model model) {
		return "community/qnaDetail";
	}
	
	
	@RequestMapping(value="/qnaForm.al")
	public String qnaForm(Model model) {
		return "community/qnaForm";
	}
	
	
	@RequestMapping(value="/qna.al")
	public String qna(Model model) {
		return "community/qna";
	}
	
	
	
}
