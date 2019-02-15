package org.wlgzs.agro_achievement.service;

import org.wlgzs.agro_achievement.entity.Organization;
import com.baomidou.mybatisplus.extension.service.IService;
import org.wlgzs.agro_achievement.util.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡亚星
 * @since 2019-01-19
 */
public interface IOrganizationService extends IService<Organization> {

    //添加机构
    Result addOrganization(Organization organization);

    //删除机构
    Result deleteOrganization(Integer organizationId);

    //按用户查询机构
    Result selectOrganizationByUser(HttpServletRequest request);

    //前台查询所有机构
    List<Organization> selectAllOrganization(int current,int limit);

}
