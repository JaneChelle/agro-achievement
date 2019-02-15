package org.wlgzs.agro_achievement.service;

import org.wlgzs.agro_achievement.entity.Achievement;
import com.baomidou.mybatisplus.extension.service.IService;
import org.wlgzs.agro_achievement.util.Result;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡亚星
 * @since 2019-01-19
 */
public interface IAchievementService extends IService<Achievement> {

    //发布需求
    Result addAchievement(Achievement achievement, String start_time,
                          String end_time);

    //删除需求
    Result deleteAchievement(Integer achievementId);

    //修改需求
    Result modifyAchievement(Achievement achievement, String start_time, String end_time);

    //按照用户查询所有需求（状态码）
    Result selectAchievement(Integer userId, String statusCode, int current, int limit);

    //查看需求详情
    Result achievementDetails(Integer achievementId);

    //按照点击量排序成果
    Result rankingAchievement(int current, int limit);

    //按分类查询成果
    Result selectAchieveByType(String type, int current, int limit);

    //按时间查询（首页）
    List<Achievement> selectAchieveByTime();
}
