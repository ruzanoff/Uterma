package ru.opi_opi.test;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Result extends ActionBarActivity {

    private TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        txtRes = (TextView) findViewById(R.id.txtRes);

        txtRes.setText(getIntent().getStringExtra("data"));
    }

    public void Back (View view){
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }

}
