import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globals
import Globals from '../../Globals';

//Import Pages


class Welcome extends Component {

    render() {
        //defaultValue={Globals.getJogador()}
        //{require('../assets .svg')}

        Globals.criarPartida();

        return (
            <div>
                <div id="logo-inicial">
                    <img src={require('../assets/images/capivaralogo.svg')} alt="logo capivara wars" />
                </div>

                <div className="capii-animation move-bottom-3"></div>

                <div className="container-bamboo">

                    <div className="container-bamboo-title">
                        <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                        <span>Welcome</span>
                    </div>

                    <div className="container-bamboo-border">
                        <form className="container-bamboo-bg-color text-center padding-bottom-1">

                            <p>Choose your Side in this War!</p>

                            <span className="form-group-button">
                                <button className="form-button margin-left-right-1">register</button>
                                <button className="form-button-confirm margin-left-right-1">sign in</button>
                            </span>

                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

//export and allow redirect by "this.props.history"
export default withRouter(Welcome);