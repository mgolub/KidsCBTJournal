package golub.kidscbtjournal;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Hindy on 1/6/2016.
 */
public class NewEntryActivity extends AppCompatActivity {

    private int value = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_form);

        final Database database = new Database(this);

        TextView date = (TextView) findViewById(R.id.date);

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        String dayOfWeek = "Hello";
        if (day == 1) {
            dayOfWeek = "Sunday";
        }
        if (day == 2) {
            dayOfWeek = "Monday";
        }
        if (day == 3) {
            dayOfWeek = "Tuesday";
        }
        if (day == 4) {
            dayOfWeek = "Wednesday";
        }
        if (day == 5) {
            dayOfWeek = "Thursday";
        }
        if (day == 6) {
            dayOfWeek = "Friday";
        }
        if (day == 7) {
            dayOfWeek = "Saturday";
        }
        date.append(dayOfWeek);

        TextView event = (TextView) findViewById(R.id.event);
        final EditText userEvent = (EditText) findViewById(R.id.userEvent);

        TextView feeling = (TextView) findViewById(R.id.feeling);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.clearCheck();


        TextView feelingb = (TextView)findViewById(R.id.feelingb);
        final RadioGroup radioGroupb = (RadioGroup) findViewById(R.id.radioGroupb);
        radioGroupb.clearCheck();

        TextView rate = (TextView) findViewById(R.id.rate);
       ImageView mood = (ImageView) findViewById(R.id.moodPic);
        mood.setImageResource(R.drawable.mood);

        TextView feelingsThermo = (TextView)findViewById(R.id.feelingsThermo);
        feelingsThermo.setText("10 Ahhh!!!! \n 9 Freeking out! \n 8 Very bad! \n " +
                "7 Bad! \n 6 This is hard! \n 5 Not good \n 4 A little uncomfortable \n " +
                "3 Could be worse \n 2 Okay, fine \n 1 Good. All is well");

        final SeekBar seekBar = (SeekBar) findViewById(R.id.moodBar);
        seekBar.setMax(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                value = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        TextView action = (TextView) findViewById(R.id.action);
        final EditText userAction = (EditText) findViewById(R.id.userAction);

        TextView thought = (TextView) findViewById(R.id.thought);
        final EditText userThought = (EditText) findViewById(R.id.userThought);


        TextView help = (TextView)findViewById(R.id.help);
        final RadioGroup yesNo = (RadioGroup)findViewById(R.id.yesNo);
        yesNo.clearCheck();

        TextView thoughtsNext = (TextView)findViewById(R.id.nextThoughts);
        final EditText userNextThoughts = (EditText)findViewById(R.id.userNextThoughts);
        Button button = (Button) findViewById(R.id.submitButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String event = userEvent.getText().toString();

               RadioButton rb = (RadioButton)radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
               String feeling = rb.getText().toString();

                RadioButton rb2 = (RadioButton)radioGroupb.findViewById(radioGroupb.getCheckedRadioButtonId());
                String feelingb = rb2.getText().toString();

                String action = userAction.getText().toString();
                String thought = userThought.getText().toString();

                RadioButton answer = (RadioButton) yesNo.findViewById(yesNo.getCheckedRadioButtonId());
                String yesNo = answer.getText().toString();
                String nextThought = userNextThoughts.getText().toString();

                Date today = Calendar.getInstance().getTime();
                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy  hh:mm");
                String date = format.format(today);

                database.insertEntry(date, event, feeling, feelingb, String.valueOf(value), action, thought, yesNo, nextThought);

                finish();

            }
        });

    }
}
