package guess.competion.com;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import guess.competion.data.DeviceTool;

public class ScrollingActivity extends AppCompatActivity {
    private ImageView iv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        iv1= (ImageView )findViewById(R.id.iv1);
        int width = DeviceTool.getScreenWidth(this);
        int  height1 = (int) ((2714f/690f)*width);
        LinearLayout.LayoutParams l1 = new LinearLayout.LayoutParams(width,height1);
//        l1.setMargins(0,0,0,DeviceTool.dp2px(getContext(),60));
        iv1.setLayoutParams(l1);
    }
}
