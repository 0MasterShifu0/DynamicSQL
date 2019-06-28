package com.mon.project.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    //拦截所有Exception,展示Error页面
    @ExceptionHandler(value = Exception.class)
    public String exception(Exception exception, WebRequest webRequest,Model model){
        logger.error("访问 "+webRequest.getContextPath() +"报错,报错信息为: {}",exception.getMessage());
        model.addAttribute("erroMessage",exception.getMessage());
        return   "error";
    }

    //将额外键值添加到所有全局请求参数中
    @ModelAttribute
    public void addAttribute(Model model){
        model.addAttribute("msg","额外信息");
    }

    //忽略请求中的id参数
//    @InitBinder
//    public void initBinder(WebDataBinder webDataBinder){
//        webDataBinder.setDisallowedFields("id");
//    }


}
