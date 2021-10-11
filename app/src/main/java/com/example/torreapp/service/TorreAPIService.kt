package com.example.torreapp.service

import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.torreapp.model.User
import com.google.gson.Gson
import android.R
import android.content.Context
import android.net.Uri
import android.util.Log
import android.util.Log.ERROR
import android.widget.ImageView
import android.widget.ListView
import androidx.fragment.app.FragmentActivity
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.torreapp.adapter.OpportunityAdapter
import com.example.torreapp.model.Opportunity
import com.example.torreapp.ui.home.HomeViewModel

import com.google.android.material.navigation.NavigationView
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.json.JSONArray
import org.json.JSONObject
import java.nio.charset.Charset
import kotlin.concurrent.thread

object TorreAPIService{

        fun getProfile(textView: TextView, imageView: ImageView, queue: RequestQueue) {
            val url = "https://torre.bio/api/bios/franklinlucena89"
            var picture = ""
            // Request a string response from the provided URL.
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                { response ->
                    // Display the first 500 characters of the response string.
                    val gson = Gson()
                    val user: User = gson.fromJson(response, User::class.java)
                    picture = user.person.picture

                    imageView.setImageURI(Uri.parse(picture))
                },
                 { textView.text = "That didn't work!" })

            // Add the request to the RequestQueue.
            queue.add(stringRequest)
        }

     fun getOpporunities(activity: Context, homeViewModel: HomeViewModel, listView: ListView):
             ArrayList<Opportunity> {

         var opportunityList = ArrayList<Opportunity>()

         GlobalScope.async {
             val queue = Volley.newRequestQueue(activity)
             val url =
                 "https://search.torre.co/opportunities/_search/?[offset=0&size=10&aggregate=0]"
             val params: MutableMap<String, String> = HashMap()
             params["offset"] = "0"
             params["size"] = "10"
             params["aggregate"] = "0"

             val stringRequest = JsonObjectRequest(
                 Request.Method.POST, url, JSONObject(params as Map<*, *>),
                 { response -> //Listener
                     val gson = Gson()
                     var results = response.get("results") as JSONArray
                     for (result in 0 until results.length()) {
                         opportunityList.add(
                             gson.fromJson(
                                 results.get(result).toString(),
                                 Opportunity::class.java
                             )
                         )
                     }
                     val adapter =  OpportunityAdapter(activity,
                         opportunityList, homeViewModel )
                         listView.adapter = adapter
                 },
                 { error ->
                     Log.e("GetOpportunities", error.localizedMessage) }) //ErrorListener

             // Add the request to the RequestQueue.
             queue.add(stringRequest)
         }
        return opportunityList!!
    }
}