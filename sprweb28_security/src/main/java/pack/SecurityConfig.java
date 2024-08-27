package pack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {  // 기본적인 웹 보안 구성을 설정
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		// HttpSecurity 객체를 사용하여 보안설정 정의
		http
			.authorizeHttpRequests(authorizeRequest -> // http 요청에 대한 보안 권한 설정 부분
				authorizeRequest
					.requestMatchers("/login").permitAll()  // login 경로는 인증없이 누구든 접근 허용
					.anyRequest().authenticated()   // 나머지 요청은 인증된 경우에 접근허용
			)
			.formLogin(formLogin -> 
				formLogin
					.loginPage("/login")   // login 페이지 경로 지정
					.defaultSuccessUrl("/", true)  // 로그인 성공 시 컨텍스트 루트로 이동 
					.permitAll()    // login 페이지는 인증없이 누구든 접근 허용
			)
			.logout(logout ->
				logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login?logout")
					.permitAll()   // logout은 인증없이 누구든 접근 허용
			)
			.sessionManagement(sessionManagement -> 
				sessionManagement
					.maximumSessions(1)   // 최대 동시 세션 수를 제한
					.expiredUrl("/login?expired")  // 세션 만료시 로긴으로 이동
			);
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.builder()
							.username("kor")
							.password(passwordEncoder().encode("123"))
							.roles("USER")   // default user 역할
							.build();  // 사용자명과 비밀번호 역할 설정
		
		return new InMemoryUserDetailsManager(user); 
		// 사용자 정보를 메모리에 저장하고 관리는 클래스 
		// 주로 어플리케이션, 테스트 환경에서 사용. 영구 저장소 X
		// 어플리케이션 재시작하면 사라짐.
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();  // 비밀번호 암호화를 BCrypt 알고리즘 사용
		// 단방향 해시함수를 이용하여 암호화 수행
	}
}
