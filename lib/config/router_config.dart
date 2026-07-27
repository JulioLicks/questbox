import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../screens/home/home_screen.dart';
import '../screens/quest_detail/quest_detail_screen.dart';
import '../screens/create_quest/create_quest_screen.dart';
import '../screens/settings/settings_screen.dart';

class AppRouter {
  static final GoRouter router = GoRouter(
    initialLocation: '/',
    routes: [
      GoRoute(path: '/', builder: (context, state) => const HomeScreen()),
      GoRoute(
        path: '/quest/:id',
        builder: (context, state) => QuestDetailScreen(questId: state.pathParameters['id']!),
      ),
      GoRoute(path: '/create-quest', builder: (context, state) => const CreateQuestScreen()),
      GoRoute(path: '/settings', builder: (context, state) => const SettingsScreen()),
    ],
  );
}