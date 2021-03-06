package lok.tar.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author frank
 * @date 2019-05-07 17:35
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeRequests()
                .antMatchers("/noauth/**").permitAll()
                .antMatchers("/users/create").permitAll()

                // 为 Swagger2 增加规则 TODO 这种方式不是最优秀的，是否可以通过其他方式解决？
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/v2/api-docs").permitAll()

                .anyRequest().authenticated()
                .and()
                .csrf().disable()
        ;
        // @formatter:on
    }

}
