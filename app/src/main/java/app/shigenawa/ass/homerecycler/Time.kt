package app.shigenawa.ass.homerecycler

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*


 open class Time(
    @PrimaryKey open var id: String=UUID.randomUUID().toString(),

     open var uri:String?=null,  //画像のuriの文字化

     open var timeData:String?=null,  //日付

     open var ratingValue1:Float?=null, //きれいさ評価の値
     open var ratingValue2:Float?=null, //維持の評価の値

    open var createdAt: Date=Date(System.currentTimeMillis())



) :RealmObject()