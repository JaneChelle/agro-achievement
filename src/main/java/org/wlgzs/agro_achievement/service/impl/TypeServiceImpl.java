package org.wlgzs.agro_achievement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.wlgzs.agro_achievement.entity.Demand;
import org.wlgzs.agro_achievement.entity.Type;
import org.wlgzs.agro_achievement.mapper.TypeMapper;
import org.wlgzs.agro_achievement.service.ITypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.wlgzs.agro_achievement.util.Result;
import org.wlgzs.agro_achievement.util.ResultCode;

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
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements ITypeService {

    //添加类型
    @Override
    public Result addType(Type type) {
        if (type != null) {
            baseMapper.insert(type);
            return new Result(ResultCode.SUCCESS, "填写成功！");
        }
        return new Result(ResultCode.FAIL, "请输入正确的信息！");
    }

    //删除类型
    @Override
    public Result deleteType(Integer typeId) {
        Type type = baseMapper.selectById(typeId);
        if (type != null) {
            baseMapper.deleteById(typeId);
            return new Result(ResultCode.SUCCESS, "删除成功！");
        }
        return new Result(ResultCode.FAIL, "不存在！");
    }

    //查找所有类型
    @Override
    public Result selectAllType() {
        QueryWrapper<Type> queryWrapper = new QueryWrapper();
        List<Type> typeList = baseMapper.selectList(queryWrapper);
        return new Result(ResultCode.SUCCESS,typeList);
    }

}
