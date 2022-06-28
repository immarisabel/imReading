package nl.marisabel.imReading;

import nl.marisabel.imReading.entities.BooksEntity;
import nl.marisabel.imReading.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;

@SpringBootApplication
public class ImReadingApplication {
	@Bean
	public MessageSource messageSource() {
		final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:/messages/webapp_messages");
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(5);
		return messageSource;
	}


	public static void main(String[] args) {
		SpringApplication.run(ImReadingApplication.class, args);
	}

}
