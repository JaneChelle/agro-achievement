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
                                         @RequestParam(value = "findName", defaultValue = "") String findName) {
        Result result = iCaseService.findExampleList(findName, current, limit);

        List<Example> exampleList = (List<Example>) result.getData();
        model.addAttribute("exampleList", exampleList);
        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数
        model.addAttribute("findName", findName);
        return new ModelAndView("admin/adminExample");
    }

    //去添加案例
    @RequestMapping(value = "/toAdminExample")
    public ModelAndView toAdd() {
        return new ModelAndView("admin/addExample");
    }

    //管理员添加案例
    @RequestMapping(value = "/adminAddExample")
    public Result adminAddExample(Model model, Example example) {
        Result result = iCaseService.addExample(example);
        return result;
    }

    //跳转到修改案例
    @RequestMapping("/toAdminEditExample")
    public ModelAndView toEdit(Model model, Integer exampleId) {
        Example example = iCaseService.exampleDetails(exampleId);
        model.addAttribute("example", example);
        return new ModelAndView("admin/modifyExample");
    }

    //修改案例
    @RequestMapping(value = "/adminEditExample")
    public Result adminEditExample(Example example, Model model) {
        Result result = iCaseService.modifyExample(example);
        return result;

    }

    //删除案例
    @RequestMapping(value = "/adminDeleteExample")
    public Result adminDeleteAchievement(Integer exampleId, Model model) {
        Result result = iCaseService.deleteExample(exampleId);
        return result;
    }

}
