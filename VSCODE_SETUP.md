# Como Conectar Questbox Flutter no VSCode

## 🚀 Pré-requisitos

Antes de começar, você precisa ter instalado:

### 1. Flutter SDK
```bash
# Verificar se Flutter está instalado
flutter --version

# Se não estiver, instale em:
https://flutter.dev/docs/get-started/install
```

### 2. Dart SDK
```bash
# Vem com Flutter, mas verifique:
dart --version
```

### 3. VSCode
```bash
# Download: https://code.visualstudio.com/
```

### 4. Extensões VSCode Obrigatórias

Instale estas extensões no VSCode:

1. **Flutter** (by Dart Code)
   - ID: `Dart-Code.flutter`
   - Vai incluir Dart também

2. **Dart** (by Dart Code)
   - ID: `Dart-Code.dart-code`

3. **Git** (built-in no VSCode)

---

## 📋 Passo 1: Clone o Repositório

```bash
# Abra o terminal e clone
git clone https://github.com/JulioLicks/questbox.git
cd questbox

# Mude para a branch Flutter
git checkout flutter-migration
```

---

## 🔧 Passo 2: Configure o Ambiente

### 2.1 Crie o arquivo `.env`

```bash
cp .env.example .env
```

### 2.2 Edite `.env` com suas credenciais

Abra o arquivo `.env` e preenchа:

```env
GEMINI_API_KEY=sua_api_key_aqui
FIREBASE_PROJECT_ID=seu_project_id
FIREBASE_APP_ID=seu_app_id
API_BASE_URL=https://api.example.com
```

**Como obter as credenciais:**

- **GEMINI_API_KEY**: 
  - Vá em https://ai.google.dev/studio
  - Clique "Create API Key"
  - Copie a chave

- **Firebase (PROJECT_ID, APP_ID)**:
  - Vá em https://console.firebase.google.com
  - Crie um novo projeto
  - Clique em "Adicionar App"
  - Selecione plataforma (Android, iOS, Web)
  - Copie as informações

### 2.3 Baixe as credenciais Firebase

**Para Android:**
```bash
# Baixe google-services.json do Firebase Console
# Coloque em: android/app/google-services.json
```

**Para iOS:**
```bash
# Baixe GoogleService-Info.plist do Firebase Console
# Coloque em: ios/Runner/GoogleService-Info.plist
```

---

## 🎯 Passo 3: Abra no VSCode

### Opção A: Via VSCode (Recomendado)

```bash
# Na pasta do projeto
code .
```

### Opção B: Abra VSCode e depois o projeto
1. Abra VSCode
2. `Ctrl+K Ctrl+O` (ou `Cmd+K Cmd+O` no Mac)
3. Selecione a pasta `questbox`

---

## 📦 Passo 4: Instale Dependências

Abra o terminal no VSCode (`Ctrl + \`` ou `Ctrl+J`):

```bash
# Obtenha todas as dependências
flutter pub get
```

Você verá:
```
Running "flutter pub get" in questbox...
Getting dependencies...
✓ Got dependencies
```

---

## ⚙️ Passo 5: Gere Código Necessário

```bash
# Gere arquivos json_serializable, hive, etc
flutter pub run build_runner build
```

Ou para modo watch (roda continuamente):

```bash
flutter pub run build_runner watch
```

---

## ✅ Passo 6: Configure Dispositivo/Emulador

### Android

**Opção A: Emulador (Recomendado para começar)**

```bash
# Abra Android Studio
# Tools → AVD Manager → Crie um emulador Android

# Depois, liste dispositivos disponíveis
flutter devices

# Você verá algo como:
# Android SDK built for x86 (mobile) • emulator-5554 • android-x86 • Android 12 (API 31)
```

**Opção B: Dispositivo Real**

```bash
# Habilite USB Debugging no seu Android
# Conecte via USB

# Liste dispositivos
flutter devices

# Você verá:
# Sony XZ Premium (mobile) • FA8CU0307N9 • android-arm64 • Android 8.0.0 (API 26)
```

### iOS (Apenas em Mac)

```bash
# Abra simulador
open -a Simulator

# Instale dependências
cd ios
pod install
cd ..

# Liste dispositivos
flutter devices
```

### Web

```bash
# Nenhuma configuração necessária!
# VSCode pode rodar direto no navegador
```

---

## 🚀 Passo 7: Execute o Projeto

### Opção 1: No Emulador/Dispositivo

```bash
flutter run
```

