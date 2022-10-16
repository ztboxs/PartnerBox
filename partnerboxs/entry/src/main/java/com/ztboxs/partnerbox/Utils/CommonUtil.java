package com.ztboxs.partnerbox.Utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ohos.app.Context;
import ohos.global.resource.RawFileEntry;
import ohos.global.resource.Resource;
import ohos.media.image.ImageSource;
import ohos.media.image.PixelMap;
import ohos.media.image.common.PixelFormat;
import ohos.media.image.common.Rect;
import ohos.media.image.common.Size;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class CommonUtil {
    private static final String TAG = "Common Utils";
    private static final String ERROR_MESSAGE = "some error happened";
    private static final int GET_COLOR_STATE_FAILED = -1;
    private static final int JSON_READ_ERROR = -1;

    /**
     * 读取本地资源
     *
     * @param context
     * @param path
     * @return
     */
    public static String readRawToString(Context context, String path) {
        RawFileEntry rawFileEntry = context.getResourceManager().getRawFileEntry(path);
        Resource resource = null;
        try {
            resource = rawFileEntry.openRawFile();
            byte[] buffers = new byte[resource.available()];
            if (resource.read(buffers) != JSON_READ_ERROR) {
                return new String(buffers, "UTF8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.of(path).toString();
    }


    public static <T> List<T> parseJsonArray(String jsonStr, TypeToken<List<T>> typeToken) {
        Gson gson = new Gson();
        List<T> list = gson.fromJson(jsonStr, typeToken.getType());
        LogUtils.error(TAG, list.toString());
        return list;
    }

    /**
     * Obtains a bitmap object based on the resource path.
     *
     * @param context context
     * @param path    path
     * @return pixelMap
     */
    public static PixelMap getPixelMapFromPath(Context context, String path) {
        InputStream drawableInputStream = null;
        try {
            drawableInputStream = context.getResourceManager().getRawFileEntry(path).openRawFile();
            ImageSource.SourceOptions sourceOptions = new ImageSource.SourceOptions();
            sourceOptions.formatHint = "image/png";
            ImageSource imageSource = ImageSource.create(drawableInputStream, sourceOptions);
            ImageSource.DecodingOptions decodingOptions = new ImageSource.DecodingOptions();
            decodingOptions.desiredSize = new Size(0, 0);
            decodingOptions.desiredRegion = new Rect(0, 0, 0, 0);
            decodingOptions.desiredPixelFormat = PixelFormat.ARGB_8888;
            return imageSource.createPixelmap(decodingOptions);
        } catch (IOException e) {
            LogUtils.info(TAG, ERROR_MESSAGE);
        } finally {
            try {
                if (drawableInputStream != null) {
                    drawableInputStream.close();
                }
            } catch (IOException e) {
                LogUtils.error(TAG, ERROR_MESSAGE);
            }
        }
        return null;
    }
}
