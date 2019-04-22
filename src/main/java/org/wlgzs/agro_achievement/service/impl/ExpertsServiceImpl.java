package org.wlgzs.agro_achievement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.wlgzs.agro_achievement.entity.Experts;
import org.wlgzs.agro_achievement.entity.User;
import org.wlgzs.agro_achievement.mapper.ExpertsMapper;
import org.wlgzs.agro_achievement.mapper.UserMapper;
import org.wlgzs.agro_achievement.service.IExpertsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.wlgzs.agro_achievement.util.RandomNumberUtils;
import org.wlgzs.agro_achievement.util.Result;
import org.wlgzs.agro_achievement.util.ResultCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class ExpertsServiceImpl extends ServiceImpl<ExpertsMapper, Experts> implements IExpertsService {

    @Autowired
    UserMapper userMapper;

    //申请成为专家
    @Override
    public Result addExperts(HttpServletRequest request, String time, Experts experts, MultipartFile myFileName) {
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user != null) {
            //判断用户之前审核过没有(有则删除信息)
            QueryWrapper<Experts> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", user.getUserId());
            Experts expertsOne = baseMapper.selectOne(queryWrapper);
            if (expertsOne != null) {
                baseMapper.deleteById(expertsOne);
            }
        } else {
            return new Result(ResultCode.FAIL, "请先登录！");
        }
        //文件处理（真实存储名）
        String realName = "";

        String fileName = myFileName.getOriginalFilename();
        //截取后缀名
        String suffixName = fileName.substring(fileName.indexOf("."), fileName.length());

        //生成实际储存的文件名（不能重复）
        realName = RandomNumberUtils.getRandomFileName() + suffixName;
        // "/upload"是你自己定义的上传目录
        String realPath = session.getServletContext().getRealPath("/HeadPortrait");
        File uploadFile = new File(realPath, realName);

        //上传文件
        try {
            myFileName.transferTo(uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = request.getContextPath() + "/HeadPortrait/" + realName;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(time + " 00:00:00", formatter);
        experts.setExpertsBirth(ldt);
        experts.setPictureAddress(str);
        experts.setPageView(0);
        experts.setStatusCode("0");
        experts.setUserId(user.getUserId());
        baseMapper.insert(experts);
        user.setUserLevel("2");
        userMapper.updateById(user);
        return new Result(ResultCode.SUCCESS, "请耐心等待审核！");
    }

    //查看（个人中心）专家信息
    @Override
    public Experts expertsUserDetails(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        QueryWrapper<Experts> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user.getUserId());
        Experts experts = baseMapper.selectOne(queryWrapper);
        return experts;
    }

    //查看专家详情
    @Override
    public Experts expertsDetails(Integer expertsId) {
        Experts experts = baseMapper.selectById(expertsId);
        return experts;
    }

    //前台查询所有专家（通过的）
    @Override
    public Result selectExperts(int current, int limit) {
        Page page = new Page(current, limit);
        QueryWrapper<Experts> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status_code", "1").orderBy(true, false, "page_view");
        IPage<Experts> iPage = baseMapper.selectPage(page, queryWrapper);
        List<Experts> list = iPage.getRecords();
        if (list != null) {
            return new Result(ResultCode.SUCCESS, list);
        }
        return new Result(ResultCode.FAIL, "暂无数据！");
    }

    //按添加时间查询专家（最新加入）
    @Override
    public Result selectExpertsByTime(int limit) {
        Page page = new Page(1, limit);
        QueryWrapper<Experts> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("experts_id");//condition   是否执行
        IPage<Experts> iPage = baseMapper.selectPage(page, queryWrapper);
        List<Experts> list = iPage.getRecords();
        if (list != null) {
            return new Result(ResultCode.SUCCESS, list);
        }
        return new Result(ResultCode.FAIL, "暂无数据！");
    }

    @Override
    public Result expertRanking(int limit) {
        Page page = new Page(1, limit);
        QueryWrapper<Experts> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("page_view");
        IPage<Experts> iPage = baseMapper.selectPage(page, queryWrapper);
        List<Experts> list = iPage.getRecords();
        if (list != null) {
            return new Result(ResultCode.SUCCESS, list);
        }
        return new Result(ResultCode.FAIL, "暂无数据！");
    }

    @Override
    public List<Experts> recommend(int limit) {
        Page page = new Page(1, limit);
        QueryWrapper<Experts> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("page_view");
        IPage<Experts> iPage = baseMapper.selectPage(page, queryWrapper);
        List<Experts> list = iPage.getRecords();
        return list;
    }

    @Override
    public IPage<Experts> findName(String findName, int current, int limit) {
        Page page = new Page(current, limit);
        QueryWrapper<Experts> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("experts_name",findName).like("research_field",findName);
        IPage<Experts> iPage = baseMapper.selectPage(page, queryWrapper);
        return iPage;
    }

    @Override
    public Result findExpertsList(String findName, int current, int limit) {
        QueryWrapper<Experts> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("experts_name", findName);
        Page page = new Page(current, limit);
        IPage<Experts> iPage = baseMapper.selectPage(page, queryWrapper);
        List<Experts> expertsList = iPage.getRecords();

        return new Result(ResultCode.SUCCESS, "", expertsList, iPage.getPages(), iPage.getCurrent());
    }

    @Override
    public Result addAdminExperts(HttpSession session,HttpServletRequest request, String time, Experts experts, MultipartFile myFileName) {
        //文件处理（真实存储名）
        String realName = "";
        String str = "";
        String fileName = myFileName.getOriginalFilename();
        if(fileName != null && !"".equals(fileName)){
            //截取后缀名
            String suffixName = fileName.substring(fileName.indexOf("."), fileName.length());

            //生成实际储存的文件名（不能重复）
            realName = RandomNumberUtils.getRandomFileName() + suffixName;
            // "/upload"是你自己定义的上传目录
            String realPath = session.getServletContext().getRealPath("/HeadPortrait");
            File uploadFile = new File(realPath, realName);

            //上传文件
            try {
                myFileName.transferTo(uploadFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            str = request.getContextPath() + "/HeadPortrait/" + realName;
        }else{
            str = "/HeadPortrait/morende.jpg";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(time + " 00:00:00", formatter);
        experts.setExpertsBirth(ldt);
        experts.setPictureAddress(str);
        baseMapper.insert(experts);
        return new Result(ResultCode.SUCCESS);
    }

    @Override
    public Result modifyExperts(String time,Experts experts) {
        if (experts.getExpertsId() != null) {
            Experts experts1 = baseMapper.selectById(experts.getExpertsId());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime ldt = LocalDateTime.parse(time + " 00:00:00", formatter);
            experts.setExpertsBirth(ldt);
            experts.setPictureAddress(experts1.getPictureAddress());
            baseMapper.updateById(experts);
            return new Result(ResultCode.SUCCESS,experts);
        }
        return new Result(ResultCode.FAIL);
    }

    @Override
    public Result adminDeleteExpertsId(Integer expertsId) {
        Experts experts = baseMapper.selectById(expertsId);
        if (experts != null) {
            baseMapper.deleteById(expertsId);
            return new Result(ResultCode.SUCCESS, "修改成功！");
        }
        return new Result(ResultCode.FAIL, "修改失败！");
    }

    @Override
    public Result selectExpertsByCode(String statusCode, int current, int limit) {
        QueryWrapper<Experts> queryWrapper = new QueryWrapper<>();
        Page page = new Page(current, limit);
        queryWrapper.eq("status_code", statusCode);
        IPage<Experts> iPage = baseMapper.selectPage(page, queryWrapper);
        List<Experts> expertsList = iPage.getRecords();

        return new Result(ResultCode.SUCCESS, "", expertsList, iPage.getPages(), iPage.getCurrent());

    }

}
