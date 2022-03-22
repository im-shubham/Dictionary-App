package com.shubham.dictionaryapp.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shubham.dictionaryapp.R;

public class MeaningsViewHolder extends RecyclerView.ViewHolder {
     public TextView textview_partsOfSpeech;
     public RecyclerView recycler_definitions;


    public MeaningsViewHolder(@NonNull View itemView) {
        super(itemView);
        textview_partsOfSpeech = itemView.findViewById(R.id.textview_partsOfSpeech);
        recycler_definitions = itemView.findViewById(R.id.recycler_definitions);
    }
}
