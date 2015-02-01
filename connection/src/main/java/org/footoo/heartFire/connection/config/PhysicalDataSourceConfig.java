/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.footoo.heartFire.connection.config;

import java.io.Serializable;
import java.sql.Connection;

/**
 * 物理数据源的配置信息
 * 
 * @author fengjing.yfj
 * @version $Id: DataSourceConfig.java, v 0.1 2015年2月1日 下午8:52:07 fengjing.yfj Exp $
 */
public interface PhysicalDataSourceConfig extends Serializable {

    /**
     * 获取真正的物理连接
     * <p>
     * 每一次执行这个方法获取一个新的物理连接
     * 
     * @return 物理连接
     */
    public Connection getConnection();
}
