package cf.dinhthanhphu.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import cf.dinhthanhphu.dto.MyUser;

public interface AuthenticationFacade {
    User getAuthentication();
}
