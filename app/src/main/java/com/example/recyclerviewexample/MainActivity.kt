package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.adapters.CustomRecyclerAdapter
import com.example.recyclerviewexample.model.Item
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = GridLayoutManager(this, 3)


        var arrayList = leerLista()

        var customAdaper = CustomRecyclerAdapter(arrayList, this){item->click(item)}
        recyclerView.adapter = customAdaper
    }

    fun leerLista() : ArrayList<Item>{
        var arrayRdo = ArrayList<Item>()

        var bufferedReaderRaw: BufferedReader = BufferedReader(InputStreamReader(resources!!.openRawResource(R.raw.lista)))
        bufferedReaderRaw.forEachLine { linea -> arrayRdo.add(Item(linea)) }
        bufferedReaderRaw.close()

        return arrayRdo
    }

    fun click(itemValue:Item){
        Toast.makeText(applicationContext,"Valor : ${itemValue.campo1 + "-" + itemValue.campo2}", Toast.LENGTH_LONG).show()
    }

    fun clickBandera(texto: String){
        Toast.makeText(applicationContext,"Bandera : ${texto}", Toast.LENGTH_LONG).show()
    }
}