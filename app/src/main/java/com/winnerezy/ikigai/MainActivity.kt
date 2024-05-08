package com.winnerezy.ikigai

import LandingView
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Animatable
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
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
import androidx.compose.material3.NavigationBarItemColors
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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.winnerezy.ikigai.navigation.Navigation
import com.winnerezy.ikigai.ui.BottomBarNavigation
import com.winnerezy.ikigai.ui.explore.ExploreView
import com.winnerezy.ikigai.ui.library.LibraryView
import com.winnerezy.ikigai.ui.profile.ProfileView
import com.winnerezy.ikigai.ui.theme.IkigaiTheme
import com.winnerezy.ikigai.ui.updates.UpdatesView

class MainActivity : ComponentActivity() {
    private var navigationSelectedItem: Int = 0
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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
                        NavigationBar(containerColor = MaterialTheme.colorScheme.background) {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination

                            items.forEachIndexed{ index, screen ->
                                NavigationBarItem(
                                    colors = NavigationBarItemColors(
                                        selectedIconColor = Color.Black,
                                        selectedTextColor = Color.White,
                                        selectedIndicatorColor = Color.White,
                                        unselectedIconColor = Color.White,
                                        unselectedTextColor = Color.White,
                                        disabledIconColor = Color.Black,
                                        disabledTextColor = Color.White
                                        ),
                                    label = {
                                        Text(text = screen.route)
                                            },
                                    alwaysShowLabel = true ,
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
                        IkigaiTheme {
                            NavHost(
                                navController = navController,
                                startDestination = BottomBarNavigation.Library.route
                            ) {
                                composable(
                                    route = BottomBarNavigation.Library.route,
                                    enterTransition = {
                                        EnterTransition.None
                                    },
                                    exitTransition = {
                                        ExitTransition.None
                                    },
                                    popEnterTransition = {
                                        EnterTransition.None
                                    },
                                    popExitTransition = {
                                        ExitTransition.None
                                    }) { LibraryView() }
                                composable(
                                    route = BottomBarNavigation.Updates.route,
                                    enterTransition = {
                                        EnterTransition.None
                                    },
                                    exitTransition = {
                                        ExitTransition.None
                                    },
                                    popEnterTransition = {
                                        EnterTransition.None
                                    },
                                    popExitTransition = {
                                        ExitTransition.None
                                    }) { UpdatesView() }
                                composable(
                                    route = BottomBarNavigation.Explore.route,
                                    enterTransition = {
                                        EnterTransition.None
                                    },
                                    exitTransition = {
                                        ExitTransition.None
                                    },
                                    popEnterTransition = {
                                        EnterTransition.None
                                    },
                                    popExitTransition = {
                                        ExitTransition.None
                                    }) { ExploreView(navController = navController) }
                                composable(
                                    route = BottomBarNavigation.Profile.route,
                                    enterTransition = {
                                        EnterTransition.None
                                    },
                                    exitTransition = {
                                        ExitTransition.None
                                    },
                                    popEnterTransition = {
                                        EnterTransition.None
                                    },
                                    popExitTransition = {
                                        ExitTransition.None
                                    }) { ProfileView() }
                                composable(
                                    route = Navigation.LandingPage.route.plus("/{id}"),
                                    enterTransition = {
                                        EnterTransition.None
                                    },
                                    exitTransition = {
                                        ExitTransition.None
                                    },
                                    popEnterTransition = {
                                        EnterTransition.None
                                    },
                                    popExitTransition = {
                                        ExitTransition.None
                                    },
                                    //getting the id from the explore page as aan argument
                                    arguments = listOf(
                                        navArgument("id") {
                                            type = NavType.StringType
                                        }
                                    )
                                ) {
                                    val param = it.arguments?.getString("id") ?: ""
                                    LandingView(param = param, navController = navController)
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}


