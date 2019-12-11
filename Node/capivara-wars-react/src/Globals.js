import Validator from './tool/Validator';
import AxiosRest from './tool/AxiosRest';
// import Canoa from './gamecore/Canoa';
// import Rio from './gamecore/Rio';
// import Capivara from './gamecore/Capivara';
// import BarraDeVida from './gamecore/BarraDeVida';
import Jogador from './gamecore/Jogador';
import Partida from './gamecore/Partida';

export default class Globals {

    static sessionKeyNick;
    static sessionKeyJogador;
    static jogadorLogado;
    static jogadores;
    static partida;

    static getSessionKeyNick() {
        if (Validator.isStringEmpty(this.sessionKeyNick) || Validator.isUndefined(this.sessionKeyNick)) {
            this.sessionKeyNick = 'capi-nick';
        }

        return this.sessionKeyNick;
    }

    static getSessionKeyJogador() {
        if (Validator.isStringEmpty(this.sessionKeyJogador) || Validator.isUndefined(this.sessionKeyJogador)) {
            this.sessionKeyJogador = 'capi-jogador';
        }

        return this.sessionKeyJogador;
    }


    //JOGADOR LOGADO
    static setJogadorLogado(novoJogador) {
        if (novoJogador instanceof Jogador) {
            this.jogadorLogado = novoJogador;
        }
        else if (novoJogador instanceof Object) {
            this.jogadorLogado = new Jogador(novoJogador.nick, novoJogador.capybaraName, 10, 4);
            this.jogadorLogado.setId(novoJogador.idPlayer);
            this.jogadorLogado.setPontos(novoJogador.score);
            this.jogadorLogado.setCorCapivara(novoJogador.capybaraColor);
        }
    }

    static setJogadorLogadoFromSession() {
        if (!this.hasJogadorLogado()
            && !Validator.isUndefined(sessionStorage.getItem(this.getSessionKeyJogador()))) {

            const jogadorTemp = JSON.parse(sessionStorage.getItem(this.getSessionKeyJogador()));
            this.setJogadorLogado(jogadorTemp);
        }
    }


    static async setJogadorLogadoFromSessionAndApi() {
        const nickAtual = sessionStorage.getItem(this.getSessionKeyNick());

        if (!Validator.isStringEmpty(nickAtual)) {
            const response = await AxiosRest.executeGET('playerService', `player/nick/${nickAtual}`);

            if (Validator.isAxiosResponseOkAndHasData(response)) {
                let jogador = new Jogador(response.data.nick, response.data.capybaraName, 10, 4);
                jogador.setId(response.data.idPlayer);
                jogador.setPontos(response.data.score);
                jogador.setCorCapivara(response.data.capybaraColor);
                this.setJogadorLogado(jogador);
            }
        }
    }

    static getJogadorLogado() {
        if (!Validator.isUndefined(this.jogadorLogado)) {
            return this.jogadorLogado;
        }

        return null;
    }

    static hasJogadorLogado() {
        return !Validator.isUndefined(this.jogadorLogado);
    }

    static getNickJogadorLogado() {
        if (!Validator.isUndefined(this.jogadorLogado)) {
            return this.jogadorLogado.getNick();
        }

        return null;
    }

    static getCapivaraJogadorLogado() {
        if (!Validator.isUndefined(this.jogadorLogado)) {
            return this.jogadorLogado.getCapivara();
        }

        return null;
    }

    static getCorCapivaraJogadorLogado() {
        if (!Validator.isUndefined(this.jogadorLogado)) {
            return this.jogadorLogado.getCorCapivara();
        }

        return null;
    }

    static getNomeCapivaraJogadorLogado() {
        if (!Validator.isUndefined(this.jogadorLogado)) {
            return this.jogadorLogado.getNomeCapivara();
        }

        return null;
    }

    static getVidaCapivaraJogadorLogado() {
        if (!Validator.isUndefined(this.jogadorLogado)) {
            return this.jogadorLogado.getVidaCapivara();
        }

        return null;
    }

    static getCanoaJogadorLogado() {
        if (!Validator.isUndefined(this.jogadorLogado)) {
            return this.jogadorLogado.getCanoa();
        }

        return null;
    }

    static getPontosJogadorLogado() {
        if (!Validator.isUndefined(this.jogadorLogado)) {
            return this.jogadorLogado.getPontos();
        }

        return null;
    }

    static getVitoriasJogadorLogado() {
        if (!Validator.isUndefined(this.jogadorLogado)) {
            return this.jogadorLogado.getVitorias();
        }

        return null;
    }

