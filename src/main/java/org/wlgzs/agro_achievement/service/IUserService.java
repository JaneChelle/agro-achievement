package org.wlgzs.agro_achievement.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.wlgzs.agro_achievement.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.wlgzs.agro_achievement.util.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡亚星
 * @since 2019-01-19
 */
public interface IUserService extends IService<User> {

    //修改密码
    Result changePassword(Integer userId, String password, String rePassword);

    //修改密码发送邮箱
    void sendEmail(HttpServletRequest request, String userEmail);

    //修改密码发送邮箱
    void sendRegisterEmail(HttpServletRequest request, String userEmail);

    //验证邮箱与验证码是否正确
    Result contrastCode(HttpServletRequest request, String userEmail, String userCode);

    //找回密码
    Result findPassword(String password, String userEmail, HttpServletRequest request);

    //修改个人信息
    Result changeInformation(HttpSession session,User user);

    //后台查询所有用户
    Result adminUserList(String userLevel, String find, Integer current, Integer limit);

    //后台增加用户
    Result adminAddUser(User user);

    //后台删除用户
    Result adminDeleteUser(Integer userId);

    //后台修改用户
    Result adminModifyUser(User user);

    //查看用户信息
    User findUserById(Integer userId);
}
