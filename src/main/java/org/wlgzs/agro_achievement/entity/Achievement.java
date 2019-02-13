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
public class Achievement implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号id
     */
    @TableId(value = "achievement_id", type = IdType.AUTO)
    private Integer achievementId;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 成果名称
     */
    private String achievementName;

    /**
     * 成果简介
     */
    private String achievementIntroduce;

    /**
     * 成果关键词
     */
    private String achievementKey;

    /**
     * 研发开始时间
     */
    private LocalDateTime startTime;

    /**
     * 研发结束时间
     */
    private LocalDateTime endTime;

    /**
     * 成品图片展示（1到3张）
     */
    private String pictureAddress;

    /**
     * 获奖情况
     */
    private String awards;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 手机
     */
    private String cellNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系地址
     */
    private String contactAddress;

    /**
     * 知识产权编号
     */
    private String propertyNumber;

    /**
     * 知识产权说明
     */
    private String propertyIntroduce;

    /**
     * 产权归属者
     */
    private String propertyMan;

    /**
     * 产权归属地
     */
    private String propertyAddress;

    /**
     * 预期交易价格（万元）
     */
    private String expectedPrice;

    /**
     * 发布时间
     */
    private LocalDateTime releaseTime;

    /**
     * 点击量
     */
    private Integer pageView;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 审核状态码（0未审核，1通过，2失败）
     */
    private String statusCode;


}
