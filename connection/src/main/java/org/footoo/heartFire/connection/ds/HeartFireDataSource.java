/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.footoo.heartFire.connection.ds;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * 核心的dataSource
 * 
 * @author fengjing.yfj
 * @version $Id: HeartFireDataSource.java, v 0.1 2015年1月29日 下午11:25:55 fengjing.yfj Exp $
 */
public class HeartFireDataSource implements DataSource {

    /** 数据源的驱动的类 */
    private String     driverClassName;

    /** jdbc的url */
    private String     url;

    /** db的属性 */
    private Properties jdbcProperties;

    /** 初始化的连接的数量 */
    private int        initialSize;

    /** 最小的连接的数量 */
    private int        minIdle;

    /** 最大的连接的数量 */
    private int        maxActive;

    /////下面的字段，不能注入
    /** 物理数据源 */
    private DataSource physicalDataSource;

    /**
     * 
     */
    public HeartFireDataSource() {
    }

    /**
     * 数据源进行初始化
     */
    public void init() {
        configCheck();
    }

    /** 
     * @see javax.sql.CommonDataSource#getLogWriter()
     */
    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    /** 
     * @see javax.sql.CommonDataSource#setLogWriter(java.io.PrintWriter)
     */
    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
    }

    /** 
     * @see javax.sql.CommonDataSource#setLoginTimeout(int)
     */
    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
    }

    /** 
     * @see javax.sql.CommonDataSource#getLoginTimeout()
     */
    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    /** 
     * @see javax.sql.CommonDataSource#getParentLogger()
     */
    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    /** 
     * @see java.sql.Wrapper#unwrap(java.lang.Class)
     */
    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    /** 
     * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
     */
    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    /** 
     * @see javax.sql.DataSource#getConnection()
     */
    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }

    /** 
     * @see javax.sql.DataSource#getConnection(java.lang.String, java.lang.String)
     */
    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    /**
     * 配置校验
     */
    private void configCheck() {

    }

}
