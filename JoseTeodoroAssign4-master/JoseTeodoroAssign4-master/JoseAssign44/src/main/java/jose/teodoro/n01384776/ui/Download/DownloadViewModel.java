//Jose Antonio Castro Teodoro n01384776 Section B

package jose.teodoro.n01384776.ui.Download;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DownloadViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DownloadViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}