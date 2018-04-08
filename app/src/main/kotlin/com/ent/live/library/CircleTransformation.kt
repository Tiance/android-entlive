package com.ent.live.library

import android.graphics.Bitmap
import com.squareup.picasso.Transformation

class CircleTransformation : Transformation {
    override fun key(): String {
        return "circle"
    }

    override fun transform(p0: Bitmap?): Bitmap {
        return p0!!
    }

}