import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globlas & Tools
import Globals from "../../Globals";
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';

//Import GameCore
import Jogador from '../../gamecore/Jogador';


export default class Header extends Component {

    constructor(props) {
        super(props);
    }

    render() {

        // Globals.criarPartida();

        return (
            <div>
                <div id="logo-inicial">
                    <img src={require('../assets/images/capivaralogo.svg')} alt="logo capivara wars" />
                </div>

                {
                    this.props.login === true &&
                    <div className="user-area">
                        <div className="user-area-nick">
                            tiago
                    </div>
                        <div>
                            <img src={require('../assets/images/usericon.svg')} alt="user foto" />
                        </div>
                        <div>
                            <Link to="/">
                                <button className="form-button">logout</button>
                            </Link>
                        </div>
                    </div>
                }
            </div>
        );
    }
}
