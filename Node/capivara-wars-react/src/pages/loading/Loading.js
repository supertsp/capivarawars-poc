import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";

//Import Globlas & Tools
import Globals from "../../Globals";
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';

//Import GameCore
import Jogador from '../../gamecore/Jogador';

//Import Components
import Header from '../components/Header';


class Loading extends Component {



    render() {
        return (
            <div>

                <Header />

                <div className="container-area-loading">

                    <img src={require('../assets/images/loading.svg')}
                        className="" alt="loading icon" />

                </div>

            </div>
        );
    }
}

//export and allow redirect by "this.props.history"
export default withRouter(Loading);
