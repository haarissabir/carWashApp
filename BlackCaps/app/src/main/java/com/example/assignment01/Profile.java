package com.example.assignment01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;

public class Profile extends Fragment {
    DatabaseHelper db ;
    MainActivity m;
    Button save;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.act_profile, container, false);
        EditText name = (EditText)rootView.findViewById(R.id.name);
        EditText address = (EditText)rootView.findViewById(R.id.address);
        EditText number = (EditText)rootView.findViewById(R.id.number);
        EditText loc = (EditText)rootView.findViewById(R.id.location);
        map_act map = new map_act();
        loc.setText(map.loc1);
        save = (Button)rootView.findViewById(R.id.btnSave);
        //BigInteger n = new BigInteger(number.getText().toString());
        number.setText(m.id1.toString());
        db = new DatabaseHelper(this.getActivity());
        m = new MainActivity();


        name.setText(db.ProfileName(m.id1,1));
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Information Saved", Toast.LENGTH_SHORT).show();

            }
        });
        return  rootView;
    }
}
