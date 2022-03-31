package com.siddhesh.yepl.ui

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.slider.Slider
import com.siddhesh.yepl.R
import com.siddhesh.yepl.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    lateinit var mViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mBinding.vm = mViewModel
        mBinding.lifecycleOwner=this

        mBinding.rcvRestaurants.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mBinding.rcvRestaurants.adapter=mViewModel.restaurantListAdapter
        mBinding.rcvRestaurants.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        mBinding.rcvRestaurants.addOnScrollListener(mViewModel.scrollListener)
        mViewModel.isRefreshing.observe(this, {
            mBinding.srlRestro.isRefreshing=it
        })

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.drawable.ic_yepl_round)
        supportActionBar!!.setDisplayUseLogoEnabled(true);

        mBinding.rsRadius.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
            }

            override fun onStopTrackingTouch(slider: Slider) {
                mViewModel.radius.value= slider.value.toInt()
                if(slider.value.toInt()<=1000){
                    mViewModel.radiusSelected.value= ""+(slider.value.toInt())+" M"
                }else{
                    mViewModel.radiusSelected.value= ""+(slider.value/1000)+" KM"
                }
                mViewModel.reset()
                mViewModel.callSearchApi(mViewModel.searchText.value!!,mViewModel.offset.value!!)
            }
        })

        mViewModel.showToast.observe(this,{
              Toast.makeText(this, it,Toast.LENGTH_SHORT ).show()
        })

    }
}