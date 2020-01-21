package edu.pacificu.cs.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity
{
    private Display mDisplay;
    private AnimationView mGraphicsView;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);

        WindowManager window = getWindowManager ();
        mDisplay = window.getDefaultDisplay ();

        mGraphicsView = new AnimationView (this, mDisplay);
        mGraphicsView.setBackgroundColor (Color.BLACK);
        setContentView (mGraphicsView);
    }
}

