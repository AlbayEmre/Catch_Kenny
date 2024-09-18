package com.albayemre.catchthekenykotlin

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.marginBottom
import com.albayemre.catchthekenykotlin.databinding.ActivityMainBinding
import com.google.android.material.R
import java.util.Objects
import kotlin.random.Random



class MainActivity : AppCompatActivity() {

    var devammi : Boolean = false
    var score  =0
    /*Jronometre icin
    var number =0
    var runnable:Runnable = Runnable{}
    var handler:Handler = Handler(Looper.getMainLooper())

     */







    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)






    }

    override fun onStart()
    {


        super.onStart()
        var Difficulty = 1000

            val alert = AlertDialog.Builder(this@MainActivity)
            alert.setTitle("Game Over")
            alert.setMessage("Retstart The Game?")
            alert.setPositiveButton("Yes", DialogInterface.OnClickListener
            { dialogInterface: DialogInterface, i: Int ->


                object : CountDownTimer(14000, Difficulty.toLong()) {
                    override fun onTick(millisUntilFinished: Long)
                    {

                        binding.time.text = "Timme:${millisUntilFinished / 1000}"
                        val randomnumberBootom = Random.nextInt(1, 308) //Random numebr
                        val randomnumberStart = Random.nextInt(1, 320) //Random numebr

                        println(randomnumberStart)
                        println(randomnumberBootom)

                        val imageView = binding.imageView2
                        val params = imageView.layoutParams as ViewGroup.MarginLayoutParams
                        params.bottomMargin = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_header_toggle_margin_bottom) // Replace R.dimen.margin_bottom with your desired dimension resource
                        imageView.layoutParams = params

                        params.bottomMargin = randomnumberBootom *4
                        params.marginStart = randomnumberStart *3
                    }

                    override fun onFinish()
                    {
                        onStart()
                    }

                }.start()
            })

            alert.setNegativeButton("No")
            { dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this@MainActivity, "Game Over", Toast.LENGTH_LONG).show()
                devammi = false
                onStart()
            }



            alert.show()

    }

    //SURE TANİMA GERİYE SAYAN HER GERİYE SAYDİDNA KENİNİN YERİNİ DEYİSTİR


fun kenny(View:View)
{
    score++
    binding.score.text="Score :${score}"




}

}


