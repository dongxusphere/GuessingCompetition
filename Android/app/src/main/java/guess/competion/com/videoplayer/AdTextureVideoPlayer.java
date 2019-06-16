package guess.competion.com.videoplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;

import java.io.File;

import guess.competion.data.VideoData;


/**
 * Created by haiyang.cui on 2016/12/20.
 * TextureView播放视频
 */

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class AdTextureVideoPlayer extends AdSplashVideoPlayer implements TextureView.SurfaceTextureListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, View.OnAttachStateChangeListener {
    private static final String TAG = "AdTextureVideoPlayer";
    private TextureView textureView;
    private MediaPlayer mMediaPlayer;
    private Surface mSurface;
    private boolean isInited;
    private VideoData mAdSplash;
    private boolean isFileExist;
    private boolean isAttach;
    public AdTextureVideoPlayer(Context context) {
        super(context);
        textureView = new TextureView(context);
        textureView.setSurfaceTextureListener(this);
        textureView.addOnAttachStateChangeListener(this);
    }


    @Override
    public void startPlay(VideoData adSplash) {
        if(adSplash!=null) {
            mAdSplash = adSplash;
            File videoFile = new File(mAdSplash.localPath);
            isFileExist = videoFile.exists() ;//&&checkFilePassword(videoFile, mAdSplash.md5);
            if (isFileExist) {
                if(onVideoStatListener!=null){
                    onVideoStatListener.onReadyStart();
                }
                Log.d("sea","sea AdTextureVideoPlayer startPlay");
                preparedPlay();
            }else if (onVideoStatListener != null) {
//                Log.i("AdTextureVideoPlayer", "--------splash video file " + mAdSplash.filePath + " is not exists! MD5：" + mAdSplash.md5);
                onVideoStatListener.onDataError();
            }
        }else if(onVideoStatListener!=null){
            Log.d("sea","sea onDataError");
            onVideoStatListener.onDataError();
        }
    }

    @Override
    public View getView() {
        return textureView;
    }

    @Override
    public void setShowDefault(boolean ifShowDefault) {
    }

    @Override
    public void setVisibility(int visibility) {
        if(textureView!=null){
            textureView.setVisibility(visibility);
        }
    }

    @Override
    public void stop() {
        if(mMediaPlayer!=null) {
            mMediaPlayer.reset();
            mMediaPlayer.release();
        }
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        if(surface!=null) {
            mSurface = new Surface(surface);
        }
        Log.i("AdTextureVideoPlayer", "sea-AdTextureVideoPlayer-onSurfaceTextureAvailable");
        if(mSurface!=null&&mSurface.isValid()) {
            preparedPlay();
        }else if(onVideoStatListener!=null){
            onVideoStatListener.onError(false);
        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        Log.i("AdTextureVideoPlayer", "sea-AdTextureVideoPlayer-onSurfaceTextureSizeChanged");
    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        Log.i("AdTextureVideoPlayer", "sea-AdTextureVideoPlayer-onSurfaceTextureDestroyed");
        if(mSurface!=null) {
            mSurface.release();
        }
        if(surface!=null) {
            surface.release();
        }
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        Log.i("AdTextureVideoPlayer", "sea-AdTextureVideoPlayer-onSurfaceTextureUpdated");
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Log.i("AdTextureVideoPlayer", "sea-AdTextureVideoPlayer-onCompletion");
        try {
            if (onVideoStatListener != null) {
                onVideoStatListener.onCompletion();
            }
        }catch (Exception e){
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        Log.i("AdTextureVideoPlayer", "sea-AdTextureVideoPlayer-onPrepared");
        if(mMediaPlayer!=null){
            mMediaPlayer.start();
        }
        if(onVideoStatListener!=null){
            onVideoStatListener.onPrepared();
        }
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        Log.i("AdTextureVideoPlayer", "sea-AdTextureVideoPlayer-onError");
        if(onVideoStatListener!=null){
            onVideoStatListener.onError(false);
        }
        return true;
    }

    public void preparedPlay(){
        if(mSurface!=null&&mSurface.isValid()&&!isInited&&mAdSplash!=null&&isFileExist){
            isInited = true;
            try {
                if(mMediaPlayer!=null){
                    mMediaPlayer.reset();
                    mMediaPlayer.release();
                }
                mMediaPlayer = new MediaPlayer();
                mMediaPlayer.setSurface(mSurface);
                mMediaPlayer.setDataSource(mAdSplash.localPath);
                mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mMediaPlayer.setOnCompletionListener(this);
                mMediaPlayer.setOnPreparedListener(this);
                mMediaPlayer.setOnErrorListener(this);
                mMediaPlayer.prepareAsync();
            } catch (Exception e) {
                Log.e(TAG, e.toString());
                if(onVideoStatListener!=null){
                    onVideoStatListener.onError(false);
                }
            }
        }
    }

    public  void rePlay(){
        try {
            if(mMediaPlayer!=null){
                mMediaPlayer.stop();
                mMediaPlayer.reset();
                mMediaPlayer.setDataSource(mAdSplash.localPath);
                mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mMediaPlayer.setOnCompletionListener(this);
                mMediaPlayer.setOnPreparedListener(this);
                mMediaPlayer.setOnErrorListener(this);
                mMediaPlayer.prepare();
                mMediaPlayer.start();
//                mMediaPlayer.prepareAsync();
            }
        }catch (Exception e){

        }
    }

    @Override
    public void onViewAttachedToWindow(View v) {
        Log.d("sea","sea AdTextureVideoPlayer onAttachedToWindow isHardwareAccelerated:"+(v!=null&&v.isHardwareAccelerated()));
        if (v!=null&&!v.isHardwareAccelerated()&&!isAttach){//未成功开启硬件加速
            isAttach = true;
            v.setVisibility(View.GONE);
            if(onVideoStatListener!=null) {
                onVideoStatListener.onError(true);//延时关闭，否则会黑
            }
        }
    }

    @Override
    public void onViewDetachedFromWindow(View v) {

    }
}
