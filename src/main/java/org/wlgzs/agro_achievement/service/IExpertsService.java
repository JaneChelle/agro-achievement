package org.wlgzs.agro_achievement.service;

import org.wlgzs.agro_achievement.entity.Experts;
import com.baomidou.mybatisplus.extension.service.IService;
import org.wlgzs.agro_achievement.util.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡亚星
 * @since 2019-01-19
 */
public interface IExpertsService extends IService<Experts> {

    //申请成为专家
    Result addExperts(HttpServletRequest request, Integer userId, String time, Experts experts);

    //查看（个人中心）专家信息
    Result expertsDetails(HttpServletRequest request);

    //前台查询所有专家（通过的）
    Result selectExperts(int current, int limit);

    //按添加时间查询专家（最新加入）
    Result selectExpertsByTime(int limit);

}
