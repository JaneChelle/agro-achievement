package org.wlgzs.agro_achievement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.multipart.MultipartFile;
import org.wlgzs.agro_achievement.entity.Achievement;
import com.baomidou.mybatisplus.extension.service.IService;
import org.wlgzs.agro_achievement.util.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    Result addAchievement(MultipartFile[] myFileNames, HttpSession session,HttpServletRequest request,
                          Achievement achievement, String start_time, String end_time);

    //删除需求
    Result deleteAchievement(Integer achievementId);

    //修改需求
    Result modifyAchievement(Achievement achievement, String start_time, String end_time);

    //修改需求
    Result modifyAdminAchievement(Achievement achievement, String start_time, String end_time);

    //按照用户查询所有需求（状态码）
    Result selectAchievement(Integer userId, String statusCode, int current, int limit);

    //查看需求详情
    Result achievementDetails(Integer achievementId);

    //按照点击量排序成果
    Result rankingAchievement(int current, int limit);

    //按分类查询成果
    Result selectAchieveByType(String type, int current, int limit);

    //按时间查询（首页）
    List<Achievement> selectAchieveByTime(String home);

    //推荐成果
    List<Achievement> hotAchievement();

    //搜索成果
    IPage<Achievement> findName(String findName, int current, int limit);

    /**
     * 管理员
     */

    //添加成果
    Result saveAchievement(HttpSession session,MultipartFile[] myFileNames,HttpServletRequest request,
                           Achievement achievement, String start_time, String end_time);

    //查询所有成果
    Result adminAchievementList(String findName,int current, int limit);

    //按照成果状态查询
    Result AchievementStatusCode(String statusCode,int current,int limit);


}
