package org.wlgzs.agro_achievement.controller.admin;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping("/organizationType")
public class OrganizationTypeController extends BaseController {

    //增加机构类型
    @RequestMapping(value = "/addOrganizationType",method = RequestMethod.PUT)
    public Result addOrganizationType(OrganizationType organizationType){
        return iOrganizationTypeService.addOrganizationType(organizationType);
    }

    //删除机构类型
    @RequestMapping(value = "/deleteOrganizationType", method = RequestMethod.DELETE)
    public Result deleteOrganizationType(Integer organizationTypeId) {
        return iOrganizationTypeService.deleteOrganizationType(organizationTypeId);
    }

    //查找所有机构类型
    @GetMapping("/selectAllOrganizationType")
    public Result selectAllOrganizationType(){
        return iOrganizationTypeService.selectAllOrganizationType();
    }

}
