package org.example.Racas

import org.example.Personagem.Personagem

class MeioElfo() : Raca{
    override fun implementaBonus(personagem: Personagem) {
        personagem.incrementaCarisma(2)
    }
}