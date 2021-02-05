package bag.dev.timerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import bag.dev.timerapp.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var aList = ArrayList<AimList>()
    lateinit var adapter:ItemAdapter
    private val fullTime = 86400
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

//        binding.progressBar2.progress
        var isRun = false

        var hours:Int
        var minutes:Int
        var seconds:Int

        binding.button.setOnClickListener {
            aList.add(AimList(binding.editText.text.toString(),fullTime))
            adapter.notifyDataSetChanged()
        }


//        binding.button.setOnClickListener {
//            if (!isRun){
//                binding.progressBar.visibility= View.VISIBLE
//                var time = 20
//                isRun=true
//                val timer = Timer()
//                timer.schedule(object : TimerTask(){
//                    override fun run(){
//                        runOnUiThread{
//                            time--
//                            hours = time/3600
//                            minutes = time%3600/60
//                            seconds = time%60
//                            binding.textView.text = "$hours : $minutes : $seconds"
//                            if (time==0){
//                                timer.cancel()
//                                isRun = false
//                                binding.progressBar.visibility= View.INVISIBLE
//                            }
////                            binding.progressBar2.progress++
////                            if (binding.progressBar2.progress==100){
////                                binding.progressBar2.progress=0
////                            }
//                        }
//                    }
//                },0,1000)
//            }
//        }


    }


}