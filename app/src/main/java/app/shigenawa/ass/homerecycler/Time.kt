package app.shigenawa.ass.homerecycler

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

public open class Time(
    //@PrimaryKey open var id: String=UUID.randomUUID().toString(),
   //open var imageId: Int=0,
   // open var dataId: String ="",
    public open var uri:String?=null,
   // public open var timeData: Date=Date(System.currentTimeMillis())
    public open var timeData:String?=null
) :RealmObject(){}