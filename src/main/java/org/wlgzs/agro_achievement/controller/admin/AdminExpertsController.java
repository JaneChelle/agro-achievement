package org.wlgzs.agro_achievement.controller.admin;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Experts;
import org.wlgzs.agro_achievement.entity.Type;
import org.wlgzs.agro_achievement.util.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2019-02-20 21:29
 * @description:
 **/
@RestController
@RequestMapping("/admin")
public class AdminExpertsController extends BaseController {

    //查询所有专家(分页)
    @RequestMapping(value = "/adminExpertsList")
    public ModelAndView adminExpertsList(Model model, @RequestParam(value = "current", defaultValue = "1") int current,
                                         @RequestParam(value = "limit", defaultValue = "8") int limit,
                                         @RequestParam(value = "findName", defaultValue = "") String findName) {
        Result result = iExpertsService.findExpertsList(findName, current, limit);

        List<Experts> expertsList = (List<Experts>) result.getData();
        model.addAttribute("expertsList", expertsList);
        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数
        model.addAttribute("findName", findName);
        return new ModelAndView("admin/adminExperts");
    }

    //去添加专家
    @RequestMapping(value = "/toAdminAddExperts")
    public ModelAndView toAdd(Model model) {
        //查询所有类型
        Result result1 = iTypeService.selectAllType();
        List<Type> typeList = (List<Type>) result1.getData();
        model.addAttribute("typeList", typeList);
        return new ModelAndView("admin/addExpert");
    }

    //管理员添加专家
    @RequestMapping(value = "/adminAddExperts")
    public Result adminAddExperts(HttpSession session, Model model, HttpServletRequest request, String time, Experts experts, @RequestParam(value = "file", required = false)MultipartFile myFileName) {
        Result result = iExpertsService.addAdminExperts(session,request,time, experts, myFileName);
        return result;
    }

    //跳转到修改专家
    @RequestMapping("/toAdminEditExperts")
    public ModelAndView toEdit(Model model, Integer expertsId) {
        Experts experts = iExpertsService.expertsDetails(expertsId);
        model.addAttribute("experts", experts);
        return new ModelAndView("admin/detailsExpert");
    }

    //修改专家
    @RequestMapping(value = "/adminEditExperts")
    public Result modifyExperts(String time,Experts experts, Model model) {
        Result result = iExpertsService.modifyExperts(time,experts);
        return result;
    }

    //删除专家
    @RequestMapping(value = "/adminDeleteExperts")
    public Result adminDeleteExperts(Integer expertsId, Model model) {
        Result result = iExpertsService.adminDeleteExpertsId(expertsId);
        return result;
    }

}
