package cf.dinhthanhphu.service;

import java.util.List;

import cf.dinhthanhphu.model.NewsModel;

public interface INewService {
	List<NewsModel> findAll();
}
