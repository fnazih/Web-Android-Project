/**
 * @authors : Valentin POLLART - Fatima-Zohra NAZIH
 * @title : Events in Paris
 */

package com.ismin.projectapp

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class Event(val id: String,
                 val title: String,
                 val cover_url: String,
                 val category: String,
                 val lead_text: String,
                 val programs: String,
                 val description: String,
                 val date_start: String,
                 val date_end: String,
                 val contact_name: String,
                 val contact_phone: String,
                 val contact_mail: String,
                 val address_name: String,
                 val address_street: String,
                 val address_zipcode: String,
                 val address_city: String,
                 val transport_indications: String,
                 val cover_alt: String,
                 val price_type: String,
                 val price_detail: String,
                 val access_link: String,
                 val tags: String,
                 var fav : Boolean): Serializable