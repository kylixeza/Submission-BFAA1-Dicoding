package com.kylix.submissionbfaa1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kylix.submissionbfaa1.databinding.ActivityDetailBinding
import com.kylix.submissionbfaa1.model.User

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val user = intent.getParcelableExtra<User>(EXTRA_USER)

        Glide.with(this)
            .load(user?.avatar)
            .apply(RequestOptions.circleCropTransform())
            .into(detailBinding.ivDetailAvatarUrl)

        detailBinding.apply {
            tvDetailNumberOfRepos.text = user?.repository
            tvDetailNumberOfFollowers.text = user?.followers
            tvDetailNumberOfFollowing.text = user?.following
            tvDetailName.text = user?.name
            tvDetailCompany.text = user?.company
            tvDetailLocation.text = user?.location
        }

        supportActionBar?.apply {
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
            setDisplayHomeAsUpEnabled(true)
            title = user?.username
        }
    }
}