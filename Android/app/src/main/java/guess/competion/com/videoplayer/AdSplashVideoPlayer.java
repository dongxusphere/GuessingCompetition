package guess.competion.com.videoplayer;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import guess.competion.data.VideoData;

/**
 * Created by haiyang.cui on 2016/12/20.
 */

public abstract class AdSplashVideoPlayer extends AbsAdVideoPlayer<VideoData> {
    private static final String TAG = "AdSplashVideoPlayer";
    private char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    private MessageDigest messagedigest = null;

    public AdSplashVideoPlayer(Context context) {
        super(context);
//        try {
//            messagedigest = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException e) {
//            Log.d("SplashViewCreater","sea SplashViewCreater初始化失败，MessageDigest不支持MD5Util");
//            Log.e(TAG, e.toString());
//        }
    }

    /**
     * 生成文件的md5校验值
     *
     * @param file
     * @return
     * @throws IOException
     */
    private String getFileMD5String(File file) {
        InputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int numRead = 0;
            while ((numRead = fis.read(buffer)) > 0) {
                messagedigest.update(buffer, 0, numRead);
            }
            return bufferToHex(messagedigest.digest());
        } catch (IOException e) {
            Log.e("sea",e.toString());
            return "";
        }finally {
            try {
                if(fis!=null) {
                    fis.close();
                }
            } catch (IOException e) {
                Log.e(TAG, e.toString());
            }
        }
    }

    /**
     * 校验文件的MD5
     * @param file
     * @param passWord
     * @return
     * @throws IOException
     */
    protected boolean checkFilePassword(File file,String passWord){
        if(TextUtils.isEmpty(passWord))
            return false;
        return passWord.equals(getFileMD5String(file));
    }

    private String bufferToHex(byte bytes[]) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[(bt & 0xf0) >> 4];// 取字节中高 4 位的数字转换
        char c1 = hexDigits[bt & 0xf];// 取字节中低 4 位的数字转换
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }
}
