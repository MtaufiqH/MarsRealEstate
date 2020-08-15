package app.taufiq.marsrealestate.remote

import com.squareup.moshi.Json

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
data class MarsProperty(
    @Json(name = "id")
    val id: String,

    @Json(name = "type")
    val type: String,

    @Json(name = "price")
    val price: Long,

    @Json(name = "img_src")
    val imageSrcUrl: String
)
