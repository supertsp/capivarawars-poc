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


class TurnStatus extends Component {

    state = {
        contPedacoCanoa: 0
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
            this.props.history.push('/matchresult');
        }
    }

    componentDidMount() {
        if (Globals.isTerminouPartida()) {
            this.props.history.push('/matchresult');
        }

        console.log(`${Globals.getPartida()}\n`);
    }

    // componentDidUpdate(prevProps) {
    //     if (Globals.isTerminouPartida()) {
    //         this.props.history.push('/matchresult');
    //     }
    // }

    persistirLogin = () => {
        if (!Globals.hasJogadorLogado()
            && !Validator.isUndefined(sessionStorage.getItem(Globals.getSessionKeyJogador()))) {

            Globals.setJogadorLogadoFromSession();
            this.state.jogadorLogado = Globals.getJogadorLogado();
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
        Globals.isTerminouPartida();

        if (Globals.isTerminouPartida()) {
            this.props.history.push('/matchresult');
        }
        else {
            this.props.history.push('/moveboat');
        }
    }

    onChangeRadio = (event) => {
        this.setState({ posicaoEscolhida: event.target.value });
    }

    render() {
        return (
            <div>

                <Header isLoginOk="true" userNick={Globals.getJogadorLogado().getNick()} userType={Globals.getJogadorLogado().getGender()} />

                <div className="container-area-turnstatus">

                    <div className="container-bamboo-title">
                        <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                        <span>Turn Status</span>
                    </div>

                    <div className="container-bamboo-border">
                        <form onSubmit={this.onSubmitHandler} className="container-bamboo-bg-color text-center padding-bottom-1">

                            <p>How is the game going?</p>

                            <table className="turn-status-table">
                                <tbody>
                                    <tr>
                                        <td colSpan="2" className="turn-status-table-title">
                                            {
                                                Globals.getJogadorLogado().getGender() === 'M' ?
                                                    <img src={require('../assets/images/user-male-icon.svg')} alt="user foto" /> :
                                                    Globals.getJogadorLogado().getGender() === 'F' ?
                                                        <img src={require('../assets/images/user-female-icon.svg')} alt="user foto" /> :
                                                        <img src={require('../assets/images/user-enemy-icon.svg')} alt="user foto" />
                                            }
                                            &nbsp;
                                            <span className="turn-status-table-title-nick">
                                                {Globals.getJogadorLogado().getNick()}
                                            </span>
                                            ' Status
                                        </td>
                                        <td className="turn-status-table-white-space">
                                            &nbsp;
                                        </td>
                                        <td colSpan="2" className="turn-status-table-title">
                                            {
                                                Globals.getJogadorInimigo(0).getGender() === 'M' ?
                                                    <img src={require('../assets/images/user-male-icon.svg')} alt="user foto" /> :
                                                    Globals.getJogadorInimigo(0).getGender() === 'F' ?
                                                        <img src={require('../assets/images/user-female-icon.svg')} alt="user foto" /> :
                                                        <img src={require('../assets/images/user-enemy-icon.svg')} alt="user foto" />
                                            }
                                            &nbsp;
                                            <span className="turn-status-table-title-nick">
                                                {Globals.getJogadorInimigo(0).getNick()}
                                            </span>
                                            ' Status
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <IconCapybara color={Globals.getJogadorLogado().getCapybaraColor()} specialClass="user-capii-icon" />
                                        </td>
                                        <td className="turn-status-table-capivara-nane">
                                            {Globals.getJogadorLogado().getCapybaraName()}
                                        </td>

                                        <td className="turn-status-table-white-space">
                                            &nbsp;
                                        </td>

                                        <td>
                                            <IconCapybara color={Globals.getJogadorInimigo(0).getCapybaraColor()} specialClass="user-capii-icon" />
                                        </td>
                                        <td className="turn-status-table-capivara-nane">
                                            {Globals.getJogadorInimigo(0).getCapybaraName()}
                                        </td>
                                    </tr>

                                    <tr>
                                        <td colSpan="2">
                                            <span className="current-boat-size">
                                                {
                                                    Globals.getJogadorLogado().getBoatPieces().map(
                                                        (pedaco) =>
                                                            <span key={this.getKeyPedacoAtual()} className="current-boat-size-piece"></span>
                                                    )
                                                }
                                            </span>
                                        </td>

                                        <td className="turn-status-table-white-space">
                                            &nbsp;
                                        </td>

                                        <td colSpan="2">
                                            <span className="current-boat-size">
                                                {
                                                    Globals.getJogadorInimigo(0).getBoatPieces().map(
                                                        (pedaco) =>
                                                            <span key={this.getKeyPedacoAtual()} className="current-boat-size-piece"></span>
                                                    )
                                                }
                                            </span>
                                        </td>
                                    </tr>
                                </tbody>

                            </table>

                            <div>

                                <button onClick={this.onClickNext} className="form-button" type="submit">Next</button>

                            </div>

                        </form>
                    </div>

                </div>

            </div>
        );
    }

    debugPartida = () => {
        // console.log(`[MoveBoat] JogadorLogado\n>>${Globals.getJogadorLogado().getNick()}<<`);
        console.log(`[MoveBoat] JogadorLogado\n>>${Globals.getJogadorLogado()}<<`);
        // console.log(`[MoveBoat] JogadorLogado (json)\n>>${JSON.stringify(Globals.getJogadorLogado())}<<`);
        console.log(`[MoveBoat] Partida\n>>${Globals.getPartida()}<<`);

        // if (!Validator.isUndefined(Globals.getJogadorAtualNaPartida())) {
        console.log(`[MoveBoat] JogadorAtual\n>>${Globals.getJogadorAtualNaPartida()}<<`);
        // }
        // if (!Validator.isUndefined(Globals.getJogadorAtualNaPartida(Globals.getJogadorInimigo(0)))) {
        console.log(`[MoveBoat] JogadorInimigo\n>>${Globals.getJogadorInimigo(0)}<<`);
        // }
    }

    getKeyPedacoAtual = () => {
        let num = this.state.contPedacoCanoa;
        num++;
        this.state.contPedacoCanoa = num;
        return num;
    }

}

//export and allow redirect by "this.props.history"
export default withRouter(TurnStatus);