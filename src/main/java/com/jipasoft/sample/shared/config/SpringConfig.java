package com.jipasoft.sample.shared.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.jipasoft.sample.server.controller" })
public class SpringConfig extends WebMvcConfigurerAdapter {
	private final Logger log = Logger.getLogger(this.getClass());

	@Bean
	public JasperReportsViewResolver getJasperReportsViewResolver() {
		final JasperReportsViewResolver reportResolver = new JasperReportsViewResolver();
		reportResolver.setPrefix("classpath:/reports/");
		reportResolver.setSuffix(".jasper");
		reportResolver.setReportDataKey("datasource");
		reportResolver.setViewNames(new String[] { "rpt_*" });
		reportResolver.setViewClass(JasperReportsMultiFormatView.class);
		reportResolver.setOrder(0);

		log.info("JasperReportsViewResolver initialized");
		return reportResolver;
	}
}
