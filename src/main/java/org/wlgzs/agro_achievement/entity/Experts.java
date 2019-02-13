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
public class Experts implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 专家id
     */
    @TableId(value = "experts_id", type = IdType.AUTO)
    private Integer expertsId;

    /**
     * 姓名
     */
    private String expertsName;

    /**
     * 性别
     */
    private String expertsSex;

    /**
     * 出生日期
     */
    private LocalDateTime expertsBirth;

    /**
     * 国籍
     */
    private String expertsCountry;

    /**
     * 学历
     */
    private String expertsEducation;

    /**
     * 学位
     */
    private String degree;

    /**
     * 毕业院校
     */
    private String school;

    /**
     * 所学专业
     */
    private String major;

    /**
     * 所在单位
     */
    private String unit;

    /**
     * 行政职务
     */
    private String position;

    /**
     * 专家类型id
     */
    private Integer typeId;

    /**
     * 照片地址
     */
    private String pictureAddress;

    /**
     * 研究领域
     */
    private String researchField;

    /**
     * 主要研究成果简介
     */
    private String researchAchievements;

    /**
     * 个人获奖状况
     */
    private String personalPrize;

    /**
     * 成果获奖状况
     */
    private String resultsPrize;

    /**
     * 联系方式
     */
    private String expertsPhone;

    /**
     * 邮箱
     */
    private String expertsEmail;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 审核状态码（0未审核，1通过，2失败）
     */
    private String statusCode;

    /**
     * 点击量
     */
    private Integer pageView;


}
