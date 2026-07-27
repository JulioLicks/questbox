import 'package:flutter/foundation.dart';
import '../models/quest.dart';

class QuestProvider extends ChangeNotifier {
  List<Quest> _quests = [];
  Quest? _selectedQuest;
  bool _isLoading = false;
  String? _error;

  List<Quest> get quests => _quests;
  Quest? get selectedQuest => _selectedQuest;
  bool get isLoading => _isLoading;
  String? get error => _error;

  void setLoading(bool loading) {
    _isLoading = loading;
    notifyListeners();
  }

  void setError(String? error) {
    _error = error;
    notifyListeners();
  }

  void addQuest(Quest quest) {
    _quests.add(quest);
    notifyListeners();
  }

  void selectQuest(Quest quest) {
    _selectedQuest = quest;
    notifyListeners();
  }

  void updateQuest(Quest quest) {
    final index = _quests.indexWhere((q) => q.id == quest.id);
    if (index != -1) {
      _quests[index] = quest;
      notifyListeners();
    }
  }

  void removeQuest(String questId) {
    _quests.removeWhere((q) => q.id == questId);
    notifyListeners();
  }
}