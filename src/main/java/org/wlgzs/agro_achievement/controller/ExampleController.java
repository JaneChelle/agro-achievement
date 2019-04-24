package org.wlgzs.agro_achievement.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Example;
import org.wlgzs.agro_achievement.entity.User;
import org.wlgzs.agro_achievement.util.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 * 案例
 *
 * @author 胡亚星
 * @since 2019-01-19
 */
@RestController
@RequestMapping("/example")
public class ExampleController extends BaseController {

    //去添加案例
    @RequestMapping(value = "/toAddExample")
    public ModelAndView toAddExample() {
        return new ModelAndView("/information/addExample");
    }

    //添加案例
    @RequestMapping(value = "/addExample")
    public Result addExample(Example example) {
        return iCaseService.addExample(example);
    }

    //去修改案例
    @RequestMapping(value = "/toModifyExample")
    public ModelAndView toModifyExample(Model model, Integer exampleId) {
        Example example = iCaseService.exampleDetails(exampleId);
        model.addAttribute("example", example);
        return new ModelAndView("/information/modifyExample");
    }

    //修改案例
    @RequestMapping(value = "/modifyExample")
    public Result modifyExample(Model model, Example example) {
        Result result = iCaseService.modifyExample(example);
        return result;
    }

    //删除案例
    @RequestMapping(value = "/deleteExample", method = RequestMethod.DELETE)
    public Result deleteExample(Model model, Integer exampleId) {
        Result result = iCaseService.deleteExample(exampleId);
        return result;
    }

    //按照用户查询所有成功案例（状态码）(用户自身操作)
    @GetMapping("/selectExampleByUser")//分页
    public ModelAndView selectExampleByUser(Model model, String statusCode, HttpSession session,
                                            @RequestParam(value = "current", defaultValue = "1") Integer current,
                                            @RequestParam(value = "limit", defaultValue = "8") Integer limit) {
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        Result result = iCaseService.selectExampleByUser(userId, statusCode, current, limit);
        List<Example> exampleList = (List<Example>) result.getData();
        model.addAttribute("exampleList", exampleList);
        model.addAttribute("statusCode", statusCode);
        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数
        return new ModelAndView("/information/userExampleList");
    }

    //查看案列详情
    @RequestMapping(value = "/exampleDetails")
    public ModelAndView exampleDetails(Model model, Integer exampleId) {
        Example example = iCaseService.exampleDetails(exampleId);
        model.addAttribute("example", example);
        return new ModelAndView("/example/exampleDetails");
    }

    //查询所有案例
    @RequestMapping(value = "/selectAllExample")
    public ModelAndView selectAllExample(Model model) {
        QueryWrapper<Example> queryWrapper = new QueryWrapper<>();
        List<Example> exampleList = iCaseService.list(queryWrapper);
        System.out.println("exampleList" + exampleList);

        model.addAttribute("exampleList", exampleList);
        return new ModelAndView("/example/ExampleList");
    }

}
