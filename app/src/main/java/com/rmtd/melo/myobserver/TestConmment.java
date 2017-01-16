package com.rmtd.melo.myobserver;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by melo on 2017/1/16.
 */
public class TestConmment extends AppCompatActivity {
    EditText mEditText;
    Button mButton;
    TextView mTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testconmment);
        mButton= (Button) findViewById(R.id.btn_ok_test);
        mEditText = (EditText) findViewById(R.id.et_name_test);
        mTextView= (TextView) findViewById(R.id.tv_content_test);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = mEditText.getText().toString();
                Log.i("tag", "str:" + str);
                mTextView.setText(str);
            }
        });


    }
}
