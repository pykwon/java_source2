package pack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	// 클라이언트 요청 --> 필터 + 필터 ... + DispatcherServlet
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		// 인증없이 접근 가능 요청(url)
		String[] whiteList = { 
				"/", "/notice", "/user/loginform", 
				"/user/login_fail", "/user/expired", "/shop" 
		};

		httpSecurity
			.csrf(csrf -> csrf.disable()) // csrf 사용 안하기
			.authorizeHttpRequests(config -> // 사용자 인증 설정
				config
					.requestMatchers(whiteList).permitAll()
					.requestMatchers("/admin/**").hasRole("ADMIN") // 특정 권한을 가진 사용자만 접근 허용
					.requestMatchers("/staff/**").hasAnyRole("ADMIN", "STAFF")
					.anyRequest().authenticated()
				)
			.formLogin(config -> 
			    config
			    	.loginPage("/user/required_loginform")
			    	.loginProcessingUrl("/user/login") // 시큐리티가 자동으로 로그인 처리를 해줄 요청경로 설정 
					.usernameParameter("userName") // 이때 username과 password를 알려야 함
					.passwordParameter("password")
					.successHandler(new AuthSuccessHandler()) // 로그인 성공 이후에 뭔가를 처리할 것이 있다면 핸들러를 등록해서 처리한다.
					.failureForwardUrl("/user/login_fail") // 로그인 실패시 이동할 경로 설정
					.permitAll()
				)
			.logout(config -> 
				config
					.logoutUrl("/user/logout") // 시큐리티가 자동으로 로그아웃 처리해 줄 경로 설정
					.logoutSuccessUrl("/") // 로그아웃 이후에 리다이렉트 경로 설정
					.permitAll()
				)
			.exceptionHandling(config -> // 인증 처리 중 예외가 발생했을 때 설정. 권한 확인과정에서 예외가 발생한 경우.
				config.accessDeniedPage("/user/denied") // 시큐리티는 에러인 경우 403 forbidden을 발생시킴. 이 때 이동할 경로 설정
				)
			.sessionManagement(config -> 
				config
					.maximumSessions(1) // 최대 허용 세션 갯수
					.expiredUrl("/user/expired") 
					// 허용 세션 갯수가 넘어서 로그인인 해제된 경우 리다이렉트할 경로 지정
			);

		return httpSecurity.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity httpSecurity, 
			UserDetailsService userDetailsService,
			BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception{
		AuthenticationManagerBuilder authManagerBuilder = 
				httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
		authManagerBuilder
			.userDetailsService(userDetailsService)
			.passwordEncoder(bCryptPasswordEncoder);
		
		return authManagerBuilder.build();
	}
}
