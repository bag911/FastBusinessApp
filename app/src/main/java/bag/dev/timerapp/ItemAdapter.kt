package bag.dev.timerapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class ItemAdapter (private var activity: MainActivity,private var context: Context, private var items:ArrayList<AimList>):RecyclerView.Adapter<ItemAdapter.ViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.viewAim.text = item.aim
        var time = item.time
        val timer = Timer()
        var hours:Int
        var minutes:Int
        var seconds:Int
        holder.viewProgress.visibility= View.VISIBLE
        timer.schedule(object : TimerTask(){
            override fun run(){
               activity.runOnUiThread{
                    time--
                    hours = time/3600
                    minutes = time%3600/60
                    seconds = time%60
                    holder.viewTimer.text = "$hours : $minutes : $seconds"
                    if (time==0){
                        timer.cancel()
                        holder.viewProgress.visibility= View.INVISIBLE
                        holder.viewTimer.text = "Ты обосрался"
                        holder.viewTimer.setTextColor(Color.WHITE)
                        holder.itemView.setBackgroundColor(Color.RED)

                    }
//                            binding.progressBar2.progress++
//                            if (binding.progressBar2.progress==100){
//                                binding.progressBar2.progress=0
//                            }
                }
            }
        },0,1000)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val viewAim : TextView = view.findViewById(R.id.aim)
        val viewTimer : TextView = view.findViewById(R.id.timeText)
        val viewProgress : ProgressBar = view.findViewById(R.id.timeProgress)
    }
}