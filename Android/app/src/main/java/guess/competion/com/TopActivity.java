package guess.competion.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import guess.competion.data.DeviceTool;

public class TopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        ImageView iv1 = (ImageView) findViewById(R.id.iv1);
        int width = DeviceTool.getScreenWidth(this);
        int  height1 = (int) ((1334f/750f)*width);
        LinearLayout.LayoutParams l1 = new LinearLayout.LayoutParams(width,height1);
        iv1.setLayoutParams(l1);
    }
}
