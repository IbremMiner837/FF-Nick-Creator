package com.infinitybyte.nickcreator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.infinitybyte.nickcreator.adapter.Adapter;
import com.infinitybyte.nickcreator.adapter.Model;

import java.util.ArrayList;
import java.util.List;

public class SelectFontActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Model> viewItems = new ArrayList<>();
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_font);

        mRecyclerView = (RecyclerView) findViewById(R.id.recview);
        mRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(this, viewItems);
        mRecyclerView.setAdapter(adapter);

        String nicknameString = getIntent().getStringExtra("nickname");

        Model nicknameItem = new Model(nicknameString);

        viewItems.add(nicknameItem);
        viewItems.add(nicknameItem);
    }
}