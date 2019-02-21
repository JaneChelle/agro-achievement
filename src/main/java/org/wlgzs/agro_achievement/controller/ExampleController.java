package org.wlgzs.agro_achievement.controller;


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
 *  前端控制器
 * </p>
 * 案例
 * @author 胡亚星
 * @since 2019-01-19
 */
@RestController
@RequestMapping("/example")
public class ExampleController extends BaseController {

    //去添加案例
    @RequestMapping(value = "/toAddExample")
    public ModelAndView toAddExample(){
        return new ModelAndView("addExample");
    }

    //添加案例
    @RequestMapping(value = "/addExample")
    public ModelAndView addExample(Example example){
        iCaseService.addExample(example);
        return new ModelAndView("redirect:/example/selectExampleByUser");
    }

    //去修改案例
    @RequestMapping(value = "/toModifyExample")
    public ModelAndView toModifyExample(Model model,Integer exampleId){
        Example example = iCaseService.exampleDetails(exampleId);
        model.addAttribute("example",example);
        return new ModelAndView("modifyExample");
    }

    //修改案例
    @RequestMapping(value = "/modifyExample")
    public ModelAndView modifyExample(Model model,Example example){
        Result result = iCaseService.modifyExample(example);
        if (result.getCode() == 0) {
            Example example1 = (Example) result.getData();
            model.addAttribute("msg", "修改成功！");
            model.addAttribute("example1", example1);
            return new ModelAndView("exampleDetails");
        } else {
            model.addAttribute("msg", "修改失败！");
        }
        return new ModelAndView("redirect:/example/selectExampleByUser");
    }

    //删除案例
    @RequestMapping(value = "/deleteExample",method = RequestMethod.DELETE)
    public ModelAndView deleteExample(Model model,Integer exampleId){
        Result result = iCaseService.deleteExample(exampleId);
        if (result.getCode() == 0) {
            model.addAttribute("msg", "删除成功！");
        } else {
            model.addAttribute("msg", "不存在！");
        }
        return new ModelAndView("redirect:/example/selectExampleByUser");
    }

    //查询成功案例（显示的）
    @GetMapping("/selectExample")
    public ModelAndView selectExample(Model model,@RequestParam(value = "current", defaultValue = "1") Integer current,
                             @RequestParam(value = "limit", defaultValue = "8") Integer limit){
        Result result = iCaseService.selectExample(current,limit);
        List<Example> exampleList = (List<Example>) result.getData();
        if (exampleList != null) {
            model.addAttribute("msg","查询成功！");
        }else{
            model.addAttribute("msg","暂无数据！");
        }
        model.addAttribute("exampleList",exampleList);
        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数
        return new ModelAndView("ExampleList");
    }

    //按照用户查询所有成功案例（状态码）(用户自身操作)
    @GetMapping("/selectExampleByUser")//分页
    public ModelAndView selectExampleByUser(Model model,String statusCode,HttpSession session,
                               @RequestParam(value = "current", defaultValue = "1") Integer current,
                               @RequestParam(value = "limit", defaultValue = "8") Integer limit) {
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        Result result = iCaseService.selectExampleByUser(userId, statusCode,current,limit);
        List<Example> exampleList = (List<Example>) result.getData();
        model.addAttribute("exampleList",exampleList);
        model.addAttribute("statusCode",statusCode);
        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数
        return new ModelAndView("userExampleList");
    }

}
