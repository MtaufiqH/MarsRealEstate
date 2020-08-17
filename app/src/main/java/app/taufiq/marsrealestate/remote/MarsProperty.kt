package app.taufiq.marsrealestate.remote

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created By Taufiq on 8/15/2020.
 *
 */


/**
 *  a class to store the parsed result.
 * */

/** SAMPLE JSON RESPONSE
 * [{"price":450000,
 * "id":"424906",
 * "type":"rent",
 * "img_src":"http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000ML0044631300305227E03_DXXX.jpg"},
...]
 */

@Parcelize
data class MarsProperty(
    val id: String,
    val type: String,
    val price: Double,
    @Json(name = "img_src") val imageSrcUrl: String) : Parcelable {

    val isRent get() = type == "rent"
}
