package com.example.iglsmac.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin = null;
    private EditText editEmail = null;
    private EditText editPassword = null;
    private TextView subAnnounceText = null;
    private TextView announceText = null;
    private String[] emailArray = {"kcpm@gmail.com", "hoami@gmail.com"};
    private String[] passwordArray = {"qwerty", "hoami"};
    //Những account nào không có trong mảng này => Fail (vd như ecec@gmail.com bên file .feature)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnLogin = (Button)this.findViewById(R.id.btnLogin);
        this.editEmail = (EditText)this.findViewById(R.id.editEmail);
        this.editPassword = (EditText)this.findViewById(R.id.editPassword);
        this.subAnnounceText = (TextView)this.findViewById(R.id.subAnnounceText);
        this.announceText = (TextView)this.findViewById(R.id.announceText);
        this.subAnnounceText.setText("");
        this.announceText.setText("");

        this.btnLogin.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();

                if (email.equals("")) {
                    announceText.setText("Email can not be empty");
                    return;
                }

                if (password.equals("")) {
                    announceText.setText("Password can not be empty");
                    return;
                }

                subAnnounceText.setText("Login ");
                if(_authorizingAccount(email, password)){
                    announceText.setText("Success");
                }
                else{
                    announceText.setText("Fail");
                }
            }
        });
    }

    private boolean _authorizingAccount(String email, String password){
        Boolean existed = false;
        for(int i = 0;i < this.emailArray.length; i++){
            if(this.emailArray[i].equals(email) && this.passwordArray[i].equals(password)){
                existed = true;
                break;
            }
        }

        if(existed){
            return true;
        }
        return false;
    }
}
