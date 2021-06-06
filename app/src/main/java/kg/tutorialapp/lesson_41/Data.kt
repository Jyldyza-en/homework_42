package kg.tutorialapp.lesson_41

object Data {

    val items = listOf<Item>(
        Item(1, "Java", R.drawable.ic_baseline_done_24),
        Item(2, "Kotlin", R.drawable.ic_baseline_free_breakfast_24),
        Item(3, "Dart", R.drawable.ic_baseline_flight_takeoff_24)
    )

    fun getLongListOfItems(): MutableList<Item>{
        val list = mutableListOf<Item>()
        for (i in 0..50){
            list.addAll(items)
        }
        return  list
    }

}