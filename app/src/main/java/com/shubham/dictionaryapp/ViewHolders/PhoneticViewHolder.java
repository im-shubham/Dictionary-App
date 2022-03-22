package com.shubham.dictionaryapp.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shubham.dictionaryapp.R;

public class PhoneticViewHolder extends RecyclerView.ViewHolder {

    public TextView textView_phonetic;
    public ImageButton imagebtn_audio;

    public PhoneticViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_phonetic = itemView.findViewById(R.id.textView_phonetic);
        imagebtn_audio = itemView.findViewById(R.id.imagebtn_audio);

    }
}
