package org.wlgzs.agro_achievement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 胡亚星
 * @since 2019-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AchievementType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关联id
     */
    @TableId(value = "achievement_type_id", type = IdType.AUTO)
    private Integer achievementTypeId;

    /**
     * 成果编号id
     */
    private Integer achievementId;

    /**
     * 类型id
     */
    private Integer typeId;


}
