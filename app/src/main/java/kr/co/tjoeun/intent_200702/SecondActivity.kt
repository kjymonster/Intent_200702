package kr.co.tjoeun.intent_200702

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //들어온 데이터를 받아서 텍스트뷰에 반영


        //액티비티가 가진 intent 변수를 통해서 첨부된 (String (이름표) ) 데이터 저장
        val receivedMessage = intent.getStringExtra("message")

        //저장한 데이터를 텍스트뷰에 반영
        receivedMessageTxt.text = receivedMessage

        //첨부된 Int 데이터를 변수에 저장
        //만약 첨부가 안되었다면 -1을 대신 집어넣자.
        //JAVA의 기본형 변수를 받을때만 필요한 작업 (기본 자료형에서만)
        val recNum = intent.getIntExtra("number", -1)
            //String은 아무것도 없으면 null이 기본이지만, int는 기본값을 직접 넣어줘야함

        //받은 데이터 : 1234 등의 숫자.
        //세팅할 내용은 => "고유번호 : 1234" 와 같이 가공된 String을 넣어야함. (JAVA의 String.format)
        numberTxt.text = "고유번호 : ${recNum}"

    }
}