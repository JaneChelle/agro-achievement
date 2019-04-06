package org.wlgzs.agro_achievement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.wlgzs.agro_achievement.entity.Example;
import org.wlgzs.agro_achievement.mapper.ExampleMapper;
import org.wlgzs.agro_achievement.service.IExampleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.wlgzs.agro_achievement.util.Result;
import org.wlgzs.agro_achievement.util.ResultCode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class ExampleServiceImpl extends ServiceImpl<ExampleMapper, Example> implements IExampleService {

    //添加案例
    @Override
    public Result addExample(Example example) {
        if (example != null) {
            //获取现在时间
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime time = LocalDateTime.now();
            String localTime = formatter.format(time);
            LocalDateTime ldt = LocalDateTime.parse(localTime, formatter);
            example.setReleaseTime(ldt);
            if(example.getStatusCode() == null || "".equals(example.getStatusCode())){
                example.setStatusCode("0");
            }
            baseMapper.insert(example);
            return new Result(ResultCode.SUCCESS, "录入成功！");
        }
        return new Result(ResultCode.FAIL, "录入失败");
    }

    //修改案例
    @Override
    public Result modifyExample(Example example) {
        System.out.println(example);
        if (example != null) {
            Example example1 = baseMapper.selectById(example.getExampleId());
            if (example1 != null) {
                example.setReleaseTime(example1.getReleaseTime());
                example.setStatusCode(example1.getStatusCode());
                example.setUserId(example1.getUserId());
                baseMapper.updateById(example);
                return new Result(ResultCode.SUCCESS, "修改成功！",1,example);
            }
            return new Result(ResultCode.FAIL, "该条记录不存在！");
        }
        return new Result(ResultCode.FAIL, "修改失败！");
    }

    //删除案例
    @Override
    public Result deleteExample(Integer exampleId) {
        Example example = baseMapper.selectById(exampleId);
        if (example != null) {
            baseMapper.deleteById(exampleId);
            return new Result(ResultCode.SUCCESS, "删除成功！");
        }
        return new Result(ResultCode.FAIL, "不存在！");
    }

    //查询案例
    @Override
    public Result selectExample(Integer current, Integer limit) {
        Page page = new Page(current, limit);
        QueryWrapper<Example> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status_code", "1").orderBy(true, false, "release_time");
        IPage<Example> iPage = baseMapper.selectPage(page, queryWrapper);
        List<Example> exampleList = iPage.getRecords();
        if (exampleList != null) {
            return new Result(ResultCode.SUCCESS, "", exampleList, iPage.getPages(), iPage.getCurrent());
        }
        return new Result(ResultCode.FAIL, "暂无数据！");
    }

    //按照用户查询所有成功案例（状态码）(用户自身操作)
    @Override
    public Result selectExampleByUser(Integer userId, String statusCode, Integer current, Integer limit) {
        Page page = new Page(current, limit);
        QueryWrapper<Example> queryWrapper = new QueryWrapper<>();
        if (statusCode == null || statusCode.equals("")) {
        queryWrapper.eq("user_id", userId);
        } else {
            queryWrapper.eq("user_id", userId).eq("status_code", statusCode);
        }
        IPage iPage = baseMapper.selectPage(page, queryWrapper);
        List<Example> exampleList = iPage.getRecords();
        if (exampleList != null) {
            return new Result(ResultCode.SUCCESS, "", exampleList, iPage.getPages(), iPage.getCurrent());
        }
        return new Result(ResultCode.FAIL, "暂无数据！");
    }

    @Override
    public Example exampleDetails(Integer exampleId) {
        Example example = baseMapper.selectById(exampleId);
        return example;
    }


    /**
     * 管理员
     */
    //搜索案例
    @Override
    public Result findExampleList(String findName, int current, int limit) {
        QueryWrapper<Example> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("example_title",findName);
        Page page = new Page(current,limit);
        IPage<Example> iPage = baseMapper.selectPage(page,queryWrapper);
        List<Example> exampleList = iPage.getRecords();

        return new Result(ResultCode.SUCCESS,"",exampleList,iPage.getPages(),iPage.getCurrent());
    }

    @Override
    public Result addAdminExample(Example example) {
        if (example != null) {
            //获取现在时间
            baseMapper.insert(example);
            return new Result(ResultCode.SUCCESS, "录入成功！");
        }
        return new Result(ResultCode.FAIL, "录入失败");
    }

    @Override
    public Result selectExampleByCode(String statusCode, int current, int limit) {
        QueryWrapper<Example> queryWrapper = new QueryWrapper<>();
        Page page = new Page(current,limit);
        queryWrapper.eq("status_code",statusCode);
        IPage<Example> iPage = baseMapper.selectPage(page,queryWrapper);
        List<Example> exampleList = iPage.getRecords();

        return new Result(ResultCode.SUCCESS, "", exampleList, iPage.getPages(), iPage.getCurrent());
    }


}
