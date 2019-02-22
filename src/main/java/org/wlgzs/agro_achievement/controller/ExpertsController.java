package org.wlgzs.agro_achievement.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Experts;
import org.wlgzs.agro_achievement.entity.Type;
import org.wlgzs.agro_achievement.util.Result;
import org.wlgzs.agro_achievement.util.ResultCode;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    //去成为专家页面
    @RequestMapping(value = "/toAddExperts")
    public ModelAndView toAddExperts(Model model) {
        //查询所有类型
        Result result1 = iTypeService.selectAllType();
        List<Type> typeList = (List<Type>) result1.getData();
        model.addAttribute("typeList", typeList);
        return new ModelAndView("addExperts");
    }

    //申请成为专家
    @RequestMapping(value = "/addExperts")
    public ModelAndView addExperts(Model model, HttpServletRequest request, String time, Experts experts) {
        Result result = iExpertsService.addExperts(request, time, experts);
        if (result.getCode() == 0)//成功
            model.addAttribute("msg", "请耐心等待审核！");
        else
            model.addAttribute("msg", "请先登录！");
        return new ModelAndView("redirect:/experts/expertsUserDetails");
    }

    //查看专家信息
    @RequestMapping(value = "/expertsDetails")
    public ModelAndView expertsDetails(Model model,Integer expertsId) {
        Experts experts = iExpertsService.expertsDetails(expertsId);
        model.addAttribute("experts", experts);//专家信息
        if (experts == null) {
            model.addAttribute("msg", "不存在！");
        }
        return new ModelAndView("expertsDetails");
    }

    //查看(个人中心)专家信息
    @RequestMapping(value = "/expertsUserDetails")
    public ModelAndView expertsUserDetails(Model model, HttpServletRequest request) {
        Experts experts = iExpertsService.expertsUserDetails(request);
        model.addAttribute("experts", experts);//专家信息
        if (experts == null) {
            model.addAttribute("msg", "请先申请成为专家！");
        } else if (experts.getStatusCode().equals("0")) {
            model.addAttribute("msg", "请您耐心等待审核！");
        } else {
            model.addAttribute("msg", "审核失败！");
        }
        return new ModelAndView("expertsUserDetails");
    }

    //前台查询所有专家（通过的）
    @RequestMapping(value = "/selectExperts")
    public ModelAndView selectExperts(Model model,@RequestParam(value = "current", defaultValue = "1") int current,
                                      @RequestParam(value = "limit", defaultValue = "8") int limit) {
        Result result = iExpertsService.selectExperts(current, limit);
        List<Experts> expertsList = (List<Experts>) result.getData();

        model.addAttribute("expertsList",expertsList);
        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数

        return new ModelAndView("expertsList");
    }

}
