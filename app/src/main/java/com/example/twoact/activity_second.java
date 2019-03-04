package com.example.twoact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class activity_second extends AppCompatActivity {
public static final String EXTRA_REPLAY =
         "com.example.android.twoactivities.extra.REPLAY";

    private EditText mReplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReplay = (EditText) findViewById(R.id.editText_Second);

        Intent intent = getIntent();

        String message =
                intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = (TextView) findViewById(R.id.text_message);
        textView.setText(message);

    }

    public void returnReplay(View view) {
        String replay = mReplay.getText().toString();

        Intent replayIntent = new Intent();
        replayIntent.putExtra(EXTRA_REPLAY, replay);
        setResult(RESULT_OK, replayIntent);
        finish();
    }
}
