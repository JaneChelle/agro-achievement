package org.wlgzs.agro_achievement.controller.admin;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Type;
import org.wlgzs.agro_achievement.util.Result;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 胡亚星
 * @since 2019-01-19
 * 成果类型
 */
@RestController
@RequestMapping("/admin")
public class TypeController extends BaseController {

    //增加类型
    @RequestMapping(value = "/addType")
    public ModelAndView addType(Model model,Type type) {
        Result result = iTypeService.addType(type);
        model.addAttribute("msg",result.getMsg());
        return new ModelAndView("redirect:/admin/selectAllType");
    }

    //删除类型
    @RequestMapping(value = "/deleteType", method = RequestMethod.DELETE)
    public ModelAndView deleteTyped(Model model,Integer typeId) {
        Result result = iTypeService.deleteType(typeId);
        model.addAttribute("msg",result.getMsg());
        return new ModelAndView("redirect:/admin/selectAllType");
    }

    //查找所有类型
    @GetMapping("/selectAllType")
    public ModelAndView selectAllType(Model model) {
        Result result = iTypeService.selectAllType();
        model.addAttribute("typeList",result.getData());
        return new ModelAndView("admin/typeList");
    }

}
