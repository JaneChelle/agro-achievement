package org.wlgzs.agro_achievement.service;

import org.wlgzs.agro_achievement.entity.OrganizationType;
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
public interface IOrganizationTypeService extends IService<OrganizationType> {

    //添加类型
    Result addOrganizationType(OrganizationType organizationType);

    //删除类型
    Result deleteOrganizationType(Integer organizationTypeId);

    //查找所有类型
    Result selectAllOrganizationType();

}
