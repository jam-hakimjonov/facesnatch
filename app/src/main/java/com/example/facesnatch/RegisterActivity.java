package com.example.facesnatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.facesnatch.Common.Common;
import com.example.facesnatch.Model.APIResponse;
import com.example.facesnatch.Remote.IMyAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    TextView txt_login;
    EditText edt_id, edt_password, edt_name, edt_position;
    Button btn_register;


    IMyAPI mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Init Service
        mService = Common.getAPI();

        //Init View
        txt_login = (TextView) findViewById(R.id.txt_login);
        edt_id = (EditText) findViewById(R.id.edt_id);
        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_password = (EditText) findViewById(R.id.edt_password);
        edt_position = (EditText) findViewById(R.id.edt_position);
        btn_register = (Button) findViewById(R.id.btn_register);



        //Event
        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewUser(edt_id.getText().toString(), edt_name.getText().toString(), edt_position.getText().toString(), edt_password.getText().toString());
            }
        });
    }

    private void createNewUser(String id, String name, String position, String password) {
        mService.registerUser(id, name, position, password).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                APIResponse result = response.body();
                if (result.isError()){
                    Toast.makeText(RegisterActivity.this, result.getError_msg(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RegisterActivity.this, "Register Success. User: "+edt_id.getText().toString(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                }
            }
            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}