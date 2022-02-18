package jumo.admin.memeber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jumo.model.MemberBean;
import jumo.util.MapToBean;
import jumo.util.Paging;

@Controller
public class AdminMemberController {

	@Resource(name="adminMemberService")
	private AdminMemberService adminMemberService;
	
	@RequestMapping(value = "/memberList.al")
	public String memberList(HttpServletRequest request, Model model) throws Exception {
		
		/* 페이징을 위한 변수 */
		int pageSize = 5; // 페이지당 출력할 회원의 수
		int START = 1;
		int END = pageSize;
		int currentPage = 1; // 현재 페이지

		int countMemberAll; // 전체 회원의 수
		int pageBlock = 5; // 표시할 페이지의 수
		String url = "memberList.al";
		String searchUrl = "";
		
		/* 기본 페이지가 아닐 경우 */
		if(request.getParameter("page")!=null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
			START = 1 + pageSize*(currentPage-1); 
			END = pageSize*currentPage;
		}
		
		countMemberAll = adminMemberService.memberCount();
		
		// 페이징할 아이템의 총 수, 페이지의 수 ex> 1~5 6~10, 한 페이지에 표시할 아이템의 수, 현재 페이지, 이동주소, 검색시 사용할 주소 입력
		Paging paging = new Paging(countMemberAll,	pageBlock,
				pageSize ,currentPage, url, searchUrl);
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<MemberBean> memberBeanList = new ArrayList<MemberBean>();
		
		list = adminMemberService.memberListPaging(START, END); 
		
		for(Map<String, Object> mapObject : list) {
			memberBeanList.add(MapToBean.mapToMember(mapObject));
		}
		
		model.addAttribute("memberBeanList", memberBeanList);
		
		/* 페이징을 위한 값 삽입 */
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("paging", paging);
		
		return "memberList";
	}
	
	@RequestMapping(value = "/memberDetail.al")
	   public String memberDetail (MemberBean member, Model model) throws Exception {
	      Map<String, Object> map = new HashMap<String, Object>();
	      MemberBean memberBean = new MemberBean();
	      
	      map = adminMemberService.selectMemberId(member);
	      memberBean = MapToBean.mapToMember(map);
	      
	      model.addAttribute("memberBean", memberBean);
	      
	      return "memberDetail";
	   }
	 
	@RequestMapping(value = "/memberModify.al")
	public String memberModify (MemberBean member, Model model)
			throws Exception {
		
		// BlOCK값이 체크가 되지 않으면 null로 입력되어 넘어오게 된다.
		// 따라서 BlOCK을 하지 않음을 설정하기 위해 "N"값을 입력하여 넘겨준다.
		// 체크가 되었을 경우 "Y"값이 넘어오게 된다.
		if(member.getBLOCK() == null) {
			member.setBLOCK("N");
		}
		
		adminMemberService.updateMemberAdmin(member);
		
		model.addAttribute("msg", member.getEMAIL() + "회원의 정보가 수정되었습니다.");
		model.addAttribute("url", "/memberList.al");
		return "admin/member/memberModify";
	}
	
	@RequestMapping(value = "/memberDelete.al")
	public String memberDelete (Model model, MemberBean member) throws Exception {
		// 선택한 계정을 삭제하기 위해서 파라미터로 계정의 이메일값을 입력해 MemberBean으로 받는다.

		/* ADMIN 계정을 삭제하려고 시도하면 막는다 */
		if(member.getEMAIL().equals("ADMIN")) {
			model.addAttribute("msg", "관리자는 삭제할 수 없습니다.");
			model.addAttribute("url", "/memberDetail.al?EMAIL=" + member.getEMAIL());
			
			return "admin/member/memberDelete";	
		}
		
		adminMemberService.deleteMember(member);
		
		/* 회원 정보 삭제 완료 */
		model.addAttribute("msg", member.getEMAIL() + "회원이 삭제 되었습니다.");
		model.addAttribute("url", "/memberList.al");
		
		return "admin/member/memberDelete";
	}
}