import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globals
import Globals from '../../Globals';

//Import Pages


class SigninPass extends Component {

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
                        <form className="container-bamboo-bg-color text-center padding-bottom-1">

                            <p>Now enter your password</p>

                            <span className="form-input-text-field padding-bottom-1">
                                <label className="form-input-text-title" htmlFor="password">password</label>
                                <input className="form-input-text-original" type="password" name="password" />
                            </span>

                            <span className="error-message display-block">Unfortunately your Password is Wrong: 0</span>

                            <span className="form-group-button">

                                <Link to="/signin">
                                    <button className="form-button-back margin-left-right-3">back</button>
                                </Link>

                                <Link to="/home">
                                    <button className="form-button-confirm margin-left-right-3">enter</button>
                                </Link>

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