package com.facul.atividade4rvmobile.presenters;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.facul.atividade4rvmobile.adapters.PhotoAdapter;
import com.facul.atividade4rvmobile.model.Photo;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class PhotoPresenter implements PhotoPresenterContrato.presenter, Response.ErrorListener {

    private List<Photo> photos = new ArrayList<>();
    private PhotoPresenterContrato.view activity;
    private int adp = 1;
    private String urlBase;

    public PhotoPresenter(PhotoPresenterContrato.view act, String urlBase){
        this.activity = act;
        this.urlBase = urlBase;
    }

    @Override
    public void buscaJsons(){
        RequestQueue queue = Volley.newRequestQueue(activity.getContexto());

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, urlBase + "/photos", null,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                onResponsePhoto(response);
            }
        }, this);
        queue.add(request);
    }

    public void onResponsePhoto(JSONArray response) {
        photos.clear();

        try {
            for (int x = 0; x < 30; x++){
                for (int i = 0; i < response.length(); i++){
                    photos.add(new Photo(response.getJSONObject(i)));
                }
            }
            RecyclerView.Adapter adapter;
            adapter = new PhotoAdapter(photos);

            activity.prepareRecyclerView(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        // do nothing
    }
}
