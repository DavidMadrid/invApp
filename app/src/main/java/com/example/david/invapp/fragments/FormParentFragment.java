package com.example.david.invapp.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.david.invapp.PrincipalActivity;
import com.example.david.invapp.R;

import java.util.List;

public abstract class FormParentFragment extends Fragment {
    public abstract void onFragmentVisible();
}
