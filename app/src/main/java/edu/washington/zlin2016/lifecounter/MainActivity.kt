package edu.washington.zlin2016.lifecounter

import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import android.view.View
import kotlin.math.min
import android.widget.TextView
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    private var playerScore = arrayOf(15, 15, 15, 15)
    private var selectedPlayer = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val plus5 = findViewById<Button>(R.id.plus5)
        val minus = findViewById<Button>(R.id.minus)
        val plus = findViewById<Button>(R.id.plus)
        val minus5 = findViewById<Button>(R.id.minus5)
        val buttons = arrayOf(plus5,plus, minus, minus5)

        for (button in buttons) {
            button.setOnClickListener{onClick(button)}
        }

        // set up spinner
        val playersOptions = arrayOf("Player 1", "Player 2","Player 3","Player 4")
        val playerSelector = findViewById<Spinner>(R.id.playerSelector)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, playersOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        playerSelector!!.setAdapter(adapter)
        playerSelector.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
                selectedPlayer = position
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        playerSelector.setSelection(0)


        val player1Life = findViewById<TextView>(R.id.player4_life)
//        val player2Life = findViewById<TextView>(R.id.player2_life)
//        val player3Life = findViewById<TextView>(R.id.player3_life)
//        val player4Life = findViewById<TextView>(R.id.player4_life)
//        Log.i("life", player1Life.text.toString())
//        player1Life.text = playerScore[0].toString()
//        val lives = arrayOf(player1Life,player2Life, player3Life, player4Life)
//        for (i in 0..1) {
//            lives[i].text = playerScore[i].toString()
//        }






//        // Set up table
//        val table = findViewById<TableLayout>(R.id.table)
//        val row = TableRow(this)
//        val content = TextView(this)
//        content.text = "helloWOled"
//        row.addView(content)
//        table.addView(row)
////        for (i in 0 until playersOptions.size) {                                                                                                                                                                                                                                                                                                                                                                                                                          ````````````````````````````````````````````````````````````````````````````````````````
////            val row = TableRow(this@MainActivity)
////            val content = TextView(this@MainActivity)
////            content.setText(playerScore[i].toString())
////            row.addView(content)
////            table.addView(row)
////        }
//
    }

     fun onClick(v: View) {
        when (v.id){
            R.id.plus5 -> playerScore[selectedPlayer] += 5;
            R.id.plus -> playerScore[selectedPlayer] += 1;
            R.id.minus -> playerScore[selectedPlayer] -= 1;
            R.id.minus5 -> playerScore[selectedPlayer] -= 5;
            else -> playerScore[selectedPlayer] -= 0;
        }
         Log.i("click button", playerScore[selectedPlayer].toString())
    }





}
