package com.example.tt.physicalkeyevent;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_MENU:
                makeToast("Menu key press!!");
                return  true;
            case KeyEvent.KEYCODE_SEARCH:
                makeToast("Search key press!!");
                return  true;
            case KeyEvent.KEYCODE_BACK:
                onBackPressed();
                return  true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                event.startTracking();
                return  true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                makeToast("Volumd down key press!!");
                return  false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_MENU:
                makeToast("Menu key release!!");
                return  true;
            case KeyEvent.KEYCODE_SEARCH:
                makeToast("Search key release!!");
                return  true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (event.isTracking()&& !event.isCanceled()) {
                    makeToast("Volume up key release!!");
                }
                return  true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                makeToast("Volume down key release!!");
                return  false;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        makeToast("Back key Press!!!");
        super.onBackPressed();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        makeToast("Touched on x: " + x + "y: " + y);
        return true;
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        makeToast("Press Key for a long time");
        return true;
    }

    private void makeToast(String meg) {
        Toast.makeText(getApplicationContext(),meg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

}
