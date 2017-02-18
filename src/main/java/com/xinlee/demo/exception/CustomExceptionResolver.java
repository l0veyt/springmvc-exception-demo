package com.xinlee.demo.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xin.lee on 2017/2/18.
 * 自定义的全局异常处理器
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        /**
         * 异常情况：
         * 调用某些方法而抛出的异常，例如IO异常，可以try后再在catch中手动throw封装异常信息
         * 业务上的错误而要手动throw的异常
         *
         * 运行时抛出的异常，例如空指针异常
         */
        CustomException customException;
        if(e instanceof CustomException) {
            // 如果是自己手动throw的异常，则显示异常的信息
            customException = (CustomException) e;
        }else {
            // 如果是运行时异常，则显示未知错误（后台查看日志）
            // 记录日志，实际开发使用log4j等日志框架记录日志
            System.out.println("记录日志：");
            e.printStackTrace();
            customException = new CustomException("未知错误");
        }
        String message = customException.getMessage();          // 获取错误信息
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", message);             // 添加错误信息
        modelAndView.setViewName("error");                      // 指向错误页面
        return modelAndView;
    }
}
