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

public class LengthMeasureFragment extends Fragment {

    Spinner spinnerConvertFrom, spinnerConvertTo;
    TextInputLayout valueToConvert;
    TextView result;
    String convertFrom, convertTo;
    Button btnCalculate;

    public LengthMeasureFragment() {
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
        return inflater.inflate(R.layout.fragment_length_measure, container, false);
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
        arrayList.add("ចំអាម");
        arrayList.add("ហត្ថ");
        arrayList.add("ព្យាម");
        arrayList.add("សិន");
        arrayList.add("គាវុត");
        arrayList.add("យោជន៍");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerConvertFrom.setAdapter(arrayAdapter);
        spinnerConvertFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                convertFrom = adapterView.getItemAtPosition(i).toString();

                if (convertFrom == "ចំអាម") {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("ធ្នាប់");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(adapterView.getContext(), android.R.layout.simple_spinner_item, arrayListTo);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerConvertTo.setAdapter(arrayAdapter);
                }
                if (convertFrom == "ហត្ថ") {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("ចំអាម");
                    arrayListTo.add("ធ្នាប់");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(adapterView.getContext(), android.R.layout.simple_spinner_item, arrayListTo);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerConvertTo.setAdapter(arrayAdapter);
                }
                if (convertFrom == "ព្យាម") {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("ហត្ថ");
                    arrayListTo.add("ចំអាម");
                    arrayListTo.add("ធ្នាប់");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(adapterView.getContext(), android.R.layout.simple_spinner_item, arrayListTo);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerConvertTo.setAdapter(arrayAdapter);
                }
                if (convertFrom == "សិន") {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("ព្យាម");
                    arrayListTo.add("ហត្ថ");
                    arrayListTo.add("ចំអាម");
                    arrayListTo.add("ធ្នាប់");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(adapterView.getContext(), android.R.layout.simple_spinner_item, arrayListTo);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerConvertTo.setAdapter(arrayAdapter);
                }
                if (convertFrom == "គាវុត") {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("សិន");
                    arrayListTo.add("ព្យាម");
                    arrayListTo.add("ហត្ថ");
                    arrayListTo.add("ចំអាម");
                    arrayListTo.add("ធ្នាប់");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(adapterView.getContext(), android.R.layout.simple_spinner_item, arrayListTo);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerConvertTo.setAdapter(arrayAdapter);
                }
                if (convertFrom == "យោជន៍") {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("សិន");
                    arrayListTo.add("ព្យាម");
                    arrayListTo.add("ហត្ថ");
                    arrayListTo.add("ចំអាម");
                    arrayListTo.add("ធ្នាប់");
                    arrayListTo.add("គីឡូម៉ែត្រ");
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
            if (convertTo == "សិន") {
                if (convertFrom == "យោជន៍")
                    data = String.valueOf(valueFromEditText * 400);
                else
                    data = String.valueOf(valueFromEditText * 100);
            }
            else if (convertTo == "ព្យាម") {
                if (convertFrom == "យោជន៍")
                    data = String.valueOf(valueFromEditText * 400 * 20);
                else if (convertFrom == "គាវុត")
                    data = String.valueOf(valueFromEditText * 100 * 20);
                else
                    data = String.valueOf(valueFromEditText * 20);
            }
            else if (convertTo == "ហត្ថ") {
                if (convertFrom == "យោជន៍")
                    data = String.valueOf(valueFromEditText * 400 * 20 * 4);
                else if (convertFrom == "គាវុត")
                    data = String.valueOf(valueFromEditText * 100 * 20 * 4);
                else if (convertFrom == "សិន")
                    data = String.valueOf(valueFromEditText * 20 * 4);
                else
                    data = String.valueOf(valueFromEditText * 4);
            }
            else if (convertTo == "ចំអាម") {
                if (convertFrom == "យោជន៍")
                    data = String.valueOf(valueFromEditText * 400 * 20 * 4 * 2);
                else if (convertFrom == "គាវុត")
                    data = String.valueOf(valueFromEditText * 100 * 20 * 4 * 2);
                else if (convertFrom == "សិន")
                    data = String.valueOf(valueFromEditText * 20 * 4 * 2);
                else if (convertFrom == "ព្យាម")
                    data = String.valueOf(valueFromEditText * 4 * 2);
                else
                    data = String.valueOf(valueFromEditText * 2);
            }
            else if (convertTo == "ធ្នាប់") {
                if (convertFrom == "យោជន៍")
                    data = String.valueOf(valueFromEditText * 400 * 20 * 4 * 2 *12);
                else if (convertFrom == "គាវុត")
                    data = String.valueOf(valueFromEditText * 100 * 20 * 4 * 2 * 12);
                else if (convertFrom == "សិន")
                    data = String.valueOf(valueFromEditText * 20 * 4 * 2 * 12);
                else if (convertFrom == "ព្យាម")
                    data = String.valueOf(valueFromEditText * 4 * 2 * 12);
                else if (convertFrom == "ហត្ថ")
                    data = String.valueOf(valueFromEditText * 2 * 12);
                else
                    data = String.valueOf(valueFromEditText * 12);
            }
            else if (convertTo == "គីឡូម៉ែត្រ") {
                data = String.valueOf(valueFromEditText * 16);
            }
            result.setText(data + " " + convertTo);
        }

    }
}