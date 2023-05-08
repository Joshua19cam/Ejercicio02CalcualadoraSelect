package com.example.app2

import java.lang.Math.sqrt

class Calculadora {
    companion object {
        fun factorial(numero: Int): Int {
            var resultado = 1
            for (i in 2..numero) {
                resultado *= i
            }
            return resultado
        }

        fun raizCuadrada(numero: Double): Double {
            return sqrt(numero)
        }

        fun esPrimo(numero: Int): Boolean {
            if (numero <= 1) {
                return false
            }
            for (i in 2 until numero) {
                if (numero % i == 0) {
                    return false
                }
            }
            return true
        }
    }
}