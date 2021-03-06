package kr.co.tjoeun.intent_200702

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //닉네임 변경 요청 고유값을 멤버변수로 생성.

    val REQ_FOR_NiCKName = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //두번째 액티비티로 데이터 전달하기
        sendToSecondBtn.setOnClickListener {

            val inputMessage = messageEdt.text.toString()


         // 세번째 액티비티로 닉네임 변경하러 가기
            changeNickNameBtn.setOnClickListener {

                // 다른 화면으로 이동 : Intent 활용

                val myIntent = Intent(this, EditNickNameActivity::class.java)

                //이동 출발 : startActivityForResult => 그냥 가는 것이(startActivity) 아닌 결과를 가지러 이동.
                //어떤 결과를 얻으러 가는지를 고유 번호로 구별해줘야함. (한 화면에 여러가지는 경우)
                startActivityForResult(myIntent, 1000)
            }

            //입력한 고유번호 Int로 받기
            val inputNum = numberEdt.text.toString().toInt()

            //비행기 티켓 발권
            val myIntent = Intent(this, SecondActivity::class.java)

            //티켓정보를 이용해 수하물 첨부
            myIntent.putExtra("message", inputMessage)
            //추가로 정수를 첨부 (2nd step)
            myIntent.putExtra("number", inputNum)

            //탑승 / 출발
            startActivity(myIntent)
        }

        moveToFirstBtn.setOnClickListener {

            //Intent => 비행기로 여행하는 것과 유사  (인텐트로 다른 액티비티로 이동)

            //Intent() = 자바에서 new Intent(); 와 동일 (객체화)
            val myIntent = Intent(this, FirstActivity::class.java)
            startActivity(myIntent)
        }
    }

    //결과를 가지고 돌아올때 실행되는 함수.  (onactire -> 자동완성 선택)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //어떤 결과를 가지러 다녀온건지 확인. => 닉네임 받으러 간건지.
       // if(requestCode == 1000)  숫자를 직접 넣으면 가독성이 매우 떨어짐
        if(requestCode == REQ_FOR_NiCKName){   //가독성을 위해 1000을 REQ_FOR_NICKNAME 멤버변수로 대입해버림.
            //완료로 돌아온게 맞는지도 확인 (resultCode (RESULT_OK))
            if(resultCode == Activity.RESULT_OK){
                //첨부해준 닉네임을 저장 (data + '?')
                val newNickname = data?.getStringExtra("nickName")

                //텍스트뷰에 반영
                nickNameTxt.text = newNickname
            }
        }



    }
}