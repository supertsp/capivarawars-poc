import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globlas & Tools
import Globals from "../../Globals";
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';

//Import GameCore
import Player from '../../gamecore/Player';

//Import Components
import Header from '../components/Header';
import IconCapybara from '../components/IconCapybara';


class Register extends Component {

    state = {
        formNick: '',
        formPassword: '',
        formPasswordConfirm: '',
        formEmail: '',
        formFullname: '',
        formGender: '',
        formBirthday: '',
        formCapybaraColor: 'brown',
        formCapybaraName: '',
        registerCompleted: false,
        requestError: false,
        formEmpty: false,
        formPasswordsDontMatch: false
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

    onSubmitHandler = async (event) => {
        event.preventDefault();

        this.createPlayerOnApi(event);
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

    onChangeFormCapybaraColor = (event) => {
        this.setState({ formCapybaraColor: event.target.value });
    }

    onChangeFormCapybaraName = (event) => {
        this.setState({ formCapybaraName: event.target.value });
    }

    createPlayerOnApi = async (event) => {
        if (!Validator.isThereAnyEmptyString(
            this.state.formNick,
            this.state.formPassword,
            this.state.formEmail,
            this.state.formFullname,
            this.state.formGender,
            this.state.formBirthday,
            this.state.formCapybaraColor,
            this.state.formCapybaraName)
        ) {

            if (this.state.formPassword !== this.state.formPasswordConfirm) {
                this.setState({ formPasswordsDontMatch: true });
            }
            else {
                this.setState({ formPasswordsDontMatch: false });
                this.setState({ formEmpty: false });

                const response = await await AxiosRest.executePOST('playerService', `/player`, {
                    nick: this.state.formNick,
                    password: this.state.formPassword,
                    email: this.state.formEmail,
                    fullName: this.state.formFullname,
                    gender: this.state.formGender,
                    birthday: this.state.formBirthday,
                    capybaraColor: this.state.formCapybaraColor,
                    capybaraName: this.state.formCapybaraName,
                });

                if (response.status === 200 && response.data) {
                    this.setState({ registerCompleted: true });
                    this.setState({ requestError: false });
                }
                else {
                    this.setState({ registerCompleted: false });
                    this.setState({ requestError: true });
                }
            }
        }
        else {
            this.setState({ formEmpty: true });
        }
    }

    render() {
        return (
            <div>

                <Header />

                <div className="container-area-register">

                    <div className="capii-animation-register"></div>

                    <div className="container-bamboo-register">

                        <div className="container-bamboo-title">
                            <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                            <span>Register</span>
                        </div>

                        <div className="container-bamboo-border">
                            <form onSubmit={this.onSubmitHandler} className="container-bamboo-bg-color text-center form-table">
                                <span className="form-input-text-field form-table-item">
                                    <label className="form-input-text-title" htmlFor="nick">Nick</label>
                                    <input className="form-input-text-original" type="text" name="nick" required
                                        value={this.state.formNick} onChange={this.onChangeFormNick} />
                                </span>

                                <span className="form-input-text-field form-table-item">
                                    <label className="form-input-text-title" htmlFor="password">password</label>
                                    <input className="form-input-text-original" type="password" name="password" required
                                        value={this.state.formPassword} onChange={this.onChangeFormPassword} />
                                </span>

                                <span className="form-input-text-field form-table-item">
                                    <label className="form-input-text-title" htmlFor="password">password confirm</label>
                                    <input className="form-input-text-original" type="password" name="passwordConfirm" required
                                        value={this.state.formPasswordConfirm} onChange={this.onChangeFormPasswordConfirm} />
                                </span>

                                <span className="form-input-text-field form-table-item">
                                    <label className="form-input-text-title" htmlFor="email">email</label>
                                    <input className="form-input-text-original" type="email" name="email" required
                                        value={this.state.formEmail} onChange={this.onChangeFormEmail} />
                                </span>

                                <span className="form-input-text-field form-table-item">
                                    <label className="form-input-text-title" htmlFor="fullname">full name</label>
                                    <input className="form-input-text-original" type="text" name="fullname" required
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
                                    <input className="form-input-date-original" type="date" name="birthday" required
                                        value={this.state.formBirthday} onChange={this.onChangeFormBirthday} />
                                </span>

                                <span className="form-table-item form-select-group">
                                    <label className="form-input-text-title" htmlFor="capybaraColor">Capybara Color</label>
                                    <select className="form-select" onChange={this.onChangeFormCapybaraColor} name="capybaraColor">
                                        <option value="brown">brown</option>
                                        <option value="green">green</option>
                                        <option value="blue">blue</option>
                                        <option value="red">red</option>
                                        <option value="yellow">yellow</option>
                                        <option value="purple">purple</option>
                                        <option value="pink">pink</option>
                                        <option value="black">black</option>
                                        <option value="white">white</option>
                                    </select>
                                    <label className="form-capii-icon">
                                        <IconCapybara color={this.state.formCapybaraColor} />
                                    </label>
                                </span>

                                <span className="form-capybara-name form-table-item">
                                    <label className="form-input-text-title" htmlFor="capybaraName">Capybara Name</label>
                                    <input className="form-input-text-original" type="text" name="capybaraName" required
                                        value={this.state.formCapybaraName} onChange={this.onChangeFormCapybaraName} />
                                </span>

                                <div className="form-bottom-area">
                                    {
                                        this.state.formEmpty ?
                                            <div className="margin-top-bottom-1">
                                                <span className="error-message">Wow! You left things blank !!! :0 </span>
                                            </div> :
                                            this.state.requestError ?
                                                <div className="margin-top-bottom-1">
                                                    <span className="error-message">Unfortunately this Nick already Exists ;)</span>
                                                </div> :
                                                this.state.formPasswordsDontMatch ?
                                                    <div className="margin-top-bottom-1">
                                                        <span className="error-message">The Passwords do not Match!! 8(</span>
                                                    </div> :
                                                    ''
                                    }


                                    <div className="form-buttons-back-save">

                                        <Link to="/">
                                            <button className="form-button-back">back</button>
                                        </Link>

                                        <span>
                                            <button
                                                onClick={this.onSubmitHandler}
                                                className="form-button-confirm">
                                                save
                                            </button>
                                        </span>

                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                </div>

            </div>
        );
    }
}

//export and allow redirect by "this.props.history"
export default withRouter(Register);