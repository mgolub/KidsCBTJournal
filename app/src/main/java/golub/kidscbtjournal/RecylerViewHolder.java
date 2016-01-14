package golub.kidscbtjournal;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Hindy on 1/4/2016.
 */
public class RecylerViewHolder extends RecyclerView.ViewHolder {

    private TextView date;
    private TextView feeling;


    public RecylerViewHolder(View itemView) {
        super(itemView);
        date = (TextView) itemView.findViewById(R.id.date);
        feeling = (TextView) itemView.findViewById(R.id.feeling);
    }

    public void bind(JournalEntry entry) {
        date.setText(entry.getDate());
        feeling.setText(entry.getFeeling());

    }
}
