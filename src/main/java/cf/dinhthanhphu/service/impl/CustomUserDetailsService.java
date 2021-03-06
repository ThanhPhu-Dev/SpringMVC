package cf.dinhthanhphu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cf.dinhthanhphu.constant.SystemConstant;
import cf.dinhthanhphu.dto.MyUser;
import cf.dinhthanhphu.entity.RoleEntity;
import cf.dinhthanhphu.entity.UserEntity;
import cf.dinhthanhphu.repository.UserRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		
		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (RoleEntity role: userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		
		//vì User trong spring chỉ lưu dc username với password nên nếu muốn lưu thêm
		// như fullname thì tạo 1 class extends User và thêm thuộc tính vào
		MyUser myUser = new MyUser(userEntity.getFullName(),userEntity.getUserName(), userEntity.getPassword(), 
							true, true, true, true, authorities);
		return myUser;
	}

}
