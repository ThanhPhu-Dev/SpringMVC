package cf.dinhthanhphu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cf.dinhthanhphu.dao.INewDAO;
import cf.dinhthanhphu.model.NewsModel;
import cf.dinhthanhphu.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private INewDAO newsDAO;

	@Override
	public List<NewsModel> findAll() {
		return newsDAO.findAll();
	}
}
