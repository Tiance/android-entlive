package com.ent.live.app.views.fragment.message

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ent.live.app.model.User
import com.ent.live.app.viewmodels.fragment.MessageViewModel
import com.ent.live.library.*
import com.ent.live.live.R
import com.squareup.picasso.Picasso

@Produce(ViewModelScope.PROTOTYPE)
class PM : ViewModelComponent.ViewModelFragment<MessageViewModel.ViewModel>() {

    private val adapter: Adapter<User, UserAdapter.ViewHolder> by lazy {
        Adapter<User, UserAdapter.ViewHolder>(
                view = { vg, _ -> UserAdapter.ViewHolder(LayoutInflater.from(vg.context).inflate(R.layout.r_msg_pm, vg, false)) },
                config = { vh, m ->
                    Picasso.Builder(context!!)
                            .build()
                            .load(m.avatar_url)
                            .into(vh.header)
                    vh.title.text = m.login
                }
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_message, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val rv: RecyclerView = view!!.findViewById(R.id.message_recyclerView)
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = adapter
    }

    override fun bindViewModel() {
        adapter.click.subscribe { Log.d("Click", it.second.login) }.disposedBy(disposeBag)
        adapter.bind(viewModel.outputs.users)
                .disposedBy(disposeBag)

    }

    class UserAdapter {

        class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
            val header: ImageView = itemView!!.findViewById(R.id.pm_list_header)
            val title: TextView = itemView!!.findViewById(R.id.pm_list_title)
            val description: TextView = itemView!!.findViewById(R.id.pm_list_descrip)
            val date: TextView = itemView!!.findViewById(R.id.pm_list_date)
        }
    }
}