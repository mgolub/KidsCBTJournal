package golub.kidscbtjournal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Hindy on 1/4/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecylerViewHolder> {

    private ArrayList<JournalEntry>entries;


    public RecyclerViewAdapter(ArrayList<JournalEntry> list){
        this.entries = list;
    }

    @Override
    public RecylerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.entry_list, parent, false);
        RecylerViewHolder holder = new RecylerViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecylerViewHolder holder, final int position) {
        holder.bind(entries.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("ENTRIES", entries);
                intent.putExtra("POSITION", position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }
}
