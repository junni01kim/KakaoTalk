import 'package:flutter/material.dart';
import 'package:kakaotalk/chatting_page.dart';

void main() {
  runApp(const KakaoTalkApp());
}

class KakaoTalkApp extends StatelessWidget {
  const KakaoTalkApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const ChattingPage(title: 'KakaoTalk'),
    );
  }
}