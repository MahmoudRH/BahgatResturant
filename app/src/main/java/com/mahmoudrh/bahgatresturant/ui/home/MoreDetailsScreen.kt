import androidx.compose.runtime.Composable
import com.mahmoudrh.bahgatresturant.model.More
import com.mahmoudrh.bahgatresturant.ui.theme.BahgatResturantTheme

@Composable
fun MoreDetailsScreen(content: More){
    BahgatResturantTheme {
        val argument: More = content
        argument.setContent()
    }
}

