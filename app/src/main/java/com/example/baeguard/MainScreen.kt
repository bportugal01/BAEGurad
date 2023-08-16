
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.baeguard.NavigationItem
import com.example.baeguard.R
import com.example.baeguard.view.Add_DispoScreen
import com.example.baeguard.view.Add_DispoScreen_Qr

import com.example.baeguard.view.EdEmailScreen
import com.example.baeguard.view.EdNomeScreen
import com.example.baeguard.view.EdSenhaScreen
import com.example.baeguard.view.HomeScreen
import com.example.baeguard.view.HistoricoScreen
import com.example.baeguard.view.HomeDetalhe


import com.example.baeguard.view.PerfilScreen as PerfilScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    @Composable
    fun currentRoute(navController: NavController): String? {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        return navBackStackEntry?.destination?.route
    }

    fun getTopBarTitle(route: String?): String {
        return when (route) {
            NavigationItem.Home.route -> "Home"
            NavigationItem.Perfil.route -> "Perfil"
            NavigationItem.Historico.route -> "Histórico"
            NavigationItem.Ed_senha.route -> "Editar Senha"
            NavigationItem.Ed_email.route -> "Editar Email"
            NavigationItem.Ed_Nome.route -> "Editar Nome"
            NavigationItem.Add_dispositivo.route -> "Adicionar Dispositivo"
            NavigationItem.Add_Qr.route -> "Escanear QR Code"
            else -> "B. A. E. Guard"
        }
    }



    val navController = rememberNavController()
    val currentRoute = currentRoute(navController)
    val topBarTitle = remember { mutableStateOf(getTopBarTitle(currentRoute)) }

    Surface(color = colorResource(id = R.color.colorPrimaryDark)) {
        Scaffold(
            topBar = { TopBar(title = topBarTitle.value, onBackPressed = navController::navigateUp) },
            bottomBar = { BottomNavigationBar(navController) },
            content = { padding ->
                Box(modifier = Modifier.padding(padding)) {
                    Navigation(navController = navController, onRouteChanged = { route ->
                        topBarTitle.value = getTopBarTitle(route)
                    })
                }
            },
        )
    }


}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController() // Declare e inicialize a variável navController
    MainScreen(navController) // Passe o navController para a função MainScreen
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(navController: NavHostController, onRouteChanged: (String) -> Unit) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            onRouteChanged(NavigationItem.Home.route)
            HomeScreen(navController)
        }
        composable(NavigationItem.Perfil.route) {
            onRouteChanged(NavigationItem.Perfil.route)
            PerfilScreen(navController)
        }
        composable(NavigationItem.Historico.route) {
            onRouteChanged(NavigationItem.Historico.route)
            HistoricoScreen()
        }

        composable(NavigationItem.Ed_senha.route) {
            onRouteChanged(NavigationItem.Ed_senha.route)
            EdSenhaScreen(navController::navigateUp)
        }
        composable(NavigationItem.Ed_email.route) {
            onRouteChanged(NavigationItem.Ed_email.route)
            EdEmailScreen(navController::navigateUp)
        }
        composable(NavigationItem.Ed_Nome.route) {
            onRouteChanged(NavigationItem.Ed_Nome.route)
            EdNomeScreen(navController::navigateUp)
        }
        composable(NavigationItem.Add_dispositivo.route) {
            onRouteChanged(NavigationItem.Add_dispositivo.route)
            Add_DispoScreen(navController)
        }
        composable(NavigationItem.Add_Qr.route) {
            onRouteChanged(NavigationItem.Add_Qr.route)
            Add_DispoScreen_Qr(navController::navigateUp)
        }
        composable(NavigationItem.Home_detalhe.route) {
            onRouteChanged(NavigationItem.Home_detalhe.route)
            HomeDetalhe(navController)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String, onBackPressed: () -> Unit = {}) {
    Surface(color = colorResource(id = R.color.colorPrimaryDark)) {
        TopAppBar(
            colors = TopAppBarDefaults.smallTopAppBarColors(colorResource(id = R.color.colorPrimary)),
            title = {
                Text(text = title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            },
            navigationIcon = {
                IconButton(onClick = onBackPressed) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Voltar", tint = Color.White)
                }
            }
        )
    }
}


@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Perfil,
        NavigationItem.Historico,

    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.colorPrimary),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }



}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    // BottomNavigationBar()
}