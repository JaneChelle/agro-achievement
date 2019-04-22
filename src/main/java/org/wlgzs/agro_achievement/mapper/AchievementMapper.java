package org.wlgzs.agro_achievement.mapper;

import org.apache.ibatis.annotations.Select;
import org.wlgzs.agro_achievement.entity.Achievement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 胡亚星
 * @since 2019-01-19
 */
@org.apache.ibatis.annotations.Mapper
public interface AchievementMapper extends BaseMapper<Achievement> {

    @Select("SELECT * FROM achievement ORDER BY RAND() LIMIT 5;")
    List<Achievement> hotAchievement();


}
