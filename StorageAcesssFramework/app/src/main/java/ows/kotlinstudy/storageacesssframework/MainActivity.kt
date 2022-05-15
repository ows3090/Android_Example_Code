package ows.kotlinstudy.storageacesssframework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ows.kotlinstudy.storageacesssframework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val READ_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        bindViews()
    }

    private fun bindViews() = with(binding){
        actionPickButton.setOnClickListener {
            startActivityForResult(
                Intent(Intent.ACTION_PICK).apply {
                    type = "image/*"
                },
                READ_REQUEST_CODE
            )
        }

        actionGetContentButton.setOnClickListener {
            startActivityForResult(
                Intent(Intent.ACTION_GET_CONTENT).apply {
                    type = "image/*"
                },
                READ_REQUEST_CODE
            )
        }

        actionOpenDocumentButton.setOnClickListener {
            startActivityForResult(
                Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                    type = "image/*"
                },
                READ_REQUEST_CODE
            )
        }

        actionOpenDocumentTreeButton.setOnClickListener {
            startActivityForResult(
                Intent(Intent.ACTION_OPEN_DOCUMENT_TREE),
                READ_REQUEST_CODE
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == READ_REQUEST_CODE){
            val uri = data?.data
            Log.d("saf",uri.toString())
        }
    }
}