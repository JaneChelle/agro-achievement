package org.wlgzs.agro_achievement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.wlgzs.agro_achievement.entity.OrganizationType;
import org.wlgzs.agro_achievement.entity.Type;
import org.wlgzs.agro_achievement.mapper.OrganizationTypeMapper;
import org.wlgzs.agro_achievement.service.IOrganizationTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.wlgzs.agro_achievement.util.Result;
import org.wlgzs.agro_achievement.util.ResultCode;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 胡亚星
 * @since 2019-01-19
 */
@Service
public class OrganizationTypeServiceImpl extends ServiceImpl<OrganizationTypeMapper, OrganizationType> implements IOrganizationTypeService {

    @Override
    public Result addOrganizationType(OrganizationType organizationType) {
        if (organizationType != null) {
            baseMapper.insert(organizationType);
            return new Result(ResultCode.SUCCESS, "填写成功！");
        }
        return new Result(ResultCode.FAIL, "请输入正确的信息！");
    }

    @Override
    public Result deleteOrganizationType(Integer organizationTypeId) {
        OrganizationType organizationType = baseMapper.selectById(organizationTypeId);
        if (organizationType != null) {
            baseMapper.deleteById(organizationTypeId);
            return new Result(ResultCode.SUCCESS, "删除成功！");
        }
        return new Result(ResultCode.FAIL, "不存在！");
    }

    @Override
    public Result selectAllOrganizationType() {
        QueryWrapper<OrganizationType> queryWrapper = new QueryWrapper();
        List<OrganizationType> organizationTypeList = baseMapper.selectList(queryWrapper);
        return new Result(ResultCode.SUCCESS,organizationTypeList);
    }
}
