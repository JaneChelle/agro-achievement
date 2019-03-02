package org.wlgzs.agro_achievement.controller.admin;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Example;
import org.wlgzs.agro_achievement.util.Result;

import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2019-02-20 21:29
 * @description:
 **/
@RestController
@RequestMapping("/admin")
public class AdminExampleController extends BaseController {

    //查询所有案例(分页)
    @RequestMapping(value = "/adminExampleList")
    public ModelAndView adminExampleList(Model model, @RequestParam(value = "current", defaultValue = "1") int current,
                                             @RequestParam(value = "limit", defaultValue = "8") int limit,
                                             @RequestParam(value = "findName", defaultValue = "") String findName){
        Result result = iCaseService.findExampleList(findName,current,limit);

        List<Example> exampleList = (List<Example>) result.getData();
        model.addAttribute("exampleList",exampleList);
        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数

        return new ModelAndView("admin/adminExample");
    }

    //去添加成果
    @RequestMapping(value = "/toAdminExample")
    public ModelAndView toAdd(){
        return new ModelAndView("adminAddExample");
    }

    //管理员添加成果
    @RequestMapping(value = "/adminAddExample")
    public ModelAndView adminAddExample(Model model,Example example){
        Result result = iCaseService.addExample(example);
        model.addAttribute("msg",result.getMsg());
        return new ModelAndView("redirect:/admin/adminExampleList");
    }

    //跳转到修改成果
    @RequestMapping("/toAdminEditExample")
    public ModelAndView toEdit(Model model, Integer exampleId) {
        Example example = iCaseService.exampleDetails(exampleId);
        model.addAttribute("example", example);
        return new ModelAndView("adminEditExample");
    }

    //修改成果
    @RequestMapping(value = "/adminEditExample")
    public ModelAndView adminEditExample(Example example,Model model) {
        Result result = iCaseService.modifyExample(example);
        if (result.getCode() == 0) {
            Example example1 = (Example) result.getData();
            model.addAttribute("msg", "修改失败！");
            model.addAttribute("example", example1);
            return new ModelAndView("adminExampleDetails");
        } else {
            model.addAttribute("msg", "修改成功！");
        }
        return new ModelAndView("redirect:/admin/adminExampleList");
    }

    //删除成果
    @RequestMapping(value = "/adminDeleteExample")
    public ModelAndView adminDeleteAchievement(Integer exampleId, Model model) {
        Result result = iCaseService.deleteExample(exampleId);
        if (result.getCode() == 0) {
            model.addAttribute("msg", "删除成功！");
        } else {
            model.addAttribute("msg", "不存在！");
        }
        return new ModelAndView("redirect:/admin/adminExampleList");
    }

}
