package jon.ldnr.roomwordsample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "word_table")
public class Word {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    // constructor
    public Word(@NonNull String word) {
        this.mWord = word;
    }

    // getter
    public String getWord() {
        return this.mWord;
    }
}
