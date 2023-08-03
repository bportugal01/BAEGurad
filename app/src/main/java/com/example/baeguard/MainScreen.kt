import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.baeguard.R
import com.example.baeguard.view.HistoricoScreen
import com.example.baeguard.view.HomeScreen
import com.example.baeguard.view.PerfilScreen

@Composable
fun MainScreen(navController: NavHostController) {
    val selectedItem = rememberSaveable {  mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        BottomNavigation(
            backgroundColor = Color.Magenta
        ) {
            BottomNavigationItem(
                selected = selectedItem.value==0,
                onClick = { selectedItem.value=0},
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_home_24) ,
                        contentDescription ="Home",
                        tint = if (selectedItem.value==0) Color.White else Color.Black
                    )
                },
                label = {
                    Text(
                        text = "Home",
                        color=if (selectedItem.value==0) Color.White else Color.Black
                    )
                }
            )

            BottomNavigationItem(
                selected = selectedItem.value==1,
                onClick = { selectedItem.value=1},
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_person_24) ,
                        contentDescription ="Perfil",
                        tint = if (selectedItem.value==1) Color.White else Color.Black
                    )
                },
                label = {
                    Text(
                        text = "Perfil",
                        color=if (selectedItem.value==1) Color.White else Color.Black
                    )
                }
            )

            BottomNavigationItem(
                selected = selectedItem.value==2,
                onClick = { selectedItem.value=2},
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_history_24) ,
                        contentDescription ="Histórico",
                        tint = if (selectedItem.value==2) Color.White else Color.Black
                    )
                },
                label = {
                    Text(
                        text = "Histórico",
                        color=if (selectedItem.value==2) Color.White else Color.Black
                    )
                }
            )
        }
    }
    when(selectedItem.value){
        0-> HomeScreen()
        1 -> PerfilScreen()
        2-> HistoricoScreen()
    }
}
