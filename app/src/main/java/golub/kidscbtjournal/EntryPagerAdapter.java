package golub.kidscbtjournal;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Hindy on 1/4/2016.
 */
public class EntryPagerAdapter extends PagerAdapter {
    private ArrayList<JournalEntry> entries;

    public EntryPagerAdapter(ArrayList<JournalEntry> entries){
        this.entries = entries;
    }


    @Override
    public int getCount() {
        return entries.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public Object instantiateItem(ViewGroup container, int position){
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.journal_entry_item, null);

        TextView date = (TextView)view.findViewById(R.id.date);
        TextView event = (TextView)view.findViewById(R.id.event);
        TextView userEvent= (TextView)view.findViewById(R.id.userEvent);
        TextView feeling= (TextView)view.findViewById(R.id.feeling);
        TextView userFeeling = (TextView)view.findViewById(R.id.userFeeling);
        TextView feelingb = (TextView) view.findViewById(R.id.feelingb);
        TextView userFeelingb = (TextView)view.findViewById(R.id.userFeelingb);
        TextView rate = (TextView)view.findViewById(R.id.rate);
        TextView userRate = (TextView)view.findViewById(R.id.userRate);
        TextView action = (TextView)view.findViewById(R.id.action);
        TextView userAction = (TextView)view.findViewById(R.id.userAction);
        TextView thought = (TextView)view.findViewById(R.id.thought);
        TextView userThought = (TextView)view.findViewById(R.id.userThought);
        TextView help = (TextView)view.findViewById(R.id.help);
        TextView yesNo = (TextView)view.findViewById(R.id.yesNo);
        TextView nextThought = (TextView)view.findViewById(R.id.nextThoughts);
        TextView userNextThought = (TextView)view.findViewById(R.id.userNextThoughts);

        date.append(entries.get(position).getDate());
        userEvent.setText(entries.get(position).getEvent());
        userFeeling.setText(entries.get(position).getFeeling());
        userFeelingb.setText(entries.get(position).getFeelingb());
        userRate.setText(String.valueOf(entries.get(position).getRate()));
        userAction.setText(entries.get(position).getAction());
        userThought.setText(entries.get(position).getThought());
        yesNo.setText(entries.get(position).getYesNo());
        userNextThought.setText(entries.get(position).getNextThought());


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
