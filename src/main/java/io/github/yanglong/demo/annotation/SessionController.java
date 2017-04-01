package io.github.yanglong.demo.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * package: io.github.yanglong.demo.annotation <br/>
 * functional describe: web test
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2017/3/31 10:39
 */
@Controller
public class SessionController {

    @RequestMapping({"/","index"})
    public ModelAndView index(HttpSession session){
        session.setAttribute("token","testToken");
        return new ModelAndView("index");
    }
}
