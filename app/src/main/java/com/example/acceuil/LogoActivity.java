package com.example.acceuil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class LogoActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.handyman);
        videoView.setOnCompletionListener(mp -> {
            // Passer directement à l'MainActivity sans attendre
            startActivity(new Intent(LogoActivity.this, LoginActivity.class));
            finish();
        });
        videoView.start();
    }
}
