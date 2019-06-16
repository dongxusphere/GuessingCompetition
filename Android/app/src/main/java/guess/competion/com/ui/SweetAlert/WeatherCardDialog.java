package guess.competion.com.ui.SweetAlert;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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
public class WeatherCardDialog extends Dialog {
    private TextView title, desc, weather_card, ok, cancel;
    private ImageView iv1, iv2, iv3;

    public WeatherCardDialog(Context context) {
        super(context, R.style.alert_dialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_card_dialog);
//        mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
        iv1 = (ImageView) findViewById(R.id.tv1);
        iv2 = (ImageView) findViewById(R.id.tv2);
        iv3 = (ImageView) findViewById(R.id.tv3);
        title = (TextView) findViewById(R.id.title);
        desc = (TextView) findViewById(R.id.desc);
        ok = (TextView) findViewById(R.id.ok);
        iv1.setBackground(getContext().getDrawable(R.drawable.corner_bg_pink));
        cancel = (TextView) findViewById(R.id.cancel);
        weather_card = (TextView) findViewById(R.id.weather_card);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv1.setBackground(getContext().getDrawable(R.drawable.corner_bg_pink));
                iv2.setBackground(getContext().getDrawable(R.drawable.corner_bg));
                iv3.setBackground(getContext().getDrawable(R.drawable.corner_bg));
                desc.setText("已选择晴天卡 x1");
                LocalData.getInstance().delTotalCount(1);

            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv2.setBackground(getContext().getDrawable(R.drawable.corner_bg_pink));
                iv1.setBackground(getContext().getDrawable(R.drawable.corner_bg));
                iv3.setBackground(getContext().getDrawable(R.drawable.corner_bg));
                desc.setText("已选择雨天卡 x1");
                LocalData.getInstance().delTotalCount(1);

            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv3.setBackground(getContext().getDrawable(R.drawable.corner_bg_pink));
                iv2.setBackground(getContext().getDrawable(R.drawable.corner_bg));
                iv1.setBackground(getContext().getDrawable(R.drawable.corner_bg));
                desc.setText("已选择多云卡 x1");
                LocalData.getInstance().delTotalCount(1);

            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Toast.makeText(getContext(), "竞猜成功", Toast.LENGTH_SHORT).show();
                if (iOnDialogClick != null){
                    iOnDialogClick.onOkClick();
                }
//                LocalData.getInstance().delTotalCount(count);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (iOnDialogClick != null){
                    iOnDialogClick.onCancelClick();
                }
//                LocalData.getInstance().addTotalcount(count);
            }
        });

    }

    public WeatherCardDialog setOnDialogClick(IOnDialogClick iOnDialogClick) {
        this.iOnDialogClick = iOnDialogClick;
        return this;
    }

    private IOnDialogClick iOnDialogClick;

    public interface IOnDialogClick {
        void onOkClick();

        void onCancelClick();
    }

}
