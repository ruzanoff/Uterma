package ru.opi_opi.uterma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void GoAsk(View view) {
        Intent resultIntent = new Intent(this, ToAsk.class);
        startActivity(resultIntent);
    }

    public void GoSet(View view) {
        Intent resultIntent = new Intent(this, Set.class);
        startActivity(resultIntent);
    }
    //Бардак

}
