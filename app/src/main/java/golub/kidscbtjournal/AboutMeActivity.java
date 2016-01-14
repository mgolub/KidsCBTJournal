package golub.kidscbtjournal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Hindy on 1/11/2016.
 */
public class AboutMeActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private SharedPreferences preferences;

    EditText userName;
    EditText age;
    EditText hairColor;
    EditText eyeColor;
    EditText familyInput;
    EditText userColor;
    EditText userBook;
    EditText userSport;
    EditText userFood;
    EditText userAnimal;
    EditText userSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_me);

        this.preferences = this.getSharedPreferences("DEFAULT", MODE_PRIVATE);

        this.imageView = (ImageView) this.findViewById(R.id.userPic);
        Button photoButton = (Button) this.findViewById(R.id.button1);
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });


        TextView aboutMe = (TextView) findViewById(R.id.Me);
        TextView nameIs = (TextView) findViewById(R.id.name);
        userName = (EditText) findViewById(R.id.userName);
        TextView Iam = (TextView) findViewById(R.id.Iam);
        age = (EditText) findViewById(R.id.age);
        TextView yearsOld = (TextView) findViewById(R.id.yearsOld);
        TextView Ihave = (TextView) findViewById(R.id.Ihave);
        hairColor = (EditText) findViewById(R.id.hairColor);
        TextView hair = (TextView) findViewById(R.id.hair);
        eyeColor = (EditText) findViewById(R.id.eyeColor);
        TextView eye = (TextView) findViewById(R.id.eye);
        TextView myFamily = (TextView) findViewById(R.id.family);
        familyInput = (EditText) findViewById(R.id.familyInput);
        TextView favorite = (TextView) findViewById(R.id.favorite);
        TextView color = (TextView) findViewById(R.id.color);
        userColor = (EditText) findViewById(R.id.userColor);
        TextView book = (TextView) findViewById(R.id.book);
        userBook = (EditText) findViewById(R.id.userBook);
        TextView sport = (TextView) findViewById(R.id.sport);
        userSport = (EditText) findViewById(R.id.userSport);
        TextView food = (TextView) findViewById(R.id.food);
        userFood = (EditText) findViewById(R.id.userFood);
        TextView animal = (TextView) findViewById(R.id.animal);
        userAnimal = (EditText) findViewById(R.id.userAnimal);
        TextView subject = (TextView) findViewById(R.id.subject);
        userSubject = (EditText) findViewById(R.id.userSubject);

        Button close = (Button) findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }

    public void onPause() {
        super.onPause();

        imageView.buildDrawingCache();
        Bitmap bitmap = imageView.getDrawingCache();

        

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("NAME", userName.getText().toString());
        editor.putString("AGE", age.getText().toString());
        editor.putString("HAIRCOLOR", hairColor.getText().toString());
        editor.putString("EYECOLOR", eyeColor.getText().toString());
        editor.putString("FAMILYINPUT", familyInput.getText().toString());
        editor.putString("COLOR", userColor.getText().toString());
        editor.putString("BOOK", userBook.getText().toString());
        editor.putString("SPORT", userSport.getText().toString());
        editor.putString("FOOD", userFood.getText().toString());
        editor.putString("ANIMAL", userAnimal.getText().toString());
        editor.putString("SUBJECT", userSubject.getText().toString());
        editor.apply();

    }

    public void onResume() {
        super.onResume();
        userName.setText(preferences.getString("NAME", ""));
        age.setText(preferences.getString("AGE", ""));
        hairColor.setText(preferences.getString("HAIRCOLOR", ""));
        eyeColor.setText(preferences.getString("EYECOLOR", ""));
        familyInput.setText(preferences.getString("FAMILYINPUT", ""));
        userColor.setText(preferences.getString("COLOR", ""));
        userBook.setText(preferences.getString("BOOK", ""));
        userSport.setText(preferences.getString("SPORT", ""));
        userFood.setText(preferences.getString("FOOD", ""));
        userAnimal.setText(preferences.getString("ANIMAL", ""));
        userSubject.setText(preferences.getString("SUBJECT", ""));


    }
}
