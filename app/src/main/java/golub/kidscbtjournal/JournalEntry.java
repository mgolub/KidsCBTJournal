package golub.kidscbtjournal;

import golub.kidscbtjournal.MainActivity;
import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Created by Hindy on 1/4/2016.
 */
public class JournalEntry implements Serializable{

    private String date;
    private String event;
    private String feeling;
    private String feelingb;
    private int rate;
    private String action;
    private String thought;
    private String yesNo;
    private String nextThought;


    public String getYesNo() {
        return yesNo;
    }

    public JournalEntry(String date, String event, String feeling, String feelingb, int rate, String action, String thought, String yesNo, String nextThought){
        this.date = date;
        this.event = event;
        this.feeling = feeling;
        this.feelingb = feelingb;
        this.rate = rate;
        this.action = action;
        this.thought = thought;
        this.yesNo = yesNo;

        this.nextThought = nextThought;



    }


    public String getDate() {
        return date;
    }

    public String getEvent() {
        return event;
    }

    public String getFeeling() {
        return feeling;
    }

    public int getRate() {
        return rate;
    }

    public String getAction() {
        return action;
    }

    public String getThought() {
        return thought;
    }
    public String getFeelingb() {
        return feelingb;
    }

    public String getNextThought() {
        return nextThought;
    }
}
