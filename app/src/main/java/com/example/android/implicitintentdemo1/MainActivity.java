package com.example.android.implicitintentdemo1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        btnProceed = (Button) findViewById(R.id.btn_proceed);

        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.intents, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = spinner.getSelectedItemPosition();
                Intent intent = null;

                switch (position){
                    case 0:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                        break;
                    case 1:
                        intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0164558863"));
                        break;
                    case 2:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:28.632323175362604,77.22595474023433?z=19"));
                        break;
                    case 3:
                        intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        break;
                    case 4:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                        break;
                }

                if(intent != null)
                    startActivity(intent);
            }
        });
    }
}
