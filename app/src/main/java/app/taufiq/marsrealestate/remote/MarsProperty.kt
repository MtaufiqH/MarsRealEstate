package app.taufiq.marsrealestate.remote

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created By Taufiq on 8/15/2020.
 *
 */


/**
 * This data class defines a Mars property which includes an ID, the image URL, the type (sale
 * or rental) and the price (monthly if it's a rental).
 * The property names of this data class are used by Moshi to match the names of values in JSON.
 */
@Parcelize
data class MarsProperty(
    val id: String,
    val type: String,
    val price: Double,
    @Json(name = "img_src") val imageSrcUrl: String) : Parcelable {

    val isRent get() = type == "rent"
}
