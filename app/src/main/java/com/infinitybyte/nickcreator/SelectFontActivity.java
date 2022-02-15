package com.infinitybyte.nickcreator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import java.util.Random;

@RequiresApi(api = Build.VERSION_CODES.O)
public class SelectFontActivity extends AppCompatActivity {

    private TextView nickname;
    private MaterialButton next_step, before_step, next_font, before_font, random_font;
    private int indexPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_font);

        Typeface[] font = new Typeface[] {
                getResources().getFont(R.font.festive_regular),
                getResources().getFont(R.font.rowdies_bold),
                getResources().getFont(R.font.rowdies_light),
                getResources().getFont(R.font.rowdies_regular)
        };

        nickname = findViewById(R.id.nickname_list);
        next_step = findViewById(R.id.next_step);
        before_step = findViewById(R.id.before_step);
        next_font = findViewById(R.id.next_font);
        before_font = findViewById(R.id.before_font);
        random_font = findViewById(R.id.random_font);

        String nicknameString = getIntent().getStringExtra("nickname");

        nickname.setText(nicknameString);

        next_step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        before_step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        next_font.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indexPos == -1) {
                    indexPos++;
                    nickname.setTypeface(font[indexPos]);
                } else if (indexPos >= 3) {
                    indexPos = 0;
                    nickname.setTypeface(font[indexPos]);
                } else if (indexPos >= 0) {
                    indexPos++;
                    nickname.setTypeface(font[indexPos]);
                }
            }
        });

        before_font.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indexPos == -1) {
                    indexPos = 3;
                    nickname.setTypeface(font[indexPos]);
                } else if (indexPos <= 0) {
                    indexPos = 3;
                    nickname.setTypeface(font[indexPos]);
                } else if (indexPos <= 3) {
                    indexPos--;
                    nickname.setTypeface(font[indexPos]);
                }
            }
        });

        random_font.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //[new Random().nextInt(array.length)];
                nickname.setTypeface(font[new Random().nextInt(font.length)]);
            }
        });
    }
}