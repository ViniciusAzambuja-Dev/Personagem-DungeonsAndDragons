package org.example.Personagem

import org.example.Racas.*
import java.util.Scanner

class CriadorDePersonagem {

    companion object{

        fun criarPlayer(sc : Scanner) : Personagem{

            println(
                "Bem-vindo ao D&D!" +
                "\nVamos criar seu personagem!" +
                "\n"
            )

            print("Selecione o nome do seu Personagem: ")
            val nome = sc.nextLine()

            imprimirTabelaDeRacas()

            var opcaoDeRaca: Int
            while (true) {
                print("\n\nDigite o número da raça escolhida: ")
                opcaoDeRaca = sc.nextInt()
                sc.nextLine()

                return when (opcaoDeRaca) {
                    1 -> Personagem(AltoElfo(), nome)
                    2 -> Personagem(Draconato(), nome)
                    3 -> Personagem(Gnomo(), nome)
                    4 ->  Personagem(HalflingPesLeves(), nome)
                    5 ->  Personagem(MeioOrc(), nome)
                    6 ->  Personagem(Anao(), nome)
                    7 ->  Personagem(Drow(), nome)
                    8 ->  Personagem(GnomoDaFloresta(), nome)
                    9 ->  Personagem(HalflingRobusto(), nome)
                    10 -> Personagem(Tiefling(), nome)
                    11 -> Personagem(AnaoDaColina(), nome)
                    12 -> Personagem(Elfo(), nome)
                    13 -> Personagem(GnomoDasRochas(), nome)
                    14 -> Personagem(Humano(), nome)
                    15 -> Personagem(AnaoDaMontanha(), nome)
                    16 -> Personagem(ElfoDaFloresta(), nome)
                    17 -> Personagem(Halfling(), nome)
                    18 -> Personagem(MeioElfo(), nome)
                    else -> {
                        println("Escolha inválida. Por favor, selecione um número entre 1 e 18.")
                        continue
                    }
                }
            }
        }

        fun atribuirPontos(sc: Scanner, personagem: Personagem) {
            println("\nParabéns, seu personagem foi criado!" + "\n" +
                    "Agora é hora de distribuir seus pontos de habilidade!")

            println("Como todo iniciante, todas as suas habilidades começam em 8, com um limite inicial de 15 pontos!")
            println("Para que você entenda como funciona a distribuição, iremos mostrar uma tabela de Custos:\n")

            imprimirTabelaCustos()

            var opcaoDeHabilidade = 0
            var pontos = 0
            var quantidadePontosRestantes = personagem.getQuantDePontosDeHabilidade()

            while (quantidadePontosRestantes != 0){

                println("\nVocê tem " + quantidadePontosRestantes + " pontos para distribuir!")

                println(
                    "[1] Força" + "\n" +
                    "[2] Destreza" + "\n" +
                    "[3] Constituicao" + "\n" +
                    "[4] Inteligencia" + "\n" +
                    "[5] Sabedoria" + "\n" +
                    "[6] Carisma" + "\n" +
                    "[7] Sair"
                )

                print("Digite uma opção: ")
                opcaoDeHabilidade = sc.nextInt()
                if (opcaoDeHabilidade < 1 || opcaoDeHabilidade > 7) {
                    print("ERRO: Número da Habilidade selecionada deve ser entre 1 e 7\n")
                }
                else {
                    if (opcaoDeHabilidade == 7 ) {
                        break
                    }
                    print("Digite quantos pontos você deseja: ")
                    pontos = sc.nextInt()

                    if (pontos > 7 || pontos < 1) {
                        println("ERRO: Número de pontos devem ser entre 7 e 1")
                    }
                    else if (quantidadePontosRestantes < pontos) {
                        println("ERRO: Não há pontos suficientes para essa quantidade!")
                    }
                    else {
                        personagem.modificadorDeCusto(opcaoDeHabilidade, pontos)
                        quantidadePontosRestantes = personagem.getQuantDePontosDeHabilidade()
                    }
                }
            }
            personagem.adicionarBonusRaca(personagem)
            personagem.modificadorPontosDeVida()
        }

        private fun imprimirTabelaDeRacas(){

            println("\nSelecione a raça do seu personagem:")
            println(
                String.format(
                    "%-4s %-30s %-4s %-30s %-4s %-30s %-4s %-30s",
                    "1.", "Alto Elfo",
                    "6.", "Anão",
                    "11.", "Anão da Colina",
                    "15.", "Anão da Montanha"
                )
            )
            println(
                String.format(
                    "%-4s %-30s %-4s %-30s %-4s %-30s %-4s %-30s",
                    "2.", "Draconato",
                    "7.", "Drow",
                    "12.", "Elfo",
                    "16.", "Elfo da Floresta"
                )
            )
            println(
                String.format(
                    "%-4s %-30s %-4s %-30s %-4s %-30s %-4s %-30s",
                    "3.", "Gnomo",
                    "8.", "Gnomo da Floresta",
                    "13.", "Gnomo das Rochas",
                    "17.", "Halfling"
                )
            )
            println(
                String.format(
                    "%-4s %-30s %-4s %-30s %-4s %-30s %-4s %-30s",
                    "4.", "Halfling Pés Leves",
                    "9.", "Halfling Robusto",
                    "14.", "Humano",
                    "18.", "Meio Elfo"
                )
            )
            println(
                String.format(
                    "%-4s %-30s %-4s %-30s",
                    "5.", "Meio Orc",
                    "10.", "Tiefling"
                )
            )
        }

        private fun imprimirTabelaCustos(){
            println(String.format("%-15s %15s %-15s %15s", "Valor", "Custos", "Valor", "Custos"))
            println(String.format("%3s %25s %6s %23s", "8", "0", "12", "4"))
            println(String.format("%3s %25s %6s %23s", "9", "1", "13", "5"))
            println(String.format("%3s %25s %6s %23s", "10", "2", "14", "7"))
            println(String.format("%3s %25s %6s %23s", "11", "3", "15", "9"))
        }
    }
}