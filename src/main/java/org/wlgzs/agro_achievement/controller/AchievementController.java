package org.wlgzs.agro_achievement.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Achievement;
import org.wlgzs.agro_achievement.entity.Type;
import org.wlgzs.agro_achievement.entity.User;
import org.wlgzs.agro_achievement.util.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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
@RequestMapping("/achievement")
public class AchievementController extends BaseController {

    //跳转到添加成果
    @RequestMapping(value = "/toAddAchievement")
    public ModelAndView toAddAchievement(Model model) {
        //查询所有类型
        Result result1 = iTypeService.selectAllType();
        List<Type> typeList = (List<Type>) result1.getData();
        model.addAttribute("typeList", typeList);
        return new ModelAndView("/information/addAchievement");
    }

    //发布成果
    @RequestMapping(value = "/addAchievement")
    public Result addAchievement(@RequestParam(value = "file", required = false) MultipartFile[] myFileNames, HttpSession session, Model model,
                                       HttpServletRequest request, Achievement achievement, String start_time, String end_time) {
        Result result = iAchievementService.addAchievement(myFileNames, session, request, achievement, start_time, end_time);
        System.out.println(result+"-----");
        return result;
    }

    //删除成果
    @RequestMapping(value = "/deleteAchievement")
    public Result deleteAchievement(Integer achievementId, Model model) {
        Result result = iAchievementService.deleteAchievement(achievementId);
        return result;
    }

    //修改成果
    @RequestMapping(value = "/modifyAchievement")
    public Result modifyAchievement(Achievement achievement, String start_time, String end_time, Model model) {
        System.out.println(achievement);
        Result result = iAchievementService.modifyAchievement(achievement, start_time, end_time);
        return result;
    }

    //查询所有成果（用户）
    @GetMapping("/selectAchievement")//分页
    public ModelAndView selectAchievement(Model model, String statusCode, HttpSession session,
                                          @RequestParam(value = "current", defaultValue = "1") int current,
                                          @RequestParam(value = "limit", defaultValue = "8") int limit) {
        if("".equals(statusCode) || statusCode == null){
            model.addAttribute("statusCode",0);
        }else{
            model.addAttribute("statusCode",statusCode);
        }
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        Result result = iAchievementService.selectAchievement(userId, statusCode, current, limit);
        model.addAttribute("statusCode", statusCode);
        //成果数据
        List<Achievement> achievementList = (List<Achievement>) result.getData();
        String img;
        for (int i = 0; i < achievementList.size(); i++) {
            if (achievementList.get(i).getPictureAddress().contains(",")) {
                img = achievementList.get(i).getPictureAddress();
                img = img.substring(0, img.indexOf(","));
                achievementList.get(i).setPictureAddress(img);
            }
        }
        model.addAttribute("achievementList", achievementList);
        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数
        return new ModelAndView("/information/userAchieveList");
    }

    //前台查询所有成果（页面显示的，审核通过的）
    @GetMapping("/selectAllAchievement")
    public ModelAndView selectAllAchievement(Model model, @RequestParam(value = "current", defaultValue = "1") int current,
                                             @RequestParam(value = "limit", defaultValue = "8") int limit) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status_code", "1");
        Page page = new Page(current, limit);
        IPage<Achievement> iPage = iAchievementService.page(page, queryWrapper);
        List<Achievement> achievementList = iPage.getRecords();
        if (achievementList == null) {
            model.addAttribute("msg", "暂无数据！");
        }
        String img;
        for (int i = 0; i < achievementList.size(); i++) {
            if (achievementList.get(i).getPictureAddress().contains(",")) {
                img = achievementList.get(i).getPictureAddress();
                img = img.substring(0, img.indexOf(","));
                achievementList.get(i).setPictureAddress(img);
            }
        }

        model.addAttribute("achievementList", achievementList);
        model.addAttribute("TotalPages", iPage.getPages());//总页数
        model.addAttribute("Number", iPage.getCurrent());//当前页数

        //所有类别
        Result result1 = iTypeService.selectAllType();
        List<Type> typeList = (List<Type>) result1.getData();
        model.addAttribute("typeList", typeList);

