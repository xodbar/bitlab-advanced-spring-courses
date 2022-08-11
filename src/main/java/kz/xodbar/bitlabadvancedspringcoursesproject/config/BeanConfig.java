package kz.xodbar.bitlabadvancedspringcoursesproject.config;

import kz.xodbar.bitlabadvancedspringcoursesproject.dto.mapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public CourseMapper courseMapper() {
        return new CourseMapperImpl();
    }

}
