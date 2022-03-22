package com.shubham.dictionaryapp;

import com.shubham.dictionaryapp.Models.APIResponse;

public interface OnFetchDataListener {
    void onFetchData(APIResponse apiResponse, String message);
    void onError(String message);


}
