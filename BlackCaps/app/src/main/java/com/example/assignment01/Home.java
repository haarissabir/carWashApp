package com.example.assignment01;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Home extends Fragment  {
    EditText txtAmount;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_home, container, false);
        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);
        txtAmount = (EditText) rootView.findViewById(R.id.txtAmount);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.packages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getSelectedItemPosition()== 0) {
                    txtAmount.setText("Rs. 400/=");
                } else if (parent.getSelectedItemPosition() == 1) {
                    txtAmount.setText("Rs. 250/=");
                } else if (parent.getSelectedItemPosition() == 2) {
                    txtAmount.setText("Rs. 100/=");
                } else {
                    txtAmount.setText("Please Select a valid package");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });


        return rootView;


    }

}



