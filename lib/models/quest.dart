import 'package:json_annotation/json_annotation.dart';

part 'quest.g.dart';

@JsonSerializable()
class Quest {
  final String id;
  final String title;
  final String description;
  final String category;
  final DateTime createdAt;
  final DateTime? dueDate;
  final bool isCompleted;
  final List<String> challenges;
  final String userId;

  Quest({
    required this.id,
    required this.title,
    required this.description,
    required this.category,
    required this.createdAt,
    this.dueDate,
    this.isCompleted = false,
    this.challenges = const [],
    required this.userId,
  });

  factory Quest.fromJson(Map<String, dynamic> json) => _$QuestFromJson(json);
  Map<String, dynamic> toJson() => _$QuestToJson(this);

  Quest copyWith({
    String? id,
    String? title,
    String? description,
    String? category,
    DateTime? createdAt,
    DateTime? dueDate,
    bool? isCompleted,
    List<String>? challenges,
    String? userId,
  }) {
    return Quest(
      id: id ?? this.id,
      title: title ?? this.title,
      description: description ?? this.description,
      category: category ?? this.category,
      createdAt: createdAt ?? this.createdAt,
      dueDate: dueDate ?? this.dueDate,
      isCompleted: isCompleted ?? this.isCompleted,
      challenges: challenges ?? this.challenges,
      userId: userId ?? this.userId,
    );
  }
}