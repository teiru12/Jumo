package jumo.event;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jumo.model.JUMO_EVENT;
import jumo.model.JUMO_POINT;
import jumo.util.Paging;

@Controller
public class EventController {

	@Resource(name="eventService")
	EventService eventService;
	
	@RequestMapping("/point.al")
	public String point(HttpServletRequest request, Model model) throws Exception {
		
		/* 현재 로그인한 사용자의 email을 읽어와서 이벤트 테이블의 정보를 읽어온다 */
		String email = (String) request.getSession().getAttribute("EMAIL");
		JUMO_EVENT eventBean = eventService.selectEventId(email);
		
		/* 페이징을 위한 변수 */
		int pageSize = 5; // 페이지당 출력할 포인트 정보의 수
		int START = 1;
		int END = pageSize;
		int currentPage = 1; // 현재 페이지

		int countEventAll; // 전체 상품의 수
		int pageBlock = 5; // 표시할 페이지의 수
		String url = "point.al";
		String searchUrl = "";
		
		/* 검색 조건일 경우 사용 변수 */
		// 날짜는 8자리 "yyyyMMdd"
		String MINDATE = ""; // 검색 날짜 최소값
		String MAXDATE = ""; // 검색 날짜 최대값
		
		/* 기본 페이지가 아닐 경우 */
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
			START = 1 + pageSize * (currentPage - 1);
			END = pageSize * currentPage;
		}
		
		/* MINDATE와 MAXDATE 계산 */
		// "maxDate" 파라미터가 null이 아니면 검색
		if(request.getParameter("maxDate")!=null) {
			int maxDateInt = Integer.parseInt(request.getParameter("maxDate"));
			
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
			// 오늘 날짜를 구해서 캘린더객체로 생성한 다음에
			// 오늘 날짜의 8자리 yyyyMMdd값을 구한다.
			Calendar cal = Calendar.getInstance();
			
			String today = formatDate.format(cal.getTime()); // 오늘
			
			cal.add(Calendar.MONTH, -1);
			String oneMonthAgo = formatDate.format(cal.getTime()); // 1달전

			cal.add(Calendar.MONTH, -1);
			String twoMonthAgo = formatDate.format(cal.getTime()); // 2달전

			cal.add(Calendar.MONTH, -1);
			String threeMonthAgo = formatDate.format(cal.getTime()); // 3달전
			
			cal.add(Calendar.YEAR, -100);
			String stoneAge = formatDate.format(cal.getTime()); // 100년전
			
			if(maxDateInt == 0) {
				// maxDate값이 0이면 1개월전 ~ 오늘
				MAXDATE = today;
				MINDATE = oneMonthAgo;
			} else if(maxDateInt == 1) {
				// maxDate값이 1이면 2개월전 ~ 1개월전
				MAXDATE = oneMonthAgo;		
				MINDATE = twoMonthAgo;		
			} else if(maxDateInt == 2) {
				// maxDate값이 2이면 3개월전 ~ 2개월전
				MAXDATE = twoMonthAgo;		
				MINDATE = threeMonthAgo;	
			} else if(maxDateInt == 3) {
				// maxDate값이 3이면 100년전~3개월 이전
				MAXDATE = threeMonthAgo;		
				MINDATE = stoneAge;		
			}			
		}		
		
		/* 페이징을 위한 값 계산 */
		if(request.getParameter("maxDate")!= null) {
			// 조건이 있을 경우 조건 검색에 따른 수량 계산
			countEventAll = eventService.pointIdSearchCount(MINDATE, MAXDATE, email);
		} else {
			countEventAll = eventService.pointIdCount(email);
		}
		
		// 페이징할 아이템의 총 수, 페이지의 수 ex> 1~5 6~10, 한 페이지에 표시할 아이템의 수, 현재 페이지, 이동주소, 검색시 사용할
		// 주소 입력
		Paging paging = new Paging(countEventAll, pageBlock, pageSize, currentPage, url, searchUrl);

		List<JUMO_POINT> list = new ArrayList<JUMO_POINT>();
		if(request.getParameter("maxDate")!= null) {
			// 조건이 있을 경우 조건 검색
			list = eventService.pointIdListSearchPaging(email, MINDATE, MAXDATE, START, END);
		} else {
			list = eventService.pointIdListPaging(email, START, END);
		}
		
		model.addAttribute("eventBean", eventBean);
		model.addAttribute("pointList", list);
		model.addAttribute("maxDate", request.getParameter("maxDate"));
		
		/* 페이징을 위한 값 삽입 */
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("paging", paging);
		
		return "point";
	}
	
	@RequestMapping("/coupon.al")
	public String coupon(HttpServletRequest request, Model model) throws Exception {
		
		/* 현재 로그인한 사용자의 email을 읽어와서 이벤트 테이블의 정보를 읽어온다 */
		String email = (String) request.getSession().getAttribute("EMAIL");
		JUMO_EVENT eventBean = eventService.selectEventId(email);
		
		model.addAttribute("eventBean", eventBean);		
		
		return "coupon";
	}
	
	@RequestMapping("/rullet.al")
	public String rullet(HttpServletRequest request, Model model) throws Exception {
	
		/* 현재 로그인한 사용자의 email을 읽어와서 이벤트 테이블의 정보를 읽어온다 */
		String email = (String) request.getSession().getAttribute("EMAIL");
		JUMO_EVENT eventBean = eventService.selectEventId(email);
		
		model.addAttribute("eventBean", eventBean);		
		
		return "coupon";
	}
	
	// Ajax를 사용한 point 수정
//	@ResponseBody
//	@RequestMapping("/updatePoint.al")
//	public String updatePoint(@RequestBody String message, JUMO_EVENT eventBean) throws Exception {
//		
//	}

	// Ajax를 사용한 coupon 수정
//	@ResponseBody
//	@RequestMapping("/updateCoupon.al")
//	public String updateCoupon(@RequestBody JUMO_EVENT eventBean) throws Exception {
//		
//	}	
}