package com.example.app2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val options = arrayOf("Factorial","Raiz cuadrada","Primo")
        var defaultPosition = 0

        val spOpciones = findViewById<Spinner>(R.id.spinner)

        //Boton para elegir que accion se quiere hacer
        val botonCalculadora = findViewById<Button>(R.id.buttonMenu)

        //Hace referencia al editText para tomar el numero que se digite
        val numero = findViewById<EditText>(R.id.editTextPhone)

        //Hace referencia al textView que se mostrá el resultado
        val resultado = findViewById<TextView>(R.id.textViewRespuesta)

        botonCalculadora.setOnClickListener {

            if(TextUtils.isEmpty(numero.text.toString())){
                Toast.makeText(this, "Primero debes escribir un número antes de escoger una opción", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }else{
                val numeroUtil = numero.text.toString().toInt()
                val builderSingle =AlertDialog.Builder(this)
                builderSingle.setTitle("Selecciona")
                builderSingle.setPositiveButton(getString(android.R.string.ok)){dialog,_->dialog.dismiss()}
                builderSingle.setSingleChoiceItems(options,defaultPosition){ _, which ->
                    defaultPosition = which

                    when(which) {
                        0 -> {
                            val factorial = Calculadora.factorial(numeroUtil)
                            resultado.text = "El factorial es: $factorial"
                        }
                        1 -> {
                            val raizCuadrada = Calculadora.raizCuadrada(numeroUtil.toDouble())
                            resultado.text = "La raíz cuadrada es: $raizCuadrada"
                        }
                        2 -> {
                            val esPrimo = if (Calculadora.esPrimo(numeroUtil)) "Si" else "No"
                            resultado.text = "El numero $esPrimo es primo"
                        }
                    }
                }
                builderSingle.show()
            }
        }
        //Para cerrar la aplicación
        val cerrarApp =findViewById<Button>(R.id.buttonOut)
        cerrarApp.setOnClickListener {
            finish()
        }
    }
}