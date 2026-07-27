import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import '../models/quest.dart';

class FirebaseService {
  final FirebaseAuth _auth = FirebaseAuth.instance;
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  Future<void> saveQuest(Quest quest) async {
    try {
      await _firestore.collection('quests').doc(quest.id).set(quest.toJson());
    } catch (e) {
      throw Exception('Failed to save: $e');
    }
  }

  Future<List<Quest>> getUserQuests(String userId) async {
    try {
      final snapshot = await _firestore.collection('quests').where('userId', isEqualTo: userId).get();
      return snapshot.docs.map((doc) => Quest.fromJson(doc.data())).toList();
    } catch (e) {
      throw Exception('Failed to fetch: $e');
    }
  }

  Future<void> deleteQuest(String questId) async {
    try {
      await _firestore.collection('quests').doc(questId).delete();
    } catch (e) {
      throw Exception('Failed to delete: $e');
    }
  }
}