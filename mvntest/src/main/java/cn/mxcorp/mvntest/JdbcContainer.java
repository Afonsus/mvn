package cn.mxcorp.mvntest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * User: landy Date: 15/2/7 Time: 上午9:45
 */
@Service
public class JdbcContainer implements ApplicationContextAware, DisposableBean {
	private Map<String, DataSource> dataSourceMap = Maps.newConcurrentMap();
	private ArrayList<DataSourceProps> dataSourceProps;

	public void destroy() throws Exception {
		for (DataSource ds : dataSourceMap.values()) {
			try {
				if (ds instanceof DruidDataSource) {
					((DruidDataSource) ds).close();
				}
			} catch (Throwable e) {

			}
		}
	}

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(
			String serverName, DatabaseType type) {
		return new NamedParameterJdbcTemplate(getDataSource(serverName, type));
	}

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(
			String serverName) {
		return getNamedParameterJdbcTemplate(serverName, DatabaseType.Logs);
	}

	public JdbcTemplate getJdbcTemplate(String serverName, DatabaseType type) {
		return new JdbcTemplate(getDataSource(serverName, type));
	}

	public JdbcTemplate getJdbcTemplate(String serverName) {
		return getJdbcTemplate(serverName, DatabaseType.Logs);
	}

	private DataSource getDataSource(String serverName, DatabaseType type) {
		String url = getJdbcUrl(serverName, type);
		if (StringUtils.hasText(url)) {
			if (dataSourceMap.containsKey(url)) {
				return dataSourceMap.get(url);
			}
		}
		throw new IllegalArgumentException("Can't found database info for ["
				+ serverName + ":" + type.name() + "] or the info is disabled!");
	}

	private String getJdbcUrl(String serverName, DatabaseType type) {
		for (DataSourceProps one : this.dataSourceProps) {
			if (one.getServer().getServerName().equalsIgnoreCase(serverName)
					&& one.getDatabaseType().equals(type)) {
				return one.getUrl();
			}
		}
		return null;
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		Map<String, DataSourceProps> beans = applicationContext
				.getBeansOfType(DataSourceProps.class);
		initDataSource(beans.values());
	}

	private void initDataSource(Collection<DataSourceProps> values) {
		this.dataSourceProps = Lists.newArrayList(values);
		for (DataSourceProps one : values) {
			if (one.isEnable() && !dataSourceMap.containsKey(one.getUrl())) {
				try {
					DruidDataSource ds = new DruidDataSource();
					ds.setDriverClassName(one.getDriverClass());
					ds.setUrl(one.getUrl());
					ds.setUsername(one.getUserName());
					ds.setPassword(one.getPassWord());
					ds.setQueryTimeout(120);
					ds.setMaxActive(3);
					ds.setInitialSize(2);

					DruidPooledConnection connection = ds.getConnection();
					connection.checkState();
					connection.close();

					dataSourceMap.put(one.getUrl(), ds);
					LoggerFactory.getLogger(JdbcContainer.class).info(
							"init datasource : "
									+ one.getServer().getServerName() + ","
									+ one.getDatabaseType());
				} catch (SQLException e) {
					throw new IllegalArgumentException(
							"init datasource error !"
									+ one.getServer().getServerName() + ","
									+ one.getDatabaseType(), e);
				}
			}
		}
	}
}
