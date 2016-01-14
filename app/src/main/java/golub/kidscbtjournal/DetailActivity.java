package golub.kidscbtjournal;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by Hindy on 1/4/2016.
 */
public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        ArrayList<JournalEntry> entries = (ArrayList<JournalEntry>) getIntent().getSerializableExtra("ENTRIES");


        EntryPagerAdapter adapter = new EntryPagerAdapter(entries);
        viewPager.setAdapter(adapter);

        int position = getIntent().getIntExtra("POSITION", 0);
        viewPager.setCurrentItem(position);

    }


}
