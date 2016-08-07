package com.hotbitmapgg.ohmybilibili.utils;

import java.lang.reflect.Array;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * Array数组工具类
 */
public class ArrayUtils
{

    public static <T> T[] concat(T[] A, T[] B)
    {

        final Class<?> typeofA = A.getClass().getComponentType();
        @SuppressWarnings("unchecked")
        T[] C = (T[]) Array.newInstance(typeofA, A.length + B.length);
        System.arraycopy(A, 0, C, 0, A.length);
        System.arraycopy(B, 0, C, A.length, B.length);

        return C;
    }

    public static <T> int indexOf(T[] array, T s)
    {

        for (int i = 0; i < array.length; i++)
        {
            if (array[i].equals(s))
            {
                return i;
            }
        }
        return -1;
    }
}
