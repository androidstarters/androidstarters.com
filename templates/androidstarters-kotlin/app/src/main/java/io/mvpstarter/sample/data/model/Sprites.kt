package <%= appPackage %>.data.model

import com.squareup.moshi.Json

class Sprites {
    @Json(name="front_default")
    var frontDefault: String? = null
}
