package com.karandeep.covid19india

import adapter.CustomAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    val retrofitClient = Retrofit.Builder()
            .baseUrl("https://api.covid19india.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val service = retrofitClient.create(GetDataService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        service.getinfo().enqueue(object : Callback<statelist2> {
            override fun onFailure(call: Call<statelist2>, t: Throwable) {
                Snackbar.make(root,"No Internet Connection", Snackbar.LENGTH_INDEFINITE).show()
            }

            override fun onResponse(
                    call: Call<statelist2>,
                    response: Response<statelist2>
            ) {
                runOnUiThread {
                    //                    tv.text=response.body().toString()
                    rview.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
                    rview.adapter = CustomAdapter(this@MainActivity, response.body()!!.statewise)
//                    Picasso.get().load(response.body()?.Poster.toString()).into(image)
                    val snapHelper = PagerSnapHelper()
                    snapHelper.attachToRecyclerView(rview)


                }
            }
        })
    }
}
