package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.login.LoginService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/account")
public class LoginController {
    private Logger logger = Logger.getLogger(LoginController.class.getName());

    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    public String login() {
        return "/login/login";
    }

    @RequestMapping("/check")
    public ModelAndView checkAccount(@RequestParam String username, @RequestParam String password) {
        ModelAndView view = new ModelAndView();

        if (loginService.auth(username, password)) {
            if (logger.isDebugEnabled()) {
                logger.debug("login success.");
            }
            view.addObject("username", username);
            view.setViewName("redirect:/main/main.do");
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("login fail.");
            }
            view.addObject("success", "false");
            view.setViewName("/login/login");
        }
        return view;
    }

    @RequestMapping("loginout")
    public void loginOut() {

    }
}
