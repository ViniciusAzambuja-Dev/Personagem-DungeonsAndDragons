package org.example.Racas

import org.example.Personagem.Personagem

class Humano() : Raca {
    override fun implementaBonus(personagem: Personagem) {
        personagem.incrementaForca(1)
        personagem.incrementaDestreza(1)
        personagem.incrementaConstituicao(1)
        personagem.incrementaInteligencia(1)
        personagem.incrementaSabedoria(1)
        personagem.incrementaCarisma(1)
    }
}