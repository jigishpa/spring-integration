package com.senyume.oauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author Jigish Patel
 */

@Configuration
public class OAuth2Config {
	
	@Configuration
	@EnableAuthorizationServer
	protected static class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
		
		@Override
		public void configure(ClientDetailsServiceConfigurer clientDetails) throws Exception {
			// we define two clients that can use Client Credentials Grants Flow
			clientDetails.inMemory()
							.withClient("bookstore-client")
								.authorizedGrantTypes("client_credentials")
								.authorities("ROLE_BOOKSTORE_API")
								.scopes("read,write")
								.resourceIds("client-credentials-resource")
								.secret("bookstorepasswd")
						.and()
							.withClient("tasks-client")
								.authorizedGrantTypes("client_credentials")
								.authorities("ROLE_TASKS_API")
								.scopes("read,write")
								.resourceIds("client-credentials-resource")
								.secret("taskspasswd")
						.and()
							.withClient("all-api-client")
								.authorizedGrantTypes("client_credentials")
								.authorities("ROLE_ALL_API")
								.scopes("read,write")
								.resourceIds("client-credentials-resource")
								.secret("allapipasswd");

							
			
		}
	}
	
	@Configuration
	@EnableResourceServer
	protected static class ResourceServerConfig extends ResourceServerConfigurerAdapter {
		
		@Override
		public void configure(ResourceServerSecurityConfigurer resouceServer){
			resouceServer.resourceId("client-credentials-resource");
		}
		
		@Override
		public void configure(HttpSecurity http) throws Exception{
			http
				.authorizeRequests()
					.antMatchers("/oauth/token")
						.permitAll()
					.antMatchers("/bookstore-rest-api/**")
						.hasAnyRole("BOOKSTORE_API", "ALL_API")
					.antMatchers("/tasks-rest-api/**")
						.hasAnyRole("TASKS_API", "ALL_API")
					.antMatchers("/**")
						.denyAll();
			
		}
	}
	
}
