package adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.karandeep.covid19india.R
import com.karandeep.covid19india.statelist
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.custom_row.view.*

class CustomAdapter(val context: Context, private val arrayList: ArrayList<statelist>)
    : RecyclerView.Adapter<CustomAdapter.GithubViewHolder>() {
    //    val prefs= PreferenceManager.getDefaultSharedPreferences(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        val inflater = LayoutInflater.from(context)
        return GithubViewHolder(inflater.inflate(R.layout.custom_row, parent, false))

    }
    override fun getItemCount(): Int = arrayList.size
    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {

    val user = arrayList[position]
    holder.bind(user, position)
}


    inner class GithubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currentuser: statelist? = null
        var currentposition = 0

        init {
          /*  itemView.setOnClickListener {
                //            Toast.makeText(context, currentuser!!.title + "clicked!",Toast.LENGTH_LONG ).show()
                val detail = Intent(context, Details::class.java)
                detail.putExtra("ID", currentuser!!.id)
                context.startActivity(detail)

            }*/

        }

        fun bind(user: statelist, position: Int) {

            this.currentuser = user
            this.currentposition = position
            with(itemView) {

                statename.text = user.state
                active.text=user.active
                confirmed.text=user.confirmed
                deltacnf.text="↑ "+user.deltaconfirmed
                recovered.text=user.recovered
                deltaactv.text="↑ 0"
                deltarcvr.text="↑ "+user.deltarecovered
                deceased.text=user.deaths
               deltadecs.text= "↑ "+user.deltadeaths
            }

//        with(itemView){
//            streettv.text="\nID: "+user.id+"\nName: "+user.name+"\nUsername: "+
//                    user.username+"\nEmail: "+user.email+"\nStreet: "+user.street+
//                    "\nSuite: "+user.suite+"\nCity: "+user.city+"\nZipcode: "+user.zipcode+"\n"


//        }

        }
    }
}




