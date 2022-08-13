package com.team2.kotlinimhome3

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import androidx.navigation.ui.AppBarConfiguration


import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private var join: Button? = null
    private var login: Button? = null
    private var email_login: EditText? = null
    private var pwd_login: EditText? = null
    var firebaseAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)
        join = findViewById<View>(R.id.main_join_btn) as Button
        login = findViewById<View>(R.id.main_login_btn) as Button
        email_login = findViewById<View>(R.id.main_email) as EditText
        pwd_login = findViewById<View>(R.id.main_pwd) as EditText
        firebaseAuth = FirebaseAuth.getInstance() //firebaseAuth의 인스턴스를 가져옴
        login!!.setOnClickListener {
            val email = email_login!!.text.toString().trim { it <= ' ' }
            val pwd = pwd_login!!.text.toString().trim { it <= ' ' }
            //String형 변수 email.pwd(edittext에서 받오는 값)으로 로그인하는것
            firebaseAuth!!.signInWithEmailAndPassword(email, pwd)
                .addOnCompleteListener(
                    this@MainActivity
                ) { task ->
                    if (task.isSuccessful) { //성공했을때
                        val intent = Intent(this@MainActivity, SuccessActivity::class.java)
                        startActivity(intent)
                    } else { //실패했을때
                        Toast.makeText(this@MainActivity, "로그인 오류", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        join!!.setOnClickListener {
            val intent = Intent(this@MainActivity, Main2Activity::class.java)
            startActivity(intent)
        }
    }
}