    static getDerrotasJogadorLogado() {
        if (!Validator.isUndefined(this.jogadorLogado)) {
            return this.jogadorLogado.getDerrotas();
        }

        return null;
    }

    static getEmpatesJogadorLogado() {
        if (!Validator.isUndefined(this.jogadorLogado)) {
            return this.jogadorLogado.getEmpates();
        }

        return null;
    }


    //ARRAY JOGADORES
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


    //JOGADOR NA PARTIDA
    static lengthOfJogadoresNaPartida() {
        return this.partida.getQtdAtualDeJogadores();
    }

    static getJogadorNaPartida(indiceJogador) {
        if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
            return this.partida.getJogador(indiceJogador);
        }

        return null;
    }

    static getNickJogadorNaPartida(indiceJogador) {
        if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
            return this.partida.getJogador(indiceJogador).getNick();
        }

        return null;
    }

    static getCapivaraJogadorNaPartida(indiceJogador) {
        if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
            return this.partida.getJogador(indiceJogador).getCapivara();
        }

        return null;
    }

    static getCorCapivaraJogadorNaPartida(indiceJogador) {
        if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
            return this.partida.getJogador(indiceJogador).getCorCapivara();
        }

        return null;
    }

    static getNomeCapivaraJogadorNaPartida(indiceJogador) {
        if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
            return this.partida.getJogador(indiceJogador).getNomeCapivara();
        }

        return null;
    }

    static getVidaCapivaraJogadorNaPartida(indiceJogador) {
        if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
            return this.partida.getJogador(indiceJogador).getVidaCapivara();
        }

        return null;
    }

    static getCanoaJogadorNaPartida(indiceJogador) {
        if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
            return this.partida.getJogador(indiceJogador).getCanoa();
        }

        return null;
    }

    static getPontosJogadorNaPartida(indiceJogador) {
        if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
            return this.partida.getJogador(indiceJogador).getPontos();
        }

        return null;
    }

    static getVitoriasJogadorNaPartida(indiceJogador) {
        if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
            return this.partida.getJogador(indiceJogador).getVitorias();
        }

        return null;
    }

    static getDerrotasJogadorNaPartida(indiceJogador) {
        if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
            return this.partida.getJogador(indiceJogador).getDerrotas();
        }

        return null;
    }

    static getEmpatesJogadorNaPartida(indiceJogador) {
        if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
            return this.partida.getJogador(indiceJogador).getEmpates();
        }

        return null;
    }


    //JOGADOR ATUAL NA PARTIDA
    static getJogadorAtualNaPartida() {
        if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
            return this.partida.getJogadorAtual();
        }

        return null;
    }

    static getNickJogadorAtualNaPartida() {
        if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
            return this.partida.getJogadorAtual().getNick();
        }

        return null;
    }

    static getCapivaraJogadorAtualNaPartida() {
        if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
            return this.partida.getJogadorAtual().getCapivara();
        }

        return null;
    }

    static getCorCapivaraJogadorAtualNaPartida() {
        if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
            return this.partida.getJogadorAtual().getCorCapivara();
        }

        return null;
    }

    static getNomeCapivaraJogadorAtualNaPartida() {
        if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
            return this.partida.getJogadorAtual().getNomeCapivara();
        }

        return null;
    }

    static getVidaCapivaraJogadorAtualNaPartida() {
        if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
            return this.partida.getJogadorAtual().getVidaCapivara();
        }

        return null;
    }

    static getCanoaJogadorAtualNaPartida() {
        if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
            return this.partida.getJogadorAtual().getCanoa();
        }

        return null;
    }

    static getPontosJogadorAtualNaPartida() {
        if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
            return this.partida.getJogadorAtual().getPontos();
        }

        return null;
    }

    static getVitoriasJogadorAtualNaPartida() {
        if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
            return this.partida.getJogadorAtual().getVitorias();
        }

        return null;
    }

    static getDerrotasJogadorAtualNaPartida() {
        if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
            return this.partida.getJogadorAtual().getDerrotas();
        }

        return null;
    }

    static getEmpatesJogadorAtualNaPartida() {
        if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
            return this.partida.getJogadorAtual().getEmpates();
        }

        return null;
    }



    //ADD JOGADOR INIMIGO
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
 * SESSION STORAGE
 *      //https://developer.mozilla.org/pt-BR/docs/Web/API/Window/sessionStorage
 *
 */