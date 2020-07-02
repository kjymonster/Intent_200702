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


        }

        moveToFirstBtn.setOnClickListener {

            //Intent => 비행기로 여행하는 것과 유사  (인텐트로 다른 액티비티로 이동)

            //Intent() = 자바에서 new Intent(); 와 동일 (객체화)
            val myIntent = Intent(this, FirstActivity::class.java)
            startActivity(myIntent)
        }
    }
}