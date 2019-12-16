import Validator from './tool/Validator';
import AxiosRest from './tool/AxiosRest';
// import Canoa from './gamecore/Canoa';
// import Rio from './gamecore/Rio';
// import Capivara from './gamecore/Capivara';
// import BarraDeVida from './gamecore/BarraDeVida';
import Player from './gamecore/Player';
import Partida from './gamecore/Partida';

export default class Globals {

    static sessionKeyNick;
    static sessionKeyJogador;
    static jogadorLogado;
    static jogadoresInimigos;
    static partida;
    static sessionKeyPartida;

    static getSessionKeyNick() {
        if (Validator.isUndefined(this.sessionKeyNick)) {
            this.sessionKeyNick = 'capi-nick';
        }

        return this.sessionKeyNick;
    }

    static getSessionKeyJogador() {
        if (Validator.isUndefined(this.sessionKeyJogador)) {
            this.sessionKeyJogador = 'capi-jogador';
        }

        return this.sessionKeyJogador;
    }

    static getSessionKeyPartida() {
        if (Validator.isUndefined(this.sessionKeyPartida)) {
            this.sessionKeyPartida = 'capi-partida';
        }

        return this.sessionKeyPartida;
    }

    //JOGADOR LOGADO
    static setJogadorLogado(novoJogador) {
        if (novoJogador instanceof Player) {
            this.jogadorLogado = novoJogador;
        }
        else if (novoJogador instanceof Object) {
            this.jogadorLogado = new Player();
            this.jogadorLogado.setJsonFields(novoJogador);
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
                // const jsonPlayer = { ...response.data };
                // this.setJogadorLogado(jsonPlayer);
                this.setJogadorLogado(response.data);
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

    // static getNickJogadorLogado() {
    //     if (!Validator.isUndefined(this.jogadorLogado)) {
    //         return this.jogadorLogado.getNick();
    //     }

    //     return null;
    // }

    // static getCapivaraJogadorLogado() {
    //     if (!Validator.isUndefined(this.jogadorLogado)) {
    //         return this.jogadorLogado.getCapivara();
    //     }

    //     return null;
    // }

    // static getCorCapivaraJogadorLogado() {
    //     if (!Validator.isUndefined(this.jogadorLogado)) {
    //         return this.jogadorLogado.getCorCapivara();
    //     }

    //     return null;
    // }

    // static getNomeCapivaraJogadorLogado() {
    //     if (!Validator.isUndefined(this.jogadorLogado)) {
    //         return this.jogadorLogado.getNomeCapivara();
    //     }

    //     return null;
    // }

    // static getVidaCapivaraJogadorLogado() {
    //     if (!Validator.isUndefined(this.jogadorLogado)) {
    //         return this.jogadorLogado.getVidaCapivara();
    //     }

    //     return null;
    // }

    // static getCanoaJogadorLogado() {
    //     if (!Validator.isUndefined(this.jogadorLogado)) {
    //         return this.jogadorLogado.getCanoa();
    //     }

    //     return null;
    // }

    // static getPontosJogadorLogado() {
    //     if (!Validator.isUndefined(this.jogadorLogado)) {
    //         return this.jogadorLogado.getPontos();
    //     }

    //     return null;
    // }

    // static getVitoriasJogadorLogado() {
    //     if (!Validator.isUndefined(this.jogadorLogado)) {
    //         return this.jogadorLogado.getVitorias();
    //     }

    //     return null;
    // }

    // static getDerrotasJogadorLogado() {
    //     if (!Validator.isUndefined(this.jogadorLogado)) {
    //         return this.jogadorLogado.getDerrotas();
    //     }

    //     return null;
    // }

    // static getEmpatesJogadorLogado() {
    //     if (!Validator.isUndefined(this.jogadorLogado)) {
    //         return this.jogadorLogado.getEmpates();
    //     }

    //     return null;
    // }


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

    // static getNickJogadorNaPartida(indiceJogador) {
    //     if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
    //         return this.partida.getJogador(indiceJogador).getNick();
    //     }

    //     return null;
    // }

    // static getCapivaraJogadorNaPartida(indiceJogador) {
    //     if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
    //         return this.partida.getJogador(indiceJogador).getCapivara();
    //     }

    //     return null;
    // }

    // static getCorCapivaraJogadorNaPartida(indiceJogador) {
    //     if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
    //         return this.partida.getJogador(indiceJogador).getCorCapivara();
    //     }

    //     return null;
    // }

    // static getNomeCapivaraJogadorNaPartida(indiceJogador) {
    //     if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
    //         return this.partida.getJogador(indiceJogador).getNomeCapivara();
    //     }

    //     return null;
    // }

    // static getVidaCapivaraJogadorNaPartida(indiceJogador) {
    //     if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
    //         return this.partida.getJogador(indiceJogador).getVidaCapivara();
    //     }

    //     return null;
    // }

    // static getCanoaJogadorNaPartida(indiceJogador) {
    //     if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
    //         return this.partida.getJogador(indiceJogador).getCanoa();
    //     }

    //     return null;
    // }

    // static getPontosJogadorNaPartida(indiceJogador) {
    //     if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
    //         return this.partida.getJogador(indiceJogador).getPontos();
    //     }

    //     return null;
    // }

    // static getVitoriasJogadorNaPartida(indiceJogador) {
    //     if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
    //         return this.partida.getJogador(indiceJogador).getVitorias();
    //     }

    //     return null;
    // }

    // static getDerrotasJogadorNaPartida(indiceJogador) {
    //     if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
    //         return this.partida.getJogador(indiceJogador).getDerrotas();
    //     }

    //     return null;
    // }

    // static getEmpatesJogadorNaPartida(indiceJogador) {
    //     if (!Validator.isUndefined(this.partida.getJogador(indiceJogador))) {
    //         return this.partida.getJogador(indiceJogador).getEmpates();
    //     }

    //     return null;
    // }


    //JOGADOR ATUAL NA PARTIDA
    static getJogadorAtualNaPartida() {
        if (!Validator.isUndefined(this.partida) && !Validator.isUndefined(this.partida.getJogadorAtual())) {
            return this.partida.getJogadorAtual();
        }

        return null;
    }

    // static getNickJogadorAtualNaPartida() {
    //     if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
    //         return this.partida.getJogadorAtual().getNick();
    //     }

    //     return null;
    // }

    // static getCapivaraJogadorAtualNaPartida() {
    //     if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
    //         return this.partida.getJogadorAtual().getCapivara();
    //     }

    //     return null;
    // }

    // static getCorCapivaraJogadorAtualNaPartida() {
    //     if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
    //         return this.partida.getJogadorAtual().getCorCapivara();
    //     }

    //     return null;
    // }

    // static getNomeCapivaraJogadorAtualNaPartida() {
    //     if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
    //         return this.partida.getJogadorAtual().getNomeCapivara();
    //     }

    //     return null;
    // }

    // static getVidaCapivaraJogadorAtualNaPartida() {
    //     if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
    //         return this.partida.getJogadorAtual().getVidaCapivara();
    //     }

    //     return null;
    // }

    // static getCanoaJogadorAtualNaPartida() {
    //     if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
    //         return this.partida.getJogadorAtual().getCanoa();
    //     }

    //     return null;
    // }

    // static getPontosJogadorAtualNaPartida() {
    //     if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
    //         return this.partida.getJogadorAtual().getPontos();
    //     }

    //     return null;
    // }

    // static getVitoriasJogadorAtualNaPartida() {
    //     if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
    //         return this.partida.getJogadorAtual().getVitorias();
    //     }

    //     return null;
    // }

    // static getDerrotasJogadorAtualNaPartida() {
    //     if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
    //         return this.partida.getJogadorAtual().getDerrotas();
    //     }

    //     return null;
    // }

    // static getEmpatesJogadorAtualNaPartida() {
    //     if (!Validator.isUndefined(this.partida.getJogadorAtual())) {
    //         return this.partida.getJogadorAtual().getEmpates();
    //     }

    //     return null;
    // }


    //JOGADORES INIMIGOS
    static lengthOfJogadoresInimigos() {
        return this.jogadoresInimigos.length;
    }

    static getJogadorInimigo(indiceJogadorInimigo) {
        if (!Validator.isUndefined(this.jogadoresInimigos)
            && this.jogadoresInimigos.length >= 1
            && indiceJogadorInimigo >= 0
            && indiceJogadorInimigo < this.jogadoresInimigos.length) {

            return this.jogadoresInimigos[indiceJogadorInimigo];
        }

        return null;
    }

    static addJogadorInimigo(novoJogadorInimigo) {
        if (Validator.isUndefined(this.jogadoresInimigos)) {
            this.jogadoresInimigos = [];
        }

        if (novoJogadorInimigo instanceof Player) {
            this.jogadoresInimigos.push(novoJogadorInimigo);
        }
        else if (novoJogadorInimigo instanceof Object) {
            const inimigoTemp = new Player();
            inimigoTemp.setJsonFields(novoJogadorInimigo);
            this.jogadoresInimigos.push(inimigoTemp);
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


    //PARTIDA
    static limparArrayDeInimigos() {
        this.jogadoresInimigos = [];
    }

    static criarPartida() {
        if (!Validator.isUndefined(this.jogadoresInimigos)
            && this.jogadorLogado instanceof Player
            && this.jogadoresInimigos.length >= 1) {

            this.partida = new Partida(this.jogadoresInimigos.length);

            this.partida.addJogador(this.jogadorLogado);

            for (let contJogador = 0; contJogador < this.jogadoresInimigos.length; contJogador++) {
                this.partida.addJogador(this.getJogadorInimigo(contJogador));
            }

            this.partida.iniciar();

            return true;
        }

        return false;
    }

    static hasPartidaAtiva() {
        return !Validator.isUndefined(this.partida);
    }

    static setPartidaFromSession() {
        if (!this.hasPartidaAtiva()
            && !Validator.isUndefined(sessionStorage.getItem(this.getSessionKeyPartida()))) {

            const inimigoPartida = JSON.parse(sessionStorage.getItem(this.getSessionKeyPartida()));
            this.addJogadorInimigo(inimigoPartida);
            this.criarPartida();
        }
    }

    static getPartida() {
        if (!Validator.isUndefined(this.partida)) {
            return this.partida;
        }

        return null;
    }

    static isIniciouPartida() {
        if (!Validator.isUndefined(this.partida)) {
            return this.partida.isIniciou();
        }

        return false;
    }

    static isTerminouPartida() {
        if (!Validator.isUndefined(this.partida)) {
            return this.partida.isTerminou();
        }

        return false;
    }

    static moverCanoaDoJogadorAtual(posicaoNoRio) {
        try {
            posicaoNoRio = parseInt(posicaoNoRio);
        } catch (error) { }
        // console.log("    POSIÇÃO NO RIO: " + posicaoNoRio + " - TYPE: " + typeof (posicaoNoRio));
        if (this.partida instanceof Partida) {
            this.partida.moverCanoaDoJogadorAtual(posicaoNoRio);
        }
    }

    static atirarNoInimigoDoJogadorAtual(posicaoDoTiro, indiceJogadorInimigo = 0) {
        try {
            posicaoDoTiro = parseInt(posicaoDoTiro);
            indiceJogadorInimigo = parseInt(indiceJogadorInimigo);
        } catch (error) { }

        if (this.partida instanceof Partida) {
            this.partida.atirarNoInimigoDoJogadorAtual(
                posicaoDoTiro,
                this.getJogadorNaPartida(indiceJogadorInimigo)
            );
        }
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