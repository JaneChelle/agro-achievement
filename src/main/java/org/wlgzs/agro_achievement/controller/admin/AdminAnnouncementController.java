package org.wlgzs.agro_achievement.controller.admin;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Announcement;
import org.wlgzs.agro_achievement.util.Result;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 * 公告
 *
 * @author 胡亚星
 * @since 2019-01-19
 */
@RestController
@RequestMapping("/admin")
public class AdminAnnouncementController extends BaseController {

    //去添加公告
    @RequestMapping(value = "/toAddAnnouncement")
    public ModelAndView toAddAnnouncement() {
        return new ModelAndView("addAnnouncement");
    }

    //添加公告（管理员）
    @RequestMapping(value = "/addAnnouncement")
    public ModelAndView addAnnouncement(Announcement announcement) {
        iAnnouncementService.addAnnouncement(announcement);
        return new ModelAndView("redirect:/admin/selectAnnouncement");
    }

    //查看公告详情（管理员）
    @RequestMapping("/announcementAdminDetails")
    public ModelAndView announcementAdminDetails(Model model,Integer announcementId){
        Announcement announcement = iAnnouncementService.announcementDetails(announcementId);
        model.addAttribute("announcement",announcement);
        if(announcement == null){
            model.addAttribute("msg","数据不存在！");
            return new ModelAndView("redirect:/admin/selectAnnouncement");
        }
        return new ModelAndView("announcementAdminDetails");
    }

    //修改公告
    @RequestMapping(value = "/modifyAnnouncement")
    public ModelAndView modifyAnnouncement(Model model, Announcement announcement) {
        Result result = iAnnouncementService.modifyAnnouncement(announcement);
        if (result.getCode() == 0) {
            model.addAttribute("msg", "修改成功！");
        } else {
            model.addAttribute("msg", "修改失败！");
        }
        return new ModelAndView("redirect:/admin/selectAnnouncement");
    }

    //删除公告
    @RequestMapping(value = "/deleteAnnouncement")
    public ModelAndView deleteAnnouncement(Integer announcementId,Model model) {
        Result result = iAnnouncementService.deleteAnnouncement(announcementId);
        model.addAttribute("msg",result.getMsg());
        return new ModelAndView("redirect:/admin/selectAnnouncement");
    }

}
