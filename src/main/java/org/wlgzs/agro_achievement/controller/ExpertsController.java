package org.wlgzs.agro_achievement.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Experts;
import org.wlgzs.agro_achievement.util.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 前端控制器
 * </p>
 * 专家
 *
 * @author 胡亚星
 * @since 2019-01-19
 */
@RestController
@RequestMapping("/experts")
public class ExpertsController extends BaseController {

    //申请成为专家
    @RequestMapping(value = "/addExperts", method = RequestMethod.PUT)
    public Result addExperts(HttpServletRequest request, Integer userId,String time, Experts experts) {
        return iExpertsService.addExperts(request, userId,time, experts);
    }

    //查看（个人中心）专家信息
    @RequestMapping(value = "/expertsDetails",method = RequestMethod.GET)
    public Result expertsDetails(HttpServletRequest request){
        return iExpertsService.expertsDetails(request);
    }

    //前台查询所有专家（通过的）
    @RequestMapping(value = "/selectExperts",method = RequestMethod.GET)
    public Result selectExperts(@RequestParam(value = "current", defaultValue = "1") int current,
                                @RequestParam(value = "limit", defaultValue = "8") int limit){
        return iExpertsService.selectExperts(current,limit);
    }

    //按添加时间查询专家（最新加入）
    @GetMapping("/selectExpertsByTime")
    public Result selectExpertsByTime(@RequestParam(value = "limit", defaultValue = "8") int limit){
        return iExpertsService.selectExpertsByTime(limit);
    }


}
