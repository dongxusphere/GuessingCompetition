package guess.competion.data;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;

/**
 * @ClassName: DeviceTool
 * @Description:
 * @Author: dongxu.zhao
 * @Date: 2019-06-15 13:15
 */
public  class DeviceTool {
    private static int sScreenWidth;
    private static int sScreenHeight;
    /**
     * 获得屏幕宽度（随屏幕旋转改变）
     * 如果获取失败，则返回720
     *
     * @return 屏幕高度，或720
     */
    public static int getScreenWidth(Context mAppContext) {
        if (sScreenWidth != 0) {
            return sScreenWidth;
        }
        return reload(mAppContext);
    }

    private static int reload(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (wm != null && wm.getDefaultDisplay() != null) {
            DisplayMetrics outMetrics = new DisplayMetrics();
            Display display = wm.getDefaultDisplay();
            display.getMetrics(outMetrics);
            switch (display.getRotation()) {
                case Surface.ROTATION_0:
                case Surface.ROTATION_180://fall through
                    sScreenWidth = outMetrics.widthPixels;
                    sScreenHeight = outMetrics.heightPixels;
                    break;
                case Surface.ROTATION_90:
                case Surface.ROTATION_270://fall through
                    sScreenWidth = outMetrics.heightPixels;
                    sScreenHeight = outMetrics.widthPixels;
                    break;
                default:
            }
            return sScreenWidth;
        } else {
            return 720;
        }
    }

    /**
     * 获得屏幕高度
     * 如果获取失败，则返回1080
     *
     * @return 屏幕高度，或1080
     */
    public static int getScreenHeight(Context mAppContext) {
        if (sScreenHeight != 0) {
            return sScreenHeight;
        }
        WindowManager wm = (WindowManager) mAppContext.getSystemService(Context.WINDOW_SERVICE);
        if (wm != null && wm.getDefaultDisplay() != null) {
            DisplayMetrics outMetrics = new DisplayMetrics();
            Display display = wm.getDefaultDisplay();
            display.getMetrics(outMetrics);
            switch (display.getRotation()) {
                case Surface.ROTATION_0:
                case Surface.ROTATION_180://fall through
                    sScreenHeight = outMetrics.heightPixels;
                    sScreenWidth = outMetrics.widthPixels;
                    break;
                case Surface.ROTATION_90:
                case Surface.ROTATION_270://fall through
                    sScreenHeight = outMetrics.widthPixels;
                    sScreenWidth = outMetrics.heightPixels;
                    break;
            }
            return sScreenHeight;
        } else {
            return 1080;
        }
    }

    /**
     * dp转px
     */
    public static int dp2px(Context mAppContext,float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, mAppContext.getResources().getDisplayMetrics());
    }
}
