package cf.dinhthanhphu.dao;

import java.util.List;

import cf.dinhthanhphu.model.NewsModel;

public interface INewDAO extends GenericDAO<NewsModel> {
	List<NewsModel> findAll();

}
  