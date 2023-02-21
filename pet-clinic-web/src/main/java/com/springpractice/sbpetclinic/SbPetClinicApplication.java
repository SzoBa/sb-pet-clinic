package com.springpractice.sbpetclinic;

import com.springpractice.sbpetclinic.configuration.DataConfig;
import com.springpractice.sbpetclinic.configuration.DataSourceConfig;
import com.springpractice.sbpetclinic.configuration.WebConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;

@Slf4j
@SpringBootApplication
public class SbPetClinicApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SbPetClinicApplication.class, args);

		ApplicationContext ctx = SpringApplication.run(SbPetClinicApplication.class, args);

		WebConfig sfgConfiguration = ctx.getBean(WebConfig.class);
		log.info(sfgConfiguration.getUsername());
		log.info(sfgConfiguration.getPassword());
		log.info(sfgConfiguration.getJdbcurl());

		DataConfig dataConfig = ctx.getBean(DataConfig.class);
		DataSourceConfig h2DataSourceConfig = dataConfig.getH2DataSourceConfig();
		log.info(dataConfig.getH2DataSourceConfig().getUsername());
		log.info(dataConfig.getH2DataSourceConfig().getPassword());
		log.info(dataConfig.getH2DataSourceConfig().getJdbcurl());
		log.info(String.valueOf(LocaleContextHolder.getLocale()));
	}

}
