package com.example.composedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Created by Bhoopesh.
 */
class MainActivity : AppCompatActivity() {
    val TAG="MainActivity"
    lateinit var myViewModel: MyViewModel
    private var  mAdapter:RecylcerViewAdapter?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        setObservers()
        prepareSetup()
    }

    private fun setObservers() {
        myViewModel.itemList.observe(this, Observer<List<ResponseModel>> {
            progressBar.makeGone()
            if(!it.isNullOrEmpty()&&it.size>0) {
                searchView.makeVisible()
                tvNoData.makeGone()
                btnRetry.makeGone()
                searchView.setIconifiedByDefault(true)
                searchView.isIconified=false
                mAdapter = RecylcerViewAdapter(this@MainActivity, it as ArrayList<ResponseModel>)
                rvItems.adapter = mAdapter
            }else{
                tvNoData.makeVisible()
                btnRetry.makeVisible()
                this@MainActivity.showToast(getString(R.string.no_data_found))
            }
        })

        myViewModel.error.observe(this, Observer<String?> {
            progressBar.makeGone()
            this@MainActivity.showToast(getString(R.string.some_thing_went_wrong))
        })

    }

    private fun prepareSetup(){
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override
            fun onQueryTextSubmit(query: String?): Boolean {
                mAdapter?.getFilter()?.filter(query)
                return false
            }

            override
            fun onQueryTextChange(query: String?): Boolean {
                mAdapter?.getFilter()?.filter(query)
                return false
            }
        })
        btnRetry.setOnClickListener {
            getData()
        }
        getData()
    }


    /*****
     * Method to call api
     * ********/
    fun getData() {
        if (!this.isInternetAvailable()) {
            AppHelper.showDialog(
                this,
                getString(R.string.net_connection_not_available),
                getString(R.string.alert)
            )
            btnRetry.makeVisible()
        }else{
            progressBar.makeVisible()
            myViewModel.callApi()
        }
    }


}
