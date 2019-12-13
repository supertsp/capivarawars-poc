import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globlas & Tools
import Globals from "../../Globals";
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';

//Import GameCore
import Player from '../../gamecore/Player';

//Import Pages
import Header from '../components/Header';

class MoveBoat extends Component {

    state = {
        jogadorLogado: '',
        jogadorAtual: '',
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
    }

    persistirLogin = () => {
        if (!Globals.hasJogadorLogado()
            && !Validator.isUndefined(sessionStorage.getItem(Globals.getSessionKeyJogador()))) {

            Globals.setJogadorLogadoFromSession();
            this.state.jogadorLogado = Globals.getJogadorLogado();


        }
    }

    render() {



        return (
            <div>

                <Header isLoginOk="true" userType={Globals.getJogadorLogado().getGenero()} />

                <div className="container-area-moveboat">

                    <div className="container-bamboo-title">
                        <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                        <span>Move</span>
                    </div>

                    <div className="container-bamboo-border">
                        <form className="container-bamboo-bg-color text-center padding-bottom-1">

                            <p>Choose a new position for your boat! <br />
                                Come on! Move! Move! Move!!!</p>

                            <div className="boat-area">

                                <input type="button" className="form-button-back" value="-" />

                                <span className="boat-area-all-pieces">
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="0" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="1" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="2" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="3" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="4" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="5" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="6" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="7" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="8" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="9" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                </span>

                                <input type="button" className="form-button-back" value="+" />
                            </div>

                            <div className="statistics-area">

                                <span>My Foto</span>

                                <div className="statistics-area-title">Your Boat Status</div>
                                <span className="current-boat-size">
                                    <span className="current-boat-size-piece"></span>
                                    <span className="current-boat-size-piece"></span>
                                    <span className="current-boat-size-piece"></span>
                                    <span className="current-boat-size-piece"></span>
                                </span>
                                <span className="current-boat-size-number">
                                    4
                                </span>
                            </div>

                            <div className="confirmation-area">

                                <Link to="/moveaim">
                                    <button className="form-button">Move!</button>
                                </Link>

                            </div>


                        </form>
                    </div>

                </div>

            </div>
        );
    }

    debugPartida = () => {
        //Debug Partida
        console.log(`MoveBoat - Jogador Logado: >> ${this.state.jogadorLogado} <<`);

        if (!Validator.isUndefined(Globals.getJogadorAtualNaPartida())) {
            console.log(`MoveBoat - Jogador Atual: ${Globals.getJogadorAtualNaPartida().getNick()}`);
        }
        if (!Validator.isUndefined(Globals.getJogadorAtualNaPartida(Globals.getJogadorInimigo(0)))) {
            console.log(`MoveBoat - Jogador Inimigo: ${Globals.getJogadorInimigo(0).getNick()}`);
        }
    }

}

//export and allow redirect by "this.props.history"
export default withRouter(MoveBoat);