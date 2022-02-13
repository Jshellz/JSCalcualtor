package com.android.jscalcualtor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var tvVal: TextView
    private lateinit var tvRes: TextView
    lateinit var btnOne: Button
    lateinit var btnTwo: Button
    lateinit var btnThree: Button
    lateinit var btnFour: Button
    lateinit var btnFive: Button
    lateinit var btnSix: Button
    lateinit var btnSeven: Button
    lateinit var btnEight: Button
    lateinit var btnNine: Button
    lateinit var btnComma: Button
    lateinit var btnErase: Button
    lateinit var btnZero: Button
    lateinit var btnC: Button
    lateinit var btnAC: Button
    lateinit var btnPercent: Button
    lateinit var btnAdd: Button
    lateinit var btnSub: Button
    lateinit var btnMul: Button
    lateinit var btnDiv: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvVal = findViewById(R.id.tvVal)
        tvRes = findViewById(R.id.tvRes)
        btnOne = findViewById(R.id.btnOne)
        btnTwo = findViewById(R.id.btnTwo)
        btnThree = findViewById(R.id.btnThree)
        btnFour = findViewById(R.id.btnFour)
        btnFive = findViewById(R.id.btnFive)
        btnSix = findViewById(R.id.btnSix)
        btnSeven = findViewById(R.id.btnSeven)
        btnEight = findViewById(R.id.btnEight)
        btnNine = findViewById(R.id.btnNine)
        btnComma = findViewById(R.id.btnComma)
        btnErase = findViewById(R.id.btnErase)
        btnZero = findViewById(R.id.btnZero)
        btnC = findViewById(R.id.btnC)
        btnAC = findViewById(R.id.btnAC)
        btnPercent = findViewById(R.id.btnPercent)
        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMul = findViewById(R.id.btnMul)
        btnDiv = findViewById(R.id.btnDiv)

        btnOne.setOnClickListener { setTextFields("1") }
        btnTwo.setOnClickListener { setTextFields("2") }
        btnThree.setOnClickListener { setTextFields("3") }
        btnFour.setOnClickListener {setTextFields("4") }
        btnFive.setOnClickListener { setTextFields("5") }
        btnSix.setOnClickListener { setTextFields("6") }
        btnSeven.setOnClickListener { setTextFields("7") }
        btnEight.setOnClickListener { setTextFields("8") }
        btnNine.setOnClickListener { setTextFields("9") }
        btnAdd.setOnClickListener{ setTextFields("+") }
        btnSub.setOnClickListener{ setTextFields("-") }
        btnMul.setOnClickListener{ setTextFields("*") }
        btnDiv.setOnClickListener{ setTextFields("/") }
        btnComma.setOnClickListener { setTextFields(".") }
        btnZero.setOnClickListener { setTextFields("0") }
        btnAC.setOnClickListener {
            tvVal.text = ""
            tvRes.text = ""
        }
        btnC.setOnClickListener {
            val str = tvVal.text.toString()
            if (str.isNotEmpty()) {
                tvVal.text = str.substring(0, str.length -1)
                tvRes.text = ""
            }
        }
        btnErase.setOnClickListener {
            val text = tvVal.text.toString()
            val expression = ExpressionBuilder(text).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                tvRes.text = longResult.toString()
            } else {
                tvRes.text = result.toString()
            }
        }
    }
    private fun setTextFields(str:String){
        tvVal.append(str)
    }
}