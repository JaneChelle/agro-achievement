package org.wlgzs.agro_achievement.controller.admin;


import org.springframework.web.bind.annotation.*;

import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.User;
import org.wlgzs.agro_achievement.util.Result;

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
@RequestMapping("/user")
public class UserController extends BaseController {

    //后台查询所有用户(搜索)
    @GetMapping("/adminUserList")
    public Result adminUserList(String userLevel,
                                    @RequestParam(value = "find", defaultValue = "") String find,
                                @RequestParam(value = "current", defaultValue = "1") Integer current,
                                @RequestParam(value = "limit", defaultValue = "8") Integer limit){
        return iUserService.adminUserList(userLevel,find,current,limit);
    }

    //后台增加用户
    @RequestMapping(value = "/adminAddUser",method = RequestMethod.PUT)
    public Result adminAddUser(User user){
        return iUserService.adminAddUser(user);
    }

    //后台删除用户
    @RequestMapping(value = "/adminDeleteUser",method = RequestMethod.DELETE)
    public Result adminDeleteUser(Integer userId){
        return iUserService.adminDeleteUser(userId);
    }

    //后台修改用户
    @RequestMapping(value = "/adminModifyUser",method = RequestMethod.PUT)
    public Result adminModifyUser(User user){
        return iUserService.adminModifyUser(user);
    }

}
