package golub.kidscbtjournal;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ArrayList<JournalEntry> entries;
    public Database database;
    int numEntries = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        entries = new ArrayList<JournalEntry>();
        database = new Database(this);

        Cursor cursor = database.getAllEntries();
        JournalEntry entry;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String date = cursor.getString(1);
            String event = cursor.getString(2);
            String feeling = cursor.getString(3);
            String feelingb = cursor.getString(4);
            String rate = cursor.getString(5);
            String action = cursor.getString(6);
            String thought = cursor.getString(7);
            String yesNo = cursor.getString(8);
            String nextThought = cursor.getString(9);

            entry = new JournalEntry(date, event, feeling, feelingb, Integer.parseInt(rate), action, thought, yesNo, nextThought);
            entries.add(entry);
            numEntries++;
            cursor.moveToNext();
        }

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(entries);
        recyclerView.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "New Entry", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, NewEntryActivity.class);
                intent.putExtra("ENTRIES", entries);
                intent.putExtra("POSITION", 0);
                MainActivity.this.startActivity(intent);
            }
        });

    }


    public void onResume() {
        super.onResume();
        Cursor cursor = database.getAllEntries();
        JournalEntry entry;
        cursor.move(numEntries);
        while (!cursor.isAfterLast()) {
            String date = cursor.getString(1);
            String event = cursor.getString(2);
            String feeling = cursor.getString(3);
            String feelingb = cursor.getString(4);
            String rate = cursor.getString(5);
            String action = cursor.getString(6);
            String thought = cursor.getString(7);
            String yesNo = cursor.getString(8);
            String nextThought = cursor.getString(9);

            entry = new JournalEntry(date, event, feeling, feelingb, Integer.parseInt(rate), action, thought, yesNo, nextThought);
            entries.add(entry);
            numEntries++;
            cursor.moveToNext();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        new MenuInflater(getApplication()).inflate(R.menu.menu_main, menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(this, AboutMeActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
