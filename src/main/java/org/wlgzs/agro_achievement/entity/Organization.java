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
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 机构id
     */
    @TableId(value = "organization_id", type = IdType.AUTO)
    private Integer organizationId;

    /**
     * 机构名称
     */
    private String organizationName;

    /**
     * 所在国家
     */
    private String organizationCountry;

    /**
     * 所在地区
     */
    private String organizationRegion;

    /**
     * 法人类别
     */
    private String legalCategory;

    /**
     * 机构简介
     */
    private String organizationIntroduce;

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
     * 网址
     */
    private String organizationUrl;

    /**
     * 地址
     */
    private String contactAddress;

    /**
     * （对应）成果id
     */
    private Integer achievementId;

    /**
     * 机构类型id
     */
    private Integer organizationTypeId;
}
