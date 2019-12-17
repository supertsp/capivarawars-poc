import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globlas & Tools
import Globals from "../../Globals";
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';
import PushNotification from "../../tool/PushNotification";

//Import GameCore
import Player from '../../gamecore/Player';

//Import Pages
import Header from '../components/Header';
import IconCapybara from '../components/IconCapybara';

class MatchResult extends Component {

    state = {
        xxxx: false
    }

    constructor(props) {
        super(props);

        this.persistirLogin();

        if (Globals.hasJogadorLogado() && Globals.isIniciouPartida()) {
            // this.props.history.push('/');

        }
        else {
            this.state.jogadorLogado = Globals.getJogadorLogado();
        }

        if (Globals.isTerminouPartida()) {
            this.updatePlayerStatusOnApi();
        }
    }

    persistirLogin = () => {
        if (!Globals.hasJogadorLogado()
            && !Validator.isUndefined(sessionStorage.getItem(Globals.getSessionKeyJogador()))) {

            Globals.setJogadorLogadoFromSession();
        }

        if (!Globals.hasPartidaAtiva()) {
            Globals.setPartidaFromSession();
        }

        // this.debugPartida();
    }

    onSubmitHandler = async (event) => {
        event.preventDefault();

        // this.createPlayerOnApi(event);
    }

    onClickNext = () => {
        this.setState({ contPedacoCanoa: 0 });

        // console.log(`STATUS PARTIDA: ${Globals.getPartida()}\nTerminou? ${Globals.isTerminouPartida()}`);


    }

    updatePlayerStatusOnApi = async (event) => {
        const response = await AxiosRest.executePATCH('playerService',
            `/player/${Globals.getJogadorLogado().getIdPlayer()}`, {
            score: Globals.getJogadorLogado().getScore(),
            wins: Globals.getJogadorLogado().getWins(),
            losses: Globals.getJogadorLogado().getLosses(),
            draws: Globals.getJogadorLogado().getDraws(),
            capybaraLife: Globals.getJogadorLogado().getCapybaraLife()
        });

        if (Validator.isAxiosResponseOkAndHasData(response)) {
            console.log(response);
        }
        else {
            console.log("ERROR!!!\n" + response);
        }
    }


    render() {
        return (
            <div>

                <Header isLoginOk="true" userNick={Globals.getJogadorLogado().getNick()} userType={Globals.getJogadorLogado().getGender()} />

                <div className="container-area-matchresult">

                    <div className="capii-sweating"></div>

                    <div className="container-bamboo-matchresult">

                        <div className="container-bamboo-title">
                            <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                            <span>Match Result</span>
                        </div>

                        <div className="container-bamboo-border">
                            <form onSubmit={this.onSubmitHandler} className="container-bamboo-bg-color">
                                {
                                    Globals.isEmpatouPartida() &&
                                    <p>Oh no!!! Unfortunately we had a draw this time :0</p>
                                    ||
                                    <p>And the Winner of this match was ...</p>
                                }


                                <div className="match-result-winner-name">
                                    {
                                        Globals.isTerminouPartida() && Globals.isEmpatouPartida() ?
                                            Globals.getEmpatantesDaPartida().map(
                                                (jogador) =>
                                                    <p>{jogador.getNick()}</p>
                                            )
                                            :
                                            <p>{Globals.getJogadorVencedorDaPartida().getNick()}</p>
                                    }
                                </div>

                                <div>

                                    <Link to="/home">
                                        <button className="form-button">Finish</button>
                                    </Link>

                                </div>

                            </form>
                        </div>
                    </div>

                </div>

            </div>
        );
    }
}

//export and allow redirect by "this.props.history"
export default withRouter(MatchResult);