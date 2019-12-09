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


class SigninStepPass extends Component {

    state = {
        formPassword: '',
        nickJogadorLogado: 'tsetes',
        jogador: '',
        loginCompleted: false,
        loginError: false
    }

    constructor(props) {
        super(props);

        if (Validator.isUndefined(Globals.getJogadorLogado())) {
            this.props.history.push('/');
        }
        else {
            this.state.nickJogadorLogado = Globals.getJogadorLogado().getNick();
            this.state.jogador = Globals.getJogadorLogado();
        }
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

    }

    render() {

        Globals.criarPartida();

        return (
            <div>
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
            </div>
        );
    }
}

//export and allow redirect by "this.props.history"
export default withRouter(SigninStepPass);