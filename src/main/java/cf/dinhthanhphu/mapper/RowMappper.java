package cf.dinhthanhphu.mapper;

import java.sql.ResultSet;

public interface RowMappper<T> {
	//dùng để lấy kết quả từ câu truy vấn(resultSet) đổ vào (mapper) đối tượng(model)
	T mapRow(ResultSet rs);
}
