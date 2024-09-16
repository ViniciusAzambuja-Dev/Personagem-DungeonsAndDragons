package org.example

import org.example.Personagem.CriadorDePersonagem
import java.util.Scanner

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val personagem = CriadorDePersonagem.criarPlayer(sc)
    CriadorDePersonagem.atribuirPontos(sc, personagem)
    print(personagem)
}