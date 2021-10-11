package com.example.torreapp.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.torreapp.R
import com.example.torreapp.model.Opportunity
import com.example.torreapp.ui.home.HomeViewModel
import java.net.URL
import kotlin.concurrent.thread

class OpportunityAdapter(private val mContext: Context, private val opportunityList: ArrayList<Opportunity>, viewModel : HomeViewModel):
    BaseAdapter() {

    private val inflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int {
        return opportunityList.size
    }

    override fun getItem(position: Int): Any {
        return opportunityList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val opportunity = getItem(position)
        val itemView  = inflater.inflate(R.layout.card_view_item_layout,parent, false)
        var icons:ImageView = itemView.findViewById(R.id.icon_list)
        var title:TextView = itemView.findViewById(R.id.title_text_view)

        val currentItem = opportunityList[position]
//        thread {
//            currentItem.organizations.stream().forEach {
//                val url = URL(it.picture).openStream()
//                val bmp = BitmapFactory.decodeStream(url)
////                activity?.runOnUiThread{
//                icons.setImageBitmap(bmp)
////                }
//            }
//        }

        title.text = currentItem.objective
        return itemView
    }

}