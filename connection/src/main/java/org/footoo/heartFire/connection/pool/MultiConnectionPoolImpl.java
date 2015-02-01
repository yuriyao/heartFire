/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.footoo.heartFire.connection.pool;

import java.sql.Connection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.footoo.common.exception.ConnectionException;
import org.footoo.heartFire.connection.config.PhysicalDataSourceConfig;
import org.footoo.heartFire.connection.ds.HeartFireDataSource;

/**
 * 多配置的连接池的实现
 * <p>
 * 这里面的连接的配置是不同构的，对应的SingleConnectionPoolImpl中所有的连接是同构的
 * 
 * @author fengjing.yfj
 * @version $Id: DefaultConnectionPoolImpl.java, v 0.1 2015年1月27日 下午10:39:37 fengjing.yfj Exp $
 */
public class MultiConnectionPoolImpl extends AbstractConnectionPool {

    /** 数据源的信息 */
    private HeartFireDataSource                                    heartFireDataSource;

    /** 是否已经初始化完毕 */
    private boolean                                                inited                = false;

    /** 物理数据源配置到连接的Holer的映射 */
    private Map<PhysicalDataSourceConfig, PhysicalConnectionHoler> physicalConnectionMap = new ConcurrentHashMap<PhysicalDataSourceConfig, MultiConnectionPoolImpl.PhysicalConnectionHoler>();

    /** 并发锁 */
    private Lock                                                   lock                  = new ReentrantLock();

    /**
     * 默认的构造函数
     */
    public MultiConnectionPoolImpl() {
    }

    /** 
     * @see org.footoo.heartFire.connection.pool.ConnectionPool#init()
     */
    @Override
    public void init() throws ConnectionException {
    }

    /** 
     * @see org.footoo.heartFire.connection.pool.ConnectionPool#getConnection()
     */
    @Override
    public Connection getConnection(PhysicalDataSourceConfig dataSourceConfig)
                                                                              throws ConnectionException {
        return null;
    }

    /** 
     * @see org.footoo.heartFire.connection.pool.ConnectionPool#getConnection(org.footoo.heartFire.connection.config.PhysicalDataSourceConfig, long)
     */
    @Override
    public Connection getConnection(PhysicalDataSourceConfig dataSourceConfig, long timeout)
                                                                                            throws ConnectionException {
        return null;
    }

    /** 
     * @see org.footoo.heartFire.connection.pool.ConnectionPool#close()
     */
    @Override
    public void close() throws ConnectionException {
    }

    /** 
     * @see org.footoo.heartFire.connection.pool.ConnectionPool#setMaxActive(int)
     */
    @Override
    public void setMaxActive(int max) {
    }

    /** 
     * @see org.footoo.heartFire.connection.pool.ConnectionPool#setMinIdle(int)
     */
    @Override
    public void setMinIdle(int minIdle) {
    }

    /**
     * 物理连接的hodler
     * 
     * @author fengjing.yfj
     * @version $Id: DefaultConnectionPoolImpl.java, v 0.1 2015年2月1日 下午8:59:37 fengjing.yfj Exp $
     */
    public static class PhysicalConnectionHoler {
        /** 实际的物理连接 */
        private Connection               physicalConnection;

        /** 本物理数据连接对应的数据源配置 */
        private PhysicalDataSourceConfig physicalDataSourceConfig;

        /**
         * Getter method for property <tt>physicalConnection</tt>.
         * 
         * @return property value of physicalConnection
         */
        public Connection getPhysicalConnection() {
            return physicalConnection;
        }

        /**
         * Setter method for property <tt>physicalConnection</tt>.
         * 
         * @param physicalConnection value to be assigned to property physicalConnection
         */
        public void setPhysicalConnection(Connection physicalConnection) {
            this.physicalConnection = physicalConnection;
        }

        /**
         * Getter method for property <tt>physicalDataSourceConfig</tt>.
         * 
         * @return property value of physicalDataSourceConfig
         */
        public PhysicalDataSourceConfig getPhysicalDataSourceConfig() {
            return physicalDataSourceConfig;
        }

        /**
         * Setter method for property <tt>physicalDataSourceConfig</tt>.
         * 
         * @param physicalDataSourceConfig value to be assigned to property physicalDataSourceConfig
         */
        public void setPhysicalDataSourceConfig(PhysicalDataSourceConfig physicalDataSourceConfig) {
            this.physicalDataSourceConfig = physicalDataSourceConfig;
        }

    }

}
