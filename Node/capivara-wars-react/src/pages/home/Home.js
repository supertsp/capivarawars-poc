import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globlas & Tools
import Globals from "../../Globals";
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';

//Import GameCore
import Jogador from '../../gamecore/Jogador';

//Import Pages
import Header from '../components/Header';

class Home extends Component {

    state = {
        jogador: '',
        partidaIniciou: false
    }

    constructor(props) {
        super(props);

        if (Validator.isUndefined(Globals.getJogadorLogado())) {
            // this.props.history.push('/');
        }
        else {
            this.state.jogador = Globals.getJogadorLogado();
        }
    }

    componentDidMount() {
        //qdo renderizado no início
        // this.setState({ nickJogadorLogado: Globals.getJogadorLogado().getNick() });
        // this.setState({ nickJogadorLogado: Globals.getJogadorLogado() });
    }

    componentDidUpdate(prevProps) {
        if (this.state.partidaIniciou) {

            Globals.addJogadorInimigo(new Jogador("Julia", "Feliceta", 10, 4).setId(777));

            if (Globals.criarPartida()) {
                this.props.history.push('/moveboat');
            }
        }

    }

    onSubmitHandler = (event) => {
        event.preventDefault();
    }

    onClickPlay = (event) => {
        this.setState({ partidaIniciou: true });
    }


    render() {

        Globals.criarPartida();

        return (
            <div>
                <Header />

                <div className="container-bamboo-home">

                    <div className="container-bamboo-home-item-game">

                        <div className="container-bamboo-title">
                            <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                            <span>Game</span>
                        </div>

                        <div className="container-bamboo-border">
                            <form onSubmit={this.onSubmitHandler} className="container-bamboo-bg-color text-center padding-bottom-1">

                                <p>Let the games begin!!</p>


                                <button onClick={this.onClickPlay} className="form-button-play">
                                    <img src={require('../assets/images/buttonplay.svg')} alt="#" />
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

                                    <tr className="tr-no-hover">
                                        <td className="table-first-col">
                                            <img className="user-capii-icon" src={require('../assets/images/capii-icon-brown.svg')} alt="capivara foto" />
                                        </td>
                                        <td>
                                            Capii
                                        </td>
                                    </tr>

                                    <tr>
                                        <td className="table-first-col">
                                            Life
                                        </td>
                                        <td>
                                            7
                                        </td>
                                    </tr>

                                    <tr>
                                        <td className="table-first-col">
                                            Score
                                        </td>
                                        <td>
                                            100
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
                                            10
                                        </td>
                                    </tr>

                                    <tr>
                                        <td className="table-first-col">
                                            Losses
                                        </td>
                                        <td>
                                            1
                                        </td>
                                    </tr>

                                    <tr>
                                        <td className="table-first-col">
                                            Draws
                                        </td>
                                        <td>
                                            5
                                        </td>
                                    </tr>

                                </table>

                            </form>
                        </div>
                    </div>

                </div>

            </div>
        );
    }
}

//export and allow redirect by "this.props.history"
export default withRouter(Home);