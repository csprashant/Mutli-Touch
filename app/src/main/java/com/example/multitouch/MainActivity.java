package com.example.multitouch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int touchType,countPointerUp,countPointerDown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.constaint_layout).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                touchType=event.getActionMasked();
                switch (touchType){
                    case MotionEvent.ACTION_POINTER_DOWN:
                        countPointerDown=event.getPointerCount();
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                        countPointerUp=event.getPointerCount();
                        break;
                }
                ((TextView)findViewById(R.id.result)).setText("Number of Touch Down :"+countPointerDown+" Number of Touch UP :"+countPointerUp);
                return true;
            }
        });
    }
}