/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.footoo.heartFire.connection.pool;

import java.sql.Connection;

import org.footoo.common.exception.ConnectionException;
import org.footoo.heartFire.connection.config.PhysicalDataSourceConfig;

/**
 * 连接池
 * <p>
 * 管理所有的连接
 * 
 * @author fengjing.yfj
 * @version $Id: ConnectionPool.java, v 0.1 2015年1月27日 下午9:41:53 fengjing.yfj Exp $
 */
public interface ConnectionPool {

    /**
     * 进行初始化
     * <p>
     * 初始化结束以后，不能再修改连接的配置信息（连接池的大小除外）
     * 
     * @throws ConnectionException 连接异常
     */
    public void init() throws ConnectionException;

    /**
     * 获取连接
     * 
     * @param dataSourceConfig 物理数据源的配置信息
     * @return 返回连接
     * @throws ConnectionException 连接异常
     */
    public Connection getConnection(PhysicalDataSourceConfig dataSourceConfig)
                                                                              throws ConnectionException;

    /**
     * 获取连接
     * <p>
     * timeout 毫秒的超时时间
     * 
     * @param dataSourceConfig 物理数据源的配置信息
     * @param timeout 超时时间(单位毫秒)
     * @return 获取到的连接
     * @throws ConnectionException 连接异常
     */
    public Connection getConnection(PhysicalDataSourceConfig dataSourceConfig, long timeout)
                                                                                            throws ConnectionException;

    /**
     * 关闭连接池
     * 
     * @throws ConnectionException 连接异常
     */
    public void close() throws ConnectionException;

    /**
     * 设置最大的连接数
     * <p>
     * 及时连接池初始化完毕，也可以进行连接池大小的调整
     * 
     * @param max 连接池的最大值
     */
    public void setMaxActive(int max);

    /**
     * 设置连接池的最小大小
     * 
     * @param minIdle 最小的连接池的大小
     */
    public void setMinIdle(int minIdle);
}
