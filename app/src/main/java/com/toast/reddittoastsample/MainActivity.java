package com.toast.reddittoastsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.toast.reddittoast.RedditToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RedditToast.RedditToastConfiguration.getInstance()
                .setBackgroundColor(Color.parseColor("#3f3f3f"))
                .setTextColor(Color.WHITE)
                .setTextSize(16)
                .setUseIcon(true)
                .commit();
        findViewById(R.id.defaultToast).setOnClickListener(v -> RedditToast.show(MainActivity.this, "This is default toast!",
                RedditToast.ToastType.DEFAULT));

        findViewById(R.id.successToast).setOnClickListener(v -> RedditToast.show(MainActivity.this, "This is success toast!",
                RedditToast.ToastType.SUCCESS));

        findViewById(R.id.errorToast).setOnClickListener(v -> RedditToast.show(MainActivity.this, "This is error toast!",
                RedditToast.ToastType.ERROR));

        findViewById(R.id.infoToast).setOnClickListener(v -> RedditToast.show(MainActivity.this, "This is info toast!",
                RedditToast.ToastType.INFO));

        findViewById(R.id.warningToast).setOnClickListener(v -> RedditToast.show(MainActivity.this, "This is warning toast!",
                RedditToast.ToastType.WARNING));

        findViewById(R.id.iconToast).setOnClickListener(v -> {
            Drawable icon = AppCompatResources.getDrawable(MainActivity.this, R.drawable.check);
            RedditToast.show(MainActivity.this, "This is with icon toast!", icon,
                    RedditToast.ToastType.SUCCESS);
        });

        findViewById(R.id.noIconToast).setOnClickListener(v -> {
            RedditToast.RedditToastConfiguration.getInstance().setUseIcon(false).commit();
            RedditToast.show(MainActivity.this, "This is without icon toast!",
                    RedditToast.ToastType.WARNING);
            RedditToast.RedditToastConfiguration.resetConfiguration();
        });

        findViewById(R.id.bgChangeToast).setOnClickListener(v -> {
            RedditToast.RedditToastConfiguration.getInstance().setBackgroundColor(Color.WHITE).setTextColor(Color.BLACK).commit();
            RedditToast.show(MainActivity.this, "Toast with White background.",
                    RedditToast.ToastType.SUCCESS);
            RedditToast.RedditToastConfiguration.resetConfiguration();
        });

        findViewById(R.id.fontChangeToast).setOnClickListener(v -> {
            Typeface typeface = Typeface.createFromAsset(getAssets(), "mr_robot.ttf");
            RedditToast.RedditToastConfiguration.getInstance().setToastTypeface(typeface).setDuration(RedditToast.LENGTH_LONG).commit();
            RedditToast.show(MainActivity.this, "Mr. Robot! Hackerman ",
                    R.drawable.robot, RedditToast.ToastType.WARNING);
            RedditToast.RedditToastConfiguration.resetConfiguration();
        });

    }
}