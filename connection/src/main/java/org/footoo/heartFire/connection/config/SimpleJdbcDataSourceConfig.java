/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.footoo.heartFire.connection.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.footoo.common.exception.HeartFireCommonException;
import org.footoo.common.jdbc.utils.JDBCUtils;

/**
 * 简单的jdbc的物理数据源的配置
 * 
 * @author fengjing.yfj
 * @version $Id: SimpleJdbcDataSourceConfig.java, v 0.1 2015年2月1日 下午9:10:47 fengjing.yfj Exp $
 */
public class SimpleJdbcDataSourceConfig implements PhysicalDataSourceConfig {

    /** 序列号 */
    private static final long serialVersionUID = -7435273359650947521L;

    /** jdbc的驱动类 */
    private String            jdbcClassName;

    /** jdbc的url */
    private String            url;

    /** jdbc的配置信息，用户名和密码等信息 */
    private Properties        jdbcProperties   = new Properties();

    /** 
     * @see org.footoo.heartFire.connection.config.PhysicalDataSourceConfig#getConnection()
     */
    @Override
    public Connection getConnection() {

        //加载驱动
        if (!StringUtils.isBlank(jdbcClassName)) {
            JDBCUtils.loadJDBCDriver(jdbcClassName, null);
        } else if (!StringUtils.isBlank(url)) {
            JDBCUtils.loadJDBCDriverByUrl(url, null);
        } else {
            throw new HeartFireCommonException("jdbc连接地址和jdbc的驱动名都为空，无法加载驱动", null);
        }

        try {
            return DriverManager.getConnection(url, jdbcProperties);
        } catch (Exception e) {
            throw new HeartFireCommonException("获取[" + url + "]的连接失败", e);
        }
    }

    /**
     * 设置用户名
     * 
     * @param userName 物理连接的用户名
     */
    public void setUserName(String userName) {
        setProperty("user", userName);
    }

    /**
     * 获取用户名
     * 
     * @return 用户名
     */
    public String getUserName() {
        return getProperty("user");
    }

    /**
     * 设置密码
     * 
     * @param password 密码
     */
    public void setPassword(String password) {
        setProperty("password", password);
    }

    /**
     * 获取密码
     * 
     * @return 密码
     */
    public String getPassword() {
        return getProperty("password");
    }

    /**
     * 设置jdbc的属性
     * 
     * @param key 属性的key
     * @param value 属性的value
     */
    public void setProperty(String key, String value) {
        if (jdbcProperties == null) {
            jdbcProperties = new Properties();
        }
        this.jdbcProperties.put(key, value);
    }

    /**
     * 获取<code>key</code>对应的jdbc的属性值
     * 
     * @param key properties的key
     * @return key对应的jdbc的属性的value
     */
    public String getProperty(String key) {
        if (jdbcProperties == null) {
            return null;
        }
        return jdbcProperties.getProperty(key);
    }

    /**
     * Getter method for property <tt>jdbcClassName</tt>.
     * 
     * @return property value of jdbcClassName
     */
    public String getJdbcClassName() {
        return jdbcClassName;
    }

    /**
     * Setter method for property <tt>jdbcClassName</tt>.
     * 
     * @param jdbcClassName value to be assigned to property jdbcClassName
     */
    public void setJdbcClassName(String jdbcClassName) {
        this.jdbcClassName = jdbcClassName;
    }

    /**
     * Getter method for property <tt>url</tt>.
     * 
     * @return property value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter method for property <tt>url</tt>.
     * 
     * @param url value to be assigned to property url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Getter method for property <tt>jdbcProperties</tt>.
     * 
     * @return property value of jdbcProperties
     */
    public Properties getJdbcProperties() {
        return jdbcProperties;
    }

    /**
     * Setter method for property <tt>jdbcProperties</tt>.
     * 
     * @param jdbcProperties value to be assigned to property jdbcProperties
     */
    public void setJdbcProperties(Properties jdbcProperties) {
        this.jdbcProperties = jdbcProperties;
    }

}
