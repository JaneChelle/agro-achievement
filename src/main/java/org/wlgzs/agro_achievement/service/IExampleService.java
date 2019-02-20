package org.wlgzs.agro_achievement.service;

import org.wlgzs.agro_achievement.entity.Example;
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
public interface IExampleService extends IService<Example> {

    //添加案例
    Result addExample(Example example);

    //修改案例
    Result modifyExample(Example example);

    //删除案例
    Result deleteExample(Integer exampleId);

    //查询案例
    Result selectExample(Integer current, Integer limit);

    //按照用户查询所有成功案例（状态码）(用户自身操作)
    Result selectExampleByUser(Integer userId, String statusCode, Integer current, Integer limit);

    //查看案例详情
    Example exampleDetails(Integer exampleId);
}
