package cf.dinhthanhphu.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cf.dinhthanhphu.convert.NewConverter;
import cf.dinhthanhphu.dto.NewDTO;
import cf.dinhthanhphu.entity.NewEntity;
import cf.dinhthanhphu.repository.NewRepository;
import cf.dinhthanhphu.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newReposotory;
	
	@Autowired
	private NewConverter convert;
	

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewEntity> entities = newReposotory.findAll(pageable).getContent();
		return entities.stream().map(s -> convert.toDto(s)).collect(Collectors.toList());
	}

	@Override
	public int getTotalItem() {
		return (int) newReposotory.count();
	}

	@Override
	public NewDTO findById(long id) {
		NewEntity entity = newReposotory.findOne(id);
		return convert.toDto(entity);
	}

	
	
}
