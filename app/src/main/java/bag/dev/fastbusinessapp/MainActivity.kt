package bag.dev.fastbusinessapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import bag.dev.fastbusinessapp.databinding.ActivityMainBinding
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var aList = ArrayList<AimList>()
    private lateinit var adapter:ItemAdapter
    private val fullTime = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        aList.add(AimList("сходить в зал",fullTime))
        adapter= ItemAdapter(this,this, aList)
        binding.recyclerV.layoutManager= LinearLayoutManager(this)
        binding.recyclerV.adapter =  adapter


        binding.button.setOnClickListener {
            aList.add(AimList(binding.editText.text.toString(),fullTime))
            adapter.notifyDataSetChanged()
        }



    }


}