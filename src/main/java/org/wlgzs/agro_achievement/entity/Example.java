package org.wlgzs.agro_achievement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class Example implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 案例id
     */
    @TableId(value = "example_id", type = IdType.AUTO)
    private Integer exampleId;

    /**
     * 案例标题
     */
    private String exampleTitle;

    /**
     * 案例内容
     */
    private String exampleContent;

    /**
     * 发布时间
     */
    private LocalDateTime releaseTime;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 审核状态码（0未审核，1通过，2失败）
     */
    private String statusCode;

}
