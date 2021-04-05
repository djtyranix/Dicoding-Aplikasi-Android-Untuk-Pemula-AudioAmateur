package com.nixstudio.audioamateur

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ItemDetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val HEADPHONE_DETAIL = "headphone_detail"
        const val HEADPHONE_NAME = "headphone_name"
        const val HEADPHONE_TYPE = "headphone_type"
        const val HEADPHONE_PRICE = "headphone_price"
        const val HEADPHONE_PHOTO = "headphone_photo"
        const val HEADPHONE_SELLERTEL = "headphone_sellertel"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        val imgView : ImageView = findViewById(R.id.img_item_photo)
        val tvName : TextView = findViewById(R.id.tv_item_name)
        val tvType : TextView = findViewById(R.id.tv_item_type)
        val tvPrice : TextView = findViewById(R.id.tv_item_price)
        val tvDetail : TextView = findViewById(R.id.tv_item_detail)
        val btnContact : Button = findViewById(R.id.btn_contact_seller)
        btnContact.setOnClickListener(this)

        val name = intent.getStringExtra(HEADPHONE_NAME)
        val detail = intent.getStringExtra(HEADPHONE_DETAIL)
        val type = intent.getStringExtra(HEADPHONE_TYPE)
        val price = intent.getStringExtra(HEADPHONE_PRICE)
        val photo = intent.getIntExtra(HEADPHONE_PHOTO, 0)

        tvName.text = name
        tvDetail.text = detail
        tvType.text = type
        tvPrice.text = price
        btnContact.text = "Contact"
        setActionBarTitle(name)

        Glide.with(this)
            .load(photo)
            .apply(RequestOptions().override(550, 550))
            .into(imgView)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
            R.id.btn_contact_seller -> {
                dialPhoneNumber(intent.getStringExtra(HEADPHONE_SELLERTEL))
            }
        }
    }

    private fun dialPhoneNumber(telephone : String?) {
        val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${telephone}"))
        startActivity(dialPhoneIntent)
    }
}