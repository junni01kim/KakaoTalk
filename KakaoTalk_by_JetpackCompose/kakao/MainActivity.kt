package com.example.kakao

import android.app.Activity
import android.graphics.ColorSpace.Named
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakao.ui.theme.KakaoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KakaoTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    // KakaoChat Compasable을 실행한다.
                    Menu();
                }
            }
        }
    }
}

@Composable
fun Menu(modifier: Modifier = Modifier) {
    var kakaoMenu by remember { mutableStateOf(0) }

    Surface(modifier) {
        if (kakaoMenu == 0) {
            OnboardingScreen(nextOnClick1 = { kakaoMenu = 1 }, nextOnClick2 = { kakaoMenu = 2 })
        }
        else if (kakaoMenu == 1){
            KakaoChat(backOnClick = {kakaoMenu = 0}, "1번")
        }
        else if (kakaoMenu == 2) {
            KakaoChat(backOnClick = {kakaoMenu = 0}, "2번")
        }
    }
}

// 수정해야됨
@Composable
fun OnboardingScreen(nextOnClick1: () -> Unit, nextOnClick2: () -> Unit,modifier: Modifier = Modifier) {
    val KakaoTalkColor = Color(0xFE,0xE5,0x00)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("KakaoTalk!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = nextOnClick1
        ) {
            Text("Start1")
        }

        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = nextOnClick2
        ) {
            Text("Start2")
        }
    }
}

// 메세지의 정보를 저장하는 클래스이다. 사용자, 내용으로 구성된다.
// 첫 매개변수는 누가 썼는지, 두번째 매개변수는 무슨 말을 했는지를 의미한다.
class UserText(user:String, text:String){
    var user:String = user
    var text:String = text
}

@Composable
fun KakaoChat(backOnClick: () -> Unit, name:String , modifier:Modifier = Modifier) {
    val view = LocalView.current
    // 테마컬러는 #B0E0E6이다.
    val themeColor = Color(0xB0, 0xE0, 0xE6)
    
    // 상대방 채팅은 하얀색을 사용합니다.
    val yourChatColor = Color.White
    
    // 내 채팅(KakaoTalk 색상)은 #FEE500이다.
    val myChatColor = Color(0xFE,0xE5,0x00)
    
    // 해당 리스트는 카카오톡 창 내용 정렬에 이용됩니다.
    var listStr by remember { mutableStateOf(listOf<UserText>(UserText("you", "Hello!"),UserText("me", "Nice to meet you!"),UserText("you", "안녕하세요!"))) }

    //채팅 윈도우 컴포저블
    var text by remember { mutableStateOf("") }
    
    // Surface1: 휴대폰 화면 전체를 담당한다.
    // 질문1. 굳이 Surface를 사용해야 하는가
    Surface(
        // 화면 바탕을 themeColor로 바꾼다.
        color = themeColor
    ) {
        Column {
            Text(name)
            // Surface1-1: 휴대폰의 상단바를 의미한다.
            Surface(modifier = modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(40.dp), color = themeColor) {
                // 왼쪽에서부터 화살표와 이름이 존재한다.
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // 회의를 통해 배운 것1: 안드로이드 스튜디오에서 기본으로 아이콘들을 제공하며, 이를 이용하면 효율적인 디자인이 가능하다. 
                    IconButton(onClick = backOnClick) {
                        // * 주의: 아이콘의 매개변수로는 contentDescription이 필요하다.
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back Window")
                    }
                    Text(text = "김명준")
                }
            }

            // Surface1-2: 휴대폰의 채팅창을 의미한다.
            Surface(modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp), color = themeColor) {
                // (수정필요) 높이 설정을 할 때 자신의 화면크기 값을 받는 함수 찾아내기.
                LazyColumn(modifier = Modifier
                    .height(580.dp)
                    .padding(4.dp)) {
                    items(listStr){
                        str -> if(str.user.equals("you")) Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start) {
                        Text(
                            text = str.text,
                            Modifier
                                .padding(3.dp)
                                .background(yourChatColor, RoundedCornerShape(15.dp))
                                .padding(10.dp)
                        )
                    }
                        else if(str.user.equals("me")) Row(modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End) {
                        Text(
                            text = str.text,
                            Modifier
                                .padding(3.dp)
                                .background(myChatColor, RoundedCornerShape(15.dp))
                                .padding(10.dp)
                        )
                    }
                    }
                }
            }
            
            // Chatting TextField And Button
            Surface(color = themeColor, modifier = modifier) {
                Column(modifier = Modifier.fillMaxSize()){
                    Box(modifier = Modifier.fillMaxSize()){
                        TextField(value = text, onValueChange = { text=it }, Modifier.fillMaxWidth().fillMaxHeight())
                        IconButton(
                            onClick = {
                                if(!text.equals("")) {
                                    listStr = listStr + UserText("me",text)
                                    text = ""
                                }
                            },
                            Modifier.align(Alignment.TopEnd)
                        ) {
                            // Q.왜 사이즈가 30에서 40이 되면 동그라미로 변형될까
                            Icon(Icons.Default.Send, contentDescription = "Send Message", modifier = Modifier.size(40.dp).background(myChatColor).padding(5.dp))
                        }
                    }
                }
            }
        }
    }

    // 휴대폰 상단 상태창의 색상을 바꾸기 위한 코드
    SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = themeColor.toArgb()
    }
}

@Preview
@Composable
fun MenuPreview() {
    KakaoTheme {
        Menu()
    }
}
