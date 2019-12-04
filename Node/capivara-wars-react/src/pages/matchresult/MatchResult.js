import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globals
import Globals from '../../Globals';

//Import Pages


class MatchResult extends Component {

    render() {

        Globals.criarPartida();

        return (
            <div>
                <div id="logo-inicial">
                    <img src={require('../assets/images/capivaralogo.svg')} alt="logo capivara wars" />
                </div>

                <div className="user-area">
                    <img src={require('../assets/images/usericon.svg')} alt="user foto" /><br />

                    <Link to="/">
                        <button className="form-button">logout</button>
                    </Link>

                </div>

                <div className="capii-sweating move-bottom-3"></div>

                <div className="container-bamboo">

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
        );
    }
}

//export and allow redirect by "this.props.history"
export default withRouter(MatchResult);