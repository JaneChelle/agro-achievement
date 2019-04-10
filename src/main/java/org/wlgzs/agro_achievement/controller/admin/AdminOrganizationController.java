package org.wlgzs.agro_achievement.controller.admin;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Organization;
import org.wlgzs.agro_achievement.entity.Type;
import org.wlgzs.agro_achievement.util.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2019-02-20 21:30
 * @description:
 **/
@RestController
@RequestMapping("/admin")
public class AdminOrganizationController extends BaseController {

    //查询所有机构(分页)
    @RequestMapping(value = "/adminOrganizationList")
    public ModelAndView adminOrganizationList(Model model, @RequestParam(value = "current", defaultValue = "1") int current,
                                             @RequestParam(value = "limit", defaultValue = "8") int limit,
                                             @RequestParam(value = "findName", defaultValue = "") String findName){
        Result result = iOrganizationService.adminOrganizationList(findName,current,limit);

        List<Organization> organizationList = (List<Organization>) result.getData();
        model.addAttribute("organizationList",organizationList);
        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数
        model.addAttribute("findName", findName);
        return new ModelAndView("admin/OrganizationList");
    }
    //去添加机构
    @RequestMapping(value = "/toAdminAddOrganization")
    public ModelAndView toAdd(Model model){
        //查询所有类型
        Result result1 = iTypeService.selectAllType();
        List<Type> typeList = (List<Type>) result1.getData();
        model.addAttribute("typeList", typeList);
        return new ModelAndView("adminAddOrganization");
    }


    //管理员添加机构
    @RequestMapping(value = "/adminAddOrganization")
    public ModelAndView adminAddOrganization(@RequestParam(value = "file",required = false)MultipartFile myFileName, Model model, HttpServletRequest request,
                                             Organization organization){
        Result result = iOrganizationService.saveOrganization(organization,myFileName,request);
        return new ModelAndView("redirect:/admin/adminOrganizationList");
    }

    //跳转到修改机构
    @RequestMapping("/toAdminEditOrganization")
    public ModelAndView toEdit(Model model, Integer organizationId) {
        Organization organization = iOrganizationService.getById(organizationId);
        model.addAttribute("organization", organization);
        return new ModelAndView("adminEditOrganization");
    }

    //修改机构
    @RequestMapping(value = "/adminEditOrganization")
    public ModelAndView modifyOrganization(Organization organization, Model model) {
        Boolean result = iOrganizationService.updateById(organization);
        if (!result) {
            model.addAttribute("msg", "修改失败！");
            model.addAttribute("organization", organization);
            return new ModelAndView("adminEditOrganization");
        } else {
            model.addAttribute("msg", "修改失败！");
        }
        return new ModelAndView("redirect:/admin/adminOrganizationList");
    }

    //删除机构
    @RequestMapping(value = "/adminDeleteOrganization")
    public ModelAndView adminDeleteOrganization(Integer organizationId, Model model) {
        Result result = iOrganizationService.deleteOrganization(organizationId);
        if (result.getCode() == 0) {
            model.addAttribute("msg", "删除成功！");
        } else {
            model.addAttribute("msg", "不存在！");
        }
        return new ModelAndView("redirect:/admin/adminOrganizationList");
    }

}
