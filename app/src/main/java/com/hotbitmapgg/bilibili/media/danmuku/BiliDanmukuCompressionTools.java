package com.hotbitmapgg.bilibili.media.danmuku;

import java.util.zip.Deflater;
import java.util.zip.Inflater;
import java.util.zip.DataFormatException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 压缩工具类
 */
public class BiliDanmukuCompressionTools {

    private BiliDanmukuCompressionTools() {
    }

    public static byte[] compress(byte[] value, int offset, int length, int compressionLevel) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(length);
        Deflater compressor = new Deflater();
        try {
            // 将当前压缩级别设置为指定值
            compressor.setLevel(compressionLevel);
            compressor.setInput(value, offset, length);
            // 调用时，指示压缩应当以输入缓冲区的当前内容结尾
            compressor.finish();
            final byte[] buf = new byte[1024];
            while (!compressor.finished()) {
                // 如果已到达压缩数据输出流的结尾，则返回 true。
                int count = compressor.deflate(buf);
                // 使用压缩数据填充指定缓冲区。
                bos.write(buf, 0, count);
            }
        } finally {
            // 关闭解压缩器并放弃所有未处理的输入
            compressor.end();
        }
        return bos.toByteArray();
    }

    public static byte[] compress(byte[] value, int offset, int length) {
        // 最佳压缩的压缩级别
        return compress(value, offset, length, Deflater.BEST_COMPRESSION);

    }

    public static byte[] compress(byte[] value) {
        return compress(value, 0, value.length, Deflater.BEST_COMPRESSION);
    }

    public static byte[] decompress(byte[] value) throws DataFormatException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(value.length);
        Inflater decompressor = new Inflater();
        try {
            decompressor.setInput(value);
            final byte[] buf = new byte[1024];
            while (!decompressor.finished()) {
                int count = decompressor.inflate(buf);
                bos.write(buf, 0, count);
            }
        } finally {
            decompressor.end();
        }
        return bos.toByteArray();
    }

    static byte[] decompressXML(byte[] data) throws DataFormatException {
        byte[] dest = new byte[data.length + 2];
        System.arraycopy(data, 0, dest, 2, data.length);
        dest[0] = 0x78;
        dest[1] = 0x01;
        data = dest;
        Inflater decompresser = new Inflater();
        decompresser.setInput(data);
        byte[] bufferArray = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
        try {
            int i = 1;
            while (i != 0) {
                i = decompresser.inflate(bufferArray);
                baos.write(bufferArray, 0, i);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                baos.flush();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        decompresser.end();
        return data;
    }
}
