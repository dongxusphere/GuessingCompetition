package guess.competion.com.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import guess.competion.com.FullVideoActivity;
import guess.competion.com.R;
import guess.competion.com.ui.SweetAlert.ChooseAlertDialog;
import guess.competion.com.ui.SweetAlert.SweetAlertDialog;
import guess.competion.com.ui.SweetAlert.WeatherCardDialog;
import guess.competion.data.LocalData;
import guess.competion.data.VideoData;

public class DashboardFragment extends Fragment implements WeatherCardDialog.IOnDialogClick{
    private ContentLoadingProgressBar ProgressBar;

    private DashboardViewModel dashboardViewModel;
    private TextView tv_get_weather_card;

    private TextView chooseLeft,chooseRight,count;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        tv_get_weather_card = (TextView) root.findViewById(R.id.tv_get_weather_card);
        tv_get_weather_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FullVideoActivity.class));
            }
        });
        ProgressBar = (ContentLoadingProgressBar) root.findViewById(R.id.ProgressBar);
        ProgressBar.setProgress(30);
//        ProgressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(getContext(),R.color.yellow), PorterDuff.Mode.MULTIPLY);
//        ProgressBar.setProgress(30);

        chooseLeft = (TextView) root.findViewById(R.id.choose_left);
        chooseRight =(TextView) root.findViewById(R.id.choose_right);
        count =(TextView)root.findViewById(R.id.count);
        count.setText(LocalData.getInstance().getTotalcount()+"");
        chooseLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(LocalData.getInstance().getTotalcount()<=0){
                    Toast.makeText(getContext(),"您还没有天气卡，不能参加预测",Toast.LENGTH_LONG).show();
                    return;
                }
                new WeatherCardDialog(getContext()).show();
            }
        });
        chooseRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(LocalData.getInstance().getTotalcount()<=0){
                    Toast.makeText(getContext(),"您还没有天气卡，不能参加预测",Toast.LENGTH_LONG).show();
                    return;
                }
                new WeatherCardDialog(getContext()).show();
            }
        });

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(count!=null){
            count.setText(LocalData.getInstance().getTotalcount()+"");
        }
    }

    @Override
    public void onCancelClick() {
        if(count!=null){
            count.setText(LocalData.getInstance().getTotalcount()+"");
        }
    }

    @Override
    public void onOkClick() {
        if(count!=null){
            count.setText(LocalData.getInstance().getTotalcount()+"");
        }
    }
}