package org.wlgzs.agro_achievement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.wlgzs.agro_achievement.entity.Organization;
import org.wlgzs.agro_achievement.entity.OrganizationType;
import org.wlgzs.agro_achievement.entity.User;
import org.wlgzs.agro_achievement.mapper.OrganizationMapper;
import org.wlgzs.agro_achievement.mapper.OrganizationTypeMapper;
import org.wlgzs.agro_achievement.service.IOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.wlgzs.agro_achievement.util.Result;
import org.wlgzs.agro_achievement.util.ResultCode;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements IOrganizationService {

    @Resource
    OrganizationTypeMapper organizationTypeMapper;

    @Override
    public Result addOrganization(Organization organization) {
        if (organization != null) {
            //根据前台传来的机构类型查询
            QueryWrapper<OrganizationType> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("type_name", organization.getTypeName());
            OrganizationType organizationType = organizationTypeMapper.selectOne(queryWrapper);
            if (organizationType != null) {
                organization.setOrganizationTypeId(organizationType.getOrganizationTypeId());
                baseMapper.insert(organization);
                return new Result(ResultCode.SUCCESS, "添加成功！");
            }
            return new Result(ResultCode.FAIL);
        }
        return new Result(ResultCode.FAIL);
    }

    //删除机构
    @Override
    public Result deleteOrganization(Integer organizationId) {
        Organization organization = baseMapper.selectById(organizationId);
        if (organization != null) {
            baseMapper.deleteById(organizationId);
            return new Result(ResultCode.SUCCESS, "删除成功！");
        }
        return new Result(ResultCode.FAIL, "该条记录不存在！");
    }

    //按用户查询机构(状态码)
    @Override
    public Result selectOrganizationByUser(HttpServletRequest request,String statusCode) {
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user != null) {
            QueryWrapper<Organization> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", user.getUserId()).eq("status_code",statusCode);
            List<Organization> organization = baseMapper.selectList(queryWrapper);
            if (organization != null) {
                return new Result(ResultCode.SUCCESS, organization);
            }
            return new Result(ResultCode.FAIL, "暂无所属机构！");
        }
        return new Result(ResultCode.FAIL, "请先登录！");
    }

    //前台查询所有机构
    @Override
    public List<Organization> selectAllOrganization(int current, int limit) {
        List<Organization> organizationList = null;
        Page page = new Page(current, limit);
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status_code", "1");
        IPage<Organization> iPage = baseMapper.selectPage(page, queryWrapper);
        organizationList = iPage.getRecords();
        return organizationList;
    }

    //前台按类型查询机构
    @Override
    public Result selectOrganizationByType(String type, int current, int limit) {
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>();
        if(!type.equals("")){
            queryWrapper.eq("type_name",type);
        }
        Page page = new Page(current,limit);
        IPage<Organization> iPage = baseMapper.selectPage(page,queryWrapper);
        List<Organization> organizationList = iPage.getRecords();
        if(organizationList != null){
            return new Result(ResultCode.SUCCESS,"查询成功！",organizationList,iPage.getPages(),iPage.getCurrent());
        }
        return new Result(ResultCode.FAIL,"暂无数据！");
    }

    @Override
    public List<Organization> selectOrganizationByTime() {
        QueryWrapper<Organization> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status_code", "1").orderByDesc(true, "release_time");
        Page page = new Page(1, 10);
        IPage<Organization> iPage = baseMapper.selectPage(page,queryWrapper);
        return iPage.getRecords();
    }

    @Override
    public List<Organization> rankingOrganization(int current, int limit) {
        List<Organization> organizationList = null;
        QueryWrapper<Organization> queryWrapper = new QueryWrapper();
        IPage<Organization> iPage = null;
//        queryWrapper.and(i -> i.eq("status_code", "1").orderBy(true,false,"page_view"));
        queryWrapper.orderBy(true, false, "page_view").eq("status_code", "1");
        Page page = new Page(current, limit);
        iPage = baseMapper.selectPage(page, queryWrapper);
        organizationList = iPage.getRecords();
        return organizationList;
    }


}
