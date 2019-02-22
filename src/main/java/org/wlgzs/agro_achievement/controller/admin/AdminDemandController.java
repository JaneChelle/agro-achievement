package org.wlgzs.agro_achievement.controller.admin;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Demand;
import org.wlgzs.agro_achievement.entity.Type;
import org.wlgzs.agro_achievement.util.Result;

import java.util.List;


/**
 * @author:胡亚星
 * @createTime 2019-02-20 17:07
 * @description:
 **/

@RestController
@RequestMapping("/AdminDemand")
public class AdminDemandController extends BaseController {

    //查看所有需求(搜索)
    @RequestMapping(value = "/adminAdminDemand")
    public ModelAndView adminAdminDemand(Model model, @RequestParam(value = "current", defaultValue = "1") int current,
                                         @RequestParam(value = "limit", defaultValue = "8") int limit,
                                         @RequestParam(name = "findName",defaultValue = "") String findName){
        Result result = iDemandService.adminDemandList(findName,current,limit);
        List<Demand> demandList = (List<Demand>) result.getData();

        model.addAttribute("demandList",demandList);
        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数

        return new ModelAndView("DemandList");
    }

    //去添加需求
    @RequestMapping(value = "/toAdminAddDemand")
    public ModelAndView toAdd(Model model){
        //查询所有类型
        Result result1 = iTypeService.selectAllType();
        List<Type> typeList = (List<Type>) result1.getData();
        model.addAttribute("typeList", typeList);
        return new ModelAndView("adminAddDemand");
    }

    //管理员添加成果
    @RequestMapping(value = "/adminAddDemand")
    public ModelAndView adminAddDemand(Model model ,Demand demand){
        Result result = iDemandService.saveDemand(demand);
        model.addAttribute("msg",result.getMsg());
        return new ModelAndView("redirect:/AdminDemand/adminAdminDemand");
    }

    //跳转到修改成果
    @RequestMapping("/toAdminEditDemand")
    public ModelAndView toEdit(Model model, Integer demandId) {
        Result result = iDemandService.demandDetails(demandId);
        Demand demand = (Demand) result.getData();
        model.addAttribute("demand", demand);
        return new ModelAndView("adminEditDemand");
    }

    //修改成果
    @RequestMapping(value = "/adminEditAchievement")
    public ModelAndView modifyAchievement(Demand demand, Model model) {
        Result result = iDemandService.modifyDemand(demand);
        if (result.getCode() == 0) {
            Demand demand1 = (Demand) result.getData();
            model.addAttribute("msg", "修改成功！");
            model.addAttribute("demand", demand1);
            return new ModelAndView("adminDemandDetails");
        } else {
            model.addAttribute("msg", "修改失败！");
        }
        return new ModelAndView("redirect:/AdminDemand/adminAdminDemand");
    }

    //删除成果
    @RequestMapping(value = "/adminDeleteAchievement")
    public ModelAndView adminDeleteDemand(Integer demandId, Model model) {
        Result result = iDemandService.deleteDemand(demandId);
        if (result.getCode() == 0) {
            model.addAttribute("msg", "删除成功！");
        } else {
            model.addAttribute("msg", "不存在！");
        }
        return new ModelAndView("redirect:/AdminDemand/adminAdminDemand");
    }

}
