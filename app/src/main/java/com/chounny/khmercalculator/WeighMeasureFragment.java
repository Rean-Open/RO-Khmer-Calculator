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

public class WeighMeasureFragment extends Fragment {

    Spinner spinnerConvertFrom, spinnerConvertTo;
    TextInputLayout valueToConvert;
    TextView result;
    String convertFrom, convertTo;
    Button btnCalculate;

    public WeighMeasureFragment() {
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
        return inflater.inflate(R.layout.fragment_weigh_measure, container, false);
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
        arrayList.add("ហ៊ុន");
        arrayList.add("ជី");
        arrayList.add("ដំឡឹង");
        arrayList.add("នាឡិ");
        arrayList.add("ចុង");
        arrayList.add("ហាប");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerConvertFrom.setAdapter(arrayAdapter);
        spinnerConvertFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                convertFrom = adapterView.getItemAtPosition(i).toString();

                if (convertFrom == "ហ៊ុន") {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("លី");
                    arrayListTo.add("ក្រាម");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(adapterView.getContext(), android.R.layout.simple_spinner_item, arrayListTo);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerConvertTo.setAdapter(arrayAdapter);
                }
                if (convertFrom == "ជី") {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("ហ៊ុន");
                    arrayListTo.add("លី");
                    arrayListTo.add("ក្រាម");
                    arrayListTo.add("គីឡូក្រាម");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(adapterView.getContext(), android.R.layout.simple_spinner_item, arrayListTo);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerConvertTo.setAdapter(arrayAdapter);
                }
                if (convertFrom == "ដំឡឹង") {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("ជី");
                    arrayListTo.add("ហ៊ុន");
                    arrayListTo.add("លី");
                    arrayListTo.add("ក្រាម");
                    arrayListTo.add("គីឡូក្រាម");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(adapterView.getContext(), android.R.layout.simple_spinner_item, arrayListTo);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerConvertTo.setAdapter(arrayAdapter);
                }
                if (convertFrom == "នាឡិ") {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("ដំឡឹង");
                    arrayListTo.add("ជី");
                    arrayListTo.add("ហ៊ុន");
                    arrayListTo.add("លី");
                    arrayListTo.add("ក្រាម");
                    arrayListTo.add("គីឡូក្រាម");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(adapterView.getContext(), android.R.layout.simple_spinner_item, arrayListTo);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerConvertTo.setAdapter(arrayAdapter);
                }
                if (convertFrom == "ចុង") {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("នាឡិ");
                    arrayListTo.add("ដំឡឹង");
                    arrayListTo.add("ជី");
                    arrayListTo.add("ហ៊ុន");
                    arrayListTo.add("លី");
                    arrayListTo.add("ក្រាម");
                    arrayListTo.add("គីឡូក្រាម");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(adapterView.getContext(), android.R.layout.simple_spinner_item, arrayListTo);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerConvertTo.setAdapter(arrayAdapter);
                }
                if (convertFrom == "ហាប") {
                    ArrayList<String> arrayListTo = new ArrayList<>();
                    arrayListTo.add("ចុង");
                    arrayListTo.add("នាឡិ");
                    arrayListTo.add("ដំឡឹង");
                    arrayListTo.add("ជី");
                    arrayListTo.add("ហ៊ុន");
                    arrayListTo.add("លី");
                    arrayListTo.add("ក្រាម");
                    arrayListTo.add("គីឡូក្រាម");
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
            if (convertTo == "ចុង") {
                //1 hab = 2 jg
                data = String.valueOf(valueFromEditText * 2);
            }
            else if (convertTo == "នាឡិ") {
                if (convertFrom == "ចុង") //1 jg = 50
                    data = String.valueOf(valueFromEditText * 50);
                else //1 hab = 2 * 50
                    data = String.valueOf(valueFromEditText * 2 * 50);
            }
            else if (convertTo == "ដំឡឹង") {
                if (convertFrom == "នាឡិ") // 1 nel = 16
                    data = String.valueOf(valueFromEditText * 16);
                else if (convertFrom == "ចុង") // 1 jg = 50 * 16
                    data = String.valueOf(valueFromEditText * 50 * 16);
                else // 1 hab = 2 * 50 * 16
                    data = String.valueOf(valueFromEditText * 2 * 50 * 16);
            }
            else if (convertTo == "ជី") {
                if (convertFrom == "ដំឡឹង")
                    data = String.valueOf(valueFromEditText * 10);
                else if (convertFrom == "នាឡិ") // 1 nel = 16 * 10
                    data = String.valueOf(valueFromEditText * 16 * 10);
                else if (convertFrom == "ចុង") //1 jg = 50 * 16 * 10
                    data = String.valueOf(valueFromEditText * 50 * 16 * 10);
                else //1 hab = 2 * 50 * 16 * 10
                    data = String.valueOf(valueFromEditText * 2 * 50 * 16 * 10);
            }
            else if (convertTo == "ហ៊ុន") {
                if (convertFrom == "ជី")//1 ji = 10
                    data = String.valueOf(valueFromEditText * 10);
                else if (convertFrom == "ដំឡឹង")//1 domleng = 10 * 10
                    data = String.valueOf(valueFromEditText * 10 * 10);
                else if (convertFrom == "នាឡិ") //1 nel = 16 * 10 * 10
                    data = String.valueOf(valueFromEditText * 16 * 10 * 10);
                else if (convertFrom == "ចុង") //1 jg = 50 * 16 * 10 * 10
                    data = String.valueOf(valueFromEditText * 50 * 16 * 10 * 10);
                else //1 hab = 2 * 50 * 16 * 10 * 10
                    data = String.valueOf(valueFromEditText * 2 * 50 * 16 * 10 * 10);
            }
            if (convertTo == "លី") {
                if (convertFrom == "ហ៊ុន")
                    data = String.valueOf(valueFromEditText * 10);
                else if (convertFrom == "ជី")//1 ji = 10 * 10
                    data = String.valueOf(valueFromEditText * 10 * 10);
                else if (convertFrom == "ដំឡឹង")//1 domleng = 10 * 10 * 10
                    data = String.valueOf(valueFromEditText * 10 * 10 * 10);
                else if (convertFrom == "នាឡិ") //1 nel = 16 * 10 * 10 * 10
                    data = String.valueOf(valueFromEditText * 16 * 10 * 10 * 10);
                else if (convertFrom == "ចុង") //1 jg = 50 * 16 * 10 * 10 * 10
                    data = String.valueOf(valueFromEditText * 50 * 16 * 10 * 10 * 10);
                else //1 hab = 2 * 50 * 16 * 10 * 10 * 10
                    data = String.valueOf(valueFromEditText * 2 * 50 * 16 * 10 * 10 * 10);
            }
            else if (convertTo == "ក្រាម") {
                if (convertFrom == "ហ៊ុន") //1 hun = 3.75 /10
                    data = String.valueOf((valueFromEditText * 3.75) / 10);
                else if (convertFrom == "ជី")//1 ji = 3.75
                    data = String.valueOf(valueFromEditText * 3.75);
                else if (convertFrom == "ដំឡឹង")//1 domleng = 10 * 3.75
                    data = String.valueOf(valueFromEditText * 10 * 3.75);
                else if (convertFrom == "នាឡិ") //1 nel = 16 * 10 * 3.75
                    data = String.valueOf(valueFromEditText * 116 * 10 * 3.75);
                else if (convertFrom == "ចុង") //1 jg = 50 * 16 * 10 * 3.75
                    data = String.valueOf(valueFromEditText * 50 * 16 * 10 * 3.75);
                else //1 hab = 2 * 50 * 16 * 10 * 3.75
                    data = String.valueOf(valueFromEditText * 2 * 50 * 16 * 10 * 3.75);
            }
            else if (convertTo == "គីឡូក្រាម") {
                if (convertFrom == "ហ៊ុន") //1 hun = 3.75 /10
                    data = String.valueOf((valueFromEditText * 3.75) / 10000);
                else if (convertFrom == "ជី")//1 ji = 3.75
                    data = String.valueOf((valueFromEditText * 3.75)/1000);
                else if (convertFrom == "ដំឡឹង")//1 domleng = 10 * 3.75
                    data = String.valueOf(valueFromEditText * 10 * 3.75);
                else if (convertFrom == "នាឡិ") //1 nel = 16 * 10 * 3.75
                    data = String.valueOf((valueFromEditText * 116 * 10 * 3.75)/1000);
                else if (convertFrom == "ចុង") //1 jg = 50 * 16 * 10 * 3.75
                    data = String.valueOf((valueFromEditText * 50 * 16 * 10 * 3.75)/1000);
                else //1 hab = 2 * 50 * 16 * 10 * 3.75
                    data = String.valueOf((valueFromEditText * 2 * 50 * 16 * 10 * 3.75)/1000);
            }
            result.setText(data + " " + convertTo);
        }

    }
}