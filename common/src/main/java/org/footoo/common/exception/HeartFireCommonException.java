/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.footoo.common.exception;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 通用的异常
 * 
 * @author fengjing.yfj
 * @version $Id: HeartFireCommonException.java, v 0.1 2015年1月27日 下午10:02:47 fengjing.yfj Exp $
 */
public class HeartFireCommonException extends RuntimeException {

    /** 序列号  */
    private static final long serialVersionUID = -8001264774249926105L;

    /** 错误上下文 */
    private List<Object>      errorContext     = null;

    /**
     * 默认构造函数
     */
    public HeartFireCommonException() {

    }

    /**
     * 带有异常信息的exception
     * 
     * @param e 异常信息
     */
    public HeartFireCommonException(Throwable e) {
        super(e);
    }

    /**
     * 带有异常和错误信息的构造函数
     * 
     * @param message 错误信息
     * @param e 异常信息
     */
    public HeartFireCommonException(String message, Throwable e) {
        super(message, e);
    }

    /**
     * 带有错误信息和异常以及错误对象的构造函数
     * 
     * @param message 错误信息
     * @param e 异常
     * @param error 错误对象
     */
    public HeartFireCommonException(String message, Throwable e, Object error) {
        super(message, e);
        addError(error);
    }

    /**
     * 获取错误上下文
     * 
     * @return 错误上下文
     */
    public List<Object> getErrorContext() {
        return errorContext;
    }

    /**
     * 向错误上下文中添加错误信息
     * 
     * @param error 错误信息
     */
    public void addError(Object error) {
        if (errorContext == null) {
            errorContext = new LinkedList<Object>();
        }
        if (error != null) {
            errorContext.add(error);
        }
    }

    /**
     * @see java.lang.Throwable#toString()
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        //dump出错误信息
        if (StringUtils.isNotBlank(getMessage())) {
            stringBuilder.append(getMessage()).append(":").append(System.lineSeparator());
        }

        //dump出错误上下文
        stringBuilder.append("---------------errorContext------------").append(
            System.lineSeparator());
        if (!CollectionUtils.isEmpty(errorContext)) {
            for (Object error : errorContext) {
                stringBuilder.append("--");
                stringBuilder.append(error);
                stringBuilder.append(System.lineSeparator());
            }
        }

        //dump出异常信息
        stringBuilder.append(super.toString());

        return stringBuilder.toString();
    }
}
