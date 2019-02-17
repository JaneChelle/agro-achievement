package org.wlgzs.agro_achievement.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.*;
import org.wlgzs.agro_achievement.util.Result;

import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2019-02-14 17:02
 * @description:
 **/
@Controller
@RequestMapping("/HomeController")
public class HomeController extends BaseController {

    //首页数据
    @RequestMapping("/home")
    public ModelAndView home(Model model){
        //首页技术供给
        List<Achievement> achievementList = iAchievementService.selectAchieveByTime();
        model.addAttribute("achievementList",achievementList);

        //首页技术需求
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status_code","1");
        Page page = new Page(1, 10);
        IPage<Demand> iPage = iDemandService.page(page, queryWrapper);
        List<Demand> demandList = iPage.getRecords();
        model.addAttribute("demandList",demandList);

        //成功案例
        Result result = iCaseService.selectExample(1,10);
        List<Example> exampleList = null;
        if(result.getCode() == 0){
            exampleList = (List<Example>) result.getData();
        }
        model.addAttribute("exampleList",exampleList);

        //专家推荐
        Result result1 = iExpertsService.selectExperts(1,10);
        List<Experts> expertsList = null;
        if(result1.getCode() == 0){
            expertsList = (List<Experts>) result1.getData();
        }
        model.addAttribute("expertsList",expertsList);

        //机构推荐
        List<Organization> organizationList = iOrganizationService.selectAllOrganization(1,10);
        model.addAttribute("organizationList",organizationList);

        //公告类型（新闻中心，交易活动，政策中心）
        List<Announcement> newsList = (List<Announcement>) iAnnouncementService.selectAnnouncement("",1,10).getData();
        List<Announcement> tradingList = (List<Announcement>) iAnnouncementService.selectAnnouncement("",1,10).getData();
        List<Announcement> policyList = (List<Announcement>) iAnnouncementService.selectAnnouncement("",1,10).getData();
        model.addAttribute("newsList",newsList);
        model.addAttribute("tradingList",tradingList);
        model.addAttribute("policyList",policyList);

        return new ModelAndView("index");
    }

    //成果小首页
    @RequestMapping("/AchievementHome")
    public ModelAndView AchievementHome(Model model){
        //成果所有分类
        Result result1 = iTypeService.selectAllType();
        List<Type> typeList = (List<Type>) result1.getData();
        model.addAttribute("typeList", typeList);

        //最新发布
        List<Achievement> achievementTimeList = iAchievementService.selectAchieveByTime();
        model.addAttribute("achievementTimeList",achievementTimeList);

        //排行榜
        Result result = iAchievementService.rankingAchievement(1,10);
        List<Achievement> achievementRankingList = (List<Achievement>) result.getData();
        model.addAttribute("achievementRankingList",achievementRankingList);

        //推荐
        List<Achievement> hotAchievement = iAchievementService.hotAchievement();
        model.addAttribute("hotAchievement",hotAchievement);
        return new ModelAndView("AchievementHome");
    }


    //

}
