package com.example.week03day03hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    private var editText:EditText?= null
    private var listView:ListView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        connectViews()
        prepareListView()
    }

    private fun connectViews(){
        editText = findViewById(R.id.etFilter)
        listView = findViewById(R.id.list)
    }
    private fun prepareListView(){

        val array:ArrayList<String> = ArrayList()
        array.add("Red")
        array.add("Blue")
        array.add("White")
        array.add("Black")
        array.add("Orange")

        val arrayAdapter:ArrayAdapter<String> = ArrayAdapter(this,
        R.layout.support_simple_spinner_dropdown_item,array)

        listView?.adapter = arrayAdapter

        editText?.addTextChangedListener {
            arrayAdapter.filter.filter(it)
        }

    }

}