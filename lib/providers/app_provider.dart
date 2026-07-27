import 'package:flutter/foundation.dart';

class AppProvider extends ChangeNotifier {
  bool _isDarkMode = false;
  String _userId = '';
  bool _isLoading = false;

  bool get isDarkMode => _isDarkMode;
  String get userId => _userId;
  bool get isLoading => _isLoading;

  void setDarkMode(bool isDark) {
    _isDarkMode = isDark;
    notifyListeners();
  }

  void setUserId(String id) {
    _userId = id;
    notifyListeners();
  }

  void setLoading(bool loading) {
    _isLoading = loading;
    notifyListeners();
  }
}