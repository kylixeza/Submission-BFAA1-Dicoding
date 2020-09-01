package com.example.submissionbfaa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity : AppCompatActivity() {


   companion object{
       const val EXTRA_USER = "extra_user"
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val user= intent.getParcelableExtra<User>(EXTRA_USER)
        Glide.with(this).load(user?.avatar).into(iv_ava )
        tv_username.text = user?.username
        tv_name.text = user?.name
        tv_location.text = user?.location
        tv_company.text = user?.company
        tv_repository.text = user?.repository
        tv_followers.text = user?.followers
        tv_following.text = user?.following

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}