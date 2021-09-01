package edu.mssu.cis385.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG= MainActivity.class.getSimpleName();

    public static final String EXTRA_MESSAGE = "edu.mssu.cis385.TwoActivities.extra.MESSAGE";

    public static final int TEXT_REQUEST = 1;

    private EditText mMessageEditText;
    private TextView mMessageHeader;
    private TextView mMessageBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText=findViewById(R.id.editText_message);
        mMessageHeader= findViewById(R.id.textView_mainHeader);
        mMessageBody= findViewById(R.id.textView_mainMessage);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== TEXT_REQUEST){
            if(resultCode==RESULT_OK){
                String message = data.getStringExtra(SecondActivity.EXTRA_SECOND_MESSAGE);
                mMessageBody.setText(message);
                mMessageHeader.setVisibility(View.VISIBLE);
                mMessageBody.setVisibility(View.VISIBLE);
            }
        }
    }

    public void LaunchSecondActivity(View view) {
        Log.d(LOG,"Button Clicked");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent, TEXT_REQUEST);

    }
}