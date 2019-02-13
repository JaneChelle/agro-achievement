package org.wlgzs.agro_achievement.entity;

import java.math.BigDecimal;
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
public class Demand implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 需求id
     */
    @TableId(value = "demand_id", type = IdType.AUTO)
    private Integer demandId;

    /**
     * 需求名字
     */
    private String demandName;

    /**
     * 预期价格
     */
    private BigDecimal expectedPrice;

    /**
     * 需求者（个人或机构）
     */
    private String demanders;

    /**
     * 需求说明
     */
    private String demandIntroduce;

    /**
     * 发布时间
     */
    private LocalDateTime releaseTime;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 点击量
     */
    private Integer pageView;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 机构id
     */
    private Integer organizationTypeId;

    /**
     * 审核状态码（0未审核，1通过，2失败）
     */
    private String statusCode;


}
