package app.shigenawa.ass.homerecycler

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Time(
    @PrimaryKey open var id: String=UUID.randomUUID().toString(),
   open var imageId: Int=0,
    open var dataId: String ="",
    open var createdAt: Date=Date(System.currentTimeMillis())
) :RealmObject()