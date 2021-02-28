package cf.dinhthanhphu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import cf.dinhthanhphu.model.NewsModel;

public class NewMapper implements RowMappper<NewsModel>{

	@Override
	public NewsModel mapRow(ResultSet rs) {
		
		try {
			NewsModel news = new NewsModel();
			news.setId(rs.getLong("id"));
			news.setTitle(rs.getString("title"));
			news.setCategoryId(rs.getLong("categoryid"));
			news.setContent(rs.getString("content"));
			news.setThumbnail(rs.getString("thumbnail"));
			news.setShortDescription(rs.getString("shortdescription"));
			news.setCreateDate(rs.getDate("createddate"));
			news.setCreateBy(rs.getString("createdby"));
			if(rs.getDate("modifieddate") != null)
				news.setModifiedDate(rs.getDate("modifieddate"));
			if(rs.getString("modifiedby") != null)
				news.setModifiedBy(rs.getString("modifiedby"));
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	

}
