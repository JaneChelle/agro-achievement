package org.wlgzs.agro_achievement.controller.admin;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.User;
import org.wlgzs.agro_achievement.util.Result;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 * 后台用户管理
 * @author 胡亚星
 * @since 2019-01-19
 *后台管理用户
 *
 */
@RestController
@RequestMapping("/admin")
public class UserController extends BaseController {

    //后台查询所有用户(搜索)
    @GetMapping("/adminUserList")
    public ModelAndView adminUserList(String userLevel,Model model,
                                      @RequestParam(value = "findName", defaultValue = "") String findName,
                                      @RequestParam(value = "current", defaultValue = "1") Integer current,
                                      @RequestParam(value = "limit", defaultValue = "8") Integer limit){
        Result result = iUserService.adminUserList(userLevel,findName,current,limit);
        List<User> userList = (List<User>) result.getData();

        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数
        model.addAttribute("userList",userList);
        model.addAttribute("findName", findName);
        return new ModelAndView("admin/adminUser");
    }

    //去添加用户
    @RequestMapping(value = "/toAddUser")
    public ModelAndView toAddUser(){
        return new ModelAndView("admin/addUser");
    }

    //后台增加用户
    @RequestMapping(value = "/adminAddUser")
    public Result adminAddUser(User user){
        System.out.println(user);
        Result result = iUserService.adminAddUser(user);
        return result;
    }

    //后台删除用户
    @RequestMapping(value = "/adminDeleteUser")
    public Result adminDeleteUser(Model model,Integer userId){
        Result result = iUserService.adminDeleteUser(userId);
        return result;
    }

    //去修改用户
    @RequestMapping(value = "/toAdminModifyUser")
    public ModelAndView toAdminModifyUser(Model model,Integer userId){
        User user = iUserService.findUserById(userId);
        if(user != null){
            model.addAttribute("user",user);
            model.addAttribute("msg","");
            return new ModelAndView("admin/modifyUser");
        }
        model.addAttribute("msg","不存在！");
        return new ModelAndView("redirect:/admin/adminUserList");
    }

    //后台修改用户
    @RequestMapping(value = "/adminModifyUser")
    public Result adminModifyUser(Model model,User user){
        Result result = iUserService.adminModifyUser(user);
        return result;
    }

}
