/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.footoo.common.exception;

/**
 * 连接的异常
 * 
 * @author fengjing.yfj
 * @version $Id: ConnectionException.java, v 0.1 2015年1月27日 下午10:30:06 fengjing.yfj Exp $
 */
public class ConnectionException extends HeartFireCommonException {

    /** 序列号 */
    private static final long serialVersionUID = 752176628760761885L;

    /**
     * 默认构造函数
     */
    public ConnectionException() {
    }

    /**
     * 带有异常信息的exception
     * 
     * @param e 异常信息
     */
    public ConnectionException(Throwable e) {
        super(e);
    }

    /**
     * 带有异常和错误信息的构造函数
     * 
     * @param message 错误信息
     * @param e 异常信息
     */
    public ConnectionException(String message, Throwable e) {
        super(message, e);
    }

    /**
     * 带有错误信息和异常以及错误对象的构造函数
     * 
     * @param message 错误信息
     * @param e 异常
     * @param error 错误对象
     */
    public ConnectionException(String message, Throwable e, Object error) {
        super(message, e, error);
    }

}
