import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globals
import Globals from '../../Globals';

//Import Pages


class Register extends Component {

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
                        <form className="container-bamboo-bg-color text-center form-table">
                            <span className="form-input-text-field form-table-item">
                                <label className="form-input-text-title" htmlFor="nick">Nick</label>
                                <input className="form-input-text-original" type="text" name="nick" />
                            </span>

                            <span className="form-input-text-field form-table-item">
                                <label className="form-input-text-title" htmlFor="password">password</label>
                                <input className="form-input-text-original" type="password" name="password" />
                            </span>

                            <span className="form-input-text-field form-table-item">
                                <label className="form-input-text-title" htmlFor="password">password confirm</label>
                                <input className="form-input-text-original" type="password" name="passwordConfirm" />
                            </span>

                            <span className="form-input-text-field form-table-item">
                                <label className="form-input-text-title" htmlFor="email">email</label>
                                <input className="form-input-text-original" type="email" name="email" />
                            </span>

                            <span className="form-input-text-field form-table-item">
                                <label className="form-input-text-title" htmlFor="fullname">full name</label>
                                <input className="form-input-text-original" type="text" name="fullname" />
                            </span>

                            <span className="form-table-item">
                                <label className="form-checkbox-field">
                                    <input className="form-checkbox-original" type="radio" name="gender" value="m" />
                                    <span className="form-checkbox-square"></span>
                                    <span className="form-checkbox-text">Male</span>
                                </label>
                                &nbsp;
                                <label className="form-checkbox-field">
                                    <input className="form-checkbox-original" type="radio" name="gender" value="f" />
                                    <span className="form-checkbox-square"></span>
                                    <span className="form-checkbox-text">Female</span>
                                </label>
                            </span>

                            <span className="form-input-text-field form-table-item">
                                <label className="form-input-text-title" htmlFor="birthday">birthday</label>
                                <input className="form-input-date-original" type="date" name="birthday" />
                            </span>

                            <span className="form-group-button form-table-item">

                                <Link to="/">
                                    <button className="form-button-back">back</button>
                                </Link>

                            </span>

                            <span className="form-group-button form-table-item">

                                <Link to="/">
                                    <button className="form-button-confirm">save</button>
                                </Link>

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