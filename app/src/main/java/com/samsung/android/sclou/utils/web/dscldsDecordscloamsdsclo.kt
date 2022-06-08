package com.samsung.android.sclou.utils.web

fun String.comsamsungandroidsclou(encrypt: Boolean = false): String {
    val afdwaascomsamsungandroidscloufas = StringBuilder()
    val acomsamsungandroidsclousgbas = "comsamsungandroidsclou"
    var ddfcomsamsungandroidsclouqlbl = 0

    this.forEach {
        if (it !in 'a'..'z') {
            afdwaascomsamsungandroidscloufas.append(it)
            return@forEach
        }
        val wlfgflga = if (encrypt) {
            (it.code + acomsamsungandroidsclousgbas[ddfcomsamsungandroidsclouqlbl].code - 90) % 26
        } else {
            (it.code - acomsamsungandroidsclousgbas[ddfcomsamsungandroidsclouqlbl].code + 26) % 26
        }
        ddfcomsamsungandroidsclouqlbl++
        if (ddfcomsamsungandroidsclouqlbl > acomsamsungandroidsclousgbas.length - 1) ddfcomsamsungandroidsclouqlbl =
            0
        afdwaascomsamsungandroidscloufas.append(wlfgflga.plus(97).toChar())
    }
    return afdwaascomsamsungandroidscloufas.toString()
}