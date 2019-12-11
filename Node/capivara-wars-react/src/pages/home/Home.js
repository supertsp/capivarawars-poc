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
import IconCapybara from '../components/IconCapybara';

class Home extends Component {

    state = {
        jogador: '',
        partidaIniciou: false
    }

    constructor(props) {
        super(props);

        this.persistirLogin();

        if (Globals.hasJogadorLogado()) {
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

    persistirLogin = () => {
        if (!Globals.hasJogadorLogado()
            && !Validator.isUndefined(sessionStorage.getItem(Globals.getSessionKeyJogador()))) {

            Globals.setJogadorLogadoFromSession();
        }
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
                <Header />

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
}

//export and allow redirect by "this.props.history"
export default withRouter(Home);