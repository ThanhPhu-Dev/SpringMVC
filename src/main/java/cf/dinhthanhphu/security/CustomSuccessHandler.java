package cf.dinhthanhphu.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cf.dinhthanhphu.dto.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import cf.dinhthanhphu.util.SecurityUtils;
import org.springframework.util.StringUtils;


//sau khi login thành công sẽ tới đây, ở đâu làm nhiệm vụ phân quyền
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
//	@Override
//	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication auth)
//			throws IOException {
//		//gọi hàm determineTargetUrl : lấy url theo phần quyền
//		auth = SecurityContextHolder.getContext().getAuthentication();
//		String targetUrl = determineTargetUrl(auth);
//		if (response.isCommitted()) {
//			return;
//		}
//
//		redirectStrategy.sendRedirect(request, response, targetUrl);
//	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
										HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		authentication = SecurityContextHolder.getContext().getAuthentication();

		Object user = authentication.getPrincipal();
		MyUser myUser = (MyUser) user;

		/*Set target URL to redirect*/
		String targetUrl = determineTargetUrl(authentication);
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}


	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
	
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	
	//hàm check Authentication để chuyển trang
	public String determineTargetUrl(Authentication authentication) {
		String url = "";
		List<String> roles = SecurityUtils.getAuthorities();

		if (isAdmin(roles)) {
			url = "/quan-tri/trang-chu";
		} else if (isUser(roles)) {
			url = "/trang-chu";
		}
		return url;
	}
	
	private boolean isAdmin(List<String> roles) {
		if (roles.contains("ADMIN")) {
			return true;
		}
		return false;
	}
	
	private boolean isUser(List<String> roles) {
		if (roles.contains("USER")) {
			return true;
		}
		return false;
	}


}