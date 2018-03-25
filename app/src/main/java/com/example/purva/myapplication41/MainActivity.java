package com.example.purva.myapplication41;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextName);
        if(name != null){
            name.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    return false;
                }
            });
        }
        Button dial = findViewById(R.id.button);
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialNumber();
            }
        });




    }

/*    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        boolean mHandled = false;
        if (actionId ==  EditorInfo.IME_ACTION_SEND) {
            dialNumber();
            mHandled = true;
        }
        return mHandled;
    }*/

    private void dialNumber() {

        String mPhoneNum = null;
        if (name != null) mPhoneNum = "tel:" + name.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(mPhoneNum));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
