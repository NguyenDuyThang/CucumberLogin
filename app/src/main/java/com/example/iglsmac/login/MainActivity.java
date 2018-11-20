package com.example.iglsmac.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin = null;
    private EditText editEmail = null;
    private EditText editPassword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnLogin = (Button)this.findViewById(R.id.btnLogin);
        this.editEmail = (EditText)this.findViewById(R.id.editEmail);
        this.editPassword = (EditText)this.findViewById(R.id.editPassword);

        this.btnLogin.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();

                if(_authorizingAccount(email, password)){
                    Intent goToDashboard = new Intent(MainActivity.this, Dashboard.class);

                    MainActivity.this.startActivity(goToDashboard);
                }
                else{
                    Toast.makeText(MainActivity.this, "Incorrect email or password, try again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean _authorizingAccount(String email, String password){
        if(email.equals("kcpmt2@gmail.com") && password.equals("123456")){
            return true;
        }
        return false;
    }
}
