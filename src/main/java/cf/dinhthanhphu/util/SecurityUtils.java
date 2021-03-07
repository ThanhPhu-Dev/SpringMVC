package cf.dinhthanhphu.util;


import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import cf.dinhthanhphu.dto.MyUser;
import org.springframework.util.StringUtils;


public class SecurityUtils {

	// dùng để get thong tin MyUser
	public static MyUser getPrincipal() {
		Object user = (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		MyUser myUser = (MyUser)user;
		return myUser;
    }
	
	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities() {
		List<String> results = new ArrayList<>();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>)(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        for (GrantedAuthority authority : authorities) {
            results.add(authority.getAuthority());
        }
        /*Object a = ((SecurityContextHolder.getContext()).getAuthentication().getPrincipal());
		MyUser myUser = (MyUser)a;*/
		return results;	
	}
}