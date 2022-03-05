import androidx.compose.runtime.Composable
import com.mahmoudrh.bahgatresturant.model.More
import com.mahmoudrh.bahgatresturant.model.more.Inbox
import com.mahmoudrh.bahgatresturant.model.more.Notification
import com.mahmoudrh.bahgatresturant.ui.ui.theme.*
import kotlin.reflect.KClass
import kotlin.reflect.cast
import kotlin.reflect.safeCast

@Composable
fun MoreDetailsScreen(content: More){
    BahgatResturantTheme {
        val argument: More = content
        argument.setContent()
    }
}

