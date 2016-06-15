package me.ahndrewtam.memotap.model;

import io.realm.RealmObject;

public class RealmInteger extends RealmObject {
    private int integer;

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }
}
