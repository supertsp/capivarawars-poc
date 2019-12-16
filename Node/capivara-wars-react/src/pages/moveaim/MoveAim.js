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


class MoveAim extends Component {

    state = {
        contPedacoCanoa: 0,
        posicaoEscolhida: 0
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

    componentDidMount() {
        console.log(`${Globals.getPartida()}\n`);
    }

    // componentDidUpdate(prevProps) {
    //     console.log(`MATCH!!\n${Globals.getPartida()}[componentDidUpdate]`);
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
        // console.log(`PERSISTIR LOGIN >>> MATCH!!\n${Globals.getPartida()}\n[componentDidMount]`);
    }

    onSubmitHandler = async (event) => {
        event.preventDefault();
    }

    onClickFire = () => {
        const tiroInimigo = parseInt(Math.random() * 10);
        Globals.atirarNoInimigoDoJogadorAtual(this.state.posicaoEscolhida, 1);
        // Globals.atirarNoInimigoDoJogadorAtual(1, 0);
        Globals.atirarNoInimigoDoJogadorAtual(tiroInimigo, 0);
        this.props.history.push('/turnstatus');
    }

    onChangeRadio = (event) => {
        this.setState({ posicaoEscolhida: event.target.value });
    }

    render() {
        return (
            <div>

                <Header isLoginOk="true" userNick={Globals.getJogadorLogado().getNick()} userType={Globals.getJogadorLogado().getGender()} />

                <div className="container-area-moveaim">

                    <div className="container-bamboo-title">
                        <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                        <span>Aim</span>
                    </div>

                    <div className="container-bamboo-border">
                        <form onSubmit={this.onSubmitHandler} className="container-bamboo-bg-color text-center padding-bottom-1">

                            <p>Aim at a part of the Enemy River!</p>

                            <div className="aim-area">

                                <span className="aim-area-all-pieces">
                                    <label className="aim-area-piece">
                                        <input onChange={this.onChangeRadio} type="radio" name="chosenAim" value="0" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input onChange={this.onChangeRadio} type="radio" name="chosenAim" value="1" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input onChange={this.onChangeRadio} type="radio" name="chosenAim" value="2" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input onChange={this.onChangeRadio} type="radio" name="chosenAim" value="3" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input onChange={this.onChangeRadio} type="radio" name="chosenAim" value="4" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input onChange={this.onChangeRadio} type="radio" name="chosenAim" value="5" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input onChange={this.onChangeRadio} type="radio" name="chosenAim" value="6" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input onChange={this.onChangeRadio} type="radio" name="chosenAim" value="7" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input onChange={this.onChangeRadio} type="radio" name="chosenAim" value="8" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input onChange={this.onChangeRadio} type="radio" name="chosenAim" value="9" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                </span>

                            </div>

                            <div className="statistics-area">

                                <div className="current-player-icon">
                                    {
                                        Globals.getJogadorInimigo(0).getGender() === 'M' ?
                                            <img src={require('../assets/images/user-male-icon.svg')} alt="user foto" /> :
                                            Globals.getJogadorInimigo(0).getGender() === 'F' ?
                                                <img src={require('../assets/images/user-female-icon.svg')} alt="user foto" /> :
                                                <img src={require('../assets/images/user-enemy-icon.svg')} alt="user foto" />
                                    }
                                </div>

                                <div className="current-area-boat">
                                    <div className="statistics-area-title">{Globals.getJogadorInimigo(0).getNick()}'s Boat Status</div>
                                    <span className="current-boat-size">
                                        {
                                            Globals.getJogadorInimigo(0).getBoatPieces().map(
                                                (pedaco) =>
                                                    <span key={this.getKeyPedacoAtual()} className="current-boat-size-piece"></span>
                                            )
                                        }
                                    </span>
                                    <span className="current-boat-size-number">
                                        {Globals.getJogadorInimigo(0).getBoatLength()}
                                    </span>
                                </div>
                            </div>
                            <div className="confirmation-area">

                                <button onClick={this.onClickFire} className="form-button" type="submit">Fire!</button>

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
export default withRouter(MoveAim);