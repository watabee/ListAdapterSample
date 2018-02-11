package jp.watabee.listadaptersample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.recyclerview.extensions.DiffCallback
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private val adapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter.setList(users)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        findViewById<Button>(R.id.button).setOnClickListener {
            adapter.setList(users.shuffled())
        }
    }
}

internal class UserViewHolder(parent: ViewGroup) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_user,
            parent,
            false
        )
    ) {

    private val imageView: ImageView = itemView.findViewById(R.id.image)
    private val textView: TextView = itemView.findViewById(R.id.text)

    fun bind(user: User) {
        Picasso.with(itemView.context).load(user.avatarUrl).centerInside().fit().into(imageView)
        textView.text = user.login
    }
}

private val DIFF_CALLBACK = object : DiffCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = oldItem == newItem
}

internal class UserAdapter : ListAdapter<User, UserViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(parent)
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(getItem(position))
}

internal data class User(
    val login: String,
    val id: Int,
    val avatarUrl: String
)

private val users = listOf(
    User("mojombo", 1, "https://avatars0.githubusercontent.com/u/1?v=4"),
    User("defunkt", 2, "https://avatars0.githubusercontent.com/u/2?v=4"),
    User("pjhyett", 3, "https://avatars0.githubusercontent.com/u/3?v=4"),
    User("wycats", 4, "https://avatars0.githubusercontent.com/u/4?v=4"),
    User("ezmobius", 5, "https://avatars0.githubusercontent.com/u/5?v=4"),
    User("ivey", 6, "https://avatars0.githubusercontent.com/u/6?v=4"),
    User("evanphx", 7, "https://avatars0.githubusercontent.com/u/7?v=4"),
    User("vanpelt", 17, "https://avatars1.githubusercontent.com/u/17?v=4"),
    User("wayneeseguin", 18, "https://avatars0.githubusercontent.com/u/18?v=4"),
    User("brynary", 19, "https://avatars0.githubusercontent.com/u/19?v=4"),
    User("kevinclark", 20, "https://avatars3.githubusercontent.com/u/20?v=4"),
    User("technoweenie", 21, "https://avatars3.githubusercontent.com/u/21?v=4"),
    User("macournoyer", 22, "https://avatars3.githubusercontent.com/u/22?v=4"),
    User("takeo", 23, "https://avatars3.githubusercontent.com/u/23?v=4"),
    User("Caged", 25, "https://avatars3.githubusercontent.com/u/25?v=4"),
    User("topfunky", 26, "https://avatars3.githubusercontent.com/u/26?v=4"),
    User("anotherjesse", 27, "https://avatars3.githubusercontent.com/u/27?v=4"),
    User("roland", 28, "https://avatars2.githubusercontent.com/u/28?v=4"),
    User("lukas", 29, "https://avatars2.githubusercontent.com/u/29?v=4"),
    User("fanvsfan", 30, "https://avatars2.githubusercontent.com/u/30?v=4"),
    User("tomtt", 31, "https://avatars2.githubusercontent.com/u/31?v=4"),
    User("railsjitsu", 32, "https://avatars2.githubusercontent.com/u/32?v=4"),
    User("nitay", 34, "https://avatars2.githubusercontent.com/u/34?v=4"),
    User("kevwil", 35, "https://avatars2.githubusercontent.com/u/35?v=4"),
    User("KirinDave", 36, "https://avatars2.githubusercontent.com/u/36?v=4"),
    User("jamesgolick", 37, "https://avatars2.githubusercontent.com/u/37?v=4"),
    User("atmos", 38, "https://avatars3.githubusercontent.com/u/38?v=4"),
    User("errfree", 44, "https://avatars2.githubusercontent.com/u/44?v=4"),
    User("mojodna", 45, "https://avatars2.githubusercontent.com/u/45?v=4"),
    User("bmizerany", 46, "https://avatars2.githubusercontent.com/u/46?v=4")
)

