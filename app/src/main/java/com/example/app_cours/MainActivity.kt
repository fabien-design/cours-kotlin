package com.example.app_cours

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app_cours.ui.theme.AppcoursTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppcoursTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            colors = topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = {
                                Text("Dashboard")
                            }
                        )
                    },
                    bottomBar = {
                        BottomAppBar(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.primary,
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Button(onClick = {}) { Text("Home") }
                                LargeFloatingActionButton(
                                    onClick = { },
                                    shape = CircleShape,
                                    containerColor = Color.White,
                                    modifier = Modifier.size(48.dp)
                                ) {
                                    Icon(Icons.Filled.Add, "Large floating action button", tint = Color.Red)
                                }
                                Button(onClick = {}) { Text("Profil") }
                            }
                        }
                    },
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        DashboardScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun MyButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String? = null
) {
    if (text == null) {
        Button(
            onClick = onClick,
            modifier = modifier
        ) {
            Text("Cliquez ici")
        }
    } else {
        Text(
            text = text,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppcoursTheme {
        Greeting("Android")
    }
}

@Composable
fun FilledCardExample(
    name: String = "N/A",
    age: Int? = null,
    job: String? = null
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 240.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp, top = 24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.persona_femme),
                contentDescription = "photo de $name",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(text = name, style = MaterialTheme.typography.titleMedium)
                if (age != null) {
                    Text(text = "$age ans", style = MaterialTheme.typography.bodyMedium)
                }
                if (job != null) {
                    Text(text = job, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Composable
fun CardWithLegende(
    legende: String = "Vacance 2026",
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 240.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp, top = 24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
            ) {
                Image(
                    painter = painterResource(id = R.drawable.persona_femme),
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
                    contentDescription = "photo"
                )
                Text(
                    text = legende,
                    modifier = Modifier.align(Alignment.BottomEnd).padding(top = 8.dp)
                )
            }
        }
    }
}

@Composable
fun ColorPicker() {
    var color by remember { mutableStateOf(Color.Red) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color),
            contentAlignment = Alignment.Center
        ) {
            Text("Test test", color = Color.White)
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = { color = Color.Red })   { Text("Rouge") }
            Button(onClick = { color = Color.Green }) { Text("Vert")  }
            Button(onClick = { color = Color.Blue })  { Text("Bleu")  }
        }
    }
}

@Composable
fun WeatherCard(
    temperature: String = "24°C",
    description: String = "Ensoleillé",
    lieu: String = "Lyon"
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "météo",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(32.dp)
                )
                Text(
                    text = lieu,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Text(
                text = temperature,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun SearchBar() {
    var search by remember { mutableStateOf<String>("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        TextField(
            value = search,
            onValueChange = { search = it}
        )

        if (search != "") {
            Column(
                modifier = Modifier.size(width = 260.dp, height = 260.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                Text(
                    "Results for: $search"
                )
                Text(
                    "0 Result found"
                )
            }
        }
    }
}

@Composable
fun UserPreferences() {
    var notifications by remember { mutableStateOf(false) }
    var newsletter by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Activer notifications")
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(if (notifications) "ON" else "OFF")
                    Spacer(modifier = Modifier.width(8.dp))
                    Switch(
                        checked = notifications,
                        onCheckedChange = { notifications = it }
                    )
                }
            }
            HorizontalDivider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Recevoir newsletter")
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(if (newsletter) "Coché" else "Décoché")
                    Checkbox(
                        checked = newsletter,
                        onCheckedChange = { newsletter = it }
                    )
                }
            }
        }
    }
}

data class Task(
    val title: String,
    val description: String
)

@Composable
fun TaskList() {
    val tasks = listOf(
        Task("Faire les courses", "Acheter du pain, du lait et des œufs"),
        Task("Appeler le médecin", "Prendre un rendez-vous pour la semaine prochaine"),
        Task("Réviser Kotlin", "Revoir les composants Jetpack Compose"),
        Task("Faire du sport", "30 minutes de course à pied"),
        Task("Lire", "Lire 20 pages du livre en cours")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(tasks) { task ->
            TaskCard(task)
        }
    }
}

@Composable
fun TaskCard(task: Task) {
    var done by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (done) MaterialTheme.colorScheme.secondaryContainer
            else MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = task.title, style = MaterialTheme.typography.titleMedium)
                Text(text = task.description, style = MaterialTheme.typography.bodySmall)
            }
            Button(
                onClick = { done = !done },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (done) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.secondary
                )
            ) {
                Text(if (done) "Annuler" else "Terminé")
            }
        }
    }
}

@Composable
fun FoodTaskList() {
    var selectedFood by remember { mutableStateOf<String?>(null) }
    val foods = listOf("apple", "banana", "ananas")

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = if (selectedFood != null) "Selected food: $selectedFood" else "Aucun aliment sélectionné",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(foods) { food ->
                FoodTaskCard(
                    food = food,
                    isSelected = selectedFood == food,
                    onSelect = { selectedFood = food }
                )
            }
        }
    }
}

