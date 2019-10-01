package com.dvtri.weddingmanager.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.dvtri.weddingmanager.R
import com.dvtri.weddingmanager.fragment.dirary.FragmentDiaryParty
import com.dvtri.weddingmanager.fragment.saving.FragmentSavingBook
import com.dvtri.weddingmanager.utility.Util.Companion.replaceFragment
import com.google.android.material.navigation.NavigationView



class MainActivity : AppCompatActivity(), View.OnClickListener {

    var mDrawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)

        initUI()

    }

    private fun initUI() {
        mDrawerLayout = findViewById(R.id.drawer_layout)
        replaceFragment(this,FragmentDiaryParty(),"FragmentDiaryParty","FragmentDiaryParty")

        val navigationView : NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(
            object : NavigationView.OnNavigationItemSelectedListener {
                override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
                    // set item as selected to persist highlight
                    menuItem.setChecked(true)
                    // close drawer when item is tapped
                    // Add code here to update the UI based on the item selected
                    // For example, swap UI fragments here
                    return true
                }
            })
    }

    override fun onClick(v: View?) {
        when (v) {

        }
    }

    fun DiaryParty(item: MenuItem) {
        replaceFragment(this,FragmentDiaryParty(),"FragmentDiaryParty","FragmentDiaryParty")
        mDrawerLayout!!.closeDrawers()

    }

    fun SavingBook(item: MenuItem) {
        replaceFragment(this,FragmentSavingBook(),"FragmentSavingBook","FragmentSavingBook")
        mDrawerLayout!!.closeDrawers()
    }

    fun Statistical(item: MenuItem) {}
    fun Logout(item: MenuItem) {
        finish()
    }

}