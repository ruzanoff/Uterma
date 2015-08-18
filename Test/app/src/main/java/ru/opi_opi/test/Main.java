package ru.opi_opi.test;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class Main extends ActionBarActivity {

    private EditText txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        txtData = (EditText) findViewById(R.id.txtData);

    }

    public void GoTo (View view){
        Intent intent = new Intent(this, Result.class);
        intent.putExtra("data", txtData.getText().toString());
        startActivity(intent);

    }

}
