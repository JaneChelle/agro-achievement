package org.wlgzs.agro_achievement.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.wlgzs.agro_achievement.service.*;

import javax.servlet.http.HttpSession;

/**
 * @author:胡亚星
 * @createTime 2018-08-12 15:47
 * @description:
 **/
public class BaseController {

    @Autowired
    protected IAchievementService iAchievementService;

    @Autowired
    protected IAnnouncementService iAnnouncementService;

    @Autowired
    protected IExampleService iCaseService;

    @Autowired
    protected IDemandService iDemandService;

    @Autowired
    protected IDemandTypeService iDemandTypeService;

    @Autowired
    protected IExpertsService iExpertsService;

    @Autowired

    protected HttpSession session;

    @Autowired
    protected IOrganizationService iOrganizationService;

    @Autowired
    protected IOrganizationTypeService iOrganizationTypeService;

    @Autowired
    protected ITypeService iTypeService;

    @Autowired
    protected IUserService iUserService;

    @Autowired
    protected LoginService loginService;
}
