package com.springpractice.sbpetclinic;

import com.springpractice.sbpetclinic.configuration.DataConfig;
import com.springpractice.sbpetclinic.configuration.DataSourceConfig;
import com.springpractice.sbpetclinic.configuration.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SbPetClinicApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SbPetClinicApplication.class, args);

		ApplicationContext ctx = SpringApplication.run(SbPetClinicApplication.class, args);

		WebConfig sfgConfiguration = ctx.getBean(WebConfig.class);
		System.out.println(sfgConfiguration.getUsername());
		System.out.println(sfgConfiguration.getPassword());
		System.out.println(sfgConfiguration.getJdbcurl());

		DataConfig dataConfig = ctx.getBean(DataConfig.class);
		DataSourceConfig h2DataSourceConfig = dataConfig.getH2DataSourceConfig();
		System.out.println(dataConfig.getH2DataSourceConfig().getUsername());
		System.out.println(dataConfig.getH2DataSourceConfig().getPassword());
		System.out.println(dataConfig.getH2DataSourceConfig().getJdbcurl());
	}

}
