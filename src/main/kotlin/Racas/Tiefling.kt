package org.example.Racas

import org.example.Personagem.Personagem

class Tiefling() : Raca {
    override fun implementaBonus(personagem: Personagem) {
        personagem.incrementaInteligencia(1)
        personagem.incrementaCarisma(2)
    }
}