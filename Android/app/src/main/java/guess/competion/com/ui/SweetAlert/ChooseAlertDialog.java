package guess.competion.com.ui.SweetAlert;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import guess.competion.com.R;
import guess.competion.data.LocalData;


/**
 * @ClassName: ChooseAlertDialog
 * @Description:
 * @Author: dongxu.zhao
 * @Date: 2019-06-15 16:56
 */
public class ChooseAlertDialog extends Dialog {
    private TextView tv1,tv2,tv3,title,desc,weather_card,ok,cancel;
private int count = 0;

    public ChooseAlertDialog(Context context){
        super(context, R.style.alert_dialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_dialog);
//        mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        title = (TextView) findViewById(R.id.title);
        desc = (TextView) findViewById(R.id.desc);
        ok = (TextView) findViewById(R.id.ok);
        tv1.setBackground(getContext().getDrawable(R.drawable.corner_bg_yellow));
        cancel = (TextView) findViewById(R.id.cancel);
        weather_card  =(TextView) findViewById(R.id.weather_card);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setBackground(getContext().getDrawable(R.drawable.corner_bg_yellow));
                tv2.setBackground(getContext().getDrawable(R.drawable.corner_bg));
                tv3.setBackground(getContext().getDrawable(R.drawable.corner_bg));
                desc.setText("已投入20墨币");
                count = 20;

            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setBackground(getContext().getDrawable(R.drawable.corner_bg_yellow));
                tv1.setBackground(getContext().getDrawable(R.drawable.corner_bg));
                tv3.setBackground(getContext().getDrawable(R.drawable.corner_bg));
                desc.setText("已投入50墨币");
                count = 50;

            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv3.setBackground(getContext().getDrawable(R.drawable.corner_bg_yellow));
                tv2.setBackground(getContext().getDrawable(R.drawable.corner_bg));
                tv1.setBackground(getContext().getDrawable(R.drawable.corner_bg));
                desc.setText("已投入100墨币");
                count = 100;

            }
        });
        weather_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseAlertDialog.this.dismiss();
                new WeatherCardDialog(getContext()).show();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                LocalData.getInstance().delTotalCount(count);
                Toast.makeText(getContext(), "竞猜成功", Toast.LENGTH_SHORT).show();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                LocalData.getInstance().addTotalcount(count);
            }
        });

    }

    public ChooseAlertDialog setTitle(String title){
        if(this.title!=null){
            this.title.setText(title);
            this.title.setVisibility(View.VISIBLE);
        }
        return this;
    }
}
