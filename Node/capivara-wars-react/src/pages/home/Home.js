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

class Home extends Component {

    state = {
        jogadorLogado: '',
        partidaIniciou: false
    }

    constructor(props) {
        super(props);

        this.persistirLogin();

        if (Globals.hasJogadorLogado()) {
            // this.props.history.push('/');
        }
        else {
            this.state.jogadorLogado = Globals.getJogadorLogado();
        }
    }

    componentDidUpdate(prevProps) {
        if (this.state.partidaIniciou) {
            Globals.limparArrayDeInimigos();

            Globals.addJogadorInimigo(
                new Player()
                    .setIdPlayer(777)
                    .setNick('RobotDog')
                    .setGender('R')
                    .setCapybaraName('HotDog')
                    .setCapybaraLife(3)
                    .setCapybaraColor('hotdog')
                    .setScore(21)
                    .setWins(10)
                    .setLosses(0)
                    .setDraws(1)
            );

            if (Globals.criarPartida()) {
                Globals.getPartida().reiniciarCampos();
                Globals.getPartida().iniciar();
                sessionStorage.setItem(Globals.getSessionKeyPartida(), JSON.stringify(Globals.getJogadorInimigo(0)));
                this.props.history.push('/moveboat');
            }
        }

    }

    persistirLogin = () => {
        Globals.setJogadorLogadoFromSession();
        this.state.jogadorLogado = Globals.getJogadorLogado();
        // this.debugPartida();
    }

    onSubmitHandler = (event) => {
        event.preventDefault();
    }

    onClickPlay = (event) => {
        this.setState({ partidaIniciou: true });
    }


    render() {
        return (
            <div>

                <Header isLoginOk="true" userNick={Globals.getJogadorLogado().getNick()} userType={Globals.getJogadorLogado().getGender()} />

                <div className="container-area-home">

                    <div className="container-bamboo-home-item-game">

                        <div className="container-bamboo-title">
                            <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                            <span>Game</span>
                        </div>

                        <div className="container-bamboo-border">
                            <form onSubmit={this.onSubmitHandler} className="container-bamboo-bg-color text-center padding-bottom-1">

                                <p>Let the games begin!!</p>


                                <button onClick={this.onClickPlay} className="form-button-play">
                                    <img src={require('../assets/images/buttonplay.svg')} alt="button play image" />
                                </button>

                            </form>
                        </div>
                    </div>

                    <div className="container-bamboo-home-item-status">

                        <div className="container-bamboo-title">
                            <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                            <span>Status</span>
                        </div>

                        <div className="container-bamboo-border">
                            <form onSubmit={this.onSubmitHandler} className="container-bamboo-bg-color padding-bottom-1">

                                <table>
                                    <tbody>
                                        <tr className="tr-no-hover">
                                            <td className="table-first-col">
                                                <IconCapybara color={Globals.getJogadorLogado().getCapybaraColor()} specialClass="user-capii-icon" />
                                            </td>
                                            <td>
                                                {Globals.getJogadorLogado().getCapybaraName()}
                                            </td>
                                        </tr>

                                        <tr>
                                            <td className="table-first-col">
                                                Life
                                        </td>
                                            <td>
                                                {Globals.getJogadorLogado().getCapybaraLife()}
                                            </td>
                                        </tr>

                                        <tr>
                                            <td className="table-first-col">
                                                Score
                                        </td>
                                            <td>
                                                {Globals.getJogadorLogado().getScore()}
                                            </td>
                                        </tr>
                                        <tr className="table-empty-row">
                                            <td></td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td className="table-first-col">
                                                Wins
                                        </td>
                                            <td>
                                                {Globals.getJogadorLogado().getWins()}
                                            </td>
                                        </tr>

                                        <tr>
                                            <td className="table-first-col">
                                                Losses
                                        </td>
                                            <td>
                                                {Globals.getJogadorLogado().getLosses()}
                                            </td>
                                        </tr>

                                        <tr>
                                            <td className="table-first-col">
                                                Draws
                                        </td>
                                            <td>
                                                {Globals.getJogadorLogado().getDraws()}
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>

                            </form>
                        </div>
                    </div>

                </div>

            </div>
        );
    }

    debugPartida = () => {
        console.log(`[Home] JogadorLogado\n>>${this.state.jogadorLogado.getNick()}<<`);
        console.log(`[Home] JogadorLogado\n>>${this.state.jogadorLogado}<<`);
        console.log(`[Home] JogadorLogado (json)\n>>${JSON.stringify(this.state.jogadorLogado)}<<`);

        if (!Validator.isUndefined(Globals.getJogadorAtualNaPartida())) {
            console.log(`[Home] JogadorAtual\n>>${Globals.getJogadorAtualNaPartida().getNick()}<<`);
        }
        if (!Validator.isUndefined(Globals.getJogadorAtualNaPartida(Globals.getJogadorInimigo(0)))) {
            console.log(`[Home] JogadorInimigo\n>>${Globals.getJogadorInimigo(0).getNick()}<<`);
        }
    }

}

//export and allow redirect by "this.props.history"
export default withRouter(Home);