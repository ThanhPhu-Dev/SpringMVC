package cf.dinhthanhphu.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cf.dinhthanhphu.convert.CategoryConverter;
import cf.dinhthanhphu.dto.CategoryDTO;
import cf.dinhthanhphu.entity.CategoryEntity;
import cf.dinhthanhphu.repository.CategoryRepository;
import cf.dinhthanhphu.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter convert;

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryEntity> entities = categoryRepository.findAll();
		return entities.stream().map(c -> convert.toDto(c)).collect(Collectors.toList());
	}

}
