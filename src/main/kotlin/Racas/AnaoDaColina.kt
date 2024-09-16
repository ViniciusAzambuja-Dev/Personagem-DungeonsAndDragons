package org.example.Racas

import org.example.Personagem.Personagem

class AnaoDaColina() : Raca {
    override fun implementaBonus(personagem: Personagem) {
        personagem.incrementaSabedoria(1)
    }
}