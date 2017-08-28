package edu.weber.stevenbrown.cs3270a4;

import android.content.Context;
import android.icu.math.BigDecimal;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;


public class TaxFragment extends Fragment {

    SeekBar seekBar;
    TextView txtRate, txtAmount;
    Double tax=0.0;

    public TaxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tax, container, false);

        seekBar = (SeekBar)view.findViewById(R.id.taxSeek);
        txtRate = (TextView)view.findViewById(R.id.txtRate);
        txtAmount = (TextView)view.findViewById(R.id.txtAmount);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("test","TaxFragment onProgressChanged(" + seekBar.getProgress() + ")");


                txtRate.setText("Tax Rate: "+ (float)seekBar.getProgress()/4 +"%");

                MainActivity ma = (MainActivity) getActivity();

                ma.setValues();

                //5
                // setTxtAmount(ma.setValues());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return view;
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        Log.d("test","TaxFragment onResume()");
//        MainActivity ma = (MainActivity) getActivity();
//        ma.restoreState();
//
//        seekBar.setProgress(Math.round(ma.getSeekValue()));
//    }
//
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        Log.d("test","TaxFragment onPause()");
//        MainActivity ma = (MainActivity) getActivity();
//        ma.saveState();
//    }







    public Float getSeekValue(){
        return (float)seekBar.getProgress()/4;
    }

    public Double getTaxAmount(){
        return tax;
    }

    public void setTxtAmount(Double d){

        txtAmount.setText("Tax Amount $" + String.format("%.2f",d * (double)seekBar.getProgress()/400));
        tax = Double.parseDouble(String.format("%.2f",d * (double)seekBar.getProgress()/400));
    }

    public void setSeekBar(Float t){
        seekBar.setProgress(Math.round(t));
    }





}//end class
