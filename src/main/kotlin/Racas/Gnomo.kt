package org.example.Racas

import org.example.Personagem.Personagem

class Gnomo() : Raca{
    override fun implementaBonus(personagem: Personagem) {
        personagem.incrementaInteligencia(2)
    }
}