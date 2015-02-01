/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.footoo.heartFire.connection.pool;

/**
 * 抽象的连接池的实现
 * 
 * @author fengjing.yfj
 * @version $Id: AbstractConnectionPool.java, v 0.1 2015年2月1日 下午10:10:40 fengjing.yfj Exp $
 */
public abstract class AbstractConnectionPool implements ConnectionPool {

    /** 最小的连接的数量 */
    protected int     minIdle;

    /** 最大的连接的数量 */
    protected int     maxActive;

    /** 是否已经初始化过 */
    protected boolean inited;

    /**
     * Getter method for property <tt>minIdle</tt>.
     * 
     * @return property value of minIdle
     */
    public int getMinIdle() {
        return minIdle;
    }

    /**
     * Getter method for property <tt>maxActive</tt>.
     * 
     * @return property value of maxActive
     */
    public int getMaxActive() {
        return maxActive;
    }

}
