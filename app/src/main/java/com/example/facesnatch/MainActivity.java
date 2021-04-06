package com.example.facesnatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.facesnatch.Common.Common;
import com.example.facesnatch.Model.APIResponse;
import com.example.facesnatch.Remote.IMyAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView txt_register;
    EditText edt_id, edt_password;
    Button btn_login;

    IMyAPI mService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init Service
        mService = Common.getAPI();

        //Init View
        txt_register = (TextView) findViewById(R.id.txt_register);
        edt_id = (EditText) findViewById(R.id.edt_id);
        edt_password = (EditText) findViewById(R.id.edt_password);
        btn_login = (Button) findViewById(R.id.btn_login);

        //Event
        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authenticateUser(edt_id.getText().toString(), edt_password.getText().toString());
            }
        });
    }

    private void authenticateUser(String id, String password) {
        mService.loginUser(id, password).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                APIResponse result = response.body();
                if (result.isError()){
                    Toast.makeText(MainActivity.this, result.getError_msg(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, UserActivity.class);
                    String user_id = edt_id.getText().toString();
                    i.putExtra("ID", user_id);
                    startActivity(i);
                    finish();
                }

            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
