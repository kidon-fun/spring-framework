package fun.kidon.config;

import fun.kidon.bean.Panda;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qinqidong
 */
@Configuration
public class BeanConfig {

	@Bean
	public Panda panda(){
		return new Panda(1,"qidong");
	}
}