        return new ModelAndView("/achievement/AchievementList");
    }

    //查看成果详情页面
    @GetMapping("/achievementDetails")
    public ModelAndView achievementDetails(Model model, Integer achievementId) {
        Result result = iAchievementService.achievementDetails(achievementId);
        Achievement achievement = (Achievement) result.getData();
        achievement.setPageView(achievement.getPageView() + 1);
        iAchievementService.updateById(achievement);
        String img = achievement.getPictureAddress();
        List<String> achievementImg = null;
        //图片集合
        if(img != null){
            achievementImg = Arrays.asList(img.split(","));
        }
        System.out.println(achievementImg);
//        for (int i = 0; i < achievementImg.size(); i++) {
//            if (achievementImg.get(i).contains(",")) {
//                img = achievementImg.get(i);
//                img = img.substring(0, img.indexOf(","));
//                achievementImg.set(i,img);
//            }
//        }

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String start_time = df.format(achievement.getStartTime());
        String end_time = df.format(achievement.getStartTime());
        start_time = start_time.substring(0,10);
        end_time = end_time.substring(0,10);

        //所有类别
        Result result1 = iTypeService.selectAllType();
        List<Type> typeList = (List<Type>) result1.getData();
        model.addAttribute("typeList", typeList);
        model.addAttribute("achievementImg",achievementImg);
        model.addAttribute("achievement", achievement);
        model.addAttribute("start_time", start_time);
        model.addAttribute("end_time", end_time);
        return new ModelAndView("/achievement/achieveDetails");
    }

    //查看成果详情页面(个人中心)
    @GetMapping("/achievementUserDetails")
    public ModelAndView achievementUserDetails(Model model, Integer achievementId) {
        Result result = iAchievementService.achievementDetails(achievementId);
        Achievement achievement = (Achievement) result.getData();
        String img = achievement.getPictureAddress();
        //图片集合
        List<String> achievementImg = Arrays.asList(img.split(","));
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String start_time = df.format(achievement.getStartTime());
        String end_time = df.format(achievement.getStartTime());
        start_time = start_time.substring(0,10);
        end_time = end_time.substring(0,10);

        Result result1 = iTypeService.selectAllType();
        List<Type> typeList = (List<Type>) result1.getData();
        model.addAttribute("typeList", typeList);
        model.addAttribute("achievementImg",achievementImg);
        model.addAttribute("achievement", achievement);
        model.addAttribute("start_time", start_time);
        model.addAttribute("end_time", end_time);
        return new ModelAndView("/information/achievementUserDetails");
    }

    //按照点击量排序成果(排行榜)
    @GetMapping("/rankingAchievement")
    public ModelAndView rankingAchievement(Model model, @RequestParam(value = "current", defaultValue = "1") int current,
                                           @RequestParam(value = "limit", defaultValue = "8") int limit) {
        Result result = iAchievementService.rankingAchievement(current, limit);
        List<Achievement> achievementList = (List<Achievement>) result.getData();
        model.addAttribute("achievementList", achievementList);
        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数
        return new ModelAndView("/achievement/rankingAchievement");
    }

    //按分类查询成果
    @GetMapping("/selectAchieveByType")
    public ModelAndView selectAchieveByType(Model model, String type, @RequestParam(value = "current", defaultValue = "1") int current,
                                            @RequestParam(value = "limit", defaultValue = "8") int limit) {
        Result result = iAchievementService.selectAchieveByType(type, current, limit);
        model.addAttribute("type", type);
        //成果数据
        List<Achievement> achievementList = (List<Achievement>) result.getData();
        model.addAttribute("achievementList", achievementList);
        model.addAttribute("TotalPages", result.getPages());//总页数
        model.addAttribute("Number", result.getCurrent());//当前页数

        //所有类别
        Result result1 = iTypeService.selectAllType();
        List<Type> typeList = (List<Type>) result1.getData();
        model.addAttribute("size", typeList.size());
        return new ModelAndView("/achievement/AchievementList");
    }

}