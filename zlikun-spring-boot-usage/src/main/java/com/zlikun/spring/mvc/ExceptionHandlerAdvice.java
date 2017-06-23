package com.zlikun.spring.mvc;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 13:08
 */
@ControllerAdvice   // 声明一个控制器建言，该注解组合了@Component注解，所以自动注册了Spring的Bean
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)  // 定义全局异常处理，这里拦截所有Exception
    public ModelAndView exception(Exception ex , WebRequest request) {
        ModelAndView mav = new ModelAndView("error") ;
        mav.addObject("errorMessage" ,ex.getMessage()) ;
        return mav ;
    }

    @ModelAttribute     // 添加全局键值对信息，所有注解为@RequestMapping的方法都可获取此键值对
    public void addAttributes(Model model) {
        model.addAttribute("msg" ,"额外信息") ;
    }

    @InitBinder     // 通过该注解定制WebDataBinder
    public void initBinder(WebDataBinder binder) {
        // 这里表示忽略request参数中的id参数
        binder.setDisallowedFields("id");
    }

}
