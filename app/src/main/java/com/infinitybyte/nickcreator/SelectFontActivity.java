package com.infinitybyte.nickcreator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.infinitybyte.nickcreator.adapter.Adapter;
import com.infinitybyte.nickcreator.adapter.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiresApi(api = Build.VERSION_CODES.O)
public class SelectFontActivity extends AppCompatActivity {

    //private RecyclerView mRecyclerView;
    //private List<Model> viewItems = new ArrayList<>();
    //private RecyclerView.Adapter adapter;
    //private RecyclerView.LayoutManager layoutManager;
    private TextView nickname;
    private MaterialButton next_step, before_step, next_font, before_font, random_font;
    private int indexPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_font);

        //mRecyclerView = (RecyclerView) findViewById(R.id.recview);
        //mRecyclerView.setHasFixedSize(true);
        //layoutManager = new LinearLayoutManager(this);
        //mRecyclerView.setLayoutManager(layoutManager);
        //adapter = new Adapter(this, viewItems);
        //mRecyclerView.setAdapter(adapter);
        //String nicknameString = getIntent().getStringExtra("nickname");
        //Model nicknameItem = new Model(nicknameString);
        //viewItems.add(nicknameItem);
        //viewItems.add(nicknameItem);

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