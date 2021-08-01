package com.kylix.submissionbfaa1.data

import android.content.Context
import android.content.res.TypedArray
import com.kylix.submissionbfaa1.R
import com.kylix.submissionbfaa1.model.User

object DataDummy {

   private lateinit var listOfUsername: Array<String>
   private lateinit var listOfName: Array<String>
   private lateinit var listOfLocation: Array<String>
   private lateinit var listOfCompany: Array<String>
   private lateinit var listOfRepository: Array<String>
   private lateinit var listOfFollower: Array<String>
   private lateinit var listOfFollowing: Array<String>
   private lateinit var listOFAvatar: TypedArray

    private fun prepareData(context: Context) {
        listOfUsername = context.resources.getStringArray(R.array.username)
        listOfName = context.resources.getStringArray(R.array.name)
        listOfLocation = context.resources.getStringArray(R.array.location)
        listOfCompany = context.resources.getStringArray(R.array.company)
        listOfRepository = context.resources.getStringArray(R.array.repository)
        listOfFollower = context.resources.getStringArray(R.array.followers)
        listOfFollowing = context.resources.getStringArray(R.array.following)
        listOFAvatar = context.resources.obtainTypedArray(R.array.avatar)
    }

    fun getAllUsers(context: Context): ArrayList<User> {
        val listOfUsers: ArrayList<User> = ArrayList()
        prepareData(context)

        for (position in listOfUsername.indices) {
            val user = User(
                username = listOfUsername[position],
                name = listOfName[position],
                location = listOfLocation[position],
                company = listOfCompany[position],
                repository = listOfRepository[position],
                followers = listOfFollower[position],
                following = listOfFollowing[position],
                avatar = listOFAvatar.getResourceId(position, 0)
            )
            listOfUsers.add(user)
        }

        return listOfUsers
    }

}