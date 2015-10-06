package com.rig.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Geo on 9/30/15.
 */
public class FinalPage extends AppCompatActivity {

    TextView tvText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_page);

        tvText = (TextView) findViewById(R.id.usersInfo);

        global gN = (global)getApplication();
        tvText.setText(gN.getName() + "\n" + "Level " + gN.getLevel() + "\nAge " + gN.getAge() +
        "\nGender " + gN.getGender());


    }

    public void goBackToStart(View view) {
        Intent intent = new Intent(this, UsersInformation.class);
        startActivity(intent);
    }
}
