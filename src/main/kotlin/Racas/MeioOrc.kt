package org.example.Racas

import org.example.Personagem.Personagem

class MeioOrc() : Raca{
    override fun implementaBonus(personagem: Personagem) {
        personagem.incrementaForca(2)
        personagem.incrementaConstituicao(1)
    }

}