package org.wlgzs.agro_achievement.service;

import org.wlgzs.agro_achievement.entity.Type;
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
public interface ITypeService extends IService<Type> {

    //添加类型
    Result addType(Type type);

    //删除类型
    Result deleteType(Integer typeId);

    //查找所有类型
    Result selectAllType();
}
