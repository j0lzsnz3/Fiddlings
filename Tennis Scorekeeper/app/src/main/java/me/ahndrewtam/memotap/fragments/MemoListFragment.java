package me.ahndrewtam.memotap.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;
import me.ahndrewtam.memotap.R;
import me.ahndrewtam.memotap.adapters.MatchesAdapter;
import me.ahndrewtam.memotap.adapters.RealmMemosAdapter;
import me.ahndrewtam.memotap.model.Match;
import me.ahndrewtam.memotap.realm.RealmController;

public class MemoListFragment extends Fragment{
    private MatchesAdapter adapter;
    private Realm realm;
    private FloatingActionButton fab;
    private RecyclerView recycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_memo_list, container, false);

        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        recycler = (RecyclerView) rootView.findViewById(R.id.recycler);

        this.realm = RealmController.with(this).getRealm();

        setupRecycler();

        RealmController.with(this).refresh();
        setRealmAdapter(RealmController.with(this).getMemos());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getActivity().getLayoutInflater();
                final View content = inflater.inflate(R.layout.edit_item, null);
                final EditText editTitle = (EditText) content.findViewById(R.id.title);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setView(content)
                        .setTitle("Add Match")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Match match = new Match();
                                match.setId(RealmController.getInstance().getMemos().size() + System.currentTimeMillis());
                                match.setTitle(editTitle.getText().toString());
                                match.setCount(0);

                                if (editTitle.getText() == null || editTitle.getText().toString().equals("") || editTitle.getText().toString().equals(" ")) {
                                    Toast.makeText(getActivity(), "Entry not saved, missing title", Toast.LENGTH_SHORT).show();
                                } else {
                                    realm.beginTransaction();
                                    realm.copyToRealm(match);
                                    realm.commitTransaction();

                                    adapter.notifyDataSetChanged();
                                }
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        return rootView;
    }

    public void setRealmAdapter(RealmResults<Match> matches) {
        RealmMemosAdapter realmAdapter = new RealmMemosAdapter(getActivity().getApplicationContext(), matches, true);
        adapter.setRealmAdapter(realmAdapter);
        adapter.notifyDataSetChanged();
    }

    private void setupRecycler() {
        recycler.setHasFixedSize(true);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(layoutManager);

        adapter = new MatchesAdapter(getActivity());
        recycler.setAdapter(adapter);
    }
}
