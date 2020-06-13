package app.shigenawa.ass.homerecycler

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

public open class Time(
    //@PrimaryKey open var id: String=UUID.randomUUID().toString(),
   //open var imageId: Int=0,
   // open var dataId: String ="",
    public open var uri:String?=null,  //画像のuriの文字化
   // public open var timeData: Date=Date(System.currentTimeMillis())
    public open var timeData:String?=null,  //日付

    public open var ratingValue1:Float?=null, //きれいさ評価の値
    public open var ratingValue2:Float?=null //維持の評価の値

    //punlic open var item:List<>             //recyclerviewのitemを保存したい

) :RealmObject(){}