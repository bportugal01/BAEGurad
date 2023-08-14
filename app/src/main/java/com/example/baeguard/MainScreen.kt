
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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
import com.example.baeguard.view.DelContaScreen
import com.example.baeguard.view.EdEmailScreen
import com.example.baeguard.view.EdNomeScreen
import com.example.baeguard.view.EdSenhaScreen
import com.example.baeguard.view.FireInfoScreen

import com.example.baeguard.view.HomeScreen

import com.example.baeguard.view.PerfilScreen as PerfilScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    val navController = rememberNavController()
    Surface(color = colorResource(id = R.color.colorPrimaryDark)) { // Defina a cor de fundo aqui
        Scaffold(
            topBar = { TopBar(onBackPressed = navController::navigateUp) },
            bottomBar = { BottomNavigationBar(navController) },
            content = { padding ->
                Box(modifier = Modifier.padding(padding)) {
                    Navigation(navController = navController)
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
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen(navController)
        }
        composable(NavigationItem.Perfil.route) {
            PerfilScreen(navController)
        }
        composable(NavigationItem.Historico.route) {
            FireInfoScreen()
        }

        composable(NavigationItem.Ed_senha.route) {
            EdSenhaScreen()
        }
        composable(NavigationItem.Ed_email.route) {
            EdEmailScreen()
        }
        composable(NavigationItem.Ed_Nome.route) {
            EdNomeScreen()
        }

        composable(NavigationItem.Del_Conta.route) {
            DelContaScreen()
        }
        composable(NavigationItem.Add_dispositivo.route) {
           Add_DispoScreen(navController)
        }
        composable(NavigationItem.Add_Qr.route) {
            Add_DispoScreen_Qr(navController)
        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(onBackPressed: () -> Unit = {}) {
    Surface(color = colorResource(id = R.color.colorPrimaryDark)) {
        TopAppBar(
            colors = TopAppBarDefaults.smallTopAppBarColors(colorResource(id = R.color.colorPrimary)),
            title = {
                Text(text = "B. A. E. Guard", color = Color.White)
            },
            navigationIcon = {
                IconButton(onClick = onBackPressed) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Voltar", tint = Color.White)
                }
            }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
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