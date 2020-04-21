package com.karandeep.covid19india

data class statelist(

    val active: String,
    val confirmed: String,
    val deaths: String,
    val deltaconfirmed: String,
    val deltadeaths: String,
    val deltarecovered: String,
    val lastupdatedtime: String,
    val recovered: String,
    val state: String,
    val statecode: String,
    val statenotes: String

){
    fun getTitle(): String {
        return state;
    }

}
data class statelist2(val statewise:ArrayList<statelist>)