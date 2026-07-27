## MIGRAÇÃO DE KOTLIN/ANDROID PARA FLUTTER

Este documento descreve como o projeto Questbox foi migrado de Kotlin (Android nativo) para Flutter.

### Comparação de Conceitos

| Android/Kotlin | Flutter |
|---|---|
| Activity | Screen/Page |
| Fragment | Widget/StatefulWidget |
| ViewModel | ChangeNotifier Provider |
| Room Database | Hive / Firestore |
| Retrofit + OkHttp | Dio / HTTP |
| Compose | Flutter Widgets |
| Navigation Compose | GoRouter |
| Jetpack Datastore | SharedPreferences / Hive |
| Firebase | firebase_flutter plugins |

### Estrutura Kotlin Original

```
app/
├── ui/
│   ├── screens/
│   ├── composables/
│   └── theme/
├── viewmodel/
├── repository/
├── network/
├── database/
└── models/
```

### Estrutura Flutter Equivalente

```
lib/
├── screens/
├── widgets/
├── theme/
├── providers/
├── services/
├── models/
└── config/
```

### Exemplos de Migração

#### 1. ViewModel → Provider

**Kotlin:**
```kotlin
class QuestViewModel : ViewModel() {
    private val _quests = MutableStateFlow<List<Quest>>(emptyList())
    val quests: StateFlow<List<Quest>> = _quests.asStateFlow()
    
    fun addQuest(quest: Quest) {
        _quests.value = _quests.value + quest
    }
}
```

**Flutter:**
```dart
class QuestProvider extends ChangeNotifier {
    List<Quest> _quests = [];
    List<Quest> get quests => _quests;
    
    void addQuest(Quest quest) {
        _quests.add(quest);
        notifyListeners();
    }
}
```

#### 2. Navigation Compose → GoRouter

**Kotlin:**
```kotlin
@Composable
fun NavGraph() {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        composable("quest/{id}") { backStackEntry ->
            QuestDetailScreen(backStackEntry.arguments?.getString("id"))
        }
    }
}
```

**Flutter:**
```dart
final router = GoRouter(
  routes: [
    GoRoute(
      path: '/',
      builder: (context, state) => const HomeScreen(),
    ),
    GoRoute(
      path: '/quest/:id',
      builder: (context, state) {
        final questId = state.pathParameters['id']!;
        return QuestDetailScreen(questId: questId);
      },
    ),
  ],
);
```

#### 3. Composable → StatelessWidget

**Kotlin:**
```kotlin
@Composable
fun QuestCard(quest: Quest) {
    Card {
        Column {
            Text(quest.title)
            Text(quest.description)
        }
    }
}
```

**Flutter:**
```dart
class QuestCard extends StatelessWidget {
    final Quest quest;
    
    const QuestCard({required this.quest});
    
    @override
    Widget build(BuildContext context) {
        return Card(
            child: Column(
                children: [
                    Text(quest.title),
                    Text(quest.description),
                ],
            ),
        );
    }
}
```

#### 4. Room Database → Hive

**Kotlin:**
```kotlin
@Entity
data class QuestEntity(
    @PrimaryKey val id: String,
    val title: String,
    val description: String
)

@Dao
interface QuestDao {
    @Query("SELECT * FROM quest")
    fun getAllQuests(): Flow<List<QuestEntity>>
}
```

**Flutter:**
```dart
class Quest extends HiveObject {
    @HiveField(0)
    late String id;
    
    @HiveField(1)
    late String title;
    
    @HiveField(2)
    late String description;
}

// Usage
final box = Hive.box<Quest>('quests');
List<Quest> quests = box.values.toList();
```

#### 5. Retrofit → Dio

**Kotlin:**
```kotlin
interface ApiService {
    @GET("quests/{id}")
    suspend fun getQuest(@Path("id") id: String): Quest
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://api.example.com")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
```

**Flutter:**
```dart
final dio = Dio(BaseOptions(
    baseUrl: 'https://api.example.com',
));

Future<Quest> getQuest(String id) async {
    final response = await dio.get('/quests/$id');
    return Quest.fromJson(response.data);
}
```

### Dependências Equivalentes

| Android | Flutter |
|---------|---------|
| Jetpack Compose | flutter |
| Material Design 3 | google_fonts, material3 |
| Coroutines | async/await (built-in) |
| Flow | Stream (built-in) |
| LiveData | ChangeNotifier + Provider |
| Hilt | get_it (manual injection) |
| Retrofit | dio, http |
| Room | hive, sqflite |
| Firebase | firebase_flutter packages |
| Datastore | shared_preferences, hive |

### Migração de Assets

**Kotlin (Android):**
```
android/app/src/main/res/
├── drawable/
├── mipmap/
├── values/
└── font/
```

**Flutter:**
```
assets/
├── images/
├── icons/
└── fonts/
```

Configure em `pubspec.yaml`:
```yaml
flutter:
  assets:
    - assets/images/
    - assets/icons/
  fonts:
    - family: CustomFont
      fonts:
        - asset: assets/fonts/CustomFont-Regular.ttf
```

### Próximos Passos

1. ✅ Estrutura Flutter criada
2. ⏳ Migrar componentes UI uma a uma
3. ⏳ Integrar Firebase completamente
4. ⏳ Testar em Android, iOS e Web
5. ⏳ Deploy para App Stores

### Referências

- [Flutter Documentation](https://flutter.dev/docs)
- [Flutter Migration Guide](https://flutter.dev/docs/get-started/flutter-for/android-devs)
- [Provider Package](https://pub.dev/packages/provider)
- [GoRouter Package](https://pub.dev/packages/go_router)
