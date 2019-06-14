package guess.competion.com.ui.game;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


/**
 * @ClassName: GameViewModel
 * @Description:
 * @Author: dongxu.zhao
 * @Date: 2019-06-14 14:43
 */
public class GameViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public GameViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is game fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
