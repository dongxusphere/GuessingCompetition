package guess.competion.com.ui.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import guess.competion.com.R;
import guess.competion.data.DeviceTool;


/**
 * @ClassName: GameFragment
 * @Description:
 * @Author: dongxu.zhao
 * @Date: 2019-06-14 14:42
 */
public class GameFragment extends Fragment {
    private GameViewModel gameViewModel;
    private ImageView iv1;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        gameViewModel =
                ViewModelProviders.of(this).get(GameViewModel.class);
        View root = inflater.inflate(R.layout.fragment_game, container, false);
        iv1= (ImageView )root.findViewById(R.id.iv1);
        int width = DeviceTool.getScreenWidth(getContext());
        int  height1 = (int) ((2320f/1080f)*width);
        LinearLayout.LayoutParams l1 = new LinearLayout.LayoutParams(width,height1);
        l1.setMargins(0,0,0,DeviceTool.dp2px(getContext(),60));
        iv1.setLayoutParams(l1);
        return root;
    }
}
