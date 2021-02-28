package cf.dinhthanhphu.dao.impl;

import java.util.List;



import cf.dinhthanhphu.dao.IUserDAO;
import cf.dinhthanhphu.mapper.UserMapper;
import cf.dinhthanhphu.model.UserModel;


public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder( "SELECT * FROM users AS u");
		sql.append(" JOIN role AS r ON r.id = u.roleid");
		sql.append("  WHERE username = ? AND password = ? AND status = ?");
		List<UserModel> user =  query(sql.toString(), new UserMapper(), userName,password,status);
		return user.isEmpty() ? null : user.get(0);
	}
	
}
