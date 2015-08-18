package ru.opi_opi.uterma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main extends Activity {
    DataUserHelper myDb;

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
    //Проверяем регистрацию

/*    public int getShopCount() {
        String query = "SELECT * FROM " + AppData.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.close();
        return cursor.getCount();
    }*/

}
