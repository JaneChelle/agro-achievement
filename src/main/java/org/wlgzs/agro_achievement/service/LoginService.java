package org.wlgzs.agro_achievement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.wlgzs.agro_achievement.entity.User;
import org.wlgzs.agro_achievement.util.Result;
import javax.servlet.http.HttpServletRequest;

/**
 * @author:胡亚星
 * @createTime 2019-01-19 20:16
 * @description:
 **/
public interface LoginService extends IService<User> {

    //登录
    Result login(HttpServletRequest request, String userName, String password);

    //注册
    Result register(HttpServletRequest request, User user);

    //检测用户名是否存在
    Result checkName(String userName);

    //检测手机号是否存在
    Result checkPhone(String userPhone);

    //检测邮箱是否存在
    Result checkEmail(String userEmail);

}
