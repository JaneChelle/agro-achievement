package org.wlgzs.agro_achievement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.wlgzs.agro_achievement.entity.User;
import org.wlgzs.agro_achievement.mapper.UserMapper;
import org.wlgzs.agro_achievement.service.LoginService;
import org.wlgzs.agro_achievement.util.Result;
import org.wlgzs.agro_achievement.util.ResultCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * @author:胡亚星
 * @createTime 2019-01-19 20:18
 * @description:
 **/
@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, User> implements LoginService {

    //登录
    @Override
    public Result login(HttpServletRequest request, String userName, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name", userName).or().eq("user_email", userName).or().eq("user_phone", userName);
        User user = baseMapper.selectOne(queryWrapper);
        if (user != null) {
            HttpSession session = request.getSession(true);
            if (user.getPassword().equals(password)) {//登录成功
                if ("1".equals(user.getUserLevel())) {//管理员登录
                    session.setAttribute("adminUser", user);
                    return new Result(ResultCode.ADMIN, "管理员登录成功！");
                } else if ("2".equals(user.getUserLevel())) {//专家
                    session.setAttribute("user", user);
                    System.out.println(user);
                    return new Result(ResultCode.EXPERT, "专家登录成功！");
                } else {//普通的用户
                    session.setAttribute("user", user);
                    System.out.println(user);
                    return new Result(ResultCode.SUCCESS, "普通用户登录成功！");
                }
            } else {  //密码错误
                return new Result(ResultCode.FAIL, "密码错误！");
            }
        } else { //账号不存在
            return new Result(ResultCode.FAIL, "账号不存在！");
        }
    }

    //注册
    @Override
    public Result register(HttpServletRequest request,User user) {
        baseMapper.insert(user);
        return new Result(ResultCode.SUCCESS,"注册成功！");
    }

    //检测用户名是否存在
    @Override
    public Result checkName(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",userName);
        User user = baseMapper.selectOne(queryWrapper);
        if(user != null){
            return new Result(ResultCode.FAIL,"用户名已存在！");
        }
        return new Result(ResultCode.SUCCESS,"OK");
    }

    //检测手机号是否存在
    @Override
    public Result checkPhone(String userPhone) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_phone",userPhone);
        User user = baseMapper.selectOne(queryWrapper);
        if(user != null){
            return new Result(ResultCode.FAIL,"手机号已存在！");
        }
        return new Result(ResultCode.SUCCESS,"OK");
    }

    //检测邮箱是否存在
    @Override
    public Result checkEmail(String userEmail) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_email",userEmail);
        User user = baseMapper.selectOne(queryWrapper);
        if(user != null){
            return new Result(ResultCode.FAIL,"邮箱已存在！");
        }
        return new Result(ResultCode.SUCCESS,"OK");
    }

}
