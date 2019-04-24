package jon.ldnr.myrecipiesapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    // private reference to our word repository
    private WordRepository mRepository;

    // private reference to our word list to be able to cache our datas
    private LiveData<List<Word>> mAllWords;

    // constructor will invoke our repository and our word list
    public WordViewModel (Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    // getter to get our words
    // implementation is "hidden" from UI.
    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    // Wrapper insert method which call insert method from our repository
    // still 'hidden' from UI
    public void insert(Word word) {
        mRepository.insert(word);
    }
}
