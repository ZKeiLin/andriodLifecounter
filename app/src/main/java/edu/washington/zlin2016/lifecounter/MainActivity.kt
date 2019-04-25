package edu.washington.zlin2016.lifecounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private var playerScore = arrayOf(15, 15, 15, 15)
    private var selectedPlayer = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Table
        val lives = arrayOf(
            findViewById<TextView>(R.id.player1_life),
            findViewById<TextView>(R.id.player2_life),
            findViewById<TextView>(R.id.player3_life),
            findViewById<TextView>(R.id.player4_life))
        for (i in 0..playerScore.size-1) {
            lives[i].text = playerScore[i].toString()
        }

        //  Buttons
        val buttons = arrayOf(
            findViewById<Button>(R.id.plus5),
            findViewById<Button>(R.id.minus),
            findViewById<Button>(R.id.plus),
            findViewById<Button>(R.id.minus5))
        for (button in buttons) {
            button.setOnClickListener{onClick(button, lives)}
        }

        // set up spinner
        val playersOptions = arrayOf("Player 1", "Player 2", "Player 3", "Player 4")
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
    }

     fun onClick(v: View, lives: Array<TextView>) {
        when (v.id){
            R.id.plus5 -> playerScore[selectedPlayer] += 5;
            R.id.plus -> playerScore[selectedPlayer] += 1;
            R.id.minus -> playerScore[selectedPlayer] -= 1;
            R.id.minus5 -> playerScore[selectedPlayer] -= 5;
            else -> playerScore[selectedPlayer] -= 0;
        }
         lives[selectedPlayer].text = playerScore[selectedPlayer].toString()
         if(playerScore[selectedPlayer] <= 0){
             Toast.makeText(applicationContext, "Player"+(selectedPlayer+1)+" LOSES!", Toast.LENGTH_LONG).show()
             finish()
             startActivity(getIntent())
         }
    }
}
