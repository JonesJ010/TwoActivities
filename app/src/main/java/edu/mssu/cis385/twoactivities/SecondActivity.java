package edu.mssu.cis385.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mMessageTextView;
    private EditText mEditTextToSend;
    public static final String EXTRA_SECOND_MESSAGE = "edu.mssu.cis385.twoactivities.extra.SECOND_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mMessageTextView = findViewById(R.id.textView_message);
        mEditTextToSend = findViewById(R.id.editText_secondMessage);
        Intent intent = this.getIntent();
        String incomingMessage = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        mMessageTextView.setText(incomingMessage);
    }

    public void CloseSecondActivity(View view) {

        Intent intent = new Intent();
        intent.putExtra(EXTRA_SECOND_MESSAGE,mEditTextToSend.getText().toString());

        setResult(RESULT_OK, intent);

    }
}