package com.winnerezy.ikigai

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.winnerezy.ikigai.ui.BottomBarNavigation
import com.winnerezy.ikigai.ui.explore.ExploreView
import com.winnerezy.ikigai.ui.library.LibraryView
import com.winnerezy.ikigai.ui.profile.ProfileView
import com.winnerezy.ikigai.ui.theme.IkigaiTheme
import com.winnerezy.ikigai.ui.updates.UpdatesView

class MainActivity : ComponentActivity() {
    private var navigationSelectedItem: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IkigaiTheme {
                // A surface container using the 'background' color from the theme
               val navController = rememberNavController()
                val items = listOf(
                    BottomBarNavigation.Library,
                    BottomBarNavigation.Updates,
                    BottomBarNavigation.Explore,
                    BottomBarNavigation.Profile
                )
                Scaffold (
                    bottomBar = {
                        NavigationBar {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination

                            items.forEachIndexed{ index, screen ->
                                NavigationBarItem(
                                    selected =
                                    currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                    onClick = {
                                        navigationSelectedItem = index
                                        navController.navigate(screen.route) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }


                                              },
                                    icon =
                                    {
                                        Icon(
                                            imageVector = if (navigationSelectedItem == index) ImageVector.vectorResource(screen.SelectedIcon) else ImageVector.vectorResource(screen.Icon),
                                            contentDescription = null )
                                    }
                                )
                            }
                        }
                    }, content = {
                        padding ->
                        IkigaiTheme {
                            NavHost(
                                navController = navController,
                                startDestination = BottomBarNavigation.Library.route,
                                modifier = Modifier.padding(padding)
                            ) {
                                composable(BottomBarNavigation.Library.route) { LibraryView() }
                                composable(BottomBarNavigation.Updates.route) { UpdatesView() }
                                composable(BottomBarNavigation.Explore.route) { ExploreView() }
                                composable(BottomBarNavigation.Profile.route) { ProfileView() }

                            }
                        }
                    }
                )
            }
        }
    }
}


