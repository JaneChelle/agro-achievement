package org.wlgzs.agro_achievement.controller;


import org.springframework.web.bind.annotation.*;

import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Example;
import org.wlgzs.agro_achievement.util.Result;

/**
 * <p>
 *  前端控制器
 * </p>
 * 案例
 * @author 胡亚星
 * @since 2019-01-19
 */
@RestController
@RequestMapping("/example")
public class ExampleController extends BaseController {

    //添加案例
    @RequestMapping(value = "/addExample",method = RequestMethod.PUT)
    public Result addExample(Example example){
        return iCaseService.addExample(example);
    }

    //修改案例
    @RequestMapping(value = "/modifyExample",method = RequestMethod.PUT)
    public Result modifyExample(Example example){
        return iCaseService.modifyExample(example);
    }

    //删除案例
    @RequestMapping(value = "/deleteExample",method = RequestMethod.DELETE)
    public Result deleteExample(Integer exampleId){
        return iCaseService.deleteExample(exampleId);
    }

    //查询成功案例（显示的）
    @GetMapping("/selectExample")
    public Result selectExample(@RequestParam(value = "current", defaultValue = "1") Integer current,
                             @RequestParam(value = "limit", defaultValue = "8") Integer limit){
        return iCaseService.selectExample(current,limit);
    }

    //按照用户查询所有成功案例（状态码）(用户自身操作)
    @GetMapping("/selectExampleByUser")//分页
    public Result selectExampleByUser(Integer userId, String statusCode,
                               @RequestParam(value = "current", defaultValue = "1") Integer current,
                               @RequestParam(value = "limit", defaultValue = "8") Integer limit) {
        return iCaseService.selectExampleByUser(userId, statusCode,current,limit);
    }

}
