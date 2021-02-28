package cf.dinhthanhphu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import cf.dinhthanhphu.model.NewsModel;
import cf.dinhthanhphu.model.RoleModel;
import cf.dinhthanhphu.model.UserModel;

public class UserMapper implements RowMappper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet rs) {
		
		try {
			UserModel users = new UserModel();
			users.setId(rs.getLong("id"));
			users.setFullName(rs.getString("fullname"));
			users.setUserName(rs.getString("username"));
			users.setPassword(rs.getString("password"));
			users.setStatus(rs.getInt("status"));
			
			try {
			    RoleModel role = new RoleModel();
	            role.setCode(rs.getString("code"));
	            role.setName(rs.getString("name"));
	            users.setRole(role);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
			
			
			
			users.setCreateDate(rs.getDate("createddate"));
			users.setCreateBy(rs.getString("createdby"));
			if(rs.getDate("modifieddate") != null)
				users.setModifiedDate(rs.getDate("modifieddate"));
			if(rs.getString("modifiedby") != null)
				users.setModifiedBy(rs.getString("modifiedby"));
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	

}
