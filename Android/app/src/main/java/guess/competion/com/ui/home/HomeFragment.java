package guess.competion.com.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import guess.competion.com.FullVideoActivity;
import guess.competion.com.R;
import guess.competion.com.ScrollingActivity;
import guess.competion.data.DeviceTool;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private ImageView iv1,iv2,iv3;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        iv1= (ImageView )root.findViewById(R.id.iv1);
        iv2= (ImageView )root.findViewById(R.id.iv2);
        iv3= (ImageView )root.findViewById(R.id.iv3);
        int width = DeviceTool.getScreenWidth(getContext())-DeviceTool.dp2px(getContext(),20);
        int  height1 = (int) ((504f/691f)*width);
        LinearLayout.LayoutParams l1 = new LinearLayout.LayoutParams(width,height1);
        iv1.setLayoutParams(l1);

        int  height2 = (int) ((799f/699f)*width);
        LinearLayout.LayoutParams l2 = new LinearLayout.LayoutParams(width,height2);
        iv2.setLayoutParams(l2);

        int  height3 = (int) ((967f/691f)*width);
        LinearLayout.LayoutParams l3 = new LinearLayout.LayoutParams(width,height3);
        iv3.setLayoutParams(l3);

        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ScrollingActivity.class));
            }
        });

        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FullVideoActivity.class));
            }
        });
        return root;
    }
}