package me.ahndrewtam.memotap.realm;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import me.ahndrewtam.memotap.model.Match;
import io.realm.Realm;
import io.realm.RealmResults;

public class RealmController {
    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment) {
        if (instance == null)
            instance = new RealmController(fragment.getActivity().getApplication());
        return instance;
    }

    public static RealmController with(Activity activity) {
        if (instance == null)
            instance = new RealmController(activity.getApplication());
        return instance;
    }

    public static RealmController with(Application application) {
        if (instance == null)
            instance = new RealmController(application);
        return instance;
    }

    public static RealmController getInstance() {
        return instance;
    }

    public Realm getRealm() {
        return realm;
    }

    public void refresh() {
        realm.refresh();
    }

    public void clearAll() {
        realm.beginTransaction();
        realm.clear(Match.class);
        realm.commitTransaction();
    }

    public RealmResults<Match> getMemos() {
        return realm.where(Match.class).findAll();
    }

    public Match getMemo(String id) {
        return realm.where(Match.class).equalTo("id", id).findFirst();
    }

    public boolean hasMemos() {
        return !realm.allObjects(Match.class).isEmpty();
    }

    public RealmResults<Match> queryedMemos() {
        return realm.where(Match.class)
                .contains("author", "Author 0")
                .or()
                .contains("title", "Realm")
                .findAll();
    }
}
