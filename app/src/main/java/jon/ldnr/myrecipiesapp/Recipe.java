package jon.ldnr.myrecipiesapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

@Entity(tableName = "recipe", foreignKeys = {@ForeignKey(entity = User.class, parentColumns = "userId", childColumns = "authorId"), @ForeignKey(entity = Type.class, parentColumns = "typeId", childColumns = "typeId")})
public class Recipe {

    @ColumnInfo(name = "id_recipe")
    @PrimaryKey(autoGenerate = true)
    private int recipeId;

    @ColumnInfo(name = "title")
    @NonNull
    private String title;

    private Type type;
    private Step step;

    @ColumnInfo(name = "id_author")
    @NonNull
    private int authorId;

    @ColumnInfo(name = "id_type")
    @NonNull
    private int typeId;

    @ColumnInfo(name = "date_creation")
    @NonNull
    private Date dateCreate;

    @ColumnInfo(name = "date_update")
    @NonNull
    private Date dateUpdate;

    @ColumnInfo(name = "ingredients")
    @NonNull
    private String ingredients;

    @ColumnInfo(name = "utensils")
    @NonNull
    private String utensils;

    @ColumnInfo(name = "duration")
    @NonNull
    private String duration;

    @ColumnInfo(name = "comment")
    private String comment;

    public int getRecipeId() {
        return this.recipeId;
    }

    public void setRecipeId(int id) {
        this.recipeId = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type t) {
        this.type = t;
    }

    public Step getStep() {
        return this.step;
    }

    public void setStep(Step stp) {
        this.step = stp;
    }

    public int getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(int id) {
        this.authorId = id;
    }

    public int getTypeId() {
        return this.typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }


    public Date getdateCreate() {
        return this.dateCreate;
    }

    public void setdateCreate(Date date) {
        this.dateCreate = date;
    }

    public Date getdateUpdate() {
        return this.dateUpdate;
    }

    public void setdateUpdatee(Date date) {
        this.dateUpdate = date;
    }

    public String getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getUtesils() {
        return this.utensils;
    }

    public void setUtensils(String utensils) {
        this.utensils = utensils;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
