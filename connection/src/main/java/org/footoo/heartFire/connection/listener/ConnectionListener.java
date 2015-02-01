/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.footoo.heartFire.connection.listener;

import org.footoo.heartFire.connection.listener.event.ListenerEvent;

/**
 * 连接状态的监听器
 * 
 * @author fengjing.yfj
 * @version $Id: ConnectionListener.java, v 0.1 2015年1月29日 下午11:31:24 fengjing.yfj Exp $
 */
public interface ConnectionListener {
    /**
     * 监听事件
     * 
     * @param event 连接的事件
     */
    public void listen(ListenerEvent event);
}
