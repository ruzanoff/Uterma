package ru.opi_opi.uterma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static ru.opi_opi.uterma.R.layout.setting;

public class Set extends Activity {
    DataUserHelper myDb;
    EditText editName;
    Button btnSetData;
    int selectedTest;
    Integer Key;
    TextView textSex, textAge, textKey;
    RadioButton rbtnMale, rbtnFemale;
    RadioGroup radioSex;
    String sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setting);
        myDb = new DataUserHelper(this);

        editName = (EditText) findViewById(R.id.editName);
        btnSetData = (Button) findViewById(R.id.btnSetData);
        SetData();

    }

    public void SetData() {
        btnSetData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        RadioButton myradiobutton = (RadioButton) findViewById(R.id.rbtnMale);
                        if (myradiobutton.isChecked())
                            sex = "male";
                        else
                            sex = "female";

                        /* boolean isInserted = myDb.insertData(editName.getText().toString()); */
                        boolean isInserted = myDb.updateData(editName.getText().toString(), "RU", sex, 2, 3);
                        if (isInserted = true)
                            Toast.makeText(Set.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        Intent resultIntent = new Intent(this, Main.class);
                        startActivity(resultIntent);
                        else
                        Toast.makeText(Set.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}