@Composable
fun FoodTaskCard(food: String, isSelected: Boolean, onSelect: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.secondaryContainer
            else MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = food, style = MaterialTheme.typography.titleMedium)
            Button(
                onClick = onSelect,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.secondary
                )
            ) {
                Text(if (isSelected) "Sélectionné" else "Choisir")
            }
        }
    }
}


@Composable
fun DetailedProductCard(image: Int?, name: String, price: Double, isSelected: Boolean, isFavorite: Boolean, onSelect: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.secondaryContainer
            else MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val painter = painterResource(image ?: R.drawable.persona_femme)
            Box() {
                Image(
                    painter = painter,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(2.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(12.dp)),
                    contentDescription = "product $name"
                )
                IconButton(
                    onClick = { },
                    modifier = Modifier.align(Alignment.TopStart).size(32.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.LightGray,
                        contentColor = Color(128, 0, 0)
                    )
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "add to favorite",
                        tint = Color(128, 0, 0),
                    )
                }
            }
            Column(
                modifier = Modifier.padding(start = 4.dp, end = 4.dp)
            ) {
                Text(text = name, style = MaterialTheme.typography.titleMedium)
                Text(text = "$price€", style = MaterialTheme.typography.bodyMedium)
            }
            Button(
                onClick = onSelect,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected) Color.Green
                    else MaterialTheme.colorScheme.secondary
                )
            ) {
                Icon(
                    imageVector = if (isSelected) Icons.Default.CheckCircle else Icons.Default.ShoppingCart,
                    contentDescription = "add this product",
                    tint = if (isSelected) MaterialTheme.colorScheme.primary else Color(0,128,0),
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    var isFollowing by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.persona_femme),
            contentDescription = "photo de profil",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        Text(
            text = "Alice Dupont",
            style = MaterialTheme.typography.headlineMedium
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatItem("128", "Posts")
            StatItem("4.2k", "Followers")
            StatItem("312", "Following")
        }
        Button(
            onClick = { isFollowing = !isFollowing },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isFollowing) MaterialTheme.colorScheme.secondary
                else MaterialTheme.colorScheme.primary
            )
        ) {
            Text(if (isFollowing) "Abonné" else "Suivre")
        }
    }
}

@Composable
fun StatItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, style = MaterialTheme.typography.titleLarge)
        Text(text = label, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun VolumeAndBrightness() {
    var volume by remember { mutableFloatStateOf(25f) }
    var brightness by remember { mutableFloatStateOf(50f) }
    var ghostMode by remember { mutableStateOf<Boolean>(false) }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volume :")
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Slider(
                        value = volume,
                        valueRange = 0f..100f,
                        onValueChange = { volume = it },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("${volume.toInt()}%")
                }
            }
            HorizontalDivider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Brightness: ")
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Slider(
                        value = brightness,
                        valueRange = 0f..100f,
                        onValueChange = { brightness = it },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("${brightness.toInt()}%")
                }
            }
            HorizontalDivider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ghost mode")
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(if (ghostMode) "ON" else "OFF")
                    Spacer(modifier = Modifier.width(8.dp))
                    Switch(
                        checked = ghostMode,
                        onCheckedChange = { ghostMode = it }
                    )
                }
            }
        }
    }
}

data class DashboardItem(
    val title: String,
    val description: String,
    val image: Int
)

@Composable
fun DashboardScreen() {
    val items = listOf(
        DashboardItem("Nike Air Force", "Chaussures de sport premium", R.drawable.nike_shoes),
        DashboardItem("Adidas Ultra Boost", "Confort et performance", R.drawable.persona_femme),
        DashboardItem("Puma RS-X", "Style urbain moderne", R.drawable.persona_femme),
        DashboardItem("New Balance 990", "Classique américain", R.drawable.persona_femme),
        DashboardItem("Reebok Classic", "Icône du streetwear", R.drawable.persona_femme),
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items) { item ->
            DashboardCard(item)
        }
    }
}

@Composable
fun DashboardCard(item: DashboardItem) {
    var isFavorite by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Image(
                painter = painterResource(item.image),
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
            )
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = item.title, style = MaterialTheme.typography.titleMedium)
                Text(text = item.description, style = MaterialTheme.typography.bodySmall)
                Button(
                    onClick = { isFavorite = !isFavorite },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isFavorite) Color(128, 0, 0)
                        else MaterialTheme.colorScheme.primary
                    )
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "favori",
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    if (isFavorite) {
                        Text( "Retiré des favoris", color=Color.White)
                    } else {
                        Text("Ajouter aux favoris")
                    }
                }
            }
        }
    }
}
