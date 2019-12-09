import Validator from './tool/Validator';
// import Canoa from './gamecore/Canoa';
// import Rio from './gamecore/Rio';
// import Capivara from './gamecore/Capivara';
// import BarraDeVida from './gamecore/BarraDeVida';
import Jogador from './gamecore/Jogador';
import Partida from './gamecore/Partida';

export default class Globals {

    static jogadorLogado;
    static jogadores;
    static partida;

    static setJogadorLogado(novoJogador) {
        if (novoJogador instanceof Jogador) {
            this.jogadorLogado = novoJogador;
        }
    }

    static getJogadorLogado() {
        return this.jogadorLogado;
    }

    static getNickJogadorLogado() {
        return this.jogadorLogado.getNick();
    }

    static lengthOfJogadores() {
        return this.jogadores.length;
    }

    static getJogador(indiceJogador) {
        if (!Validator.isUndefined(this.jogadores)
            && this.jogadores.length >= 1
            && indiceJogador >= 0
            && indiceJogador < this.jogadores.length) {

            return this.jogadores[indiceJogador];
        }

        return null;
    }

    static lengthOfJogadoresNaPartida() {
        return this.partida.getQtdAtualDeJogadores();
    }

    static getJogadorNaPartida(indiceJogador) {
        return this.partida.getJogador(indiceJogador);
    }

    static getNickJogadorNaPartida(indiceJogador) {
        return this.partida.getJogador(indiceJogador).getNick();
    }

    static addJogadorInimigo(novoJogadorInimigo) {
        if (novoJogadorInimigo instanceof Jogador) {

            if (Validator.isUndefined(this.jogadores)) {
                this.jogadores = [];
            }

            this.jogadores.push(novoJogadorInimigo);
        }
    }

    static criarPartida() {
        if (!Validator.isUndefined(this.jogadores)
            && this.jogadorLogado instanceof Jogador
            && this.jogadores.length >= 1) {

            this.partida = new Partida(this.jogadores.length);

            this.partida.addJogador(this.jogadorLogado);

            for (let contJogador = 0; contJogador < this.jogadores.length; contJogador++) {
                // this.getJogador(contJogador).setId(contJogador + 1);
                this.partida.addJogador(this.getJogador(contJogador));
            }

            this.partida.iniciar();

            return true;
        }

        return false;
    }

    static getPartida() {
        if (!Validator.isUndefined(this.partida)) {
            return this.partida;
        }

        return null;
    }

    static getCanoaJogadorLogado() {

    }

    static moverCanoaDoJogadorAtual(posicaoNoRio) {
        if (this.partida instanceof Partida) {
            this.partida.moverCanoaDoJogadorAtual(posicaoNoRio);
        }
    }

    static gerarIndiceJogadorInimigo() {
        let indiceJogadorInimigoSorteado = 0;

        do {
            indiceJogadorInimigoSorteado = parseInt(
                Math.random() * this.partida.getQtdAtualDeJogadores()
            );
        } while (indiceJogadorInimigoSorteado === this.partida.getIndiceJogadorAtual());

        return indiceJogadorInimigoSorteado;
    }

    static atirarNoInimigoDoJogadorAtual(posicaoDoTiro, indiceJogadorInimigo = 0) {
        if (Validator.isInteger(posicaoDoTiro) && this.partida instanceof Partida) {

            //Jogador atual é o Logado?
            if (this.partida.getIndiceJogadorAtual() === 0) {

                //Não foi passado indiceJogadorInimigo?
                if (indiceJogadorInimigo === 0) {

                    //A quantidade atual de jogadores é >= 3?
                    if (this.partida.getQtdAtualDeJogadores() >= 3) {
                        return this.partida.atirarNoInimigoDoJogadorAtual(
                            posicaoDoTiro,
                            this.partida.getJogador(this.gerarIndiceJogadorInimigo())
                        );
                    }

                    return this.partida.atirarNoInimigoDoJogadorAtual(
                        posicaoDoTiro,
                        this.partida.getJogador(1)
                    );
                }

                return this.partida.atirarNoInimigoDoJogadorAtual(
                    posicaoDoTiro,
                    this.partida.getJogador(indiceJogadorInimigo)
                );
            }

            //Não foi passado indiceJogadorInimigo?
            if (indiceJogadorInimigo === 0) {
                return this.partida.atirarNoInimigoDoJogadorAtual(
                    posicaoDoTiro,
                    this.partida.getJogador(this.gerarIndiceJogadorInimigo())
                );
            }

            return this.partida.atirarNoInimigoDoJogadorAtual(
                posicaoDoTiro,
                this.partida.getJogador(indiceJogadorInimigo)
            );
        }

        return false;
    }

    static isTerminouPartida() {
        if (!Validator.isUndefined(this.partida)) {
            return this.partida.isTerminou();
        }

        return false;
    }

    static isEmpatouPartida() {
        if (!Validator.isUndefined(this.partida)) {
            return this.partida.isEmpatou();
        }

        return false;
    }

    static getEmpatantesDaPartida() {
        if (!Validator.isUndefined(this.partida)) {
            return this.partida.getEmpatantes();
        }

        return null;
    }

    static getJogadorVencedorDaPartida() {
        if (!Validator.isUndefined(this.partida)) {
            return this.partida.getVencedor();
        }

        return null;
    }

}//class


/**
 * REACT DICAS
 *
 * ERROR: "defaultValue"
 *      https://reactjs.org/docs/uncontrolled-components.html#default-values
 *
 * USANDO CONTEXTO PARA PASSAR VARS
 *      https://pt-br.reactjs.org/docs/context.html
 *
 * COMPONENTES PAIS E FILHOS: PASSANDO DADOS DE FORMA BI-DERECIONAL
 *      https://blog.bitsrc.io/react-communication-between-components-c0cfccfa996a
 *
 */