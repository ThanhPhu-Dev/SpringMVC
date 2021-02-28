package cf.dinhthanhphu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cf.dinhthanhphu.dao.INewDAO;
import cf.dinhthanhphu.mapper.NewMapper;
import cf.dinhthanhphu.model.NewsModel;


@Repository
public class NewDao extends AbstractDAO<NewsModel> implements INewDAO{

	@Override
	public List<NewsModel> findAll() {
		String sql = "SELECT *  FROM news";
		return query(sql.toString(), new NewMapper());
	}

}
