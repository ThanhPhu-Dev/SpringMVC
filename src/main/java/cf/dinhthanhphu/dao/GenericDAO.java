package cf.dinhthanhphu.dao;

import java.util.List;

import cf.dinhthanhphu.mapper.RowMappper;

public interface GenericDAO<T> {
//tạo 1 câu truy vấn chung cần 3 tham số: câu query, đối tượng trả v�? từ câu truy vấn (resultSet),parameter của câu truy vấn
	<T> List<T> query(String sql, RowMappper<T> rowMapper, Object... Parameters);
	void Update(String sql, Object... parameters);
	Long Insert(String sql, Object... parameters);
	//void Delete(String sql, Object ...parameters );
	int count(String sql, Object... parameters);
	
}
