/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.footoo.heartFire.connection.proxy;

import java.sql.Connection;

/**
 * 连接的代理对象
 * <p>
 * 初始化后，并不会包含实际的物理连接，只有进行sql执行获取prepareStatment的时候才真正进行
 * 实际的物理的连接的获取
 * 
 * @author fengjing.yfj
 * @version $Id: ConnectionProxy.java, v 0.1 2015年1月27日 下午9:12:20 fengjing.yfj Exp $
 */
public interface ConnectionProxy extends Connection {

    /**
     * 获取真正的物理连接
     * 
     * @return 真正的物理连接
     */
    public Connection getRealConnection();
}
