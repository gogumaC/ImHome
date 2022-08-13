package com.apptive.android.imhome.feed

import android.util.Log
import com.apptive.android.imhome.baseClass.BaseInteractor
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import java.time.DayOfWeek
import java.util.*

class FeedInteractor : BaseInteractor<Feed>() {
    override val collectionPath: String
    get() = "feed"

    override fun parseData(document: DocumentSnapshot): Feed {

        val id=document.getId()
        val name=document["name"] as? String
        val date=document["date"] as? Timestamp
        val contents=document["contents"] as? String

        val feed=Feed(name.toString(), date?.toDate(),null,contents.toString())

        return feed
    }


}