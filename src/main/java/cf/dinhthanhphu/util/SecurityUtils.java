package cf.dinhthanhphu.util;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import cf.dinhthanhphu.dto.MyUser;
import cf.dinhthanhphu.security.AuthenticationFacade;

@Component
public class SecurityUtils {
	
	@Autowired
	private AuthenticationFacade facade;
	
	
	// dùng để get thong tin MyUser
	public User getPrincipal() {
//		Object user = (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//		MyUser myUser = (MyUser)user;
//        return myUser;
		 User user = facade.getAuthentication();
		return user;
    }
	
	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities() {
		List<String> results = new ArrayList<>();
//		List<GrantedAuthority> authorities = (List<GrantedAuthority>)(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		List<GrantedAuthority> authorities =(List<GrantedAuthority>) facade.getAuthentication().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            results.add(authority.getAuthority());
        }
        Object a = ((SecurityContextHolder.getContext()).getAuthentication().getPrincipal());
		MyUser myUser = (MyUser)a;
		return results;	
	}
}