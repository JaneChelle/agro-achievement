package org.wlgzs.agro_achievement.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:胡亚星
 * @createTime 2018-05-12 11:30
 * @description:
 **/
@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean filterDemoRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //注入过滤器
        registration.setFilter(new AdminFilter());
        //拦截规则
        registration.addUrlPatterns("/admin/*");
        //过滤器名称
        registration.setName("AdminFilter");
        //是否自动注册 false 取消Filter的自动注册
        registration.setEnabled(true);
        //过滤器顺序
        registration.setOrder(Integer.MAX_VALUE - 1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean filterLoginRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //注入过滤器
        registration.setFilter(new LoginFilter());
        //拦截规则
        registration.addUrlPatterns("/achievement/toAddAchievement");
        registration.addUrlPatterns("/achievement/addAchievement");
        registration.addUrlPatterns("/achievement/deleteAchievement");
        registration.addUrlPatterns("/achievement/modifyAchievement");
        registration.addUrlPatterns("/achievement/selectAchievement");
        registration.addUrlPatterns("/achievement/achievementUserDetails");

        registration.addUrlPatterns("/demand/toAddDemand");
        registration.addUrlPatterns("/demand/addDemand");
        registration.addUrlPatterns("/demand/deleteDemand");
        registration.addUrlPatterns("/demand/modifyDemand");
        registration.addUrlPatterns("/demand/selectDemand");
        registration.addUrlPatterns("/demand/demandUserDetails");

        registration.addUrlPatterns("/example/*");
        registration.addUrlPatterns("/UserManagement/toUserManagement");
        registration.addUrlPatterns("/UserManagement/toModifyUser");
        registration.addUrlPatterns("/UserManagement/toChangePassword");
        registration.addUrlPatterns("/UserManagement/changePassword");
        registration.addUrlPatterns("/UserManagement/changeInformation");
        registration.addUrlPatterns("/experts/*");
        registration.addUrlPatterns("/organization/*");
        //过滤器名称
        registration.setName("LoginFilter");
        //是否自动注册 false 取消Filter的自动注册
        registration.setEnabled(true);
        //过滤器顺序
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }

}