Você verá:
```
Launching lib/main.dart on Android SDK built for x86 in debug mode...
Syncing files to device Android SDK built for x86...
✓ Built build/app/outputs/apk/debug/app-debug.apk (27.3MB).
Installing and launching...
Waiting for Android SDK built for x86 to report its views...
Debug service listening on ws://...
```

### Opção 2: No VSCode (Com Debug)

1. Coloque um breakpoint (clique na margem esquerda)
2. Pressione `F5` ou vá em `Run → Start Debugging`
3. Escolha `Flutter`

### Opção 3: No Web

```bash
flutter run -d chrome
```

Abre no navegador automaticamente!

---

## 🎮 Passo 8: Hot Reload (Desenvolvimento)

**No terminal onde `flutter run` está rodando:**

- Pressione `r` → **Hot Reload** (recarrega código rápido)
- Pressione `R` → **Hot Restart** (reinicia app completo)
- Pressione `q` → **Quit** (encerra)

**Ou use os botões no VSCode:**
- Debug toolbar aparece no topo

---

## 🛠️ Passo 9: Estrutura do Projeto no VSCode

Você verá isso no Explorer:

```
questbox/
├── lib/                          ← Código Flutter
│   ├── config/
│   ├── models/
│   ├── providers/
│   ├── screens/
│   ├── services/
│   ├── theme/
│   └── main.dart                 ← ENTRY POINT
├── android/                      ← Código Android nativo
├── ios/                          ← Código iOS nativo
├── web/                          ← Código Web
├── test/                         ← Testes
├── pubspec.yaml                  ← Dependências (como package.json)
├── pubspec.lock                  ← Versões travadas
├── .env                          ← Suas credenciais
├── .env.example                  ← Exemplo (não editar)
└── README.md                     ← Documentação
```

---

## 📱 Dica: Selecionar Dispositivo

Se você tiver múltiplos dispositivos:

```bash
# Liste todos disponíveis
flutter devices

# Execute em um específico
flutter run -d <device-id>

# Exemplo:
flutter run -d emulator-5554
```

---

## 🔍 Passo 10: Verifique se Está Funcionando

### No terminal, execute:

```bash
flutter doctor
```

Deve mostrar: ✅ Todos os checkmarks verdes

```
✓ Flutter (Channel stable, 3.4.0, on macOS 13.5, locale pt-BR)
✓ Android toolchain - develop for Android devices (Android SDK version 36.0.0)
✓ Xcode - develop for iOS and macOS (Xcode 14.3.1)
✓ VS Code (version 1.80.0)
✓ Connected device (1 available)
✓ HTTP Host Availability
```

---

## ⚠️ Problemas Comuns

### Erro: "Flutter not found"
```bash
# Adicione Flutter ao PATH
# No seu ~/.bashrc ou ~/.zshrc, adicione:
export PATH="$PATH:/caminho/para/flutter/bin"

# Depois recarregue o terminal
source ~/.bashrc  # ou ~/.zshrc
```

### Erro: "Podfile not found" (iOS)
```bash
cd ios
pod install
cd ..
```

### Erro: "Google Services not found"
```bash
# Baixe google-services.json e coloque em:
android/app/google-services.json

# E GoogleService-Info.plist em:
ios/Runner/GoogleService-Info.plist
```

### Erro: ".env file not found"
```bash
# Certifique-se que criou o arquivo .env
cp .env.example .env
# E preencheu as credenciais
```

### Emulador não aparece
```bash
# Abra Android Studio
# Tools → AVD Manager → Play (para iniciar emulador)

# Depois:
flutter devices  # Deve listar agora
```

---

## 🎯 Seus Primeiros Passos

1. ✅ Clone o repositório
2. ✅ Configure `.env` e credenciais Firebase
3. ✅ Instale extensões VSCode
4. ✅ `flutter pub get`
5. ✅ `flutter run`
6. ✅ Veja o app rodando! 🚀

---

## 📚 Documentação Adicional

- [QUICKSTART.md](QUICKSTART.md) - Início rápido
- [SETUP.md](SETUP.md) - Setup por plataforma
- [TROUBLESHOOTING.md](TROUBLESHOOTING.md) - Problemas comuns

---

## ✨ Pronto!

Você agora pode:
- ✅ Editar código em tempo real
- ✅ Ver mudanças com hot reload
- ✅ Testar em múltiplas plataformas
- ✅ Debugar com breakpoints
- ✅ Compilar para produção

**Feliz desenvolvimento! 🎉**
