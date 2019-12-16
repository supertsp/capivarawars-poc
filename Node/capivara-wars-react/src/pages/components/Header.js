import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globlas & Tools
import Globals from "../../Globals";
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';

//Import GameCore
import Player from '../../gamecore/Player';


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
                    this.props.isLoginOk &&
                    <div className="user-area">
                        <div className="user-area-nick">
                            {this.props.userNick}
                        </div>
                        <div>
                            {
                                this.props.userType === 'M' ?
                                    <img src={require('../assets/images/user-male-icon.svg')} alt="user foto" /> :
                                    this.props.userType === 'F' ?
                                        <img src={require('../assets/images/user-female-icon.svg')} alt="user foto" /> :
                                        <img src={require('../assets/images/user-enemy-icon.svg')} alt="user foto" />
                            }

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
