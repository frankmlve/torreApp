package com.example.torreapp.model

class CompensationData(
    val code: String,
    val currency: String,
    val minAmount: Double,
    val minHourlyUSD: Double,
    val maxAmount: Double,
    val periodicity: String
) {
}