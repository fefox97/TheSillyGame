package com.example.thesillygame

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.SeekBar
import com.example.thesillygame.ValueChanged.nmosse
import com.example.thesillygame.ValueChanged.nvittorie
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO: aggiusta dimensione tasto gioco

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

        divisioni.text = "Divisioni: " + ndivisioni.toString()

        play.setOnClickListener {
            Scacchiera.inizializza()
            scacchieraView.invalidate()
        }

        seekBarLivelli.min = 3
        seekBarLivelli.max = 7

        seekBarLivelli.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                divisioni.text = "Divisioni : $i"
                ndivisioni = i
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        // Fa parte del listener su mosse
        ValueChanged.refreshListListeners.add(::refreshNMosse)
        ValueChanged.refreshListListeners.add (::refreshNVittorie)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
        //TODO: METTERE HELP AL POSTO DEI SETTINGS
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_game -> {
                // Handle the camera action
            }
            R.id.nav_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                //TODO: AGGIUSTARE FRAGMENT IMPOSTAZIONI
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }





    // Fa parte del listener su mosse
    fun refreshNMosse(){
        mosse.text = "Mosse: " + nmosse.toString()
    }

    fun refreshNVittorie(){
        vittorie.text = "Vittorie: " + nvittorie.toString()
    }
}
