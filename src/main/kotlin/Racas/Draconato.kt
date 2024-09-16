package org.example.Racas

import org.example.Personagem.Personagem

class Draconato() : Raca {
    override fun implementaBonus(personagem: Personagem) {
        personagem.incrementaForca(2)
        personagem.incrementaCarisma(1)
    }
}