import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globlas & Tools
import Globals from "../../Globals";
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';

//Import GameCore
import Player from '../../gamecore/Jogador';

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

            Globals.addJogadorInimigo(new Player("Julia", "Feliceta", 10, 4).setId(777));

            if (Globals.criarPartida()) {
                this.props.history.push('/moveboat');
            }
        }

    }

    persistirLogin = () => {
        Globals.setJogadorLogadoFromSession();

        this.debugPartida();
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

                <Header isLoginOk="true" userType={Globals.getJogadorLogado().getGenero()} />

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
                                                <IconCapybara color={Globals.getCorCapivaraJogadorLogado()} specialClass="user-capii-icon" />
                                            </td>
                                            <td>
                                                {Globals.getNomeCapivaraJogadorLogado()}
                                            </td>
                                        </tr>

                                        <tr>
                                            <td className="table-first-col">
                                                Life
                                        </td>
                                            <td>
                                                {Globals.getVidaCapivaraJogadorLogado()}
                                            </td>
                                        </tr>

                                        <tr>
                                            <td className="table-first-col">
                                                Score
                                        </td>
                                            <td>
                                                {Globals.getPontosJogadorLogado()}
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
                                                {Globals.getVitoriasJogadorLogado()}
                                            </td>
                                        </tr>

                                        <tr>
                                            <td className="table-first-col">
                                                Losses
                                        </td>
                                            <td>
                                                {Globals.getDerrotasJogadorLogado()}
                                            </td>
                                        </tr>

                                        <tr>
                                            <td className="table-first-col">
                                                Draws
                                        </td>
                                            <td>
                                                {Globals.getEmpatesJogadorLogado()}
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
export default withRouter(Home);