package guess.competion.com.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import guess.competion.com.CardsListActivity;
import guess.competion.com.R;
import guess.competion.data.DeviceTool;

public class NotificationsFragment extends Fragment {
    private ImageView iv1,iv2;

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        iv1 = (ImageView) root.findViewById(R.id.iv1);
//        iv2 = (ImageView) root.findViewById(R.id.iv2);
        int width = DeviceTool.getScreenWidth(getContext())-DeviceTool.dp2px(getContext(),20);
        int  height1 = (int) ((308f/686f)*width);
        LinearLayout.LayoutParams l1 = new LinearLayout.LayoutParams(width,height1);
        l1.setMargins(0,0,0,DeviceTool.dp2px(getContext(),60));
        l1.setMargins(DeviceTool.dp2px(getContext(),10),DeviceTool.dp2px(getContext(),20),DeviceTool.dp2px(getContext(),10),0);
        iv1.setLayoutParams(l1);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CardsListActivity.class));
            }
        });
        return root;
    }
}