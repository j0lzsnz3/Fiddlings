package me.ahndrewtam.memotap.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.ahndrewtam.memotap.R;
import me.ahndrewtam.memotap.model.Match;
import me.ahndrewtam.memotap.realm.RealmController;
import io.realm.Realm;

public class MatchesAdapter extends RealmRecyclerViewAdapter<Match> {
    final Context context;
    private Realm realm;

    public MatchesAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        realm = RealmController.getInstance().getRealm();

        final Match match = getItem(position);
        final CardViewHolder holder = (CardViewHolder) viewHolder;

        holder.duration.setText("Duration: " + match.getDuration());
        holder.date.setText(match.getDate());


        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
    }

    public int getItemCount() {
        return (getRealmAdapter() != null) ? getRealmAdapter().getCount() : 0;
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        public CardView card;
        public TextView duration;
        public TextView date;
        public TextView playerOne;
        public TextView[] playerOneScores = new TextView[5];
        public TextView playerTwo;
        public TextView[] playerTwoScores = new TextView[5];

        public CardViewHolder(View itemView) {
            super(itemView);

            card = (CardView) itemView.findViewById(R.id.card_match);
            duration = (TextView) itemView.findViewById(R.id.cardDuration);
            date = (TextView) itemView.findViewById(R.id.cardDate);

            playerOne = (TextView) itemView.findViewById(R.id.cardPlayerOneText);
            playerOneScores[0] = (TextView) itemView.findViewById(R.id.cardPlayerOneSetOne);
            playerOneScores[1] = (TextView) itemView.findViewById(R.id.cardPlayerOneSetTwo);
            playerOneScores[2] = (TextView) itemView.findViewById(R.id.cardPlayerOneSetThree);
            playerOneScores[3] = (TextView) itemView.findViewById(R.id.cardPlayerOneSetFour);
            playerOneScores[4] = (TextView) itemView.findViewById(R.id.cardPlayerOneSetFive);

            playerTwo = (TextView) itemView.findViewById(R.id.cardPlayerTwoText);
            playerTwoScores[0] = (TextView) itemView.findViewById(R.id.cardPlayerTwoSetOne);
            playerTwoScores[1] = (TextView) itemView.findViewById(R.id.cardPlayerTwoSetTwo);
            playerTwoScores[2] = (TextView) itemView.findViewById(R.id.cardPlayerTwoSetThree);
            playerTwoScores[3] = (TextView) itemView.findViewById(R.id.cardPlayerTwoSetFour);
            playerTwoScores[4] = (TextView) itemView.findViewById(R.id.cardPlayerTwoSetFive);

        }
    }
}
