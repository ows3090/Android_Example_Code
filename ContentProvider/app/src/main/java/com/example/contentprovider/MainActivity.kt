package com.example.contentprovider

import android.annotation.SuppressLint
import android.content.ContentValues
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contentprovider.PersonContract.PersonEntry.PERSON_AGE
import com.example.contentprovider.PersonContract.PersonEntry.PERSON_MOBILE
import com.example.contentprovider.PersonContract.PersonEntry.PERSON_NAME
import com.example.contentprovider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindViews()
    }

    private fun bindViews() = with(binding) {
        insertButton.setOnClickListener { insertData() }
        queryButton.setOnClickListener { queryData() }
        updateButton.setOnClickListener { updateDate() }
        deleteButton.setOnClickListener { deleteData() }
    }

    private fun insertData() {
        println("insertData가 호출됨")
        var uri = Uri.parse("content://com.example.contentprovider/person")
        val values = ContentValues().apply {
            put(PERSON_NAME, "ows")
            put(PERSON_AGE, 28)
            put(PERSON_MOBILE, "010-0000-0000")
        }

        uri = contentResolver.insert(uri, values)
        println("insertDatat 결과 : $uri")
    }

    @SuppressLint("Range")
    private fun queryData() {
        val uri = Uri.parse("content://com.example.contentprovider/person")
        val columns = arrayOf(PERSON_NAME, PERSON_AGE, PERSON_MOBILE)
        val cursor = contentResolver.query(uri, columns, null, null,"name ASC")
        println("queryData 결과 ${cursor?.count}")

        cursor?.let { cursor ->
            var index = 0
            while(cursor.moveToNext()){
                val name = cursor.getString(cursor.getColumnIndex(columns.get(0)))
                val age = cursor.getInt(cursor.getColumnIndex(columns.get(1)))
                val mobile = cursor.getString(cursor.getColumnIndex(columns.get(2)))

                println("#${index} -> ${name}, ${age}, ${mobile}")
                index++
            }
        }
    }

    private fun updateDate() {
        val uri = Uri.parse("content://com.example.contentprovider/person")
        val selection = "mobile = ?"
        val selectionArgs = arrayOf("010-0000-0000")

        val values = ContentValues().apply {
            put("mobile","010-1000-1000")
        }

        val count = contentResolver.update(uri, values, selection, selectionArgs)
        println("updateData 결과 ${count}")
    }

    private fun deleteData() {
        val uri = Uri.parse("content://com.example.contentprovider/person")
        val selection = "name = ?"
        val selectionArgs = arrayOf("ows")

        val count = contentResolver.delete(uri, selection, selectionArgs)
        println("deleteData 결과 ${count}")
    }

    private fun println(str: String) = with(binding){
        resultTextView.append("$str\n")
    }

}