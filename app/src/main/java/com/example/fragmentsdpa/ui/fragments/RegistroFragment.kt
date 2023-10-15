package com.example.fragmentsdpa.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import com.example.fragmentsdpa.R

class RegistroFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_registro, container, false)

        val btnSave: Button = view.findViewById(R.id.btnSave)
        val etFullname: EditText = view.findViewById(R.id.etFullname)
        val etEmail: EditText = view.findViewById(R.id.etEmail)
        var spnCountry: Spinner = view.findViewById(R.id.spnCountry)
        val rgGender: RadioGroup = view.findViewById(R.id.rgGender)
        val chckLicence: CheckBox = view.findViewById(R.id.chckLicence)
        val chckCar: CheckBox = view.findViewById(R.id.chckCar)

        ArrayAdapter.createFromResource(requireContext(),
            R.array.country_array,
            android.R.layout.simple_spinner_item).also {
                adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
                spnCountry.adapter = adapter

        }

        var spnCountryValue=""
        spnCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long){
                spnCountryValue = parent?.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }

        btnSave.setOnClickListener {
            var fullNameValue = etFullname.text
            var emailValue = etEmail.text
            var intSelectedButton = rgGender!!.checkedRadioButtonId
            val rbtSelected: RadioButton = view.findViewById(intSelectedButton)
            val genderValue = rbtSelected.text

            val allValues =
                "Full Name: $fullNameValue \nEmail: $emailValue \nGender: $genderValue " +
                        "\nCountry: $spnCountryValue \nLicense?: ${chckLicence.isChecked} " +
                        "\nCar?: ${chckCar.isChecked}"

            Toast.makeText(requireContext(),allValues, Toast.LENGTH_LONG).show()

        }





        return view




    }

}