import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globals
import Globals from '../../Globals';

//Import 
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';


class SigninPass extends Component {

    state = {
        formPassword: '',
        nickJogadorLogado: 'tsetes',
        jogador: '',
        loginCompleted: false,
        loginError: false
    }

    constructor(props) {
        super(props);

        this.state.nickJogadorLogado = Globals.getJogadorLogado().getNick();
        this.state.jogador = Globals.getJogadorLogado();
    }

    componentDidMount() {
        //qdo renderizado no início
        // this.setState({ nickJogadorLogado: Globals.getJogadorLogado().getNick() });
        // this.setState({ nickJogadorLogado: Globals.getJogadorLogado() });
    }

    componentDidUpdate(prevProps) {
        if (this.state.loginCompleted) {
            this.props.history.push('/home');
        }
    }

    onSubmitHandler = (event) => {
        event.preventDefault();
    }

    onChangeFormPassword = (event) => {
        this.setState({ formPassword: event.target.value });
    }

    checkPlayerCredtentialsOnApi = async (event) => {
        const response = await AxiosRest.executeNamedPOST('playerService', `/player/check/credentials`, {
            nick: this.state.nickJogadorLogado,
            password: this.state.formPassword
        });

        if (response.status === 200 && response.data) {
            this.setState({ loginCompleted: true });
            this.setState({ loginError: false });
        }
        else {
            this.setState({ loginCompleted: false });
            this.setState({ loginError: true });
        }
    }

    render() {

        Globals.criarPartida();

        return (
            <div>

                <div id="logo-inicial">
                    <img src={require('../assets/images/capivaralogo.svg')} alt="logo capivara wars" />
                </div>

                <div className="capii-silence-coat move-bottom-3"></div>

                <div className="container-bamboo">

                    <div className="container-bamboo-title">
                        <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                        <span>Sign in</span>
                    </div>

                    <div className="container-bamboo-border">
                        <form onSubmit={this.onSubmitHandler} className="container-bamboo-bg-color text-center padding-bottom-1">

                            <p>Now enter your password</p>

                            <span className="form-input-text-field padding-bottom-1">
                                <label className="form-input-text-title" htmlFor="password">password</label>
                                <input className="form-input-text-original" type="password" name="password"
                                    value={this.state.formPassword} onChange={this.onChangeFormPassword} />
                            </span>

                            {
                                this.state.loginError === true &&
                                <span className="error-message display-block">Unfortunately your Password is Wrong: 0</span>
                            }

                            <span className="form-group-button">

                                <Link to="/signin">
                                    <button className="form-button-back margin-left-right-3">back</button>
                                </Link>

                                <button onClick={this.checkPlayerCredtentialsOnApi}
                                    className="form-button-confirm margin-left-right-3" type="submit">enter</button>

                            </span>

                        </form>
                    </div>
                </div>

            </div>
        );
    }
}

//export and allow redirect by "this.props.history"
export default withRouter(SigninPass);