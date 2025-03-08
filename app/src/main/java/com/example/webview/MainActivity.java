package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.webview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] browserImages = {R.drawable.facebook, R.drawable.github, R.drawable.gmail, R.drawable.linkdin,
                R.drawable.telegram,R.drawable.messenger, R.drawable.whatsapp, R.drawable.youtube};

        String[] browserName = {"Facebook", "GitHub", "Gmail", "Linkdin",
                "Telegram","Messenger","Whatsapp","Youtube"};

        String[] browserUrls = {
                "https://www.facebook.com",
                "https://www.github.com",
                "https://mail.google.com",
                "https://www.linkedin.com",
                "https://web.telegram.org",
                "https://www.messenger.com",
                "https://www.whatsapp.com",
                "https://www.youtube.com"
        };
        HomePageActivity  homePageActivity = new HomePageActivity(MainActivity.this, browserName, browserImages);
        binding.gridView.setAdapter(homePageActivity);

        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(browserUrls[position]));
                startActivity(intent);

            }
        });
    }
}