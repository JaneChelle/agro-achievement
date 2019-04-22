package org.wlgzs.agro_achievement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.wlgzs.agro_achievement.entity.Announcement;
import org.wlgzs.agro_achievement.mapper.AnnouncementMapper;
import org.wlgzs.agro_achievement.service.IAnnouncementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.wlgzs.agro_achievement.util.Result;
import org.wlgzs.agro_achievement.util.ResultCode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 胡亚星
 * @since 2019-01-19
 */
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements IAnnouncementService {

    //添加公告
    @Override
    public Result addAnnouncement(Announcement announcement) {
        if (announcement != null) {
            //获取现在时间
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime time = LocalDateTime.now();
            String localTime = formatter.format(time);
            LocalDateTime ldt = LocalDateTime.parse(localTime, formatter);
            announcement.setReleaseTime(ldt);
            baseMapper.insert(announcement);
            return new Result(ResultCode.SUCCESS, "录入成功！");
        }
        return new Result(ResultCode.FAIL, "录入失败");
    }

    //修改公告
    @Override
    public Result modifyAnnouncement(Announcement announcement) {
        if (announcement != null) {
            Announcement announcement1 = baseMapper.selectById(announcement.getAnnouncementId());
            if (announcement1 != null) {
                announcement.setReleaseTime(announcement1.getReleaseTime());
                System.out.println("announcement"+announcement);
                baseMapper.updateById(announcement);
                return new Result(ResultCode.SUCCESS, "修改成功！");
            }
            return new Result(ResultCode.FAIL, "该条记录不存在！");
        }
        return new Result(ResultCode.FAIL, "修改失败！");
    }

    //删除公告
    @Override
    public Result deleteAnnouncement(Integer announcementId) {
        Announcement announcement = baseMapper.selectById(announcementId);
        if (announcement != null) {
            baseMapper.deleteById(announcementId);
            return new Result(ResultCode.SUCCESS, "删除成功！");
        }
        return new Result(ResultCode.FAIL, "数据不存在！");
    }

    //按类别查询公告
    @Override
    public Result selectAnnouncement(String announcementType, Integer current, Integer limit) {
        QueryWrapper<Announcement> queryWrapper = new QueryWrapper<>();
        Page page = new Page(current, limit);
        if(!announcementType.equals("")){
            queryWrapper.eq("announcement_type", announcementType).orderBy(true, false, "release_time");
        }else{
            queryWrapper.orderBy(true, false, "release_time");
        }
        IPage<Announcement> iPage = baseMapper.selectPage(page, queryWrapper);
        List<Announcement> announcementList = iPage.getRecords();
        if(announcementList != null){
            return new Result(ResultCode.SUCCESS,"",announcementList,iPage.getPages(),iPage.getCurrent());
        }
        return new Result(ResultCode.FAIL);
    }

    //查看公告详情
    @Override
    public Announcement announcementDetails(Integer announcementId) {
        Announcement announcement = baseMapper.selectById(announcementId);
        return announcement;
    }


}
