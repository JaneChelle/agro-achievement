package org.wlgzs.agro_achievement.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.util.Result;

/**
 * @author:胡亚星
 * @createTime 2019-02-13 17:03
 * @description: 审核控制层
 **/
@Controller
@RequestMapping("/audit")
public class AuditController extends BaseController {

    //审核成果
    @RequestMapping(value = "/auditAnnouncement",method = RequestMethod.PUT)
    public Result auditAnnouncement(Integer achievementId,String statusCode){
        return iAuditService.auditAnnouncement(achievementId,statusCode);
    }

    //审核需求
    @RequestMapping(value = "/auditDemand",method = RequestMethod.PUT)
    public Result auditDemand(Integer demandId,String statusCode){
        return iAuditService.auditDemand(demandId,statusCode);
    }

    //审核案例
    @RequestMapping(value = "/auditExample",method = RequestMethod.PUT)
    public Result auditExample(Integer exampleId,String statusCode){
        return iAuditService.auditExample(exampleId,statusCode);
    }

    //审核专家
    @RequestMapping(value = "/auditExperts",method = RequestMethod.PUT)
    public Result auditExperts(Integer exampleId,String statusCode){
        return iAuditService.auditExperts(exampleId,statusCode);
    }


}
