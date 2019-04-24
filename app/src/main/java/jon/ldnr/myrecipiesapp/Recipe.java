package jon.ldnr.myrecipiesapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.util.Date;


/*
,
        foreignKeys = {
@ForeignKey(entity = User.class,
        parentColumns = "id_user",
        childColumns = "id_author"),
@ForeignKey(entity = Type.class,
        parentColumns = "id_type",
        childColumns = "id_type")
            },
                    indices = {@Index(value = {"id_author"}), @Index(value = {"id_type"})}
*/
//TODO onDelete = ForeignKey.CASCADE
@Entity(tableName = "recipes",
        foreignKeys = {
                @ForeignKey(entity = User.class,
                        parentColumns = "id_user",
                        childColumns = "id_author"),
                @ForeignKey(entity = Type.class,
                        parentColumns = "id_type",
                        childColumns = "id_type")},
        indices = {
                @Index(value =
                        {"id_author"}
                        ),
                @Index(value =
                        {"id_type"}
                        )
                }
        )
public class Recipe {

    // TODO comment attributes
    @ColumnInfo(name = "id_recipe")
    @PrimaryKey(autoGenerate = true)
    private int recipeId;

    @ColumnInfo(name = "title")
    @NonNull
    private String title;

    @ColumnInfo(name = "id_author")
    private int authorId;

    @ColumnInfo(name = "id_type")
    private int typeId;

//    @ColumnInfo(name = "date_creation")
//    @NonNull
//    @TypeConverters(DateConverter.class)
//    private Date dateCreate;
//
//    @ColumnInfo(name = "date_update")
//    @NonNull
//    @TypeConverters(DateConverter.class)
//    private Date dateUpdate;

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


    // Constructors
    public Recipe(int authorId, int typeId, @NonNull String title, @NonNull String ingredients, @NonNull String utensils, @NonNull String duration, String comment) {
        this.title = title;
        this.authorId = authorId;
        this.typeId = typeId;
//        this.dateCreate = new Date();
//        this.dateUpdate = new Date();
        this.ingredients = ingredients;
        this.utensils = utensils;
        this.duration = duration;
        this.comment = comment;
    }

//    public Recipe(String title) {
//        this.title = title;
//    }

    // our getters and setters for recipe entities
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

//    public Date getDateCreate() {
//        return this.dateCreate;
//    }
//
//    public void setDateCreate(Date date) {
//        this.dateCreate = date;
//    }
//
//    public Date getDateUpdate() {
//        return this.dateUpdate;
//    }
//
//    public void setDateUpdate(Date date) {
//        this.dateUpdate = date;
//    }
//
    public String getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getUtensils() {
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
