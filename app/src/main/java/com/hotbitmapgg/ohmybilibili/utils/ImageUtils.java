package com.hotbitmapgg.ohmybilibili.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtils
{

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public static int getBitmapSize(Bitmap bitmap)
    {

        if (DeviceUtils.hasHoneycombMR1())
        {
            return bitmap.getByteCount();
        }
        // Pre HC-MR1
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /**
     * 旋转图片
     */
    public static Bitmap rotate(Bitmap b, int degrees)
    {

        if (degrees != 0 && b != null)
        {
            Matrix m = new Matrix();
            m.setRotate(degrees, (float) b.getWidth() / 2, (float) b.getHeight() / 2);
            try
            {
                Bitmap b2 = Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), m, true);
                if (b != b2)
                {
                    b.recycle();
                    b = b2;
                }
            } catch (OutOfMemoryError ex)
            {

            } catch (Exception ex)
            {

            }
        }
        return b;
    }

    /**
     * Decode and sample down a bitmap from a file to the requested width and
     * height.
     *
     * @param filename  The full path of the file to decode
     * @param reqWidth  The requested width of the resulting bitmap
     * @param reqHeight The requested height of the resulting bitmap
     * @return A bitmap sampled down from the original with the same aspect
     * ratio and dimensions that are equal to or greater than the
     * requested width and height
     */
    public static synchronized Bitmap decodeSampledBitmapFromFile(String filename, int reqWidth, int reqHeight)
    {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filename, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filename, options);
    }

    /**
     * Calculate an inSampleSize for use in a
     * {@link android.graphics.BitmapFactory.Options} object when decoding
     * bitmaps using the decode* methods from {@link BitmapFactory}. This
     * implementation calculates the closest inSampleSize that will result in
     * the final decoded bitmap having a width and height equal to or larger
     * than the requested width and height. This implementation does not ensure
     * a power of 2 is returned for inSampleSize which can be faster when
     * decoding but results in a larger bitmap which isn't as useful for caching
     * purposes.
     *
     * @param options   An options object with out* params already populated (run
     *                  through a decode* method with inJustDecodeBounds==true
     * @param reqWidth  The requested width of the resulting bitmap
     * @param reqHeight The requested height of the resulting bitmap
     * @return The value to be used for inSampleSize
     */
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight)
    {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth)
        {
            if (width > height)
            {
                inSampleSize = Math.round((float) height / (float) reqHeight);
            } else
            {
                inSampleSize = Math.round((float) width / (float) reqWidth);
            }

            // This offers some additional logic in case the image has a strange
            // aspect ratio. For example, a panorama may have a much larger
            // width than height. In these cases the total pixels might still
            // end up being too large to fit comfortably in memory, so we should
            // be more aggressive with sample down the image (=larger
            // inSampleSize).

            final float totalPixels = width * height;

            // Anything more than 2x the requested pixels we'll sample down
            // further.
            final float totalReqPixelsCap = reqWidth * reqHeight * 2;

            while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap)
            {
                inSampleSize++;
            }
        }
        return inSampleSize;
    }

    public static boolean saveBitmap(String path, Bitmap bitmap)
    {

        return saveBitmap(new File(path), bitmap);
    }

    /**
     * 保存图片到文件
     */
    public static boolean saveBitmap(File f, Bitmap bitmap)
    {

        if (bitmap == null || bitmap.isRecycled())
            return false;

        FileOutputStream fOut = null;
        try
        {
            if (f.exists())
                f.createNewFile();

            fOut = new FileOutputStream(f);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);

            fOut.flush();
            return true;
        } catch (FileNotFoundException e)
        {

        } catch (IOException e)
        {

        } catch (Exception e)
        {

        } finally
        {
            if (fOut != null)
            {
                try
                {
                    fOut.close();
                } catch (IOException e)
                {

                }
            }
        }
        return false;
    }

    public static Bitmap decodeUriAsBitmap(Context ctx, Uri uri)
    {

        Bitmap bitmap = null;
        try
        {
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            // options.outWidth = reqWidth;
            // options.outHeight = reqHeight;
            BitmapFactory.decodeStream(ctx.getContentResolver().openInputStream(uri), null, options);

            int be = (int) (options.outHeight / (float) 350);
            if (be <= 0)
                be = 1;
            options.inSampleSize = be;// calculateInSampleSize(options,
            // reqWidth, reqHeight);

            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeStream(ctx.getContentResolver().openInputStream(uri), null, options);
        } catch (FileNotFoundException e)
        {

        } catch (OutOfMemoryError e)
        {

        }
        return bitmap;
    }

    public static Bitmap zoomBitmap(Bitmap bitmap, int w, int h)
    {

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidht = ((float) w / width);
        float scaleHeight = ((float) h / height);
        matrix.postScale(scaleWidht, scaleHeight);
        Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        return newbmp;
    }

    public static Bitmap drawableToBitmap(Drawable drawable)
    {

        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * 获取图片圆角
     *
     * @param bitmap
     * @param roundPx 圆角度数
     * @return
     */
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx)
    {

        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    /**
     * 转行Drawable为Bitmap对象
     *
     * @param drawable
     * @return
     */
    public static Bitmap toBitmap(Drawable drawable)
    {

        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * 缩放图片
     *
     * @param src       缩放原图
     * @param dstWidth  缩放后宽
     * @param dstHeight 缩放后高
     * @return
     */
    public static Bitmap scaledBitmap(Bitmap src, int dstWidth, int dstHeight)
    {
        // 原图不能为空也不能已经被回收掉了
        Bitmap result = null;
        if (src != null && !src.isRecycled())
        {
            if (src.getWidth() == dstWidth && src.getHeight() == dstHeight)
            {
                result = src;
            } else
            {
                result = Bitmap.createScaledBitmap(src, dstWidth, dstHeight, true);
            }
        }
        // ThumbnailUtils.extractThumbnail(source, width, height)
        return result;
    }

    /**
     * 按比例缩放图片
     *
     * @param src
     * @param scale 例如2 就是二分之一
     * @return
     */
    public static Bitmap scaledBitmap(Bitmap src, int scale)
    {

        if (src == null || src.isRecycled())
        {
            return null;
        }
        int dstWidth = src.getWidth() / scale;
        int dstHeight = src.getHeight() / scale;
        return Bitmap.createScaledBitmap(src, dstWidth, dstHeight, true);
    }

    /**
     * 将图片转换成字节数组
     *
     * @param bitmap
     * @return
     */
    public static byte[] toBytes(Bitmap bitmap)
    {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        return outputStream.toByteArray();
    }
}
