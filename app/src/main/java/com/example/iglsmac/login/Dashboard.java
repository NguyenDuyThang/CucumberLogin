package com.example.iglsmac.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {
    private Button btnLogout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        this.btnLogout = (Button)this.findViewById(R.id.btnLogout);

        this.btnLogout.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                Dashboard.this.finish();
            }
        });
    }
}
