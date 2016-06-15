package me.ahndrewtam.memotap.adapters;

import android.content.Context;

import me.ahndrewtam.memotap.model.Match;
import io.realm.RealmResults;

public class RealmMemosAdapter extends RealmModelAdapter<Match> {

    public RealmMemosAdapter(Context context, RealmResults<Match> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }
}