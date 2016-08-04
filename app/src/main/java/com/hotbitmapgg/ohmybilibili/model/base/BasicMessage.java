package com.hotbitmapgg.ohmybilibili.model.base;

/**
 * 基于返回数据封装的模型基类
 *
 * @param <T>
 * @HotBitmapGG
 */
public class BasicMessage<T>
{

    private T object;

    private int code = 0;

    public static final int CODE_NONE = 0, CODE_SUCCEED = 1, CODE_HTTP_404 = 404, CODE_ERROR = -1;

    public BasicMessage()
    {

    }

    public BasicMessage(T object, int code)
    {

        this.object = object;
        this.code = code;
    }

    public void setObject(T object)
    {

        this.object = object;
    }

    public void setCode(int code)
    {

        this.code = code;
    }

    public T getObject()
    {

        return this.object;
    }

    public int getCode()
    {

        return this.code;
    }
}
