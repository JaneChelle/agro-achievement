package org.wlgzs.agro_achievement.controller.admin;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wlgzs.agro_achievement.base.BaseController;
import org.wlgzs.agro_achievement.entity.Type;
import org.wlgzs.agro_achievement.util.Result;

/**
 * <p>
 *  前端控制器
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
    @RequestMapping(value = "/addType",method = RequestMethod.PUT)
    public Result addType(Type type){
            return iTypeService.addType(type);
    }

    //删除类型
    @RequestMapping(value = "/deleteType", method = RequestMethod.DELETE)
    public Result deleteTyped(Integer typeId) {
        return iTypeService.deleteType(typeId);
    }

    //查找所有类型
    @GetMapping("/selectAllType")
    public Result selectAllType(){
        return iTypeService.selectAllType();
    }

}
