import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import PlayersList from '../components/PlayersList';

//Import Globlas & Tools
import Globals from "../../Globals";
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';

//Import GameCore
import Jogador from '../../gamecore/Jogador';

//Import Components
import Header from '../components/Header';
import SigninStepNick from './SigninStepNick';
import SigninStepPass from './SigninStepPass';


class Signin extends Component {

    state = {
        player: '',
        formNick: '',
        formPassword: '',
        formNickError: false,
        formPasswordError: false,
        isNickChecked: false,
        isLoginCompleted: false
    }

    constructor(props) {
        super(props);

    }

    componentDidMount() {
        //qdo renderizado no início
    }

    componentDidUpdate(prevProps) {
        if (this.isLoginCompleted) {
            //constructor(nick, nomeCapivara, tamanhoRio, tamanhoCanoa)
            let jogador = new Jogador(this.state.player.nick, 'Capii', 10, 4);
            jogador.setId(this.state.player.idPlayer);
            jogador.setPontos(this.state.player.score);
            Globals.setJogadorLogado(jogador);

            // this.props.history.push('/signinpass');
        }
    }

    onChangeFormNick = (valueFromChildComponent) => {
        //atribuição com this.setState() força um reload
        // this.setState({ formNick: valueFromChildComponent });
        console.log(valueFromChildComponent);
    }

    onChangeFormPassword = (valueFromChildComponent) => {
        //atribuição com this.setState() força um reload
        this.setState({ formPassword: valueFromChildComponent });
    }

    onSubmitHandler = (event) => {
        event.preventDefault();
    }

    searchPlayerByNickOnApi = async (event) => {
        const response = await AxiosRest.executeGET('playerService', `player/nick/${this.state.formNick}`);

        if (Validator.isAxiosResponseOkAndHasData(response)) {
            this.setState({ player: response.data });
            this.setState({ formNickError: false });
            this.setState({ isNickChecked: true });
        }
        else {
            this.setState({ player: '' });
            this.setState({ formNickError: true });
            this.setState({ isNickChecked: false });
        }
    }

    checkPlayerCredtentialsOnApi = async (event) => {
        const response = await AxiosRest.executePOST('playerService', `/player/check/credentials`, {
            nick: this.state.nickJogadorLogado,
            password: this.state.formPassword
        });

        if (Validator.isAxiosResponseOkAndHasData(response)) {
            this.setState({ isLoginCompleted: true });
            this.setState({ formPasswordError: false });
        }
        else {
            this.setState({ isLoginCompleted: false });
            this.setState({ formPasswordError: true });
        }
    }


    render() {
        return (
            <div>

                <Header />

                <div className="capii-side-and-container-bamboo">

                    <div className="capii-silence-hat move-bottom-3"></div>

                    <div className="container-bamboo">

                        <div className="container-bamboo-title">
                            <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                            <span>Sign in</span>
                        </div>

                        <div className="container-bamboo-border">
                            <form onSubmit={this.onSubmitHandler} className="container-bamboo-bg-color text-center padding-bottom-1">

                                {
                                    !this.state.isNickChecked &&
                                    <SigninStepNick parentAction={this.onChangeFormNick} nickErrorStatus={this.state.formNickError} /> ||
                                    <SigninStepPass parentAciotn={this.onChangeFormPassword} passwordErrorStatus={this.state.formPasswordError} />
                                }

                            </form>
                        </div>
                    </div>

                </div>

            </div >
        );
    }
}

//onClick={(event) => this.searchPlayerOnApi(event)}

//export and allow redirect by "this.props.history"
export default withRouter(Signin);