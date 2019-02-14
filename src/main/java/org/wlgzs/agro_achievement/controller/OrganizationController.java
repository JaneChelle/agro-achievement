package org.wlgzs.agro_achievement.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Organization;
import org.wlgzs.agro_achievement.util.Result;
import org.wlgzs.agro_achievement.util.ResultCode;

import javax.servlet.http.HttpServletRequest;

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

    //添加机构
    @RequestMapping(value = "/addOrganization",method = RequestMethod.PUT)
    public Result addOrganization(Organization organization) {
        if (organization != null) {
            return iOrganizationService.addOrganization(organization);
        }
        return new Result(ResultCode.FAIL, "请输入正确的信息！");
    }

    //删除机构
    @RequestMapping(value = "/deleteOrganization",method = RequestMethod.DELETE)
    public Result deleteOrganization(Integer organizationId) {
        return iOrganizationService.deleteOrganization(organizationId);
    }

    //按用户查询机构
    @RequestMapping(value = "/selectOrganizationByUser",method = RequestMethod.GET)
    public Result selectOrganizationByUser(HttpServletRequest request){
        return iOrganizationService.selectOrganizationByUser(request);
    }


}
