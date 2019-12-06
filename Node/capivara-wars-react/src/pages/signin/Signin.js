import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import PlayersList from '../components/PlayersList';

//Import Globals
import Globals from '../../Globals';

//Import
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';
import Jogador from '../../gamecore/Jogador';
import { async } from 'q';


class Signin extends Component {

    state = {
        player: '',
        formNick: '',
        nickJogadorLogado: '',
        loginError: false
    }

    constructor(props) {
        super(props);

    }

    componentDidMount() {
        //qdo renderizado no início
    }

    componentDidUpdate(prevProps) {
        if (this.state.player !== '') {
            //constructor(nick, nomeCapivara, tamanhoRio, tamanhoCanoa)
            let jogador = new Jogador(this.state.player.nick, 'Capii', 10, 4);
            jogador.setId(this.state.player.idPlayer);
            jogador.setPontos(this.state.player.score);

            // console.log(`\n\n\n ${jogador} \n\n\n`)

            Globals.setJogadorLogado(jogador);

            this.props.history.push('/signinpass');
        }
    }

    handleChangeNick = (event) => {
        //atribuição com this.setState() força um reload
        this.setState({ formNick: event.target.value });
    }

    onSubmitHandler = (event) => {
        event.preventDefault();
    }

    searchPlayerOnApi = async (event) => {
        const response = await AxiosRest.executeNamedGET('playerService', `player/nick/${this.state.formNick}`);

        if (response.status === 200 && response.data) {
            this.setState({ player: response.data });
            this.setState({ loginError: false });
        }

        else {
            this.setState({ player: '' });
            this.setState({ loginError: true });
        }
    }


    render() {
        //defaultValue={Globals.getJogador()}
        //{require('../assets  .svg')}

        Globals.criarPartida();

        return (
            <div>

                <div id="logo-inicial">
                    <img src={require('../assets/images/capivaralogo.svg')} alt="logo capivara wars" />
                </div>

                <div className="capii-silence-hat move-bottom-3"></div>

                <div className="container-bamboo">

                    <div className="container-bamboo-title">
                        <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                        <span>Sign in</span>
                    </div>

                    <div className="container-bamboo-border">
                        <form onSubmit={this.onSubmitHandler} className="container-bamboo-bg-color text-center padding-bottom-1">

                            <p>First enter your nick</p>

                            <span className="form-input-text-field padding-bottom-1">
                                <label className="form-input-text-title" htmlFor="nick">Nick</label>
                                <input className="form-input-text-original" type="text" name="nick" value={this.state.formNick} onChange={this.handleChangeNick} />
                            </span>

                            {
                                this.state.loginError === true &&
                                <span className="error-message display-block">Unfortunately this Nick does not Exist :(</span>
                            }

                            <span className="form-group-button">

                                <Link to="/">
                                    <button className="form-button-back margin-left-right-3">back</button>
                                </Link>

                                <button onClick={this.searchPlayerOnApi} className="form-button margin-left-right-3" type="submit">next</button>

                            </span>

                        </form>
                    </div>
                </div>

            </div>
        );
    }
}

//onClick={(event) => this.searchPlayerOnApi(event)}

//export and allow redirect by "this.props.history"
export default withRouter(Signin);