package com.nixstudio.audioamateur

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHeadphone : RecyclerView
    private var list : ArrayList<Headphone> = arrayListOf()
    var doubleBackToExitOnce : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeadphone = findViewById(R.id.rv_headphone)
        rvHeadphone.setHasFixedSize(true)

        list.addAll(HeadphonesData.listData)
        showRecyclerCardView()
    }

    override fun onBackPressed() {
        if (doubleBackToExitOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitOnce = true

        Toast.makeText(this, "Press again to exit.", Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper()).postDelayed({
            kotlin.run { doubleBackToExitOnce = false }
        }, 2000)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                showRecyclerCardView()
            }
            R.id.action_about -> {
                showAboutMe()
            }
        }
    }

    private fun showRecyclerCardView() {
        setActionBarTitle("Audio Amateur")
        rvHeadphone.layoutManager = LinearLayoutManager(this)
        val cardViewHeadphoneAdapter = CardViewHeadphoneAdapter(list)
        rvHeadphone.adapter = cardViewHeadphoneAdapter

        cardViewHeadphoneAdapter.setOnItemClickCallback(object : CardViewHeadphoneAdapter.OnItemClickCallback {
            override fun onItemClicked(data : Headphone) {
                showItemDetail(data)
            }
        })
    }

    private fun showAboutMe() {
        val aboutMeIntent = Intent(this, AboutMeActivity::class.java)
        startActivity(aboutMeIntent)
    }

    private fun showItemDetail(item : Headphone) {
        val itemDetailIntent = Intent(this@MainActivity, ItemDetailActivity::class.java)
        itemDetailIntent.putExtra(ItemDetailActivity.HEADPHONE_NAME, item.name)
        itemDetailIntent.putExtra(ItemDetailActivity.HEADPHONE_DETAIL, item.detail)
        itemDetailIntent.putExtra(ItemDetailActivity.HEADPHONE_PRICE, item.price)
        itemDetailIntent.putExtra(ItemDetailActivity.HEADPHONE_SELLERTEL, item.sellerTel)
        itemDetailIntent.putExtra(ItemDetailActivity.HEADPHONE_TYPE, item.type)
        itemDetailIntent.putExtra(ItemDetailActivity.HEADPHONE_PHOTO, item.photo)
        title = item.name
        startActivity(itemDetailIntent)
    }

    private fun setActionBarTitle(title: String?) {
        supportActionBar?.title = title
    }
}