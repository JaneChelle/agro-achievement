package org.wlgzs.agro_achievement.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.User;
import org.wlgzs.agro_achievement.util.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author:胡亚星
 * @createTime 2019-01-22 15:26
 * @description:
 **/
@RestController
@RequestMapping("/UserManagement")
public class UserManagementController extends BaseController {

    //到达个人中心
    @RequestMapping(value = "/toUserManagement")
    public ModelAndView toUserManagement(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return new ModelAndView("information");
    }

    //去修改个人信息
    @RequestMapping(value = "/toModifyUser")
    public ModelAndView toModifyUser(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return new ModelAndView("register");
    }

    //去修改密码
    @RequestMapping(value = "/toChangePassword")
    public ModelAndView toUserManagement() {
        return new ModelAndView("changePassword");
    }

    //修改密码
    @RequestMapping(value = "/changePassword")
    public ModelAndView changePassword(Model model, Integer userId, String password, String rePassword) {
        Result result = iUserService.changePassword(userId, password, rePassword);
        if (result.getCode() == 0) {
            model.addAttribute("msg", "修改成功！");
        } else {
            model.addAttribute("msg", "原密码错误！");
        }
        return new ModelAndView("redirect:/UserManagement/toUserManagement");
    }

    //发送找回密码邮箱(验证码)
    @RequestMapping(value = "/sendEmail")
    public void sendEmail(HttpServletRequest request, String userEmail) {
        iUserService.sendEmail(request, userEmail);
    }

    //发送注册邮箱(验证码)
    @RequestMapping(value = "/sendRegisterEmail")
    public void sendRegisterEmail(HttpServletRequest request, String userEmail) {
        iUserService.sendRegisterEmail(request, userEmail);
    }


    //验证邮箱与验证码是否正确
    @RequestMapping(value = "/contrastCode", method = RequestMethod.GET)
    public Result contrastCode(HttpServletRequest request, String userEmail, String userCode) {
        return iUserService.contrastCode(request, userEmail, userCode);
    }

    //去找回密码
    @RequestMapping(value = "/toFindPassword")
    public ModelAndView toFindPassword() {
        return new ModelAndView("findPassword");
    }

    //找回密码
    @RequestMapping(value = "/findPassword")
    public ModelAndView findPassword(Model model,String password, String userEmail, HttpServletRequest request) {
        Result result = iUserService.findPassword(password, userEmail, request);
        if(result.getCode() == 0){
            model.addAttribute("msg","修改成功！");
            return new ModelAndView("login");
        }
        model.addAttribute("msg","验证失效！");
        return new ModelAndView("redirect:/UserManagement/toFindPassword");
    }

    //修改个人信息
    @RequestMapping(value = "/changeInformation")
    public ModelAndView changeInformation(Model model,HttpSession session, User user) {
        Result result = iUserService.changeInformation(session, user);
        if(result.getCode() == 0){
            model.addAttribute("msg","修改成功！");
        }else{
            model.addAttribute("msg","修改失败！");
        }
        return new ModelAndView("redirect:/UserManagement/toUserManagement");
    }

}
