package com.mahmoudrh.bahgatresturant.utils

import kotlin.random.Random

object FakeOtpManager {
    private val fakeOtp: String = Random.nextInt(from = 1000, until = 9999).toString()

    fun checkVerificationCode(input: String): Boolean {
        return (input == fakeOtp)
    }

    fun getVerificationCode(): String {
        return fakeOtp
    }
}