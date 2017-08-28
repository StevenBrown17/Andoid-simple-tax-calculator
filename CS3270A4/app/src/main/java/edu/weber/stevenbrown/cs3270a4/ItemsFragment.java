package edu.weber.stevenbrown.cs3270a4;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class ItemsFragment extends Fragment {

    EditText edtAmount1, edtAmount2, edtAmount3, edtAmount4;


    public ItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_items, container, false);

        edtAmount1 = (EditText)view.findViewById(R.id.edtAmount1);
        edtAmount2 = (EditText)view.findViewById(R.id.edtAmount2);
        edtAmount3 = (EditText)view.findViewById(R.id.edtAmount3);
        edtAmount4 = (EditText)view.findViewById(R.id.edtAmount4);

        return view;
    }


    public double getTotal(){
        Log.d("test","ItemsFragment getTotal()");
        Double total = 0.00;

        try {
            if (edtAmount1 == null || !edtAmount1.getText().toString().matches("[0-9]+(\\.[0-9][0-9]?)?")) {
                edtAmount1.setText("0.00");
            }
            if (edtAmount2 == null || !edtAmount2.getText().toString().matches("[0-9]+(\\.[0-9][0-9]?)?")) {
                edtAmount2.setText("0.00");
            }
            if (edtAmount3 == null || !edtAmount3.getText().toString().matches("[0-9]+(\\.[0-9][0-9]?)?")) {
                edtAmount3.setText("0.00");
            }
            if (edtAmount4 == null || !edtAmount4.getText().toString().matches("[0-9]+(\\.[0-9][0-9]?)?")) {
                edtAmount4.setText("0.00");
            }


            total += Double.parseDouble(edtAmount1.getText().toString());
            total += Double.parseDouble(edtAmount2.getText().toString());
            total += Double.parseDouble(edtAmount3.getText().toString());
            total += Double.parseDouble(edtAmount4.getText().toString());
        }catch(Exception e){}

        return total;
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d("test","ItemsFragment onResume()");
        MainActivity ma = (MainActivity) getActivity();
        ma.restoreState();

        setEdtAmount1(ma.getAmt1());
        setEdtAmount2(ma.getAmt2());
        setEdtAmount3(ma.getAmt3());
        setEdtAmount4(ma.getAmt4());
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.d("test","ItemsFragment onPause()");
        MainActivity ma = (MainActivity) getActivity();
        ma.saveState();
    }

    public String getEdtAmount1() {
        return edtAmount1.getText().toString();
    }

    public String getEdtAmount2() {
        return edtAmount2.getText().toString();
    }

    public String getEdtAmount3() {
        return edtAmount3.getText().toString();
    }

    public String getEdtAmount4() {
        return edtAmount4.getText().toString();
    }

    public void setEdtAmount1(String edtAmount1) {
        this.edtAmount1.setText(edtAmount1);
    }

    public void setEdtAmount2(String edtAmount2) {
        this.edtAmount2.setText(edtAmount2);
    }

    public void setEdtAmount3(String edtAmount3) {
        this.edtAmount3.setText(edtAmount3);
    }

    public void setEdtAmount4(String edtAmount4) {
        this.edtAmount4.setText(edtAmount4);
    }
}
