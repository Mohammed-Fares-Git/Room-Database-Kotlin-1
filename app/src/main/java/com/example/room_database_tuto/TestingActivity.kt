package com.example.room_database_tuto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.room_database_tuto.databinding.ActivityTestingBinding
import com.example.room_database_tuto.db.AppartementDatabase
import com.example.room_database_tuto.model.Appartement
import com.example.room_database_tuto.repositry.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class TestingActivity : AppCompatActivity() {
    lateinit var binding: ActivityTestingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.testText.text = "WA HKONA"




    }

    override fun onStart() {
        super.onStart()


        val a1 = Appartement("extra", 100, true, "image")
        val a2 = Appartement("basic", 120, false, "image")
        val a3 = Appartement("basic", 80, true, "image")
        val a4 = Appartement("extra", 150, false, "image")

        val repository = Repository(AppartementDatabase.getInstance(this))



        runBlocking {

            repository.insertAll(a1)
            repository.insertAll(a2)
            repository.insertAll(a3)
            repository.insertAll(a4)


            repository.getAll().collect { appartements ->
                Log.d("fares", "the size is : ${appartements.size}")
                for (appartement in appartements) {
                    binding.testText.text = appartement.toString()
                    Log.d("fares", appartement.toString())
                    delay(2000L)
                }
            }
        }
    }
}