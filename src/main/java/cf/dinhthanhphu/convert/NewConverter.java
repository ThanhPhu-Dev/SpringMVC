package cf.dinhthanhphu.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cf.dinhthanhphu.dto.NewDTO;
import cf.dinhthanhphu.entity.NewEntity;

@Component
public class NewConverter {

	public NewDTO toDto(NewEntity entity) {
		NewDTO result = new NewDTO();
		BeanUtils.copyProperties(entity, result);
		result.setCategoryCode(entity.getCategory().getCode());
		return result;
	}
	
	public NewEntity toEntity(NewDTO dto) {
		NewEntity result = new NewEntity();
		BeanUtils.copyProperties(dto, result);
		return result;
	}
	
	public NewEntity toEntity(NewEntity result, NewDTO dto) {
		BeanUtils.copyProperties(dto, result);
		return result;
	}
}
