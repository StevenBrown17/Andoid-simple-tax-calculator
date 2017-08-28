package edu.weber.stevenbrown.cs3270a4;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TotalsFragment extends Fragment {


    TextView total;

    public TotalsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_totals, container, false);

        total = (TextView)view.findViewById(R.id.txtTotal);

        return view;
    }


//    @Override
//    public void onResume() {
//        super.onResume();
//        Log.d("test","TotalsFragment onResume()");
//        MainActivity ma = (MainActivity) getActivity();
//        ma.restoreState();
//
//    }
//
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        Log.d("test","TotalsFragment onPause()");
//        MainActivity ma = (MainActivity) getActivity();
//        ma.saveState();
//    }

    public void setTotal(String s){
        total.setText(s);
    }

    public String getTotal(){
        return total.getText().toString();
    }

    public void clearTotal(){
        total.setText("");
    }

}
