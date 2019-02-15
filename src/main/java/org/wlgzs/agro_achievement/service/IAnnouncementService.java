package org.wlgzs.agro_achievement.service;

import org.wlgzs.agro_achievement.entity.Announcement;
import com.baomidou.mybatisplus.extension.service.IService;
import org.wlgzs.agro_achievement.util.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡亚星
 * @since 2019-01-19
 */
public interface IAnnouncementService extends IService<Announcement> {

    //添加公告
    Result addAnnouncement(Announcement announcement);

    //修改公告
    Result modifyAnnouncement(Announcement announcement);

    //删除公告
    Result deleteAnnouncement(Integer announcementId);

    //按类别查询公告
    Result selectAnnouncement(String announcementType, Integer current, Integer limit);

    //
}
