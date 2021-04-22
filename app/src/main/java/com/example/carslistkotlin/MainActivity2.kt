package com.example.carslistkotlin


import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    private val PERMISSIONS_REQUEST = 1

    private val PERMISSION_CAMERA = Manifest.permission.CAMERA
    private val STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE
    private val WRITE = Manifest.permission.WRITE_EXTERNAL_STORAGE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val image = findViewById<ImageView>(R.id.imageView)
        val saveBtn =  findViewById<Button>(R.id.button)
        saveBtn.setOnClickListener{

        }
        image.setOnClickListener{
            if(hasPermission())
            {
            //TODO the fuck u want
            }
            else
            {
                requestPermission()
            }
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
    {
        super.onRequestPermissionsResult(requestCode, permissions!!, grantResults)
        if (requestCode == PERMISSIONS_REQUEST) {
            if (allPermissionsGranted(grantResults)) {
             //   setFragment()
            } else {
                requestPermission()
            }
        }
    }

    private fun allPermissionsGranted(grantResults: IntArray): Boolean {
        for (result in grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    private fun hasPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkSelfPermission(PERMISSION_CAMERA) == PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(WRITE) == PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(STORAGE) == PackageManager.PERMISSION_GRANTED
        } else {
            true
        }
    }

    private fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (shouldShowRequestPermissionRationale(PERMISSION_CAMERA)
                && shouldShowRequestPermissionRationale(STORAGE)
                && shouldShowRequestPermissionRationale(WRITE)
            ) {
                Toast.makeText(
                    this,
                    "Camera permission is required for this demo",
                    Toast.LENGTH_LONG
                )
                    .show()
            }
            requestPermissions(arrayOf(PERMISSION_CAMERA, WRITE, STORAGE),PERMISSIONS_REQUEST
            )
        }
    }


}