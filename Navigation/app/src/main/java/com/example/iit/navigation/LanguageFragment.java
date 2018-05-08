package com.example.iit.navigation;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class LanguageFragment extends Fragment implements View.OnClickListener {
    private AlertDialog mAlertDialog = null;
    private TextView txtView = null;
    ArrayList<String>mArray=new ArrayList<String>();
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,@Nullable Bundle savedInstanceState) {



        view= inflater.inflate(R.layout.laguage_text, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view , @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mArray=this.getArguments().getStringArrayList("mArray");
        txtView = getActivity().findViewById(R.id.txt_id);
        txtView.setOnClickListener(this);

    }
    public void onClick(View view){

        new CustomDialog(getActivity(), mArray, mAlertDialog, txtView);

    }
}
