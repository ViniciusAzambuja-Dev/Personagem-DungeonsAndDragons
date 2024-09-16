package org.example.Personagem

import org.example.Racas.Raca

class Personagem {
    private var raca : Raca
    private var pontosDeVida : Int
    private var nome : String
    private var nivel : Int
    private var xp : Int
    private var forca : Int
    private var destreza : Int
    private var constituicao : Int
    private var inteligencia : Int
    private var sabedoria : Int
    private var carisma : Int
    private var pontosDeHabilidade : Int

    constructor(raca : Raca, nome : String){
        this.raca = raca
        this.pontosDeVida = 10
        this.nome = nome
        this.nivel = 1
        this.xp = 0
        this.forca = 8
        this.destreza = 8
        this.constituicao = 8
        this.inteligencia = 8
        this.sabedoria = 8
        this.carisma = 8
        this.pontosDeHabilidade = 27
    }

    internal fun incrementaForca(pontos : Int){
        forca += pontos
    }
    internal fun incrementaDestreza(pontos : Int){
        destreza += pontos
    }
    internal fun incrementaConstituicao(pontos : Int){
        constituicao += pontos
    }
    internal fun incrementaInteligencia(pontos : Int){
        inteligencia += pontos
    }
    internal fun incrementaSabedoria(pontos : Int){
        sabedoria += pontos
    }
    internal fun incrementaCarisma(pontos : Int){
        carisma += pontos
    }

    //getNome apenas para o teste JUnit
    fun getNome() : String{
        return nome
    }
    fun getQuantDePontosDeHabilidade() : Int{
        return pontosDeHabilidade
    }

    private fun distribuirPontos(pontos: Int, opcaoHabilidade : Int) {
        when (opcaoHabilidade) {
            1 -> forca += pontos
            2 -> destreza += pontos
            3 -> constituicao += pontos
            4 -> inteligencia += pontos
            5 -> sabedoria += pontos
            6 -> carisma += pontos
        }
    }

    internal fun modificadorDeCusto(opcaoDeHabilidade: Int, pontos: Int) {

        val habilidades = intArrayOf(forca, destreza, constituicao, inteligencia, sabedoria, carisma)
        val valorAtualDaHabilidade = habilidades[opcaoDeHabilidade - 1]
        val valorNovoDaHabilidade = valorAtualDaHabilidade + pontos

        if (valorNovoDaHabilidade > 15) {
            println("ERRO: Limite de pontos para essa habilidade atingido!")
            return
        }
        var custo = 0
        for (pontoAtual in valorAtualDaHabilidade until valorNovoDaHabilidade) {
            custo += when {
                pontoAtual in 8 until 13 -> 1
                pontoAtual in 13 until 15 -> 2
                else -> 0
            }
        }

        if (custo > pontosDeHabilidade) {
            println("ERRO: Pontos insuficientes! Custo maior que a quantidade de pontos restantes!")
        } else {
            distribuirPontos(pontos, opcaoDeHabilidade)
            pontosDeHabilidade -= custo
        }

    }

    internal fun modificadorPontosDeVida(){

        when(constituicao){
                1 -> pontosDeVida -= 5
                2, 3 -> pontosDeVida -=4
                4, 5 -> pontosDeVida -= 3
                6, 7 -> pontosDeVida -= 2
                8, 9 -> pontosDeVida -= 1
                12, 13 -> pontosDeVida += 1
                14, 15 -> pontosDeVida += 2
                16, 17 -> pontosDeVida += 3
                18, 19 -> pontosDeVida += 4
                20, 21 -> pontosDeVida += 5
                22, 23 -> pontosDeVida += 6
                24, 25 -> pontosDeVida += 7
                26, 27 -> pontosDeVida += 8
                28, 29 -> pontosDeVida += 9
                30 -> pontosDeVida += 10
        }
    }

    internal fun adicionarBonusRaca(personagem: Personagem){
        raca.implementaBonus(personagem)
    }

    override fun toString() : String{
        return "\nNome do jogador " + nome + "\n" +
                "Nivel: " + nivel + "\n" +
                "Pontos de Vida: " + pontosDeVida + "\n" +
                "Pontos de habilidade: " + pontosDeHabilidade + "\n" +
                "Força: " + forca + "\n" +
                "Destreza: " + destreza + "\n" +
                "Constituicao: " + constituicao + "\n" +
                "Inteligencia: " + inteligencia + "\n" +
                "Sabedoria: " + sabedoria + "\n" +
                "Carisma: " + carisma + "\n"
    }

}