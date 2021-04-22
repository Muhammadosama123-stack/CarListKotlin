package com.example.carslistkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean { // this function is used to add menus in the app.

        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.add_car,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { // with this function you tell your menu what to do.
        if (item.itemId == R.id.add_car){
           val intent = Intent(applicationContext,MainActivity2::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}