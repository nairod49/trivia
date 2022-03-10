package com.adaptionsoft.games.uglytrivia;

import java.lang.reflect.Array;

public class Category {
    int idCategory;
    String typeCategory;

    public Category(int idCategory, String typeCategory) {
        this.idCategory = idCategory;
        this.typeCategory = typeCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getTypeCategory() {
        return typeCategory;
    }

    public void setTypeCategory(String typeCategory) {
        this.typeCategory = typeCategory;
    }
}
