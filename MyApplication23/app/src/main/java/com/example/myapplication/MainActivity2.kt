

package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var b11 : Button
    private lateinit var b12 : Button
    private lateinit var b13 : Button
    private lateinit var b21 : Button
    private lateinit var b22: Button
    private lateinit var b23: Button
    private lateinit var b31: Button
    private lateinit var b32: Button
    private lateinit var player1: TextView
    private lateinit var player2: TextView
    private lateinit var b33: Button
    private var activePlayer = 1
    private var firsPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()
    private lateinit var reset: Button
    private lateinit var bundle: Bundle
    private lateinit var name1:String
    private lateinit var name2:String
    private var player1point = 0
    private var player2point = 0



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        bundle = intent.extras!!
        name1 = bundle.get("play1name") as String
        name2 = bundle.get("play2name") as String


        b11 = findViewById(R.id.button7)
        player1 = findViewById(R.id.textView2)
        player2 = findViewById(R.id.textView)
        b12 = findViewById(R.id.button8)
        b13 = findViewById(R.id.button3)
        b21 = findViewById(R.id.button12)
        b22 = findViewById(R.id.button10)
        b23 = findViewById(R.id.button4)
        b31 = findViewById(R.id.button14)
        b32 = findViewById(R.id.button11)
        b33 = findViewById(R.id.button5)
        reset = findViewById(R.id.button6)
        b11.setOnClickListener(this)
        b12.setOnClickListener(this)
        b13.setOnClickListener(this)
        b21.setOnClickListener(this)
        b22.setOnClickListener(this)
        b23.setOnClickListener(this)
        b31.setOnClickListener(this)
        b32.setOnClickListener(this)
        b33.setOnClickListener(this)

        setPoints()

        var buttonArr = arrayOf(b11, b12, b13, b21, b22, b23, b31, b32, b33)

        reset.setOnClickListener {
            for (i in 0 until buttonArr.size){
                buttonArr[i].text = ""
                buttonArr[i].setBackgroundColor(0X3FA8A7)
                buttonArr[i].isEnabled = true
                activePlayer=1
                firsPlayer = ArrayList()
                secondPlayer = ArrayList()
            }
            player1point = 0
            player2point = 0
            setPoints()
        }



    }

    @SuppressLint("SetTextI18n")
    fun setPoints(){
        player1.text= "$name1: $player1point"
        player2.text = "$name2: $player2point"
    }

    override fun onClick(clickedView: View) {
        if (clickedView is Button) {
            var buttonNumber = 0
            when (clickedView.id) {
                R.id.button7 -> buttonNumber = 1
                R.id.button8 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button12 -> buttonNumber = 4
                R.id.button10 -> buttonNumber = 5
                R.id.button4 -> buttonNumber = 6
                R.id.button14 -> buttonNumber = 7
                R.id.button11 -> buttonNumber = 8
                R.id.button5 -> buttonNumber = 9
            }
            playGame(buttonNumber,clickedView)
        }
    }
    private fun playGame(buttonNumber: Int,clickedView: Button) {
        if (activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.DKGRAY)
            activePlayer = 2
            firsPlayer.add(buttonNumber)

        } else if (activePlayer == 2) {
            clickedView.text = "O"
            clickedView.setBackgroundColor(Color.LTGRAY)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false
        check()

    }


    private fun check(){

        var buttonArray = arrayOf(b11, b12, b13, b21, b22, b23, b31, b32, b33)

        var winnerPlayer = 0
        if(firsPlayer.contains(1) && firsPlayer.contains(4)  && firsPlayer.contains(7) ){
            winnerPlayer = 1
        }
        if(firsPlayer.contains(1) && firsPlayer.contains(5)  && firsPlayer.contains(9) ){
            winnerPlayer = 1
        }
        if(firsPlayer.contains(7) && firsPlayer.contains(5)  && firsPlayer.contains(3) ){
            winnerPlayer = 1
        }
        if(firsPlayer.contains(4) && firsPlayer.contains(5)  && firsPlayer.contains(6) ){
            winnerPlayer = 1
        }
        if(firsPlayer.contains(7) && firsPlayer.contains(8)  && firsPlayer.contains(9) ){
            winnerPlayer = 1
        }
        if(firsPlayer.contains(1) && firsPlayer.contains(2)  && firsPlayer.contains(3) ){
            winnerPlayer = 1
        }
        if(firsPlayer.contains(2) && firsPlayer.contains(5)  && firsPlayer.contains(8) ){
            winnerPlayer = 1
        }
        if(firsPlayer.contains(3) && firsPlayer.contains(6)  && firsPlayer.contains(9) ){
            winnerPlayer = 1
        }

        if(secondPlayer.contains(1) && secondPlayer.contains(4)  && secondPlayer.contains(7) ){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(1) && secondPlayer.contains(5)  && secondPlayer.contains(9) ){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(7) && secondPlayer.contains(5)  && secondPlayer.contains(3) ){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(4) && secondPlayer.contains(5)  && secondPlayer.contains(6) ){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(7) && secondPlayer.contains(8)  && secondPlayer.contains(9) ){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(1) && secondPlayer.contains(2)  && secondPlayer.contains(3) ){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(2) && secondPlayer.contains(5)  && secondPlayer.contains(8) ){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(3) && secondPlayer.contains(6)  && secondPlayer.contains(9) ){
            winnerPlayer = 2
        }

        if (winnerPlayer == 1){

            Toast.makeText(this, "მოიგო პირველმა მოთამაშემ", Toast.LENGTH_SHORT).show()
            player1point++
            setPoints()
            b11.isEnabled = false
            b12.isEnabled = false
            b13.isEnabled = false
            b22.isEnabled = false
            b21.isEnabled = false

            b23.isEnabled = false
            b31.isEnabled = false
            b32.isEnabled = false
            b33.isEnabled = false

            Handler(Looper.getMainLooper()).postDelayed({
                for (i in 0 until buttonArray.size){
                    buttonArray[i].text = ""
                    buttonArray[i].setBackgroundColor(0X3FA8A7)
                    buttonArray[i].isEnabled = true
                    activePlayer=1
                    firsPlayer = ArrayList()
                    secondPlayer = ArrayList()
                }
            }, 700)


        }
        if (winnerPlayer == 2){
            Toast.makeText(this, "მოიგო მეორემ მოთამაშემ", Toast.LENGTH_SHORT).show()
            player2point++
            setPoints()
            b11.isEnabled = false
            b12.isEnabled = false
            b13.isEnabled = false
            b22.isEnabled = false
            b21.isEnabled = false
            b23.isEnabled = false
            b31.isEnabled = false
            b32.isEnabled = false
            b33.isEnabled = false

            Handler(Looper.getMainLooper()).postDelayed({
                for (i in 0 until buttonArray.size){
                    buttonArray[i].text = ""
                    buttonArray[i].setBackgroundColor(0X3FA8A7)
                    buttonArray[i].isEnabled = true
                    activePlayer=1
                    firsPlayer = ArrayList()
                    secondPlayer = ArrayList()
                }
            }, 700)

        }
        else if(firsPlayer.size + secondPlayer.size == 9){
            Toast.makeText(this, "ეე განგამსტაილ", Toast.LENGTH_SHORT).show()

            Handler(Looper.getMainLooper()).postDelayed({
                for (i in 0 until buttonArray.size){
                    buttonArray[i].text = ""
                    buttonArray[i].setBackgroundColor(0X3FA8A7)
                    buttonArray[i].isEnabled = true
                    activePlayer=1
                    firsPlayer = ArrayList()
                    secondPlayer = ArrayList()
                }
            }, 700)
        }

    }





}
