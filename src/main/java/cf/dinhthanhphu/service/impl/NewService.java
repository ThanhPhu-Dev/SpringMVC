package cf.dinhthanhphu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cf.dinhthanhphu.dto.NewDTO;
import cf.dinhthanhphu.entity.NewEntity;
import cf.dinhthanhphu.repository.NewRepository;
import cf.dinhthanhphu.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newReposotory;

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> dtos = new ArrayList<NewDTO>();
		List<NewEntity> entities = newReposotory.findAll(pageable).getContent();
		for(NewEntity item: entities) {
			NewDTO dto = new NewDTO();
			BeanUtils.copyProperties(item, dto);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public int getTotalItem() {
		return (int) newReposotory.count();
	}
}
