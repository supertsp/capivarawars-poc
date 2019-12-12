import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globlas & Tools
import Globals from "../../Globals";
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';

//Import GameCore
import Player from '../../gamecore/Jogador';

//Import Pages
import Header from '../components/Header';

class MatchResult extends Component {

    render() {

        Globals.criarPartida();

        return (
            <div>

                <Header isLoginOk="true" userType={Globals.getJogadorLogado().getGenero()} />

                <div className="container-area-matchresult">

                    <div className="capii-sweating"></div>

                    <div className="container-bamboo-turnstatus">

                        <div className="container-bamboo-title">
                            <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                            <span>Match Result</span>
                        </div>

                        <div className="container-bamboo-border">
                            <form className="container-bamboo-bg-color text-center padding-bottom-1">

                                <p>And the Winner of this match was ...</p>

                                <div className="match-result-winner-name">
                                    John
                                </div>

                                <div>

                                    <Link to="/home">
                                        <button className="form-button">Finish</button>
                                    </Link>

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
export default withRouter(MatchResult);