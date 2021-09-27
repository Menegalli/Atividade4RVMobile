package com.facul.atividade4rvmobile.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facul.atividade4rvmobile.R;
import com.facul.atividade4rvmobile.presenters.PhotoPresenter;
import com.facul.atividade4rvmobile.presenters.PhotoPresenterContrato;

public class MainActivity extends AppCompatActivity implements PhotoPresenterContrato.view {

    PhotoPresenterContrato.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new PhotoPresenter(this, "https://jsonplaceholder.typicode.com");

        //button get
        Button btn = findViewById(R.id.buttonGet);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.buscaJsons();
            }
        });

        //button clear
        Button btn2 = findViewById(R.id.buttonClear);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpaRecycler();
            }
        });

    }

    public void prepareRecyclerView(RecyclerView.Adapter adapter){
        RecyclerView rv = findViewById(R.id.rvPhotos);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
    }

    @Override
    public void limpaRecycler() {
        RecyclerView rv = findViewById(R.id.rvPhotos);
        rv.setAdapter(null);
    }

    @Override
    public Context getContexto(){
        return this.getApplicationContext();
    }

}