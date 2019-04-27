package org.wlgzs.agro_achievement.controller.admin;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Announcement;
import org.wlgzs.agro_achievement.util.Result;
import org.wlgzs.agro_achievement.util.ResultCode;

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
        return new ModelAndView("admin/addAnnouncement");
    }

    //添加公告（管理员）
    @RequestMapping(value = "/addAnnouncement")
    public Result addAnnouncement(Announcement announcement) {
        return iAnnouncementService.addAnnouncement(announcement);
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
        return new ModelAndView("admin/Announcement");
    }

    //修改公告详情（管理员）
    @RequestMapping("/announcementAdminModify")
    public ModelAndView announcementAdminModify(Model model,Integer announcementId){
        Announcement announcement = iAnnouncementService.announcementDetails(announcementId);
        model.addAttribute("announcement",announcement);
        if(announcement == null){
            model.addAttribute("msg","数据不存在！");
            return new ModelAndView("redirect:/admin/selectAnnouncement");
        }
        return new ModelAndView("admin/modifyAnnouncement");
    }

    //修改公告
    @RequestMapping(value = "/modifyAnnouncement")
    public Result modifyAnnouncement(Announcement announcement) {
        Result result = iAnnouncementService.modifyAnnouncement(announcement);
        return result;
    }

    //删除公告
    @RequestMapping(value = "/deleteAnnouncement")
    public Result deleteAnnouncement(Integer announcementId,Model model) {
        Result result = iAnnouncementService.deleteAnnouncement(announcementId);
        return result;
    }

    //按类别查询公告(默认查询所有的)
    @GetMapping("/selectAnnouncement")
    public ModelAndView selectAnnouncement(Model model,@RequestParam(value = "findName",defaultValue = "")String findName,
            @RequestParam(value = "announcementType", defaultValue = "") String announcementType,
            @RequestParam(value = "current", defaultValue = "1") Integer current,
            @RequestParam(value = "limit", defaultValue = "8") Integer limit) {
        Result result = iAnnouncementService.selectAnnouncement(findName, current, limit);
        List<Announcement> announcementList = (List<Announcement>) result.getData();
        model.addAttribute("announcementList",announcementList);
        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数
        model.addAttribute("findName",findName);

        return new ModelAndView("admin/adminAnnouncement");
    }

    //按公告是否显示查询
    @RequestMapping("/selectByIsShow")
    public ModelAndView selectByIsShow(int isShow,Model model,@RequestParam(value = "current", defaultValue = "1") Integer current,
                                       @RequestParam(value = "limit", defaultValue = "8") Integer limit){
        QueryWrapper<Announcement> queryWrapper = new QueryWrapper<>();
        if(isShow == 0 || isShow == 1){
            queryWrapper.eq("is_show",isShow);
        }
        List<Announcement> announcementList = iAnnouncementService.list(queryWrapper);
        model.addAttribute("announcementList",announcementList);
        return new ModelAndView("admin/adminAnnouncement");
    }

    //修改公告是否显示
    @RequestMapping("/modifiedAccording")
    public Result modifiedAccording(int announcementId,int isShow){
        Announcement announcement = iAnnouncementService.getById(announcementId);
        if(announcement != null){
            announcement.setIsShow(isShow);
            iAnnouncementService.updateById(announcement);
            return new Result(ResultCode.SUCCESS,"修改成功！");
        }
        return new Result(ResultCode.FAIL,"不存在！");
    }

}
