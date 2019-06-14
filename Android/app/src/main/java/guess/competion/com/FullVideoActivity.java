package guess.competion.com;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import guess.competion.com.videoplayer.AbsAdVideoPlayer;
import guess.competion.com.videoplayer.AdSplashVideoPlayer;
import guess.competion.com.videoplayer.AdTextureVideoPlayer;
import guess.competion.data.VideoData;


/**
 * @ClassName: FullVideoActivity
 * @Description:
 * @Author: dongxu.zhao
 * @Date: 2019-06-14 15:21
 */
public class FullVideoActivity extends Activity implements AbsAdVideoPlayer.OnVideoStatListener {
    AdSplashVideoPlayer adSplashVideoPlayer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int option = View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            getWindow().getDecorView().setSystemUiVisibility(option);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_video);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.root_view);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED, WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
//        MJLogger.d("SplashVideoActivity", "sea SplashVideoActivity AdTextureVideoPlayer");
        adSplashVideoPlayer = new AdTextureVideoPlayer(this);
        adSplashVideoPlayer.setOnVideoStatListener(this);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        relativeLayout.addView(adSplashVideoPlayer.getView(), lp);
        VideoData videoData = new VideoData();
        adSplashVideoPlayer.startPlay(videoData);
    }

    @Override
    public void onPrepared() {

    }

    @Override
    public void onReadyStart() {

    }

    @Override
    public void onCompletion() {

    }

    @Override
    public void onError(boolean isDelay) {

    }

    @Override
    public void onDataError() {

    }
}

