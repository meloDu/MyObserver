package com.rmtd.melo.myobserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText mEditText;
    Button mButton;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.et_name);
        mButton = (Button) findViewById(R.id.btn_ok);
        mTextView= (TextView) findViewById(R.id.tv_content);
        final Observable<Person> observable = new Observable<Person>();
        Observer<Person> observer1 = new Observer<Person>() {
            @Override
            public void onUpdate(Observable<Person> observable, Person data) {
                Log.i("tag", "observer1:" + data.getname());
                mTextView.setText(data.getname());
            }
        };

        Observer<Person> observer2 = new Observer<Person>() {
            @Override
            public void onUpdate(Observable<Person> observable, Person data) {
                Log.i("tag", "observer2:" + data.getname());
            }
        };

        observable.register(observer1);
        observable.register(observer2);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = mEditText.getText().toString();
                Person person = new Person(str);
                observable.notifyObservers(person);
            }
        });


    }


}
