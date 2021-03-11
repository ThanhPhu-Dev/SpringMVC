package cf.dinhthanhphu.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cf.dinhthanhphu.dto.CategoryDTO;
import cf.dinhthanhphu.entity.CategoryEntity;

@Component
public class CategoryConverter {

	public CategoryDTO toDto(CategoryEntity entity) {
		CategoryDTO result = new CategoryDTO();
		BeanUtils.copyProperties(entity, result);
		return result;
	}
	
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity result = new CategoryEntity();
		BeanUtils.copyProperties(dto, result);
		return result;
	}
}
