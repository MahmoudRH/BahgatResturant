import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.mahmoudrh.bahgatresturant.model.more.More

@Composable
fun MoreDetailsScreen(content: More) {
    val argument: More = content
    Column { argument.SetContent() }
}

