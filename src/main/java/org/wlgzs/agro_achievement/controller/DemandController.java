package org.wlgzs.agro_achievement.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Demand;
import org.wlgzs.agro_achievement.util.Result;
import org.wlgzs.agro_achievement.util.ResultCode;

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
    public ModelAndView toAddDemand() {
        return new ModelAndView("addDemand");
    }

    //发布一个新需求
    @RequestMapping(value = "/addDemand")
    public ModelAndView addDemand(Demand demand) {
        iDemandService.addDemand(demand);
        return new ModelAndView("redirect:/demand/selectDemand");
    }

    //删除一个需求
    @RequestMapping(value = "/deleteDemand", method = RequestMethod.DELETE)
    public Result deleteDemand(Integer demandId) {
        return iDemandService.deleteDemand(demandId);
    }

    //修改需求
    @RequestMapping(value = "/modifyDemand", method = RequestMethod.PUT)
    public Result modifyDemand(Demand demand) {
        return iDemandService.modifyDemand(demand);
    }

    //按照用户查询所有需求（状态码）(用户自身操作)
    @GetMapping("/selectDemand")//分页
    public Result selectDemand(Integer userId, String statusCode,
                               @RequestParam(value = "current", defaultValue = "1") Integer current,
                               @RequestParam(value = "limit", defaultValue = "8") Integer limit) {
        return iDemandService.selectDemand(userId, statusCode, current, limit);
    }

    //前台查询所有需求（页面显示的，审核通过的）
    @GetMapping("/selectAllDemand")
    public Result selectAllDemand(@RequestParam(value = "current", defaultValue = "1") int current,
                                  @RequestParam(value = "limit", defaultValue = "8") int limit) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status_code", "1");
        Page page = new Page(current, limit);
        IPage<Demand> iPage = iDemandService.page(page, queryWrapper);
        List<Demand> demandList = iPage.getRecords();
        if (demandList != null) {
            return new Result(ResultCode.SUCCESS, "", demandList, iPage.getPages(), iPage.getCurrent());
        }
        return new Result(ResultCode.FAIL, "没有数据！");
    }

    //查看需求详情页面
    @GetMapping("/demandDetails")
    public Result demandDetails(Integer demandId) {
        return iDemandService.demandDetails(demandId);
    }

}
