package com.zeroone.star.project.sysmanage.operlog.utils;

/**
 * 处理并记录日志文件
 * 
 * @author 酌
 */
public class LogUtils
{
    public static String getBlock(Object msg)
    {
        if (msg == null)
        {
            msg = "";
        }
        return "[" + msg.toString() + "]";
    }
}
