package org.wlgzs.agro_achievement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.User;
import org.wlgzs.agro_achievement.util.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:胡亚星
 * @createTime 2019-01-19 11:23
 * @description:
 **/
@RestController
@RequestMapping("/LogUser")
public class LogUserController extends BaseController {

    /**
     * 登录
     * @param request
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public Result login(HttpServletRequest request,String userName,String password){
        Result result = loginService.login(request,userName,password);
        return result;
    }

    /**
     * 注册
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.PUT)
    public Result register(HttpServletRequest request, User user){
        Result result = loginService.register(request,user);
        return result;
    }

    /**
     * 检测用户名是否存在
     * @param userName
     * @return
     */
    @RequestMapping(value = "/checkName",method = RequestMethod.GET)
    public Result checkName(String userName){
        return loginService.checkName(userName);
    }

    /**
     * 检测收手机号是否存在
     * @param userPhone
     * @return
     */
    @RequestMapping(value = "/checkPhone",method = RequestMethod.GET)
    public Result checkPhone(String userPhone){
        return loginService.checkPhone(userPhone);
    }

    /**
     * 检测邮箱是否存在
     * @param userEmail
     * @return
     */
    @RequestMapping(value = "/checkEmail",method = RequestMethod.GET)
    public Result checkEmail(String userEmail){
        return loginService.checkEmail(userEmail);
    }
}
