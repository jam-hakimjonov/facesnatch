package com.example.facesnatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {
    TextView user_id;
    String id;
    ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        user_id = (TextView)findViewById(R.id.user_id);
        id = getIntent().getExtras().getString("ID");
        user_id.setText(id);

        photo = (ImageView)findViewById(R.id.btn_photo);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserActivity.this, CameraActivity.class));
            }
        });
    }
}