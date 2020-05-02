package com.lago.api.response

import com.google.gson.annotations.SerializedName

data class ExchangeResponse(
    @SerializedName("AED")
    val aED: String,
    @SerializedName("AUD")
    val aUD: String,
    @SerializedName("BDT")
    val bDT: String,
    @SerializedName("BHD")
    val bHD: String,
    @SerializedName("BND")
    val bND: String,
    @SerializedName("BRL")
    val bRL: String,
    @SerializedName("CAD")
    val cAD: String,
    @SerializedName("CHF")
    val cHF: String,
    @SerializedName("CLP")
    val cLP: String,
    @SerializedName("CNY")
    val cNY: String,
    @SerializedName("CZK")
    val cZK: String,
    @SerializedName("DKK")
    val dKK: String,
    @SerializedName("EGP")
    val eGP: String,
    @SerializedName("EUR")
    val eUR: String,
    @SerializedName("GBP")
    val gBP: String,
    @SerializedName("HKD")
    val hKD: String,
    @SerializedName("HUF")
    val hUF: String,
    @SerializedName("IDR")
    val iDR: String,
    @SerializedName("ILS")
    val iLS: String,
    @SerializedName("INR")
    val iNR: String,
    @SerializedName("JOD")
    val jOD: String,
    @SerializedName("JPY")
    val jPY: String,
    @SerializedName("KWD")
    val kWD: String,
    @SerializedName("KZT")
    val kZT: String,
    @SerializedName("MNT")
    val mNT: String,
    @SerializedName("MXN")
    val mXN: String,
    @SerializedName("MYR")
    val mYR: String,
    @SerializedName("NOK")
    val nOK: String,
    @SerializedName("NZD")
    val nZD: String,
    @SerializedName("OMR")
    val oMR: String,
    @SerializedName("PHP")
    val pHP: String,
    @SerializedName("PKR")
    val pKR: String,
    @SerializedName("PLN")
    val pLN: String,
    @SerializedName("QAR")
    val qAR: String,
    @SerializedName("RUB")
    val rUB: String,
    @SerializedName("SAR")
    val sAR: String,
    @SerializedName("SEK")
    val sEK: String,
    @SerializedName("SGD")
    val sGD: String,
    @SerializedName("THB")
    val tHB: String,
    @SerializedName("TRY")
    val tRY: String,
    @SerializedName("TWD")
    val tWD: String,
    @SerializedName("timestamp")
    val timestamp: String,
    @SerializedName("USD")
    val uSD: String,
    @SerializedName("VND")
    val vND: String,
    @SerializedName("ZAR")
    val zAR: String
)
