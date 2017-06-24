package com.zlikun.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 默认控制器
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/24 14:57
 */
@Controller
public class DefaultController {

    @RequestMapping("/")
    public @ResponseBody Object index() {
        return "系统正在开发中，敬请期待 ..." ;
    }

}