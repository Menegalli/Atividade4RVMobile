package com.facul.atividade4rvmobile.presenters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface PhotoPresenterContrato {
    interface view {
        public void prepareRecyclerView(RecyclerView.Adapter adapter);
        public void limpaRecycler();
        public Context getContexto();
    }
    interface presenter {
        public void buscaJsons();
    }
}
