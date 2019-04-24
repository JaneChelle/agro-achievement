package org.wlgzs.agro_achievement.controller.admin;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.OrganizationType;
import org.wlgzs.agro_achievement.entity.Type;
import org.wlgzs.agro_achievement.util.Result;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 胡亚星
 * @since 2019-01-19
 */
@RestController
@RequestMapping("/admin")
public class OrganizationTypeController extends BaseController {

    //增加机构类型
    @RequestMapping(value = "/addOrganizationType")
    public Result addOrganizationType(Model model,OrganizationType organizationType){
        Result result = iOrganizationTypeService.addOrganizationType(organizationType);
        return result;
    }

    //删除机构类型
    @RequestMapping(value = "/deleteOrganizationType", method = RequestMethod.DELETE)
    public Result deleteOrganizationType(Model model,Integer organizationTypeId) {
        Result result = iOrganizationTypeService.deleteOrganizationType(organizationTypeId);
        return result;
    }

    //查找所有机构类型
    @GetMapping("/selectAllOrganizationType")
    public ModelAndView selectAllOrganizationType(Model model){
        Result result = iOrganizationTypeService.selectAllOrganizationType();
        model.addAttribute("OrganizationTypeList",result.getData());
        return new ModelAndView("admin/adminOrganizationType");
    }

}
