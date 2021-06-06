package kg.tutorialapp.lesson_41

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(item: Item){

        itemView.run {

            val ivIcon = findViewById<ImageView>(R.id.iv_icon)
            val tvName = findViewById<TextView>(R.id.tv_name)

            ivIcon.setImageResource(item.icon)
            tvName.text = item.name

        }
    }

    companion object{
        fun create(parent: ViewGroup): MyViewHolder{
            val view =LayoutInflater.from(parent.context)
                .inflate(R.layout.item_my_view_holder, parent, false)

            return MyViewHolder(view)
        }
    }
}