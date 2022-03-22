package com.shubham.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.shubham.dictionaryapp.Adapters.MeaningAdapter;
import com.shubham.dictionaryapp.Adapters.PhoneticsAdapter;
import com.shubham.dictionaryapp.Models.APIResponse;

public class MainActivity extends AppCompatActivity {
    SearchView search_view;
    TextView textView_word;
    RecyclerView recycler_phonetics , recycler_meanings;
    ProgressDialog progressDialog;
    PhoneticsAdapter phoneticsAdapter;
    MeaningAdapter meaningAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        search_view = findViewById(R.id.search_view);
        textView_word = findViewById(R.id.textView_word);
        recycler_phonetics = findViewById(R.id.recycler_phonetics);
        recycler_meanings = findViewById(R.id.recycler_meanings);
        progressDialog = new ProgressDialog(this);


        progressDialog.setTitle("Loading..");
        progressDialog.show();
        RequestManager manager= new RequestManager(MainActivity.this);
        manager.getWordMeaning(listener,"Welcome");


        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Searching word ... "+query);
                progressDialog.show();
                RequestManager manager= new RequestManager(MainActivity.this);
                manager.getWordMeaning(listener,query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }
    private final OnFetchDataListener listener = new OnFetchDataListener() {
        @Override
        public void onFetchData(APIResponse apiResponse, String message) {
            progressDialog.dismiss();
            if(apiResponse==null){
                Toast.makeText(MainActivity.this, "Shama Kre..No Data Found", Toast.LENGTH_SHORT).show();
                return;
            }
            showData(apiResponse);

        }

        @Override
        public void onError(String message) {

            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

        }
    };

    private void showData(APIResponse apiResponse) {
        textView_word.setText("Word: "+apiResponse.getWord());
        recycler_phonetics.setHasFixedSize(true);
        recycler_phonetics.setLayoutManager(new GridLayoutManager(this,1));
        phoneticsAdapter = new PhoneticsAdapter(this,apiResponse.getPhonetics());
        recycler_phonetics.setAdapter(phoneticsAdapter);

        recycler_meanings.setHasFixedSize(true);
        recycler_meanings.setLayoutManager(new GridLayoutManager(this,1));
        meaningAdapter = new MeaningAdapter(this,apiResponse.getMeanings());
        recycler_meanings.setAdapter(meaningAdapter);


    }
}