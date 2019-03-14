package org.wlgzs.agro_achievement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.wlgzs.agro_achievement.entity.User;
import org.wlgzs.agro_achievement.mapper.UserMapper;
import org.wlgzs.agro_achievement.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.wlgzs.agro_achievement.util.RandomNumberUtils;
import org.wlgzs.agro_achievement.util.Result;
import org.wlgzs.agro_achievement.util.ResultCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 胡亚星
 * @since 2019-01-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private JavaMailSender mailSender;

    //修改密码
    @Override
    public Result changePassword(Integer userId, String password, String rePassword) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).eq("password", password);
        User user = baseMapper.selectOne(queryWrapper);
        if (user != null) {
            user.setPassword(rePassword);
            baseMapper.updateById(user);
            return new Result(ResultCode.SUCCESS, "修改成功！");
        }
        return new Result(ResultCode.FAIL, "原密码错误！");
    }

    //发送邮箱
    @Override
    public void sendEmail(HttpServletRequest request, String userEmail) {
        HttpSession session = request.getSession(true);
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        RandomNumberUtils randomNumberUtils = new RandomNumberUtils();
        String authCode = randomNumberUtils.getRandonString(6);
        session.setMaxInactiveInterval(60 * 2);
        session.setAttribute("authCode", authCode);
        System.out.println(authCode);
        session.setAttribute("userEmail", userEmail);
        //发送者
        mainMessage.setFrom("huystar@126.com");
        //接收者
        mainMessage.setTo(userEmail);
        //发送的标题
        mainMessage.setSubject("农业成果转化修改密码");
        //发送的内容
        mainMessage.setText("验证码：" + authCode + "您正在修改密码，请输入您的验证码继续完成操作。");
        mailSender.send(mainMessage);
    }

    @Override
    public void sendRegisterEmail(HttpServletRequest request, String userEmail) {
        HttpSession session = request.getSession(true);
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        RandomNumberUtils randomNumberUtils = new RandomNumberUtils();
        String authCode = randomNumberUtils.getRandonString(6);
        session.setMaxInactiveInterval(60 * 2);
        session.setAttribute("authCode", authCode);
        System.out.println(authCode);
        session.setAttribute("userEmail", userEmail);
        //发送者
        mainMessage.setFrom("huystar@126.com");
        //接收者
        mainMessage.setTo(userEmail);
        //发送的标题
        mainMessage.setSubject("农业成果转化注册");
        //发送的内容
        mainMessage.setText("验证码：" + authCode + "您正在注册农业成果转化，请输入您的验证码继续完成操作。");
        mailSender.send(mainMessage);
    }

    //验证邮箱与验证码是否正确
    @Override
    public Result contrastCode(HttpServletRequest request, String userEmail, String userCode) {
        HttpSession session = request.getSession();
        String sessionCode = (String) session.getAttribute("authCode"); //获取保存在session里面的验证码
        String sessionMail = (String) session.getAttribute("userEmail");//获取保存在session里面的邮箱
        if (userEmail != null && userCode != null && userEmail.equals(sessionMail) && userCode.equals(sessionCode)) {
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    //找回密码
    @Override
    public Result findPassword(String password, String userEmail, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String sessionMail = (String) session.getAttribute("userEmail");//获取保存在session里面的邮箱
        if (sessionMail.equals(userEmail)) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_email", userEmail);
            User user = baseMapper.selectOne(queryWrapper);
            user.setPassword(password);
            baseMapper.updateById(user);
            return new Result(ResultCode.SUCCESS, "修改成功！");
        }
        return new Result(ResultCode.FAIL, "验证失效！");
    }

    //修改个人信息
    @Override
    public Result changeInformation(HttpSession session,User user) {
        if (user != null) {
            baseMapper.updateById(user);
            session.setAttribute("user",user);
            return new Result(ResultCode.SUCCESS);
        }
        return new Result(ResultCode.FAIL);
    }

    //后台查询所有用户
    @Override
    public Result adminUserList(String userLevel, String find, Integer current, Integer limit) {
        List<User> achievementList = null;
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        Page page = new Page(current, limit);
        IPage<User> iPage = null;
        if (!"".equals(find)) {
            if (userLevel.equals("")) {//查询普通用户和专家
                queryWrapper.in("user_level", "2", "3").like("user_name", find).or().like("user_email", find).or().like("user_phone", find);
                iPage = baseMapper.selectPage(page, queryWrapper);
            } else {
                queryWrapper.eq("user_level", userLevel).or().like("user_name", find).or().like("user_email", find).or().like("user_phone", find);
                iPage = baseMapper.selectPage(page, queryWrapper);
            }
        } else {
            if ("".equals(userLevel)) {//查询普通用户和专家
                queryWrapper.in("user_level", "2", "3");
                iPage = baseMapper.selectPage(page, queryWrapper);
            } else {
                queryWrapper.in("user_level", "1","2", "3");
                iPage = baseMapper.selectPage(page, queryWrapper);
            }
        }
        achievementList = iPage.getRecords();
        return new Result(ResultCode.SUCCESS,find,achievementList,iPage.getPages(),iPage.getCurrent());
    }

    //后台增加用户
    @Override
    public Result adminAddUser(User user) {
        if(user != null){
            baseMapper.insert(user);
            return new Result(ResultCode.SUCCESS,"添加成功！");
        }
        return new Result(ResultCode.FAIL,"添加失败！");
    }

    //后台删除用户
    @Override
    public Result adminDeleteUser(Integer userId) {
        User user = baseMapper.selectById(userId);
        if(user != null){
            baseMapper.deleteById(userId);
            return new Result(ResultCode.SUCCESS,"删除成功！");
        }
        return new Result(ResultCode.FAIL,"删除失败！");
    }

    //后台修改用户
    @Override
    public Result adminModifyUser(User user) {
        if(user != null){
            baseMapper.updateById(user);
            return new Result(ResultCode.SUCCESS,"修改成功！");
        }
        return new Result(ResultCode.FAIL,"修改失败！");
    }

    //查看用户信息
    @Override
    public User findUserById(Integer userId) {
        User user = baseMapper.selectById(userId);
        return user;
    }


}
