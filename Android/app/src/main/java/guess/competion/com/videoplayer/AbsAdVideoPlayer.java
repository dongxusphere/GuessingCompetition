package guess.competion.com.videoplayer;

import android.content.Context;
import android.view.View;

/**
 * Created by haiyang.cui on 2016/12/20.
 */

public abstract class AbsAdVideoPlayer<T> {
    protected Context context;
    protected OnVideoStatListener onVideoStatListener;
    public AbsAdVideoPlayer(Context context){
        this.context = context;
    }

    /**
     * 开始播放视频
     * @param t
     */
    public abstract void startPlay(T t);

    /**
     * 获取视频view
     * @return
     */
    public abstract View getView();

    /**
     * 视频播放状态
     */
    public interface OnVideoStatListener {
        void onCompletion();//播放完成
        void onError(boolean isDelay);//播放出错
        void onPrepared();//准备播放
        void onDataError();//数据出错
        void onReadyStart();//准备开始
    }
    public void setOnVideoStatListener(OnVideoStatListener onVideoStatListener){
        this.onVideoStatListener = onVideoStatListener;
    }

    /**
     * 是否默认展示
     * @param ifShowDefault
     */
    public abstract void setShowDefault(boolean ifShowDefault);

    public abstract void setVisibility(int visibility);

    /**
     * 停止播放
     */
    public abstract void stop();

}
