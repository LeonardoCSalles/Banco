package com.example.banco

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class PixActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pix)
        setSupportActionBar(findViewById(R.id.toolbar))
        val btnConf = findViewById<Button>(R.id.btnConfirmar)
        val txtsaldo = intent.getStringExtra("sSaldo")
        var nsaldo = txtsaldo.toString().toDouble()
        val edtChave = findViewById<EditText>(R.id.edtChave)
        btnConf.setOnClickListener {
            val data = Intent()
            val valorPix = findViewById<EditText>(R.id.edtValor)
            var nvalor = valorPix.text.toString().toDouble()

            if(nsaldo>nvalor) {
                Toast.makeText(this, "Saldo de $nsaldo é insuficiente", LENGTH_SHORT).show()
            }
            else {
                nsaldo -= nvalor
            }
            val txtSaldo = nsaldo.toString()
            data.putExtra("sSaldo",txtSaldo)
            setResult(Activity.RESULT_OK,data)
            Toast.makeText(this,"$nsaldo", LENGTH_SHORT).show()
            valorPix.setText("".toString())
            edtChave.setText("".toString())
            finish()

        }
    }
}