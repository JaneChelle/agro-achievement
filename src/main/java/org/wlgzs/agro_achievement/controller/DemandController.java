package org.wlgzs.agro_achievement.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Demand;
import org.wlgzs.agro_achievement.entity.Type;
import org.wlgzs.agro_achievement.entity.User;
import org.wlgzs.agro_achievement.util.Result;
import org.wlgzs.agro_achievement.util.ResultCode;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 胡亚星
 * @since 2019-01-19
 */
@RestController
@RequestMapping("/demand")
public class DemandController extends BaseController {

    //跳转到发布一个需求
    @RequestMapping(value = "/toAddDemand")
    public ModelAndView toAddDemand(Model model) {
        //查询所有类型
        Result result1 = iTypeService.selectAllType();
        List<Type> typeList = (List<Type>) result1.getData();
        model.addAttribute("typeList", typeList);
        return new ModelAndView("addDemand");
    }

    //发布一个新需求
    @RequestMapping(value = "/addDemand")
    public ModelAndView addDemand(Demand demand) {
        iDemandService.addDemand(demand);
        return new ModelAndView("redirect:/demand/selectDemand");
    }

    //删除一个需求
    @RequestMapping(value = "/deleteDemand")
    public ModelAndView deleteDemand(Model model, Integer demandId) {
        Result result = iDemandService.deleteDemand(demandId);
        if (result.getCode() == 0) {
            model.addAttribute("msg", "删除成功！");
        } else {
            model.addAttribute("msg", "不存在！");
        }
        return new ModelAndView("redirect:/demand/selectDemand");
    }

    //修改需求
    @RequestMapping(value = "/modifyDemand")
    public ModelAndView modifyDemand(Model model, Demand demand) {
        Result result = iDemandService.modifyDemand(demand,null);
        if (result.getCode() == 0) {
            Demand demand1 = (Demand) result.getData();
            model.addAttribute("msg", "修改成功！");
            model.addAttribute("demand", demand1);
            return new ModelAndView("demandUserDetails");
        } else {
            model.addAttribute("msg", "修改失败！");
        }
        return new ModelAndView("redirect:/demand/selectDemand");
    }

    //按照用户查询所有需求（状态码）(用户自身操作)
    @GetMapping("/selectDemand")//分页
    public ModelAndView selectDemand(Model model,String statusCode,HttpSession session,
                               @RequestParam(value = "current", defaultValue = "1") Integer current,
                               @RequestParam(value = "limit", defaultValue = "8") Integer limit) {
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        Result result = iDemandService.selectDemand(userId, statusCode, current, limit);
        List<Demand> demandList = (List<Demand>) result.getData();
        model.addAttribute("demandList",demandList);
        model.addAttribute("statusCode",statusCode);
        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数
        return new ModelAndView("userDemandList");
    }

    //前台查询所有需求（页面显示的，审核通过的）
    @GetMapping("/selectAllDemand")
    public ModelAndView selectAllDemand(Model model,@RequestParam(value = "current", defaultValue = "1") int current,
                                  @RequestParam(value = "limit", defaultValue = "8") int limit) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status_code", "1");
        Page page = new Page(current, limit);
        IPage<Demand> iPage = iDemandService.page(page, queryWrapper);
        List<Demand> demandList = iPage.getRecords();
        if (demandList != null) {
            model.addAttribute("msg","查询成功！");
        }else{
            model.addAttribute("msg","暂无数据！");
        }
        model.addAttribute("demandList",demandList);
        model.addAttribute("TotalPages", iPage.getPages());//总页数
        model.addAttribute("Number", iPage.getCurrent());//当前页数
        return new ModelAndView("DemandList");
    }

    //查看需求详情页面
    @GetMapping("/demandDetails")
    public ModelAndView demandDetails(Model model,Integer demandId) {
        Result result = iDemandService.demandDetails(demandId);
        Demand demand = (Demand) result.getData();
        if(demand != null){
            demand.setPageView(demand.getPageView() + 1);
            iDemandService.updateById(demand);
        }
        model.addAttribute("demand",demand);
        return new ModelAndView("demandDetails");
    }

    //查看需求详情页面(个人中心)
    @GetMapping("/demandUserDetails")
    public ModelAndView demandUserDetails(Model model,Integer demandId) {
        Result result = iDemandService.demandDetails(demandId);
        Demand demand = (Demand) result.getData();
        model.addAttribute("demand",demand);
        //查询所有类型
        Result result1 = iTypeService.selectAllType();
        List<Type> typeList = (List<Type>) result1.getData();
        model.addAttribute("typeList", typeList);

        return new ModelAndView("demandUserDetails");
    }

}
