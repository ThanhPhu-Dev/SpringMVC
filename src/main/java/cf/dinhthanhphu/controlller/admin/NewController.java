package cf.dinhthanhphu.controlller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cf.dinhthanhphu.dto.NewDTO;
import cf.dinhthanhphu.service.ICategoryService;
import cf.dinhthanhphu.service.INewService;

@Controller(value = "newControllerOfAdmin")
public class NewController {
	@Autowired
	private INewService newSerivce;
	
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
	   public ModelAndView showlist(@RequestParam("page") int page, 
			   						@RequestParam("limit") int limit) {
		  NewDTO model = new NewDTO();
		  model.setPage(page);
		  model.setLimit(limit);
	      ModelAndView mav = new ModelAndView("admin/new/list");
	      Pageable pageable = new PageRequest(page - 1, limit);
	      model.setListResult(newSerivce.findAll(pageable));
	      //tính số trang để số ra frontend
	      model.setTotalItem(newSerivce.getTotalItem());
	      model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
	      mav.addObject("model", model);
	      return mav;
	   }
	
	//load giao diện nếu có id là giao diện chỉnh sửa, và k có id là giao diện thêm
	@RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
	   public ModelAndView editNew(@RequestParam( value = "id", required = false) Long id) {
	      ModelAndView mav = new ModelAndView("admin/new/edit");
	      NewDTO model =new NewDTO();
	      if(id != null) {
	    	  model = newSerivce.findById(id);
	      }
	      mav.addObject("catogories", categoryService.findAll());
	      mav.addObject("model", model);
	      return mav;
	   }
}
