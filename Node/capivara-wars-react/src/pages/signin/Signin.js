import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globals
import Globals from '../../Globals';

//Import Pages


class Signin extends Component {

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
                        <form className="container-bamboo-bg-color text-center padding-bottom-1">

                            <p>First enter your nick</p>

                            <span className="form-input-text-field padding-bottom-1">
                                <label className="form-input-text-title" forName="nick">Nick</label>
                                <input className="form-input-text-original" type="text" name="nick" />
                            </span>

                            <span className="error-message display-block">Unfortunately this Nick does not Exist :(</span>

                            <span className="form-group-button">
                                <button className="form-button-back margin-left-right-3">back</button>
                                <button className="form-button margin-left-right-3">next</button>
                            </span>

                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

//export and allow redirect by "this.props.history"
export default withRouter(Signin);