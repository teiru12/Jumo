package jumo.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("------------------ Interceptor : LoginInterceptor ------------------ ");
		
		String email = (String) request.getSession().getAttribute("EMAIL");
		
		/* 로그인하지 않아도 사용할 수 있는 기능들 */
		// main.al loginForm.al login.al joinForm.al joinSuccess.al 
		// findId.al findIdResult.al findPw.al findPwResult.al confirmId.al
		// allList.al aclList.al etcList.al pDetail.al
		// noticeList.al noticeDetial.al qnaList.al qnaDetail.al
		
		/* 로그인하지 않은 사용자 핸들 */
		if(email == null) {
			System.out.println("1");
			response.sendRedirect("/Jumo/main.al");
			return false;
		} else {
			if(! email.equals("ADMIN")) { 

				System.out.println("2");
				response.sendRedirect("/Jumo/main.al");
				return false;
			} else {
				System.out.println("3");
				return super.preHandle(request, response, handler);
			}
		}
	}

}