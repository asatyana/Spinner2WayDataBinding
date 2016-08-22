package com.example.spinner;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by ananth on 22/08/16.
 */


@InverseBindingMethods({
        @InverseBindingMethod(type = Spinner.class, attribute = "android:selectedItemPosition"),
})
public class Model extends BaseObservable {

    private String[] countries;
    private int position;
    private String country;


    public Model() {
        List<String> allCountries = new ArrayList<String>();
        String[] locales = Locale.getISOCountries();

        for (String countryCode : locales) {

            Locale obj = new Locale("", countryCode);

            allCountries.add(obj.getDisplayCountry());

        }

        countries = allCountries.toArray(new String[allCountries.size()]);
    }

    @Bindable
    public String[] getCountries() {
        return countries;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
        notifyPropertyChanged(com.example.spinner.BR.countries);
    }

    @Bindable
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;

        //if (position != 0)
        setCountry(countries[position]);
    }

    @Bindable
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
        notifyPropertyChanged(com.example.spinner.BR.country);
    }

    public int getPosition(Spinner spinner) {
        return spinner.getSelectedItemPosition();
    }
}
