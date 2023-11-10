package com.example.room_database_tuto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.example.room_database_tuto.databinding.ActivityTestingBinding
import com.example.room_database_tuto.db.AppartementDatabase
import com.example.room_database_tuto.model.Appartement
import com.example.room_database_tuto.repositry.Repository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TestingActivity : AppCompatActivity() {
    lateinit var binding: ActivityTestingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val a1 = Appartement(1,"extra",100,true,"image")
        val a2 = Appartement(2,"basic",120,false,"image")
        val a3 = Appartement(3,"basic",80,true,"image")
        val a4 = Appartement(4,"extra",150,false,"image")

        val repository = Repository(AppartementDatabase.getInstance(this))

        val job1 = lifecycleScope.launch {
            repository.insertAll(a1)
            repository.insertAll(a2)
            repository.insertAll(a3)
            repository.insertAll(a4)

            repository.getAll().collect { appartements ->
                for (appartement in appartements) {
                    binding.testText.text = appartement.toString()
                    delay(1000L)
                }
            }
        }

        runBlocking {
            job1.join()
        }







    }
}