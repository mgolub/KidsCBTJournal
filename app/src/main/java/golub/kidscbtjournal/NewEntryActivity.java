package golub.kidscbtjournal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Hindy on 1/6/2016.
 */
public class NewEntryActivity extends AppCompatActivity {

    private int value = 1;
    private RadioButton checkedRadioButton;
    private RadioButton checkedRadioButton2;

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

        //final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        // radioGroup.clearCheck();

        final RadioButton happy = (RadioButton) findViewById(R.id.happy);
        final RadioButton sad = (RadioButton) findViewById(R.id.sad);
        final RadioButton lonely = (RadioButton) findViewById(R.id.lonely);
        final RadioButton nervous = (RadioButton) findViewById(R.id.nervous);
        final RadioButton excited = (RadioButton) findViewById(R.id.excited);
        final RadioButton guilty = (RadioButton) findViewById(R.id.guilty);
        final RadioButton embarrassed = (RadioButton) findViewById(R.id.embarrassed);
        final RadioButton angry = (RadioButton) findViewById(R.id.angry);
        final RadioButton stressed = (RadioButton) findViewById(R.id.stressed);

        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton = happy;
                happy.setChecked(true);
                sad.setChecked(false);
                lonely.setChecked(false);
                nervous.setChecked(false);
                excited.setChecked(false);
                guilty.setChecked(false);
                embarrassed.setChecked(false);
                angry.setChecked(false);
                stressed.setChecked(false);
            }
        });
        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton = sad;
                sad.setChecked(true);
                happy.setChecked(false);
                lonely.setChecked(false);
                nervous.setChecked(false);
                excited.setChecked(false);
                guilty.setChecked(false);
                embarrassed.setChecked(false);
                angry.setChecked(false);
                stressed.setChecked(false);
            }
        });
        lonely.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton = lonely;
                lonely.setChecked(true);
                sad.setChecked(false);
                happy.setChecked(false);
                nervous.setChecked(false);
                excited.setChecked(false);
                guilty.setChecked(false);
                embarrassed.setChecked(false);
                angry.setChecked(false);
                stressed.setChecked(false);
            }
        });
        nervous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton = nervous;
                nervous.setChecked(true);
                sad.setChecked(false);
                lonely.setChecked(false);
                happy.setChecked(false);
                excited.setChecked(false);
                guilty.setChecked(false);
                embarrassed.setChecked(false);
                angry.setChecked(false);
                stressed.setChecked(false);
            }
        });
        excited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton = excited;
                excited.setChecked(true);
                sad.setChecked(false);
                lonely.setChecked(false);
                nervous.setChecked(false);
                happy.setChecked(false);
                guilty.setChecked(false);
                embarrassed.setChecked(false);
                angry.setChecked(false);
                stressed.setChecked(false);
            }
        });
        guilty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton = guilty;
                guilty.setChecked(true);
                sad.setChecked(false);
                lonely.setChecked(false);
                nervous.setChecked(false);
                excited.setChecked(false);
                happy.setChecked(false);
                embarrassed.setChecked(false);
                angry.setChecked(false);
                stressed.setChecked(false);
            }
        });
        embarrassed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton = embarrassed;
                embarrassed.setChecked(true);
                sad.setChecked(false);
                lonely.setChecked(false);
                nervous.setChecked(false);
                excited.setChecked(false);
                guilty.setChecked(false);
                happy.setChecked(false);
                angry.setChecked(false);
                stressed.setChecked(false);
            }
        });
        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton = angry;
                angry.setChecked(true);
                sad.setChecked(false);
                lonely.setChecked(false);
                nervous.setChecked(false);
                excited.setChecked(false);
                guilty.setChecked(false);
                embarrassed.setChecked(false);
                happy.setChecked(false);
                stressed.setChecked(false);
            }
        });
        stressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton = stressed;
                happy.setChecked(true);
                sad.setChecked(false);
                lonely.setChecked(false);
                nervous.setChecked(false);
                excited.setChecked(false);
                guilty.setChecked(false);
                embarrassed.setChecked(false);
                angry.setChecked(false);
                happy.setChecked(false);
            }
        });

        TextView feelingb = (TextView) findViewById(R.id.feelingb);
        //final RadioGroup radioGroupb = (RadioGroup) findViewById(R.id.radioGroupb);
        //radioGroupb.clearCheck();

        final RadioButton happyb = (RadioButton) findViewById(R.id.happyb);
        final RadioButton sadb = (RadioButton) findViewById(R.id.sadb);
        final RadioButton lonelyb = (RadioButton) findViewById(R.id.lonelyb);
        final RadioButton nervousb = (RadioButton) findViewById(R.id.nervousb);
        final RadioButton excitedb = (RadioButton) findViewById(R.id.excitedb);
        final RadioButton guiltyb = (RadioButton) findViewById(R.id.guiltyb);
        final RadioButton embarrassedb = (RadioButton) findViewById(R.id.embarrassedb);
        final RadioButton angryb = (RadioButton) findViewById(R.id.angryb);
        final RadioButton stressedb = (RadioButton) findViewById(R.id.stressedb);

        happyb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton2 = happyb;
                happyb.setChecked(true);
                sadb.setChecked(false);
                lonelyb.setChecked(false);
                nervousb.setChecked(false);
                excitedb.setChecked(false);
                guiltyb.setChecked(false);
                embarrassedb.setChecked(false);
                angryb.setChecked(false);
                stressedb.setChecked(false);
            }
        });
        sadb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton2 = sadb;
                sadb.setChecked(true);
                happyb.setChecked(false);
                lonelyb.setChecked(false);
                nervousb.setChecked(false);
                excitedb.setChecked(false);
                guiltyb.setChecked(false);
                embarrassedb.setChecked(false);
                angryb.setChecked(false);
                stressedb.setChecked(false);
            }
        });
        lonelyb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton2 = lonelyb;
                lonelyb.setChecked(true);
                sadb.setChecked(false);
                happyb.setChecked(false);
                nervousb.setChecked(false);
                excitedb.setChecked(false);
                guiltyb.setChecked(false);
                embarrassedb.setChecked(false);
                angryb.setChecked(false);
                stressedb.setChecked(false);
            }
        });
        nervousb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton2 = nervousb;
                nervousb.setChecked(true);
                sadb.setChecked(false);
                lonelyb.setChecked(false);
                happyb.setChecked(false);
                excitedb.setChecked(false);
                guiltyb.setChecked(false);
                embarrassedb.setChecked(false);
                angryb.setChecked(false);
                stressedb.setChecked(false);
            }
        });
        excitedb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton2 = excitedb;
                excitedb.setChecked(true);
                sadb.setChecked(false);
                lonelyb.setChecked(false);
                nervousb.setChecked(false);
                guiltyb.setChecked(false);
                embarrassedb.setChecked(false);
                angryb.setChecked(false);
                stressedb.setChecked(false);
            }
        });
        guiltyb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton2 = guiltyb;
                guiltyb.setChecked(true);
                sadb.setChecked(false);
                lonelyb.setChecked(false);
                nervousb.setChecked(false);
                excitedb.setChecked(false);
                happyb.setChecked(false);
                embarrassedb.setChecked(false);
                angryb.setChecked(false);
                stressedb.setChecked(false);
            }
        });
        embarrassedb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton2 = embarrassedb;
                embarrassedb.setChecked(true);
                sadb.setChecked(false);
                lonelyb.setChecked(false);
                nervousb.setChecked(false);
                excitedb.setChecked(false);
                guiltyb.setChecked(false);
                happyb.setChecked(false);
                angryb.setChecked(false);
                stressedb.setChecked(false);
            }
        });
        angryb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton2 = angryb;
                angryb.setChecked(true);
                sadb.setChecked(false);
                lonelyb.setChecked(false);
                nervousb.setChecked(false);
                excitedb.setChecked(false);
                guiltyb.setChecked(false);
                embarrassedb.setChecked(false);
                happyb.setChecked(false);
                stressedb.setChecked(false);
            }
        });
        stressedb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedRadioButton2 = stressedb;
                happyb.setChecked(true);
                sadb.setChecked(false);
                lonelyb.setChecked(false);
                nervousb.setChecked(false);
                excitedb.setChecked(false);
                guiltyb.setChecked(false);
                embarrassedb.setChecked(false);
                angryb.setChecked(false);
                happyb.setChecked(false);
            }
        });


        TextView rate = (TextView) findViewById(R.id.rate);
        ImageView mood = (ImageView) findViewById(R.id.moodPic);
        mood.setImageResource(R.drawable.mood);

        TextView feelingsThermo = (TextView) findViewById(R.id.feelingsThermo);
        feelingsThermo.setText("10 Ahhh!!!! \n 9 Freaking out! \n 8 Very bad! \n " +
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


        TextView help = (TextView) findViewById(R.id.help);
        final RadioGroup yesNo = (RadioGroup) findViewById(R.id.yesNo);
        yesNo.clearCheck();

        TextView thoughtsNext = (TextView) findViewById(R.id.nextThoughts);
        final EditText userNextThoughts = (EditText) findViewById(R.id.userNextThoughts);
        Button button = (Button) findViewById(R.id.submitButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String event = userEvent.getText().toString();

                //RadioButton rb = (RadioButton)radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
                // String feeling = rb.getText().toString();
                String feeling = checkedRadioButton.getText().toString();

                //RadioButton rb2 = (RadioButton)radioGroupb.findViewById(radioGroupb.getCheckedRadioButtonId());
                // String feelingb = rb2.getText().toString();
                String feelingb = checkedRadioButton2.getText().toString();

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
