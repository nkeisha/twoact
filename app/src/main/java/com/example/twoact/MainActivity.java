 package com.example.twoact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {
     private static final String LOG_TAG =
             MainActivity.class.getSimpleName();

     public static final String EXTRA_MESSAGE;

     static {
         EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
     }

     private EditText mMessageEditText;

     public static final int TEXT_REQUEST = 1;

     private TextView mReplyHeadTextView;
     private TextView mReplyTextView;
     private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessageEditText = (EditText) findViewById(R.id.editText_Main);
        mReplyHeadTextView = (TextView) findViewById(R.id.text_header_replay);
        mReplyTextView = (TextView) findViewById(R.id.text_message_replay);

    }

     public void launchSecondActivity(View view) {
         Log.d(LOG_TAG, "Button Clicked" );
                 Intent intent = new Intent(this,  activity_second.class);
                 String message = mMessageEditText.getText().toString();

                 intent.putExtra(EXTRA_MESSAGE, message);
                 startActivityForResult(intent, TEXT_REQUEST);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String replay =
                        data.getStringExtra(activity_second.EXTRA_REPLAY);

                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(replay);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
 }
