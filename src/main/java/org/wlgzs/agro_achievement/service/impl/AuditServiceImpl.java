package org.wlgzs.agro_achievement.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;
import org.wlgzs.agro_achievement.entity.Achievement;
import org.wlgzs.agro_achievement.entity.Demand;
import org.wlgzs.agro_achievement.entity.Example;
import org.wlgzs.agro_achievement.entity.Experts;
import org.wlgzs.agro_achievement.mapper.AchievementMapper;
import org.wlgzs.agro_achievement.mapper.DemandMapper;
import org.wlgzs.agro_achievement.mapper.ExampleMapper;
import org.wlgzs.agro_achievement.mapper.ExpertsMapper;
import org.wlgzs.agro_achievement.service.IAuditService;
import org.wlgzs.agro_achievement.util.Result;
import org.wlgzs.agro_achievement.util.ResultCode;

import javax.annotation.Resource;

/**
 * @author:胡亚星
 * @createTime 2019-02-14 8:54
 * @description:
 **/
@Service
public class AuditServiceImpl implements IAuditService {

    @Resource
    AchievementMapper achievementMapper;

    @Resource
    DemandMapper demandMapper;

    @Resource
    ExampleMapper exampleMapper;

    @Resource
    ExpertsMapper expertsMapper;

    //去审核成果



    //审核成果
    @Override
    public Result auditAchievement(Integer achievementId, String statusCode) {
        Achievement achievement = achievementMapper.selectById(achievementId);
        if(achievement != null){
            achievement.setStatusCode(statusCode);
            achievementMapper.updateById(achievement);
            return new Result(ResultCode.SUCCESS,"审核成功！");
        }
        return new Result(ResultCode.FAIL,"该条记录不存在！");
    }

    @Override
    public Result auditDemand(Integer achievementId, String statusCode) {
        Demand demand = demandMapper.selectById(achievementId);
        if(demand != null){
            demand.setStatusCode(statusCode);
            demandMapper.updateById(demand);
            return new Result(ResultCode.SUCCESS,"审核成功！");
        }
        return new Result(ResultCode.FAIL,"该条记录不存在！");
    }

    @Override
    public Result auditExample(Integer exampleId, String statusCode) {
        Example example = exampleMapper.selectById(exampleId);
        if(example != null){
            example.setStatusCode(statusCode);
            exampleMapper.updateById(example);
            return new Result(ResultCode.SUCCESS,"审核成功！");
        }
        return new Result(ResultCode.FAIL,"该条记录不存在！");
    }

    @Override
    public Result auditExperts(Integer exampleId, String statusCode) {
        Experts experts = expertsMapper.selectById(exampleId);
        if(experts != null){
            experts.setStatusCode(statusCode);
            expertsMapper.updateById(experts);
            return new Result(ResultCode.SUCCESS,"审核成功！");
        }
        return new Result(ResultCode.FAIL,"该条记录不存在！");
    }


}
