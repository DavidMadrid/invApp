package com.example.david.invapp.fragments;

import android.support.v4.app.Fragment;

public abstract class FormParentFragment extends Fragment {
    public abstract void onFragmentVisible();
    public void onPreferencesChange(Class<?> from){
        //do nothing
    }
}
