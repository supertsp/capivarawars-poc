import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globals
import Globals from '../../Globals';

//Import 
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';


class Register extends Component {

    state = {
        formNick: '',
        formPassword: '',
        formPasswordConfirm: '',
        formEmail: '',
        formFullname: '',
        formGender: '',
        formBirthday: '',
        registerCompleted: false,
        formError: false
    }

    constructor(props) {
        super(props);

    }

    componentDidMount() {
        //qdo renderizado no início
        // this.setState({ nickJogadorLogado: Globals.getJogadorLogado().getNick() });
        // this.setState({ nickJogadorLogado: Globals.getJogadorLogado() });
    }

    componentDidUpdate(prevProps) {
        if (this.state.registerCompleted) {
            this.props.history.push('/');
        }
    }

    onSubmitHandler = (event) => {
        event.preventDefault();
    }

    onChangeFormNick = (event) => {
        this.setState({ formNick: event.target.value });
    }

    onChangeFormPassword = (event) => {
        this.setState({ formPassword: event.target.value });
    }

    onChangeFormPasswordConfirm = (event) => {
        this.setState({ formPasswordConfirm: event.target.value });
    }

    onChangeFormEmail = (event) => {
        this.setState({ formEmail: event.target.value });
    }

    onChangeFormFullname = (event) => {
        this.setState({ formFullname: event.target.value });
    }

    onChangeFormGender = (event) => {
        this.setState({ formGender: event.target.value });
    }

    onChangeFormBirthday = (event) => {
        this.setState({ formBirthday: event.target.value });
    }

    createPlayerOnApi = async (event) => {
        const response = await await AxiosRest.executeNamedPOST('playerService', `/player`, {
            nick: this.state.formNick,
            password: this.state.formPassword,
            email: this.state.formEmail,
            fullName: this.state.formFullname,
            gender: this.state.formGender,
            birthday: this.state.formBirthday
        });

        if (response.status === 200 && response.data) {
            this.setState({ registerCompleted: true });
            this.setState({ formError: false });
        }
        else {
            this.setState({ registerCompleted: false });
            this.setState({ formError: false });
        }

    }

    render() {

        Globals.criarPartida();

        return (
            <div>

                <div id="logo-inicial">
                    <img src={require('../assets/images/capivaralogo.svg')} alt="logo capivara wars" />
                </div>

                <div className="capii-animation-register move-bottom-3"></div>

                <div className="container-bamboo-register">

                    <div className="container-bamboo-title">
                        <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                        <span>Register</span>
                    </div>

                    <div className="container-bamboo-border">
                        <form onSubmit={this.onSubmitHandler} className="container-bamboo-bg-color text-center form-table">
                            <span className="form-input-text-field form-table-item">
                                <label className="form-input-text-title" htmlFor="nick">Nick</label>
                                <input className="form-input-text-original" type="text" name="nick"
                                    value={this.state.formNick} onChange={this.onChangeFormNick} />
                            </span>

                            <span className="form-input-text-field form-table-item">
                                <label className="form-input-text-title" htmlFor="password">password</label>
                                <input className="form-input-text-original" type="password" name="password"
                                    value={this.state.formPassword} onChange={this.onChangeFormPassword} />
                            </span>

                            <span className="form-input-text-field form-table-item">
                                <label className="form-input-text-title" htmlFor="password">password confirm</label>
                                <input className="form-input-text-original" type="password" name="passwordConfirm"
                                    value={this.state.formPasswordConfirm} onChange={this.onChangeFormPasswordConfirm} />
                            </span>

                            <span className="form-input-text-field form-table-item">
                                <label className="form-input-text-title" htmlFor="email">email</label>
                                <input className="form-input-text-original" type="email" name="email"
                                    value={this.state.formEmail} onChange={this.onChangeFormEmail} />
                            </span>

                            <span className="form-input-text-field form-table-item">
                                <label className="form-input-text-title" htmlFor="fullname">full name</label>
                                <input className="form-input-text-original" type="text" name="fullname"
                                    value={this.state.formFullname} onChange={this.onChangeFormFullname} />
                            </span>

                            <span className="form-table-item">
                                <label className="form-checkbox-field">
                                    <input className="form-checkbox-original" type="radio" name="gender" value="m" onChange={this.onChangeFormGender} />
                                    <span className="form-checkbox-square"></span>
                                    <span className="form-checkbox-text">Male</span>
                                </label>
                                &nbsp;
                                <label className="form-checkbox-field">
                                    <input className="form-checkbox-original" type="radio" name="gender" value="f" onChange={this.onChangeFormGender} />
                                    <span className="form-checkbox-square"></span>
                                    <span className="form-checkbox-text">Female</span>
                                </label>
                            </span>

                            <span className="form-input-text-field form-table-item">
                                <label className="form-input-text-title" htmlFor="birthday">birthday</label>
                                <input className="form-input-date-original" type="date" name="birthday"
                                    value={this.state.formBirthday} onChange={this.onChangeFormBirthday} />
                            </span>

                            <span className="form-group-button form-table-item">

                                <Link to="/">
                                    <button className="form-button-back">back</button>
                                </Link>

                            </span>

                            <span className="form-group-button form-table-item">


                                <button onClick={this.createPlayerOnApi} className="form-button-confirm"
                                    type="submit">save</button>


                            </span>

                            <span className="error-message display-none">Unfortunately this Nick does not Exist :(</span>
                        </form>
                    </div>
                </div>

            </div>
        );
    }
}

//export and allow redirect by "this.props.history"
export default withRouter(Register);