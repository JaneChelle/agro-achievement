package org.wlgzs.agro_achievement.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Achievement;
import org.wlgzs.agro_achievement.entity.Demand;
import org.wlgzs.agro_achievement.util.Result;
import org.wlgzs.agro_achievement.util.ResultCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
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
    public ModelAndView toAddAchievement(){
        return new ModelAndView("addAchievement");
    }

    //发布成果
    @RequestMapping(value = "/addAchievement")
    public ModelAndView addAchievement(@RequestParam("file") MultipartFile[] myFileNames, HttpSession session,
                                       HttpServletRequest request,Achievement achievement, String start_time, String end_time){
        iAchievementService.addAchievement(myFileNames,session,request,achievement,start_time,end_time);
        model.addAttribute("msg","发布成功！");
        return new ModelAndView("redirect:/achievement/selectAchievement");
    }

    //删除成果
    @RequestMapping(value = "/deleteAchievement")
    public ModelAndView deleteAchievement(Integer achievementId) {
        Result result = iAchievementService.deleteAchievement(achievementId);
        if(result.getCode() == 0){
            model.addAttribute("msg","删除成功！");
        }else{
            model.addAttribute("msg","不存在！");
        }
        return new ModelAndView("redirect:/achievement/selectAchievement");
    }

    //修改成果
    @RequestMapping(value = "/modifyAchievement", method = RequestMethod.PUT)
    public ModelAndView modifyAchievement(Achievement achievement,String start_time, String end_time) {
        Result result = iAchievementService.modifyAchievement(achievement,start_time,end_time);
        if(result.getCode() == 0){
            Achievement achievement1 = (Achievement) result.getData();
            model.addAttribute("msg","修改成功！");
            model.addAttribute("achievement",achievement1);
        }
        return new ModelAndView("111");
    }

    //查询所有成果（用户）
    @GetMapping("/selectAchievement")//分页
    public Result selectAchievement(Integer userId, String statusCode,
                               @RequestParam(value = "current", defaultValue = "1") Integer current,
                               @RequestParam(value = "limit", defaultValue = "8") Integer limit) {
        return iAchievementService.selectAchievement(userId, statusCode,current,limit);
    }

    //前台查询所有成果（页面显示的，审核通过的）
    @GetMapping("/selectAllAchievement")
    public Result selectAllAchievement(@RequestParam(value = "current", defaultValue = "1") int current,
                                  @RequestParam(value = "limit", defaultValue = "8") int limit) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status_code","1");
        Page page = new Page(current, limit);
        IPage<Achievement> iPage = iAchievementService.page(page, queryWrapper);
        List<Achievement> demandList = iPage.getRecords();
        if (demandList != null) {
            return new Result(ResultCode.SUCCESS, "",demandList, iPage.getPages(), iPage.getCurrent());
        }
        return new Result(ResultCode.FAIL, "没有数据！");
    }

    //查看成果详情页面
    @GetMapping("/achievementDetails")
    public Result achievementDetails(Integer achievementId){
        return iAchievementService.achievementDetails(achievementId);
    }

    //按照点击量排序成果
    @GetMapping("/rankingAchievement")
    public Result rankingAchievement(String ranking,@RequestParam(value = "current", defaultValue = "1") int current,
                                     @RequestParam(value = "limit", defaultValue = "8") int limit){
        return iAchievementService.rankingAchievement(current,limit);
    }

    //按分类查询成果
    @GetMapping("/selectAchieveByType")
    public Result selectAchieveByType(String type,@RequestParam(value = "current", defaultValue = "1") int current,
                                      @RequestParam(value = "limit", defaultValue = "8") int limit){
        return iAchievementService.selectAchieveByType(type,current,limit);
    }

}
