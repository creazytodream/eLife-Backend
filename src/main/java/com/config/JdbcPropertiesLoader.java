package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import com.alibaba.druid.util.JdbcUtils;

public class JdbcPropertiesLoader implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		
		Properties prop = new Properties();
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			ConfigurableEnvironment environment = event.getEnvironment();
			String url = environment.getProperty("spring.datasource.url");
			String username = environment.getProperty("spring.datasource.username");
			String password = environment.getProperty("spring.datasource.password");
			String driverClassName = environment.getProperty("spring.datasource.driver-class-name");

			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, username, password);
			
			String sql = "select paraname, paravalue from config";

			statement = con.prepareStatement(sql);
			result = statement.executeQuery();
			
			logger.info("初始化加载数据库配置");
			while (result.next()) {
				String parameterCode = result.getString(1);
				String parameterValue = result.getString(2);
				logger.info("PARAMETER_NAME：" + parameterCode + "\t\t" + "PARAMETER_VALUE：" + parameterValue);
				prop.setProperty(parameterCode, parameterValue);
			}
			PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource("jdbc.sys.config", prop);
			environment.getPropertySources().addLast(propertiesPropertySource);
		} catch (Exception e) {
			logger.error("初始化加载数据库配置异常", e);
		} finally {
			JdbcUtils.close(result);
			JdbcUtils.close(statement);
			JdbcUtils.close(con);
		}
		
	}

}
