package guess.competion.com.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import guess.competion.com.FullVideoActivity;
import guess.competion.com.R;

public class DashboardFragment extends Fragment {
    private ContentLoadingProgressBar ProgressBar;

    private DashboardViewModel dashboardViewModel;
    private TextView tv_get_weather_card;

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

        return root;
    }
}