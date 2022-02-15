package jumo.common.community;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jumo.model.CommunityBean;
import jumo.model.MemberBean;
import jumo.util.MapToBean;
import jumo.util.Paging;
import jumo.util.validator.CommunityValidator;

@Controller
public class CommunityController {

	@Resource(name = "communityService")
	private CommunityService communityService;

	@RequestMapping(value = "/noticeList.al")
	public String noticeList(Model model,HttpServletRequest request) throws Exception {
		
		/* 페이징을 위한 변수 */
		int pageSize = 20; // 페이지당 출력할 공지의 수
		int START = 1;
		int END = pageSize;
		int currentPage = 1; // 현재 페이지

		int noticeListCount; // 전체 공지글의 수
		int pageBlock = 5; // 표시할 페이지의 수
		String url = "noticeList.al";
		String searchUrl = "";

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<CommunityBean> noticeBeanList = new ArrayList<CommunityBean>();
		list = communityService.noticeListPaging(START, END);

		noticeListCount = communityService.noticeListCount();
		
		// 페이징할 아이템의 총 수, 페이지의 수 ex> 1~5 6~10, 한 페이지에 표시할 공지의 수, 현재 페이지, 이동주소, 검색시 사용할 주소 입력
		Paging paging = new Paging(noticeListCount,	pageBlock,
				pageSize ,currentPage, url, searchUrl);
		
		
		for (Map<String, Object> mapObject : list) {
			noticeBeanList.add(MapToBean.mapToCommunity(mapObject));
		}
		
		model.addAttribute("noticeBeanList", noticeBeanList);
		/* 페이징을 위한 값 삽입 */
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("paging", paging);
		
		
		return "noticeList";
	}

	@RequestMapping(value = "/noticeDetail.al")
	public String noticeDetail(CommunityBean community, Model model, HttpServletRequest request) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		CommunityBean communityBean = new CommunityBean();
		
		communityBean = MapToBean.mapToCommunity(map); 
		map = communityService.selectNoticeId(community);
		
		model.addAttribute("communityBean", communityBean);

		return "noticeDetail";
	}

	@RequestMapping(value = "/qnaList.al")
	public String qnaList(@RequestParam("START") int START, @RequestParam("END") int END, Model model)
			throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<CommunityBean> qnaBeanList = new ArrayList<CommunityBean>();
		list = communityService.qnaListPaging(START, END);

		for (Map<String, Object> mapObject : list) {
			qnaBeanList.add(MapToBean.mapToCommunity(mapObject));
		}

		model.addAttribute("qnaBeanList", qnaBeanList);
		return "qnaList";
	}

	@RequestMapping(value = "/qnaDetail.al")
	public String qnaDetail(Model model, CommunityBean community) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		CommunityBean communityBean = new CommunityBean();

		map = communityService.selectQnaId(community);

		communityBean = MapToBean.mapToCommunity(map);

		model.addAttribute("communityBean", communityBean);

		return "qnaDetail";
	}

	@RequestMapping(value = "/qnaForm.al")
	public String qnaForm(Model model) {
		return "qnaForm";
	}

	@RequestMapping(value = "/qna.al")
	public String qna(Model model, CommunityBean community, BindingResult result) throws Exception {
		CommunityBean communityBean = new CommunityBean();

		new CommunityValidator().validate(community, result);

		if (result.hasErrors()) {
			return "/qnaForm.al";
		}

		communityService.insertQna(communityBean);

		return "/community/qna";
	}
}