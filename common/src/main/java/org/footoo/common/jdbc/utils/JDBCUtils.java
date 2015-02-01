/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.footoo.common.jdbc.utils;

import java.sql.Driver;

import org.footoo.common.exception.HeartFireCommonException;

/**
 * jdbc的工具类
 * 
 * @author fengjing.yfj
 * @version $Id: JDBCUtils.java, v 0.1 2015年2月1日 下午9:16:21 fengjing.yfj Exp $
 */
public class JDBCUtils {
    /**
     * 加载JDBC的驱动
     * 
     * @param driverClassName 驱动的类名
     * @param classLoader 类加载器
     * @return JDBC的驱动的类的实例
     */
    @SuppressWarnings("unchecked")
    public static Class<Driver> loadJDBCDriver(String driverClassName, ClassLoader classLoader)
                                                                                               throws HeartFireCommonException {
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }

        try {
            Class<?> driver = Class.forName(driverClassName, true, classLoader);

            if (Driver.class.isAssignableFrom(driver)) {
                return (Class<Driver>) driver;
            } else {
                throw new HeartFireCommonException("[" + driverClassName
                                                   + "]不是[java.sql.Driver]的实例", null, null);
            }
        } catch (ClassNotFoundException e) {
            throw new HeartFireCommonException("无法加载类[" + driverClassName + "]", e);
        }

    }

    /**
     * 根据JDBC连接的url来加载所需要的驱动
     * <p>
     * 系统能够自动识别
     * 
     * @param url jdbc连接的url
     * @param classLoader 类加载器
     * @return 驱动信息
     */
    public static Class<Driver> loadJDBCDriverByUrl(String url, ClassLoader classLoader) {
        return loadJDBCDriver(getDriverClassByUrl(url), classLoader);
    }

    /**
     * 根据url获取实际的db的驱动的类名
     * <p>
     * 这些数据来源于{@link druid}
     * 
     * @param url jdbc的连接的地址
     * @return 连接所对应的db的驱动类名
     */
    public static String getDriverClassByUrl(String url) {
        if (url.startsWith("jdbc:derby:")) {
            return "org.apache.derby.jdbc.EmbeddedDriver";
        } else if (url.startsWith("jdbc:mysql:")) {
            return "com.mysql.jdbc.Driver";
        } else if (url.startsWith("jdbc:log4jdbc:")) {
            return "net.sf.log4jdbc.DriverSpy";
        } else if (url.startsWith("jdbc:mariadb:")) {
            return "org.mariadb.jdbc.Driver";
        } else if (url.startsWith("jdbc:oracle:") //
                   || url.startsWith("JDBC:oracle:")) {
            return "oracle.jdbc.driver.OracleDriver";
        } else if (url.startsWith("jdbc:alibaba:oracle:")) {
            return "com.alibaba.jdbc.AlibabaDriver";
        } else if (url.startsWith("jdbc:microsoft:")) {
            return "com.microsoft.jdbc.sqlserver.SQLServerDriver";
        } else if (url.startsWith("jdbc:sqlserver:")) {
            return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        } else if (url.startsWith("jdbc:sybase:Tds:")) {
            return "com.sybase.jdbc2.jdbc.SybDriver";
        } else if (url.startsWith("jdbc:jtds:")) {
            return "net.sourceforge.jtds.jdbc.Driver";
        } else if (url.startsWith("jdbc:fake:") || url.startsWith("jdbc:mock:")) {
            return "com.alibaba.druid.mock.MockDriver";
        } else if (url.startsWith("jdbc:postgresql:")) {
            return "org.postgresql.Driver";
        } else if (url.startsWith("jdbc:hsqldb:")) {
            return "org.hsqldb.jdbcDriver";
        } else if (url.startsWith("jdbc:db2:")) {
            return "COM.ibm.db2.jdbc.app.DB2Driver";
        } else if (url.startsWith("jdbc:sqlite:")) {
            return "org.sqlite.JDBC";
        } else if (url.startsWith("jdbc:ingres:")) {
            return "com.ingres.jdbc.IngresDriver";
        } else if (url.startsWith("jdbc:h2:")) {
            return "org.h2.Driver";
        } else if (url.startsWith("jdbc:mckoi:")) {
            return "com.mckoi.JDBCDriver";
        } else if (url.startsWith("jdbc:cloudscape:")) {
            return "COM.cloudscape.core.JDBCDriver";
        } else if (url.startsWith("jdbc:informix-sqli:")) {
            return "com.informix.jdbc.IfxDriver";
        } else if (url.startsWith("jdbc:timesten:")) {
            return "com.timesten.jdbc.TimesTenDriver";
        } else if (url.startsWith("jdbc:as400:")) {
            return "com.ibm.as400.access.AS400JDBCDriver";
        } else if (url.startsWith("jdbc:sapdb:")) {
            return "com.sap.dbtech.jdbc.DriverSapDB";
        } else if (url.startsWith("jdbc:JSQLConnect:")) {
            return "com.jnetdirect.jsql.JSQLDriver";
        } else if (url.startsWith("jdbc:JTurbo:")) {
            return "com.newatlanta.jturbo.driver.Driver";
        } else if (url.startsWith("jdbc:firebirdsql:")) {
            return "org.firebirdsql.jdbc.FBDriver";
        } else if (url.startsWith("jdbc:interbase:")) {
            return "interbase.interclient.Driver";
        } else if (url.startsWith("jdbc:pointbase:")) {
            return "com.pointbase.jdbc.jdbcUniversalDriver";
        } else if (url.startsWith("jdbc:edbc:")) {
            return "ca.edbc.jdbc.EdbcDriver";
        } else if (url.startsWith("jdbc:mimer:multi1:")) {
            return "com.mimer.jdbc.Driver";
        } else if (url.startsWith("jdbc:dm:")) {
            return "dm.jdbc.driver.DmDriver";
        } else if (url.startsWith("jdbc:kingbase:")) {
            return "com.kingbase.Driver";
        } else {
            throw new HeartFireCommonException("无法识别的jdbc连接: " + url, null, null);
        }
    }
}
