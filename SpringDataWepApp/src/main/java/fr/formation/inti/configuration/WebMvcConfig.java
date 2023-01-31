package fr.formation.inti.configuration;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebMvc
public class WebMvcConfig {
	private static final Charset UTF8 = Charset.forName("UTF-8");

	   // Config UTF-8 Encoding.
	   public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	       StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
	       stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain", UTF8)));
	       converters.add(stringConverter);

	       // Add other converters ...
	   }

	   // Static Resource Config
	   // equivalents for <mvc:resources/> tags
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {
	       registry.addResourceHandler("/CSS/**").addResourceLocations("/CSS/").setCachePeriod(31556926);
	       registry.addResourceHandler("/resources/img/**").addResourceLocations("/resources/img/").setCachePeriod(31556926);
	       registry.addResourceHandler("/resources/script/**").addResourceLocations("/resources/script/").setCachePeriod(31556926);
	   }
	   
//	   public void addResourceHandlers(ResourceHandlerRegistry registry) {
//			registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//		}

	   // Equivalent for <mvc:default-servlet-handler/> tag
	   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	       configurer.enable();
	   }

}
