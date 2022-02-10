package com.infinitybyte.nickcreator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.infinitybyte.nickcreator.config.Settings;
import com.infinitybyte.nickcreator.config.SettingsAssist;

import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText nickname_input;
    private MaterialButton random_nick, next_step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File settingsFile = new File(getFilesDir(), "Settings.json");
        if(!settingsFile.exists()) {
            try {
                SettingsAssist.save(settingsFile, Settings.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        loadSettings();
        setContentView(R.layout.activity_main);

        nickname_input = findViewById(R.id.nickname_input);
        random_nick = findViewById(R.id.random_nick_btn);
        next_step = findViewById(R.id.next_step);

        random_nick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] array = getResources().getStringArray(R.array.chechen_males_nicknames);
                String randomStr = array[new Random().nextInt(array.length)];
                nickname_input.setText(randomStr);
            }
        });

        next_step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nickname_input.getText().toString().isEmpty()) {
                    Toast.makeText(v.getContext(), R.string.enter_nickname_to_continue, Toast.LENGTH_SHORT).show();
                } else {
                    next_step.setClickable(true);
                }
            }
        });
    }

    public void getNicknamesArray() {
        if (Settings.nicknamesArray.equals("chechen_males_nicknames")) {
            String[] array = getResources().getStringArray(R.array.chechen_males_nicknames);
            String randomStr = array[new Random().nextInt(array.length)];
            nickname_input.setText(randomStr);
        } else if (Settings.nicknamesArray.equals("chechen_female_nicknames")) {
            String[] array = getResources().getStringArray(R.array.chechen_female_nicknames);
            String randomStr = array[new Random().nextInt(array.length)];
            nickname_input.setText(randomStr);
        }
    }

    public void saveSettings() {
        File settingsFile = new File(getFilesDir(), "Settings.json");

        try {
            SettingsAssist.save(settingsFile, Settings.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadSettings() {
        File settingsFile = new File(getFilesDir(), "Settings.json");

        try {
            SettingsAssist.load(settingsFile, Settings.class);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}