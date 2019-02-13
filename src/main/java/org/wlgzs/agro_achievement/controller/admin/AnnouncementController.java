package org.wlgzs.agro_achievement.controller.admin;


import org.springframework.web.bind.annotation.*;

import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Announcement;
import org.wlgzs.agro_achievement.util.Result;

/**
 * <p>
 *  前端控制器
 * </p>
 *  公告
 * @author 胡亚星
 * @since 2019-01-19
 */
@RestController
@RequestMapping("/announcement")
public class AnnouncementController extends BaseController {

    //添加公告（管理员）
    @RequestMapping(value = "/addAnnouncement",method = RequestMethod.PUT)
    public Result addAnnouncement(Announcement announcement){
        return iAnnouncementService.addAnnouncement(announcement);
    }

    //修改公告
    @RequestMapping(value = "/modifyAnnouncement",method = RequestMethod.PUT)
    public Result modifyAnnouncement(Announcement announcement){
        return iAnnouncementService.modifyAnnouncement(announcement);
    }

    //删除公告
    @RequestMapping(value = "/deleteAnnouncement",method = RequestMethod.DELETE)
    public Result deleteAnnouncement(Integer announcementId){
        return iAnnouncementService.deleteAnnouncement(announcementId);
    }

    //按类别查询公告
    @GetMapping("/selectAnnouncement")
    public Result selectAnnouncement(String announcementType,
                                     @RequestParam(value = "current", defaultValue = "1") Integer current,
                                     @RequestParam(value = "limit", defaultValue = "8") Integer limit){
        return iAnnouncementService.selectAnnouncement(announcementType,current,limit);
    }


}
