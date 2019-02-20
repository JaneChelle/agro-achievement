package org.wlgzs.agro_achievement.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Achievement;
import org.wlgzs.agro_achievement.entity.Type;
import org.wlgzs.agro_achievement.util.Result;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author:胡亚星
 * @createTime 2019-02-14 10:29
 * @description: 管理员成果管理
 **/
@Controller
@RequestMapping("/AdminAchievement")
public class AdminAchievementController extends BaseController {

    //查询所有成果(分页)
    @RequestMapping(value = "/adminAchievementList")
    public ModelAndView adminAchievementList(Model model,@RequestParam(value = "current", defaultValue = "1") int current,
                                             @RequestParam(value = "limit", defaultValue = "8") int limit,
                                             @RequestParam(value = "findName", defaultValue = "") String findName){
        Result result = iAchievementService.adminAchievementList(findName,current,limit);

        List<Achievement> achievementList = (List<Achievement>) result.getData();
        model.addAttribute("achievementList",achievementList);
        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数

        return new ModelAndView("AchievementList");
    }

    //去添加成果
    @RequestMapping(value = "/toAdminAddAchievement")
    public ModelAndView toAdd(Model model){
        //查询所有类型
        Result result1 = iTypeService.selectAllType();
        List<Type> typeList = (List<Type>) result1.getData();
        model.addAttribute("typeList", typeList);
        return new ModelAndView("adminAddAchievement");
    }

    //管理员添加成果
    @RequestMapping(value = "/adminAddAchievement")
    public ModelAndView adminAddAchievement(@RequestParam(value = "file", required = false) MultipartFile[] myFileNames,Model model,
                                            HttpServletRequest request, Achievement achievement, String start_time, String end_time){
        Result result = iAchievementService.saveAchievement(myFileNames,request,achievement,start_time,end_time);
        return new ModelAndView("redirect:/AdminAchievement/adminAchievementList");
    }

    //跳转到修改成果
    @RequestMapping("/toAdminEditAchievement")
    public ModelAndView toEdit(Model model, Integer achievementId) {
        Result result = iAchievementService.achievementDetails(achievementId);
        Achievement achievement = (Achievement) result.getData();
        model.addAttribute("achievement", achievement);
        return new ModelAndView("adminEditAchievement");
    }

    //修改成果
    @RequestMapping(value = "/adminEditAchievement")
    public ModelAndView modifyAchievement(Achievement achievement, String start_time, String end_time, Model model) {
        Result result = iAchievementService.modifyAchievement(achievement, start_time, end_time);
        if (result.getCode() == 0) {
            Achievement achievement1 = (Achievement) result.getData();
            model.addAttribute("msg", "修改成功！");
            model.addAttribute("achievement", achievement1);
            return new ModelAndView("adminAchieveDetails");
        } else {
            model.addAttribute("msg", "修改失败！");
        }
        return new ModelAndView("redirect:/AdminAchievement/adminAchievementList");
    }

    //删除成果
    @RequestMapping(value = "/adminDeleteAchievement")
    public ModelAndView adminDeleteAchievement(Integer achievementId, Model model) {
        Result result = iAchievementService.deleteAchievement(achievementId);
        if (result.getCode() == 0) {
            model.addAttribute("msg", "删除成功！");
        } else {
            model.addAttribute("msg", "不存在！");
        }
        return new ModelAndView("redirect:/AdminAchievement/adminAchievementList");
    }

}
