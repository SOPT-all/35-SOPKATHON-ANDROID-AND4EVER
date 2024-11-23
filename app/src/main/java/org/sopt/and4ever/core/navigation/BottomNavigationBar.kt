package org.sopt.and4ever.core.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import org.sopt.and4ever.core.util.state.noRippleClickable

@Composable
fun BottomNavigationBar(
    selectedItem: BottomNavigationItem,
    onItemSelected: (BottomNavigationItem) -> Unit,
    modifier: Modifier = Modifier,
    selectedItemColor: Color = Color(0xFFFF4A63),
    unselectedItemColor: Color = Color.Unspecified
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        BottomNavigationItem.entries.fastForEach {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .noRippleClickable { onItemSelected(it) }
                    .padding(vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    tint = if (selectedItem == it) selectedItemColor else unselectedItemColor,
                    imageVector = ImageVector.vectorResource(it.iconRes),
                    contentDescription = null
                )
            }
        }
    }
}