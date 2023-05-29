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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class FruitMeasureFragment extends Fragment {

    Spinner spinnerConvertFrom, spinnerConvertTo;
    TextInputLayout valueToConvert;
    TextView result;
    String convertFrom, convertTo;
    Button btnCalculate;

    public FruitMeasureFragment() {
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
        return inflater.inflate(R.layout.fragment_fruit_measure, container, false);
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
        arrayList.add("គូ");
        arrayList.add("ដំប");
        arrayList.add("ផ្លូន");
        arrayList.add("ស្លឹក");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerConvertFrom.setAdapter(arrayAdapter);
        spinnerConvertFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                convertFrom = adapterView.getItemAtPosition(i).toString();

                if (convertFrom.equals("គូ")) {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("ផ្លែ");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(adapterView.getContext(), android.R.layout.simple_spinner_item, arrayListTo);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerConvertTo.setAdapter(arrayAdapter);
                }
                if (convertFrom.equals("ដំប")) {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("គូ");
                    arrayListTo.add("ផ្លែ");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(adapterView.getContext(), android.R.layout.simple_spinner_item, arrayListTo);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerConvertTo.setAdapter(arrayAdapter);
                }
                if (convertFrom.equals("ផ្លូន")) {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("ដំប");
                    arrayListTo.add("គូ");
                    arrayListTo.add("ផ្លែ");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(adapterView.getContext(), android.R.layout.simple_spinner_item, arrayListTo);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerConvertTo.setAdapter(arrayAdapter);
                }
                if (convertFrom.equals("ស្លឹក")) {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("ផ្លូន");
                    arrayListTo.add("ដំប");
                    arrayListTo.add("គូ");
                    arrayListTo.add("ផ្លែ");
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
            if (convertTo.equals("ផ្លែ") && !convertFrom.equals("គូ")) {
                if (convertFrom.equals("ស្លឹក"))
                    data = String.valueOf(valueFromEditText * 4 * 100);
                else if (convertFrom.equals("ផ្លូន"))
                    data = String.valueOf(valueFromEditText * 4 * 10);
                else
                    data = String.valueOf(valueFromEditText * 4);
            }
            else if ((convertTo.equals("ដំប") && convertFrom.equals("ផ្លូន")) || (convertTo.equals("ផ្លូន") && convertFrom.equals("ស្លឹក"))) {
                data = String.valueOf(valueFromEditText * 10);
            }
            else if ((convertTo.equals("ដំប") && convertFrom.equals("ស្លឹក"))) {
                data = String.valueOf(valueFromEditText * 100);
            }
            else {
                if (convertFrom.equals("ស្លឹក"))
                    data = String.valueOf(valueFromEditText * 2 * 100);
                else if (convertFrom.equals("ផ្លូន"))
                    data = String.valueOf(valueFromEditText * 2 * 10);
                else
                    data = String.valueOf(valueFromEditText * 2);
            }
            result.setText(data + " " + convertTo);
        }

    }
}