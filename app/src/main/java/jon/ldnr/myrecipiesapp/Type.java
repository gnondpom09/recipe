package jon.ldnr.myrecipiesapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "dishtypes")
public class Type {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_type")
    private int typeId;

    @ColumnInfo(name = "typename")
    @NonNull
    private String typeName;

    @ColumnInfo(name = "url_typeimage")
    @NonNull
    private String urlTypeImage;


    // constructors
    public Type(String typeName, String urlTypeImage) {
        this.typeName = typeName;
        this.urlTypeImage = urlTypeImage;
    }


    public int getTypeId() {
        return this.typeId;
    }

    public void setTypeId(int id){
        this.typeId=id;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String type) {
        this.typeName = type;
    }


    public String getUrlTypeImage() {
        return this.urlTypeImage;
    }

    public void setUrlTypeImage(String url) {
        this.urlTypeImage= url;
    }

}
