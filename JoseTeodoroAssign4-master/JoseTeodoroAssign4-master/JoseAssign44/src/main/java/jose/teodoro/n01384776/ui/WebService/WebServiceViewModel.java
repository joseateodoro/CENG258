//Jose Antonio Castro Teodoro n01384776 Section B

package jose.teodoro.n01384776.ui.WebService;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WebServiceViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WebServiceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}