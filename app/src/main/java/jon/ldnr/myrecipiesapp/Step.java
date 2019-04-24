package jon.ldnr.myrecipiesapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "steps")
public class Step {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_step")
    private int stepId;

    @ColumnInfo(name = "text_step")
    @NonNull
    private String stepText;

    @ColumnInfo(name = "url_media")
    @NonNull
    private String urlMedia;



    // Constructors
    public Step(String stepText, String urlMedia) {
        this.stepText = stepText;
        this.urlMedia = urlMedia;
    }


    /**
     * @return the stepId
     */
    public int getStepId() {
        return stepId;
    }

    /**
     * @param stepId the stepId to set
     */
    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

    /**
     * @return the stepText
     */
    public String getStepText() {
        return stepText;
    }

    /**
     * @param stepText the stepText to set
     */
    public void setStepText(String stepText) {
        this.stepText = stepText;
    }

    /**
     * @return the urlMedia
     */
    public String getUrlMedia() {
        return urlMedia;
    }

    /**
     * @param urlMedia the urlMedia to set
     */
    public void setUrlMedia(String urlMedia) {
        this.urlMedia = urlMedia;
    }
}
