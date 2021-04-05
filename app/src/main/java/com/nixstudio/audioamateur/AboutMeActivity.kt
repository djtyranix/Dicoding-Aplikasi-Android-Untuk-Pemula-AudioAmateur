package com.nixstudio.audioamateur

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class AboutMeActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        setActionBarTitle("About Me")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnBlog: Button = findViewById(R.id.btn_blog)
        btnBlog.setOnClickListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setActionBarTitle(title: String?) {
        supportActionBar?.title = title
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_blog -> {
                val uriUrl = Uri.parse("https://audioamateur.studio")
                val openBrowserIntent = Intent(ACTION_VIEW, uriUrl)
                startActivity(openBrowserIntent)
            }
        }
    }
}