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
 * @createTime 2019-01-22 15:26
 * @description:
 **/
@RestController
@RequestMapping("/UserManagement")
public class UserManagementController extends BaseController {

    //修改密码
    @RequestMapping(value = "/changePassword",method = RequestMethod.PUT)
    public Result changePassword(Integer userId,String password,String rePassword){
        return iUserService.changePassword(userId,password,rePassword);
    }

    //发送邮箱(验证码)
        @RequestMapping(value = "/sendEmail",method = RequestMethod.POST)
    public void sendEmail(HttpServletRequest request, String userEmail){
        iUserService.sendEmail(request,userEmail);
    }

    //验证邮箱与验证码是否正确
    @RequestMapping(value = "/contrastCode",method = RequestMethod.GET)
    public Result contrastCode(HttpServletRequest request,String userEmail,String userCode){
        return iUserService.contrastCode(request,userEmail,userCode);
    }

    //找回密码
    @RequestMapping(value = "/findPassword",method = RequestMethod.PUT)
    public Result findPassword(String password,String userEmail,HttpServletRequest request){
        return iUserService.findPassword(password,userEmail,request);
    }

    //修改个人信息
    @RequestMapping(value = "/changeInformation",method = RequestMethod.PUT)
    public Result changeInformation(User user){
        return iUserService.changeInformation(user);
    }

}
