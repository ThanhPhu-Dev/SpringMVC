package cf.dinhthanhphu.controlller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cf.dinhthanhphu.dto.NewDTO;
import cf.dinhthanhphu.service.INewService;

@Controller(value = "NewControllerOfAdmin")
public class NewController {
	@Autowired
	private INewService newSerivce;
	
	@RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
	   public ModelAndView showlist(@ModelAttribute("model") NewDTO model) {
	      ModelAndView mav = new ModelAndView("admin/new/list");
	      model.setListResult(newSerivce.findAll());
	      mav.addObject("model", model);
	      return mav;
	   }
	
	@RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
	   public ModelAndView editNew() {
	      ModelAndView mav = new ModelAndView("admin/new/edit");
	      return mav;
	   }
}
