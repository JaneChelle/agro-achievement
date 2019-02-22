package org.wlgzs.agro_achievement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.wlgzs.agro_achievement.util.Result;

/**
 * @author:胡亚星
 * @createTime 2019-02-14 8:50
 * @description:
 **/
public interface IAuditService {

    //审核成果
    Result auditAchievement(Integer achievementId, String statusCode);

    //审核需求
    Result auditDemand(Integer demandId,String statusCode);

    //审核案例
    Result auditExample(Integer exampleId,String statusCode);

    //审核专家
    Result auditExperts(Integer exampleId,String statusCode);
}
