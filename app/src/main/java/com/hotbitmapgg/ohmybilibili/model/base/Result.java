package com.hotbitmapgg.ohmybilibili.model.base;

/**
 * 定义返回请求结构
 * code message result形式
 *
 * @HotbitmapGG
 */
public class Result<T>
{

    public int code;

    public String message;

    public T result;

    public T data;

    public T getResult()
    {

        return result;
    }

    public T getData()
    {

        return result;
    }
}
