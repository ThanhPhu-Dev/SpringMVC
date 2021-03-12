package cf.dinhthanhphu.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import cf.dinhthanhphu.dto.NewDTO;

public interface INewService {
	List<NewDTO> findAll(Pageable pageable);
	int getTotalItem();
	NewDTO findById(long id);
	NewDTO saveOrUpdate(NewDTO dto);
	void delete(long[] id);
}
