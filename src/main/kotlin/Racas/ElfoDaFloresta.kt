package org.example.Racas

import org.example.Personagem.Personagem

class ElfoDaFloresta() : Raca {
    override fun implementaBonus(personagem: Personagem) {
        personagem.incrementaSabedoria(1)
    }
}