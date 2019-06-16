package guess.competion.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import guess.competion.data.DeviceTool;

public class CardsListActivity extends AppCompatActivity {
    private ImageView iv1,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards_list);
        iv1= (ImageView)findViewById(R.id.iv1);
        back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        int width = DeviceTool.getScreenWidth(this)-DeviceTool.dp2px(this,40);
        int  height1 = (int) ((1123f/675f)*width);
        LinearLayout.LayoutParams l1 = new LinearLayout.LayoutParams(width,height1);
        iv1.setLayoutParams(l1);
    }
}
