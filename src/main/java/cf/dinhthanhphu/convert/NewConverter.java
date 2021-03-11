package cf.dinhthanhphu.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cf.dinhthanhphu.dto.CategoryDTO;
import cf.dinhthanhphu.dto.NewDTO;
import cf.dinhthanhphu.entity.CategoryEntity;
import cf.dinhthanhphu.entity.NewEntity;
import cf.dinhthanhphu.repository.CategoryRepository;

@Component
public class NewConverter {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public NewDTO toDto(NewEntity entity) {
		NewDTO result = new NewDTO();
		BeanUtils.copyProperties(entity, result);
		result.setCategoryCode(entity.getCategory().getCode());
		return result;
	}
	
	public NewEntity toEntity(NewDTO dto){
		NewEntity result = new NewEntity();
		BeanUtils.copyProperties(dto, result);
		result.setCategory(categoryRepository.findOneByCode(dto.getCategoryCode()));
		return result;
	}
	
	public NewEntity toEntity(NewEntity result, NewDTO dto) {
		BeanUtils.copyProperties(dto, result);
		result.setCategory(categoryRepository.findOneByCode(dto.getCategoryCode()));
		return result;
	}
}
