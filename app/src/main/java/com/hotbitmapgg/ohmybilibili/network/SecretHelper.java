package com.hotbitmapgg.ohmybilibili.network;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * B站请求签名算法
 * <p/>
 * 需要对应的Appkey
 *
 * @HotBitmapGG
 */
public class SecretHelper
{

    public static String produceMD5(UrlBuilder url, String appSecret)
    {

        try
        {
            return encodeMD5String(url.toStringWithoutUrlRoot() + appSecret);
        } catch (NoSuchAlgorithmException e)
        {
            return null;
        }
    }

    public static String encodeMD5String(String original) throws NoSuchAlgorithmException
    {

        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(original.getBytes());
        byte[] bytes = digest.digest();
        StringBuffer sb = new StringBuffer("");
        for (byte bit : bytes)
        {
            int bt = bit & 0xff;
            sb.append(bt < 16 ? "0" : "").append(Integer.toHexString(bt));
        }
        return sb.toString();
    }
}
