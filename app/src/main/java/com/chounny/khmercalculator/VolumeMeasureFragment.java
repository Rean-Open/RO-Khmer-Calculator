package com.chounny.khmercalculator;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class VolumeMeasureFragment extends Fragment {

    Spinner spinnerConvertFrom, spinnerConvertTo;
    TextInputLayout valueToConvert;
    TextView result;
    String convertFrom, convertTo;
    Button btnCalculate;

    public VolumeMeasureFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_volume_measure, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinnerConvertFrom = view.findViewById(R.id.spinner_convert_from);
        spinnerConvertTo = view.findViewById(R.id.spinner_convert_to);
        valueToConvert = view.findViewById(R.id.amount_to_convert);
        result = view.findViewById(R.id.result);
        btnCalculate = view.findViewById(R.id.btn_calculate);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("កន្តាំង");
        arrayList.add("តៅ");
        arrayList.add("ថាំង");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerConvertFrom.setAdapter(arrayAdapter);
        spinnerConvertFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                convertFrom = adapterView.getItemAtPosition(i).toString();

                if (convertFrom == "កន្តាំង") {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("កូនល្អី");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(adapterView.getContext(), android.R.layout.simple_spinner_item, arrayListTo);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerConvertTo.setAdapter(arrayAdapter);
                }
                if (convertFrom == "តៅ") {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("កន្តាំង");
                    arrayListTo.add("កូនល្អី");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(adapterView.getContext(), android.R.layout.simple_spinner_item, arrayListTo);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerConvertTo.setAdapter(arrayAdapter);
                }
                if (convertFrom == "ថាំង") {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("តៅ");
                    arrayListTo.add("កន្តាំង");
                    arrayListTo.add("កូនល្អី");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(adapterView.getContext(), android.R.layout.simple_spinner_item, arrayListTo);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerConvertTo.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateValue(view);
            }
        });
    }

    public void calculateValue(View view) {
        String data = "";
        int valueFromEditText;
        convertFrom = spinnerConvertFrom.getSelectedItem().toString();
        convertTo = spinnerConvertTo.getSelectedItem().toString();
        String amount = valueToConvert.getEditText().getText().toString();
        if (amount.isEmpty()) {
            valueToConvert.setError("សូមបញ្ចូលចំនួនលេខ");
        }
        else {
            valueToConvert.setError(null);
            valueFromEditText = Integer.parseInt(amount);
            if ((convertFrom.equals("កន្តាំង") && convertTo.equals("កូនល្អី")) || (convertFrom.equals("តៅ") && convertTo.equals("កន្តាំង")) || (convertFrom.equals("ថាំង") && convertTo.equals("តៅ"))) {
                data = String.valueOf(valueFromEditText * 2);
            }
            else if ((convertFrom.equals("ថាំង") && convertTo.equals("កន្តាំង")) || (convertFrom.equals("តៅ") && convertTo.equals("កូនល្អី"))){
                data = String.valueOf(valueFromEditText * 4);
            }
            else  {
                data = String.valueOf(valueFromEditText * 8);
            }
            result.setText(data + " " + convertTo);
        }

    }
}