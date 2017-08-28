package edu.weber.stevenbrown.cs3270a4;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    private Float seekValue;
    private String amt1,amt2,amt3,amt4, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.totalContainer, new TotalsFragment(),"TOF").addToBackStack(null).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.taxContainer, new TaxFragment(),"TAF").addToBackStack(null).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.itemsContainer, new ItemsFragment(),"ITF").addToBackStack(null).commit();

    }


    public void setValues(){

        Log.d("test","MainActivity setValues()");
        Double total;


        ItemsFragment itemsFragment = (ItemsFragment) getSupportFragmentManager().findFragmentByTag("ITF");
        TaxFragment taxFragment = (TaxFragment) getSupportFragmentManager().findFragmentByTag("TAF");
        TotalsFragment totalsFragment = (TotalsFragment) getSupportFragmentManager().findFragmentByTag("TOF");
        seekValue = taxFragment.getSeekValue();
        total = itemsFragment.getTotal();
        taxFragment.setTxtAmount(total);
        total += taxFragment.getTaxAmount();

        totalsFragment.setTotal("$"+String.format("%.2f",total));


    }


    public void setSeekValue(){
        TaxFragment taxFragment = (TaxFragment) getSupportFragmentManager().findFragmentByTag("TAF");
        seekValue = taxFragment.getSeekValue();
    }

    public float getSeekValue(){
        return seekValue;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal() {
        TotalsFragment totalsFragment = (TotalsFragment) getSupportFragmentManager().findFragmentByTag("TOF");
        this.total = totalsFragment.getTotal();
    }

    public void setAmt() {
        Log.d("test","MainActivity setAmt()");

        ItemsFragment itemsFragment = (ItemsFragment) getSupportFragmentManager().findFragmentByTag("ITF");
        amt1=itemsFragment.getEdtAmount1();
        amt2=itemsFragment.getEdtAmount2();
        amt3=itemsFragment.getEdtAmount3();
        amt4=itemsFragment.getEdtAmount4();

    }

    public String getAmt1() { return amt1; }

    public String getAmt2() {
        return amt2;
    }

    public String getAmt3() {
        return amt3;
    }


    public String getAmt4() {
        return amt4;
    }


    public void saveState(){
        Log.d("test","MainActivity saveState()");
        setAmt();

        SharedPreferences sp = getPreferences((MODE_PRIVATE));
        SharedPreferences.Editor spEditor = sp.edit();
        spEditor.putFloat("sbValue", getSeekValue());
        spEditor.putString("amount1", getAmt1());
        spEditor.putString("amount2", getAmt2());
        spEditor.putString("amount3", getAmt3());
        spEditor.putString("amount4", getAmt4());
        spEditor.putString("total", getTotal());
        spEditor.commit();

    }

    public void restoreState(){
        Log.d("test","MainActivity restoreState()");
        SharedPreferences sp = getPreferences((MODE_PRIVATE));
        seekValue = sp.getFloat("sbValue",0);
        amt1 = sp.getString("amount1","");
        amt2 = sp.getString("amount2","");
        amt3 = sp.getString("amount3","");
        amt4 = sp.getString("amount4","");
        total = sp.getString("total","");
        TaxFragment taxFragment = (TaxFragment) getSupportFragmentManager().findFragmentByTag("TAF");
        TotalsFragment totalsFragment = (TotalsFragment) getSupportFragmentManager().findFragmentByTag("TOF");
        taxFragment.setSeekBar(seekValue);
        totalsFragment.setTotal(total);

    }


}
