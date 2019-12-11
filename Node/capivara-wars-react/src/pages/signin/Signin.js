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
        if (this.state.isLoginCompleted) {
            //constructor(nick, nomeCapivara, tamanhoRio, tamanhoCanoa)
            let jogador = new Jogador(this.state.player.nick, this.state.player.capybaraName, 10, 4);
            jogador.setId(this.state.player.idPlayer);
            jogador.setPontos(this.state.player.score);
            jogador.setCorCapivara(this.state.player.capybaraColor);
            Globals.setJogadorLogado(jogador);

            //criando uma sessão
            sessionStorage.setItem(Globals.getSessionKeyNick(), jogador.getNick());
            // sessionStorage.setItem(Globals.getSessionKeyJogador(), { ...jogador });
            sessionStorage.setItem(Globals.getSessionKeyJogador(), JSON.stringify(jogador));

            this.props.history.push('/home');
        }
    }

    componentWillUnmount() {

    }

    onChangeFormNick = (valueFromChildComponent) => {
        //atribuição com this.setState() força um reload
        this.setState({ formNick: valueFromChildComponent });
    }

    onChangeFormPassword = (valueFromChildComponent) => {
        this.setState({ formPassword: valueFromChildComponent });
    }

    onSubmitHandler = (event) => {
        event.preventDefault();

        if (!this.state.isLoginCompleted && !this.state.isNickChecked && !Validator.isStringEmpty(this.state.formNick)) {
            this.searchPlayerByNickOnApi();
        }

        if (!this.state.isLoginCompleted && this.state.isNickChecked && !Validator.isStringEmpty(this.state.formNick) && !Validator.isStringEmpty(this.state.formPassword)) {
            this.checkPlayerCredtentialsOnApi();
        }
    }

    searchPlayerByNickOnApi = async (event) => {
        const response = await AxiosRest.executeGET('playerService', `player/nick/${this.state.formNick}`);

        if (Validator.isAxiosResponseOkAndHasData(response)) {
            //Dar vários SETs ocasiona vários UPDATEs de tela
            //Boa prática dar apenas 1, pois ao mudar de tela
            //a atualização dessa tela não estará em processo de
            //update, fato esse que ocasiona erros no React
            this.setState({
                player: response.data,
                formNickError: false,
                isNickChecked: true
            });
        }
        else {
            this.setState({
                player: '',
                formNickError: true,
                isNickChecked: false
            });
        }
    }

    checkPlayerCredtentialsOnApi = async (event) => {
        const response = await AxiosRest.executePOST('playerService', `/player/check/credentials`, {
            nick: this.state.formNick,
            password: this.state.formPassword
        });

        if (Validator.isAxiosResponseOkAndHasData(response)) {
            this.setState({
                isLoginCompleted: true,
                formPasswordError: false
            });
        }
        else {
            this.setState({
                isLoginCompleted: false,
                formPasswordError: true
            });
        }
    }


    render() {
        return (
            <div>

                <Header />

                <div className="container-area-signin">

                    <div className="capii-silence-hat"></div>

                    <div className="container-bamboo-signin">

                        <div className="container-bamboo-title">
                            <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                            <span>Sign in</span>
                        </div>

                        <div className="container-bamboo-border">
                            <form onSubmit={this.onSubmitHandler} className="container-bamboo-bg-color text-center padding-bottom-1">

                                {
                                    !this.state.isNickChecked &&
                                    <SigninStepNick parentAction={this.onChangeFormNick} nickErrorStatus={this.state.formNickError} /> ||
                                    <SigninStepPass parentAction={this.onChangeFormPassword} passwordErrorStatus={this.state.formPasswordError} />
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