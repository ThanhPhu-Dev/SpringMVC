package cf.dinhthanhphu.dao;

import cf.dinhthanhphu.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findUserNameAndPasswordAndStatus(String userName,  String password, Integer status);
}
  