package com.example.bkd0708k11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {
    ImageView imgView;
    private GestureDetectorCompat mDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDetectorCompat = new GestureDetectorCompat(this, this);
        mDetectorCompat.setOnDoubleTapListener(this);
    }

    public void tapOnImage(View view) {
        Toast.makeText(this, "Bạn đã click vào ảnh", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        System.out.println("Double Tap Event");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        System.out.println("on Long Press");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        System.out.println("on Fling");
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
/*        int action = MotionEventCompat.getActionMasked(event);
        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                System.out.println("action down");
                break;

            case (MotionEvent.ACTION_UP):
                System.out.println("action up");
                break;

            case (MotionEvent.ACTION_MOVE):
                System.out.println("action move");
                break;
        }

        return super.onTouchEvent(event);*/

        if (this.mDetectorCompat.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }
}