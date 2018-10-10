package com.example.samkaru.mess;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by sam karu on 12/03/2018.
 */

public class Settings_Fragment extends PreferenceFragment {
    public void onCreate(Bundle savedInstanceState ){
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preference);


    }
    public void onAttach(Context context){
        super.onAttach(context);


    }
}
