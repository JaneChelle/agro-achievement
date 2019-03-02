package org.wlgzs.agro_achievement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Announcement;
import org.wlgzs.agro_achievement.util.Result;

import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2019-03-02 11:34
 * @description:
 **/
@Controller
@RequestMapping("/Announcement")
public class AnnouncementController extends BaseController {

    //查看公告详情（前台）
    @RequestMapping("/announcementDetails")
    public ModelAndView announcementDetails(Model model, Integer announcementId){
        Announcement announcement = iAnnouncementService.announcementDetails(announcementId);
        model.addAttribute("announcement",announcement);
        return new ModelAndView("announcementDetails");
    }

    //按类别查询公告(默认查询所有的)
    @GetMapping("/selectAnnouncement")
    public ModelAndView selectAnnouncement(Model model,
                                           @RequestParam(value = "announcementType", defaultValue = "") String announcementType,
                                           @RequestParam(value = "current", defaultValue = "1") Integer current,
                                           @RequestParam(value = "limit", defaultValue = "8") Integer limit) {
        Result result = iAnnouncementService.selectAnnouncement(announcementType, current, limit);
        List<Announcement> announcementList = (List<Announcement>) result.getData();
        model.addAttribute("announcementType",announcementType);
        model.addAttribute("announcementList",announcementList);
        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数

        return new ModelAndView("AnnouncementList");
    }
}
