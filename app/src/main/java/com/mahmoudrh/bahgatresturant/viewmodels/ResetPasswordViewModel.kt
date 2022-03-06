package com.mahmoudrh.bahgatresturant.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ResetPasswordViewModel : ViewModel() {

    private val VC : String = Random.nextInt(from = 1000, until = 9999).toString()

    private var verificationCode = mutableStateListOf<Char>(' ', ' ', ' ', ' ')

    fun verificationCodeValue(index: Int): String {
        return if (verificationCode.size > index)
            if  (verificationCode[index]!=' ') verificationCode[index].toString() else ""
        else
            ""
    }

    fun onVerificationCodeChanged(newCode: String,index: Int) {
        if (newCode.isEmpty())
            verificationCode.set(index = index, ' ')
        else
            verificationCode.set(index = index,newCode[0])
    }

    fun checkVerificationCode() :Boolean{
        return (getVerificationCodeAsString() == VC)
    }

    private fun getVerificationCodeAsString() : String{
        var vcString = ""
        for (i in verificationCode){
            vcString += i
        }
        return vcString
    }

    fun getVC(): String {
        return VC
    }
}