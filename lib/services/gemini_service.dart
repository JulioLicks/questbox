import 'package:flutter_dotenv/flutter_dotenv.dart';
import 'package:google_generative_ai/google_generative_ai.dart';

class GeminiService {
  late final GenerativeModel _model;

  GeminiService() {
    final apiKey = dotenv.env['GEMINI_API_KEY'];
    if (apiKey == null) throw Exception('GEMINI_API_KEY not found');
    _model = GenerativeModel(model: 'gemini-pro', apiKey: apiKey);
  }

  Future<String> generateQuestDescription(String questTitle) async {
    try {
      final content = [Content.text('Generate a description for: $questTitle')];
      final response = await _model.generateContent(content);
      return response.text ?? '';
    } catch (e) {
      throw Exception('Failed to generate: $e');
    }
  }
}