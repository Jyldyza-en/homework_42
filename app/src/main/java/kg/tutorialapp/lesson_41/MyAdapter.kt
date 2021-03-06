package kg.tutorialapp.lesson_41

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter: RecyclerView.Adapter<MyViewHolder>() {

    private val items = arrayListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        Log.i(MyAdapter.TAG, "onCreateViewHolder()")
        return MyViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Log.i(MyAdapter.TAG, "onBindViewHolder()")
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    fun setItems(newItems: List<Item>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    companion object{
        const val TAG = "Adapter"
    }
}