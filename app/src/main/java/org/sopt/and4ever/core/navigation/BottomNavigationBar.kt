package org.sopt.and4ever.core.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import org.sopt.and4ever.core.util.state.noRippleClickable

@Composable
fun BottomNavigationBar(
    selectedItem: BottomNavigationItem,
    onItemSelected: (BottomNavigationItem) -> Unit,
    modifier: Modifier = Modifier,
    selectedItemColor: Color = Color.White,
    unselectedItemColor: Color = Color.Magenta
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        BottomNavigationItem.entries.fastForEach {
            Column(
                modifier = Modifier.padding(vertical = 8.dp).weight(1f).noRippleClickable {
                    onItemSelected(it)
                },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    tint = if (selectedItem == it) selectedItemColor else unselectedItemColor,
                    painter = painterResource(it.iconRes),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = stringResource(it.titleRes),
                    color = if (selectedItem == it) selectedItemColor else unselectedItemColor
                )
            }
        }
    }
}