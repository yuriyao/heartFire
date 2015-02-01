/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.footoo.heartFire.connection.pool;

import java.sql.Connection;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.footoo.common.exception.ConnectionException;
import org.footoo.heartFire.connection.config.PhysicalDataSourceConfig;

/**
 * 同构的连接池的实现
 * <p>
 * 所有的连接的配置都是同构的，所有配置信息在init之前必须都已经配置好了
 * 
 * @author fengjing.yfj
 * @version $Id: SingleConnectionPoolImpl.java, v 0.1 2015年2月1日 下午10:08:01 fengjing.yfj Exp $
 */
public class SingleConnectionPoolImpl extends AbstractConnectionPool {

    /** 物理数据源的配置 */
    private PhysicalDataSourceConfig physicalDataSourceConfig;

    /** 初始的连接的数量 */
    private int                      initSize;

    /** 锁 */
    private Lock                     lock  = new ReentrantLock();

    /** 连接池为空的情况 */
    private Condition                empty = lock.newCondition();

    /** 连接池已经满的情况 */
    private Condition                full  = lock.newCondition();

    /** 已经使用的连接的数量 */
    private int                      inUseNumber;

    /** 缓存的连接数量 */
    private int                      cacheNumber;

    /** 等待的线程的数量 */
    private int                      waitThreadNumber;

    /** 
     * @see org.footoo.heartFire.connection.pool.ConnectionPool#init()
     */
    @Override
    public void init() throws ConnectionException {
        inited = true;
    }

    /** 
     * 这里的配置是没有用的
     * <p>
     * 所以直接可以传入null
     * 
     * @see org.footoo.heartFire.connection.pool.ConnectionPool#getConnection(org.footoo.heartFire.connection.config.PhysicalDataSourceConfig)
     */
    @Override
    public Connection getConnection(PhysicalDataSourceConfig dataSourceConfig)
                                                                              throws ConnectionException {
        return getConnection(dataSourceConfig, -1L);
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

}
