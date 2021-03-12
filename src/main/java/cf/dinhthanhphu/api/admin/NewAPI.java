package cf.dinhthanhphu.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cf.dinhthanhphu.dto.NewDTO;
import cf.dinhthanhphu.service.INewService;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
	
	@Autowired
	private INewService newSerivce;

	//@RequestBody dùng để map json sang object
	@PostMapping("/api/new")
	public NewDTO createNew(@RequestBody NewDTO newDTO) {
		return newSerivce.saveOrUpdate(newDTO);
	}
		
	@PutMapping("/api/new")
	public NewDTO updateNew(@RequestBody NewDTO updateDTO) {
		return newSerivce.saveOrUpdate(updateDTO);
	}
		
	@DeleteMapping("/api/new")
	public void deleteNew(@RequestBody long[] ids) {
		newSerivce.delete(ids);
	}
}
