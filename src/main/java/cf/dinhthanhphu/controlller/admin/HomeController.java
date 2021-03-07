package cf.dinhthanhphu.controlller.admin;

import cf.dinhthanhphu.dto.MyUser;
import cf.dinhthanhphu.util.SecurityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

//@Controller(value = "homeControllerOfAdmin")
@Controller
public class HomeController {

    @RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("admin/home");
        mav.addObject("user",SecurityUtils.getPrincipal().getFullName());
        return mav;
    }
}
