# Questbox - Flutter Version

**Jogo e metodologia visual de criação de projetos, planejamento, desafios.**

Questbox foi completamente migrado de Android/Kotlin para Flutter, permitindo desenvolvimento cross-platform.

## 🚀 Funcionalidades

- ✅ Criação de Quests
- ✅ Metodologia visual
- ✅ Google Gemini AI
- ✅ Firebase
- ✅ Multiplataforma (iOS, Android, Web)
- ✅ Dark Mode

## 📋 Pré-requisitos

- Flutter SDK 3.4+
- Dart SDK
- Firebase Account
- Google Gemini API Key

## 🔧 Setup

```bash
git clone https://github.com/JulioLicks/questbox.git
cd questbox
git checkout flutter-migration
flutter pub get
cp .env.example .env
# Edit .env
flutter run
```

## 📁 Estrutura

```
lib/
├── config/
├── models/
├── providers/
├── screens/
├── services/
├── theme/
└── main.dart
```

## 🏃 Comandos

```bash
flutter run              # Rodar
flutter test             # Testar
dart format .            # Formatar
flutter analyze          # Analisar
flutter build apk        # Android
flutter build ios        # iOS
flutter build web        # Web
```

## 📚 Documentação

- [SETUP.md](SETUP.md) - Setup por plataforma
- [ARCHITECTURE.md](ARCHITECTURE.md) - Arquitetura
- [MIGRATION.md](MIGRATION.md) - Migração Kotlin→Flutter
- [CONTRIBUTING.md](CONTRIBUTING.md) - Contribuir
- [TROUBLESHOOTING.md](TROUBLESHOOTING.md) - Problemas

## 📄 License

MIT License
