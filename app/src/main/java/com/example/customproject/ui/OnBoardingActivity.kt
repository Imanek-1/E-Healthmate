package com.example.customproject.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.customproject.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_on_boarding)

        viewPager = findViewById(R.id.viewPager2)

        val adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)



        adapter.addFragment(FirstFragment())
        adapter.addFragment(SecondFragment())
        adapter.addFragment(ThirdFragment())

        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        viewPager.adapter = adapter

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            //Some implementation
        }.attach()

        findViewById<Button>(R.id.next_btn).setOnClickListener {
            moveNext(viewPager)
        }

    }

    private fun moveNext(pager: ViewPager2) {
        //it doesn't matter if you're already in the last item
        if(pager.currentItem == 2) {
            val intent = Intent(this,Authentification::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            this@OnBoardingActivity.finish()

        }
        pager.currentItem = pager.currentItem + 1

    }

}