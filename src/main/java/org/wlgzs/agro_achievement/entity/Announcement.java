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
public class Announcement implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公告id
     */
    @TableId(value = "announcement_id", type = IdType.AUTO)
    private Integer announcementId;

    /**
     * 公告标题
     */
    private String announcementTitle;

    /**
     * 公告内容
     */
    private String announcementContent;

    /**
     * 发布时间
     */
    private LocalDateTime releaseTime;

    /**
     * 公告类型（新闻中心，交易活动，政策中心）
     */
    private String announcementType;

    /**
     * 是否显示(1显示，0不显示)
     */
    private Integer isShow;
}
