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
        return new ModelAndView("information/addDemand");
    }

    //发布一个新需求
    @RequestMapping(value = "/addDemand")
    public Result addDemand(Demand demand) {
        return iDemandService.addDemand(demand);
    }

    //删除一个需求
    @RequestMapping(value = "/deleteDemand")
    public Result deleteDemand(Model model, Integer demandId) {
        Result result = iDemandService.deleteDemand(demandId);
        return result;
    }

    //修改需求
    @RequestMapping(value = "/modifyDemand")
    public Result modifyDemand(Model model, Demand demand) {
        Result result = iDemandService.modifyDemand(demand,null);
        return result;
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
        return new ModelAndView("information/userDemandList");
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
        return new ModelAndView("demand/DemandList");
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
        return new ModelAndView("demand/demandDetails");
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

        return new ModelAndView("information/demandUserDetails");
    }

}
