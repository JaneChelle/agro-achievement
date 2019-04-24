package org.wlgzs.agro_achievement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.wlgzs.agro_achievement.entity.Achievement;
import org.wlgzs.agro_achievement.entity.Demand;
import org.wlgzs.agro_achievement.mapper.DemandMapper;
import org.wlgzs.agro_achievement.service.IDemandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.wlgzs.agro_achievement.util.Result;
import org.wlgzs.agro_achievement.util.ResultCode;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
public class DemandServiceImpl extends ServiceImpl<DemandMapper, Demand> implements IDemandService {

    //发布需求
    @Override
    public Result addDemand(Demand demand) {
        if (demand != null) {
            //获取现在时间
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime time = LocalDateTime.now();
            String localTime = formatter.format(time);
            LocalDateTime ldt = LocalDateTime.parse(localTime, formatter);
            demand.setStatusCode("0");//需要审核
            demand.setReleaseTime(ldt);
            demand.setPageView(0);
            baseMapper.insert(demand);
            return new Result(ResultCode.SUCCESS, "请耐心等待审核！");
        }
        return new Result(ResultCode.FAIL, "请输入正确的信息！");
    }

    //删除需求
    @Override
    public Result deleteDemand(Integer demandId) {
        Demand demand = baseMapper.selectById(demandId);
        if (demand != null) {
            baseMapper.deleteById(demandId);
            return new Result(ResultCode.SUCCESS, "删除成功！");
        }
        return new Result(ResultCode.FAIL, "不存在！");
    }

    //修改需求
    @Override
    public Result modifyDemand(Demand demand,String time) {
        if (demand != null) {
            Demand demand1 = baseMapper.selectById(demand.getDemandId());
            if (demand1 != null) {
                if(demand.getReleaseTime() == null){
                    demand.setReleaseTime(demand1.getReleaseTime());
                    baseMapper.updateById(demand);
                    return new Result(ResultCode.SUCCESS, "修改成功！",1,demand);
                }
                baseMapper.updateById(demand);
                return new Result(ResultCode.SUCCESS, "修改成功！",1,demand);
            }
            return new Result(ResultCode.FAIL, "该条记录不存在！");
        }
        return new Result(ResultCode.FAIL, "操作失败！");
    }

    //按照用户查询所有需求（状态码）
    @Override
    public Result selectDemand(Integer userId, String statusCode, int current, int limit) {
        List<Demand> demandList = null;
        QueryWrapper<Demand> queryWrapper = new QueryWrapper();
        IPage<Demand> iPage = null;
        if (statusCode == null || statusCode.equals("")) {  //查询所有
            queryWrapper.eq("user_id", userId);
            Page page = new Page(current, limit);
            iPage = baseMapper.selectPage(page, queryWrapper);
            demandList = iPage.getRecords();
            return new Result(ResultCode.SUCCESS, "", demandList, iPage.getPages(), iPage.getCurrent());
        } else {
            queryWrapper.and(i -> i.eq("user_id", userId).eq("status_code", statusCode));
            Page page = new Page(current, limit);
            iPage = baseMapper.selectPage(page, queryWrapper);
            demandList = iPage.getRecords();
            return new Result(ResultCode.SUCCESS, "", demandList, iPage.getPages(), iPage.getCurrent());
        }
    }

    //查看需求详情
    @Override
    public Result demandDetails(Integer demandId) {
        Demand demand = baseMapper.selectById(demandId);
        if (demand != null) {
            return new Result(ResultCode.SUCCESS, demand);
        }
        return new Result(ResultCode.FAIL, "不存在！");
    }

    //搜索所有需求
    @Override
    public Result adminDemandList(String findName, int current, int limit) {
        QueryWrapper<Demand> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("demand_name", findName).or().like("demand_introduce", findName).orderByDesc("demand_id");
        Page page = new Page(current, limit);
        IPage<Demand> iPage = baseMapper.selectPage(page, queryWrapper);
        List<Demand> achievementList = iPage.getRecords();

        return new Result(ResultCode.SUCCESS, "", achievementList, iPage.getPages(), iPage.getCurrent());
    }


    @Override
    public Result saveDemand(Demand demand,String time) {
        if (demand != null) {
            //获取现在时间
            System.out.println(time);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime releaseTime = LocalDateTime.parse(time, formatter);
//            demand.setStatusCode("0");//需要审核
            demand.setReleaseTime(releaseTime);
            baseMapper.insert(demand);
            return new Result(ResultCode.SUCCESS, "发布成功！",1,demand);
        }
        return new Result(ResultCode.FAIL, "请输入正确的信息！");
    }

    @Override
    public Result selectDemandByCode(String statusCode, int current, int limit) {
        QueryWrapper<Demand> queryWrapper = new QueryWrapper<>();
        Page page = new Page(current,limit);
        queryWrapper.eq("status_code",statusCode);
        IPage<Demand> iPage = baseMapper.selectPage(page,queryWrapper);
        List<Demand> demandList = iPage.getRecords();

        return new Result(ResultCode.SUCCESS, "", demandList, iPage.getPages(), iPage.getCurrent());
    }


}
