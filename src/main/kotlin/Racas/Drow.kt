package org.example.Racas

import org.example.Personagem.Personagem

class Drow() : Raca {
    override fun implementaBonus(personagem: Personagem) {
        personagem.incrementaCarisma(1)
    }
}