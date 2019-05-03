package com.codingjuction.navigationpra.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingjuction.navigationpra.R
import com.codingjuction.navigationpra.adapter.CategoryAdapter
import com.codingjuction.navigationpra.model.CategoryModel
import com.google.firebase.database.*


class Home : Fragment() {

    //Here is the problem

    lateinit var categoryList: List<CategoryModel>
    lateinit var mProgress: ProgressBar

    lateinit var ref : DatabaseReference

    lateinit var catAdapter: CategoryAdapter
    lateinit var mrecyclerview: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ref = FirebaseDatabase.getInstance().getReference("categories")

        catAdapter = CategoryAdapter(activity, categoryList)

        categoryList = ArrayList<CategoryModel>()

        mProgress = view.findViewById(R.id.progress_bar)

        mrecyclerview = view.findViewById(R.id.recyclerview)
        mrecyclerview.layoutManager = LinearLayoutManager(activity)


        mrecyclerview.adapter = catAdapter

        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {

                if (p0.exists()) {
                    for (ds in p0.children) {
                        val name = ds.key
                        val thum = ds.child("thumbnail").getValue(toString().javaClass)

                        val c = CategoryModel(name!!, thum!!)
                        (categoryList as ArrayList<CategoryModel>).add(c)
                    }
                    catAdapter.notifyDataSetChanged()
                }
            }
        })
    }
}
