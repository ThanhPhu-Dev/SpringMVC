package cf.dinhthanhphu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import cf.dinhthanhphu.model.CategoryModel;

public class CategoryMapper implements RowMappper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		
		try {
			CategoryModel category = new CategoryModel();
			category.setId(resultSet.getLong("id"));
			category.setCode(resultSet.getString("code"));
			category.setName(resultSet.getString("name"));
			return category;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	
	}

}
