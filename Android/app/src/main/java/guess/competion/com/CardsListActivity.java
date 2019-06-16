package guess.competion.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import guess.competion.data.DeviceTool;

public class CardsListActivity extends AppCompatActivity {
    private ImageView iv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards_list);
        iv1= (ImageView)findViewById(R.id.iv1);
        int width = DeviceTool.getScreenWidth(this);
        int  height1 = (int) ((1123f/675f)*width);
        LinearLayout.LayoutParams l1 = new LinearLayout.LayoutParams(width,height1);
//        l1.setMargins(0,0,0,DeviceTool.dp2px(getContext(),60));
        iv1.setLayoutParams(l1);
    }
}
