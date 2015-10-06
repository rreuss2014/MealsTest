package com.rig.project1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Geo on 9/25/15.
 */
public class UsersInformation extends AppCompatActivity {

    Button submit;
    EditText name;
    EditText pass;

    TextView age;
    SeekBar seek;
    public int current = 0;
    String s = null;
    private Switch mySwitch;
    boolean hardMode = false;
    String gender = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);

        name = (EditText) findViewById(R.id.tvName);
        pass = (EditText) findViewById(R.id.tvPass);

        mySwitch = (Switch) findViewById(R.id.hardmode);


        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(sListener);

        age = (TextView) findViewById(R.id.textView3);

        seek = (SeekBar) findViewById(R.id.seekBar);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                current = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                s = Integer.toString(current);
                age.setText(s);

            }
        });

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    hardMode = true;


                } else {
                    hardMode = false;
                }
            }

        });


        //check the current state before we display the screen
        if(mySwitch.isChecked()){
            hardMode = true;

        }
        else {
            hardMode = false;

        }


    }

    public void onRadioButtonClicked(View view) {


        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.male:
                if (checked){
                    gender = "male";
                    break;

                }

                    break;
            case R.id.female:
                if (checked){
                    gender = "female";
                    break;

                }

        }
    }

    private View.OnClickListener sListener = new View.OnClickListener() {
        public void onClick(View v) {

            global gN = (global) getApplication();
            gN.setName(name.getText().toString());
            gN.setPass(pass.getText().toString());
            gN.setAge(age.getText().toString());
            gN.setHardMode(hardMode);
            gN.setGender(gender.toString());
            submit();
        }
    };

    public void submit() {

        Intent intent = new Intent(UsersInformation.this, MainActivity.class);
        //finish();
        startActivity(intent);

    }



}