package com.example.bkd0708k11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.bkd0708k11.adapters.PersonAdapter;
import com.example.bkd0708k11.domains.Person;

import java.util.ArrayList;

public class Session9 extends AppCompatActivity {
    ArrayList<String> checkedHobbies = new ArrayList<>();
    String checkedGender = "";
    ToggleButton tglConfig;
    Spinner spnSelectPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session9);
        tglConfig = findViewById(R.id.tglConfig);
        tglConfig.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println(isChecked);
            }
        });
        spnSelectPerson = findViewById(R.id.spnSelectPerson);
        ArrayList<Person> fakePersonData = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            fakePersonData.add(new Person("Nguyen Thanh Nam " + i, 20 + i + ""));
        }
        PersonAdapter personAdapter = new PersonAdapter(Session9.this, fakePersonData);
        spnSelectPerson.setAdapter(personAdapter);

        spnSelectPerson.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Session9.this, "Bạn đã chọn " + fakePersonData.get(position).getName(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Session9.this, "Bạn không chọn gì hết", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onCheckHandler(View view) {
        CheckBox checkBox = (CheckBox) view;
        boolean isChecked = checkBox.isChecked();//cho biết là checkbox đc check hay là không
        switch (view.getId()) {
            case R.id.cboGame:
                //xử lý trong trưường hợp check/uncheck game
                if (isChecked) {
                    checkedHobbies.add("game");
                } else {
                    checkedHobbies.remove("game");
                }
                break;

            case R.id.cboCoding:
                //xử lý trong trường hợp check/uncheck coding
                if (isChecked) {
                    checkedHobbies.add("coding");
                } else {
                    checkedHobbies.remove("coding");
                }
                break;

            case R.id.cboBoxing:
                //xử lý trong trường hợp check/uncheck boxing
                if (isChecked) {
                    checkedHobbies.add("boxing");
                } else {
                    checkedHobbies.remove("boxing");
                }
                break;
        }
    }

    public void onCheckGenderHandler(View view) {
        boolean isChecked = ((RadioButton) view).isChecked();
        if (view.getId() == R.id.rdoFemale && isChecked) {
            checkedGender = "female";
        } else if (view.getId() == R.id.rdoMale && isChecked) {
            checkedGender = "male";
        }
    }

    public void getCheckedResult(View v) {
        for (int i = 0; i < checkedHobbies.size(); i++) {
            System.out.println(checkedHobbies.get(i));
        }

        System.out.println("Bạn đã chọn giới tính là ");
        System.out.println(checkedGender);
    }
}