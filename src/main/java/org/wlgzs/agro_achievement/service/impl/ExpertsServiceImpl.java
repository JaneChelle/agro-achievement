package org.wlgzs.agro_achievement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.wlgzs.agro_achievement.entity.Experts;
import org.wlgzs.agro_achievement.entity.User;
import org.wlgzs.agro_achievement.mapper.ExpertsMapper;
import org.wlgzs.agro_achievement.service.IExpertsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.wlgzs.agro_achievement.util.Result;
import org.wlgzs.agro_achievement.util.ResultCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    //申请成为专家
    @Override
    public Result addExperts(HttpServletRequest request,String time, Experts experts) {
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
        System.out.println(experts);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(time + " 00:00:00", formatter);
        experts.setExpertsBirth(ldt);
        experts.setPageView(0);
        experts.setStatusCode("0");
        experts.setUserId(user.getUserId());
        baseMapper.insert(experts);
        return new Result(ResultCode.SUCCESS, "请耐心等待审核！");
    }

    //查看（个人中心）专家信息
    @Override
    public Experts expertsDetails(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        QueryWrapper<Experts> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user.getUserId());
        Experts experts = baseMapper.selectOne(queryWrapper);
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
        IPage<Experts> iPage = baseMapper.selectMapsPage(page, queryWrapper);
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
        IPage<Experts> iPage = baseMapper.selectMapsPage (page, queryWrapper);
        List<Experts> list = iPage.getRecords();
        if (list != null) {
            return new Result(ResultCode.SUCCESS, list);
        }
        return new Result(ResultCode.FAIL, "暂无数据！");
    }

}
