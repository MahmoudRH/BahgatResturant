package com.mahmoudrh.bahgatresturant.model.more

import androidx.compose.runtime.Composable
import java.io.Serializable

sealed interface More : Serializable {
    var icon: Int
    var name: String

    @Composable
    fun SetContent()

}


private fun More.getMore() {
     when (this) {
        is About -> TODO()
        is Inbox -> TODO()
        is MyOrder -> TODO()
        is Notification -> TODO()
        is Payment -> TODO()
    }
}
val moreScreens = mapOf(
    About::class.qualifiedName to About(),
    Inbox::class.qualifiedName to Inbox(),
    MyOrder::class.qualifiedName to MyOrder(),
    Notification::class.qualifiedName to Notification(),
    Payment::class.qualifiedName to Payment()
)