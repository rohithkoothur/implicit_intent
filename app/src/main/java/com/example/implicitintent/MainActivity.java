package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mwebsiteEdittext;
    private EditText mopenlocationEdittext;
    private EditText mopenshareEdittext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mwebsiteEdittext = findViewById(R.id.website_edit_text);
        mopenlocationEdittext = findViewById(R.id.location_edit_text);
        mopenshareEdittext = findViewById(R.id.share_edit_text);

        
    }

    public void openWebsite(View view) {
        String url = mwebsiteEdittext.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Log.d("Intent_error", "Cannot open website");
        }
    }

    public void openLocation(View view) {
        String loc = mopenlocationEdittext.getText().toString();
        Uri openloc = Uri.parse(loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, openloc);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Log.d("Intent_error", "Cannot open website");
        }




    }

    public void shareText(View view) {
        String share =mopenshareEdittext.getText().toString();
        String mimetype = "Text/Plain";
        ShareCompat.IntentBuilder.from(this).setChooserTitle(R.string.enterattext).setType(mimetype).setText(share).startChooser();



    }
}