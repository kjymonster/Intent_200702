package kr.co.tjoeun.intent_200702

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //두번째 액티비티로 데이터 전달하기
        sendToSecondBtn.setOnClickListener {

            val inputMessage = messageEdt.text.toString()


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
}