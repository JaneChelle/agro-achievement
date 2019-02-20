package org.wlgzs.agro_achievement.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Organization;
import org.wlgzs.agro_achievement.entity.OrganizationType;
import org.wlgzs.agro_achievement.entity.Type;
import org.wlgzs.agro_achievement.util.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 * 机构
 *
 * @author 胡亚星
 * @since 2019-01-19
 */
@RestController
@RequestMapping("/organization")
public class OrganizationController extends BaseController {

    //去添加机构
    @RequestMapping(value = "/toAddOrganization")
    public ModelAndView toAddOrganization(Model model) {
        //查询所有类型
        Result result1 = iTypeService.selectAllType();
        List<Type> typeList = (List<Type>) result1.getData();
        model.addAttribute("typeList", typeList);
        return new ModelAndView("addOrganization");
    }

    //添加机构
    @RequestMapping(value = "/addOrganization")
    public ModelAndView addOrganization(Model model, HttpSession session,Organization organization) {
        Result result = iOrganizationService.addOrganization(session,organization);
        if(result.getCode() == 0){
            model.addAttribute("msg","添加成功！");
        }else{
            model.addAttribute("msg","添加失败！");
        }
        return new ModelAndView("redirect:/HomeController/ExpertsHome");
    }

    //删除机构
    @RequestMapping(value = "/deleteOrganization")
    public ModelAndView deleteOrganization(Model model,Integer organizationId) {
        Result result =  iOrganizationService.deleteOrganization(organizationId);
        if (result.getCode() == 0) {
            model.addAttribute("msg", "删除成功！");
        } else {
            model.addAttribute("msg", "不存在！");
        }
        return new ModelAndView("redirect:/organization/selectOrganizationByUser");
    }

    //按用户查询机构（状态码）
    @RequestMapping(value = "/selectOrganizationByUser")
    public ModelAndView selectOrganizationByUser(Model model,HttpServletRequest request,
                                                 @RequestParam(value = "statusCode",defaultValue = "1" ) String statusCode) {
        Result result = iOrganizationService.selectOrganizationByUser(request,statusCode);
        List<Organization> organizationList = (List<Organization>) result.getData();
        model.addAttribute("organizationList",organizationList);
        return new ModelAndView("userOrganizationList");
    }

    //前台查询所有机构
    @RequestMapping(value = "/selectAllOrganization")
    public ModelAndView selectAllOrganization(Model model, @RequestParam(value = "current", defaultValue = "1") int current,
                                              @RequestParam(value = "limit", defaultValue = "8") int limit) {
        List<Organization> organizationList = iOrganizationService.selectAllOrganization(current, limit);
        if(organizationList != null){
            model.addAttribute("msg","查询成功！");
        }else{
            model.addAttribute("msg","查询成功！");
        }
        model.addAttribute("organizationList", organizationList);
        return new ModelAndView("OrganizationList");
    }

    //前台按类型查询机构
    @RequestMapping(value = "/selectAchieveByType")
    public ModelAndView selectOrganizationByType(Model model,@RequestParam(value = "type",defaultValue = "") String type,@RequestParam(value = "current", defaultValue = "1") int current,
                                            @RequestParam(value = "limit", defaultValue = "8") int limit){
        Result result = iOrganizationService.selectOrganizationByType(type, current, limit);
        List<Organization> organizationList = (List<Organization>) result.getData();

        model.addAttribute("organizationList",organizationList);
        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数

        //查询所有机构类别
        List<OrganizationType> list = (List<OrganizationType>) iOrganizationTypeService.selectAllOrganizationType().getData();
        model.addAttribute("OrganizationTypeList",list);

        return new ModelAndView("OrganizationList");
    }

}
