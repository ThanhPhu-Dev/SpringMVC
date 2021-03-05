package cf.dinhthanhphu.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import cf.dinhthanhphu.dto.MyUser;

@Component
public class AuthenticationFacadeImpl implements AuthenticationFacade{

	@Override
	public User getAuthentication() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

}
