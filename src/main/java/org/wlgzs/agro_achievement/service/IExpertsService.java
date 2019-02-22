package org.wlgzs.agro_achievement.service;

import org.springframework.web.multipart.MultipartFile;
import org.wlgzs.agro_achievement.entity.Experts;
import com.baomidou.mybatisplus.extension.service.IService;
import org.wlgzs.agro_achievement.util.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 胡亚星
 * @since 2019-01-19
 */
public interface IExpertsService extends IService<Experts> {

    //申请成为专家
    Result addExperts(HttpServletRequest request, String time, Experts experts,MultipartFile myFileName);

    //查看（个人中心）专家信息
    Experts expertsUserDetails(HttpServletRequest request);

    //查看专家详情
    Experts expertsDetails(Integer expertsId);

    //前台查询所有专家（通过的）
    Result selectExperts(int current, int limit);

    //按添加时间查询专家（最新加入）
    Result selectExpertsByTime(int limit);

    //按点击量查询专家（最新加入）
    Result expertRanking(int limit);

    /**
     * 管理员
     */
    //搜索专家
    Result findExpertsList(String findName, int current, int limit);

    //管理添加专家
    Result addAdminExperts(Experts experts);

    //修改专家信息
    Result modifyExperts(Experts experts);

    //删除专家信息
    Result adminDeleteExpertsId(Integer expertsId);
}
