package com.hotbitmapgg.ohmybilibili.utils;

import java.lang.reflect.Array;

/**
 * Array工具类
 *
 * @HotBitmapGG
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
