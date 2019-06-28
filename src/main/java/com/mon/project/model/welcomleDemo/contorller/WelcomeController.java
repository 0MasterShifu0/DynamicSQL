package com.mon.project.model.welcomleDemo.contorller;

import com.mon.project.model.welcomleDemo.vo.Welcome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/welcome")
public class WelcomeController {
    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
    /**
     * hello.html页面并输入动态值
     * @return
     */
    @RequestMapping("welcomeIndex")
    public String welcomeIndex(Model model){
        Welcome people = new Welcome();
        people.setId(1L);
        people.setName("Tom");
        people.setAge(20);
        model.addAttribute("singlePerson",people);
        return "hello";
    }

    /**
     * 模拟请求接口报错
     * @return
     */
    @RequestMapping("getError")
    @ResponseBody
    public List<Welcome> getError(){
        /**
         * 测试数据
         */
        List<Welcome> welcomes = new ArrayList<>();
        Welcome w1 = new Welcome();
        w1.setId(1L);
        w1.setName("xx1");
        w1.setAge(11);
        w1.setGender("女");
        throw new IllegalArgumentException("抱歉,访问链接有误!");
//        return welcomes;
    }

    /**
     * 模拟请求带断言参数接口
     * @return
     */
    @RequestMapping(value = "getAdvicePost",method = RequestMethod.POST)
    @ResponseBody
    public Welcome getAdvicePost(@ModelAttribute("msg") String msg, @RequestBody Welcome w1){
        w1.setName(msg+w1.getName());
        return w1;
    }

    /**
     * 返回json字符串
     * @return
     */
    @RequestMapping("getWelcomeInfo")
    @ResponseBody
    public List<Welcome> getWelcomeInfo(){
       //测试数据
        List<Welcome> welcomes = new ArrayList<>();
        Welcome w1 = new Welcome();
        w1.setId(1L);
        w1.setName("xx1");
        w1.setAge(11);
        w1.setGender("女");
        Welcome w2 = new Welcome();
        w2.setId(2L);
        w2.setName("xx2");
        w2.setAge(22);
        w2.setGender("男");
        welcomes.add(w1);
        welcomes.add(w2);
        logger.info(welcomes.toString());
        logger.warn(welcomes.toString());
        logger.error(welcomes.toString());
        return welcomes;
    }

}
