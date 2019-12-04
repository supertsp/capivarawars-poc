import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globals
import Globals from '../../Globals';

//Import Pages


class Home extends Component {

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

                <div className="container-bamboo-home">

                    <div className="container-bamboo-home-item-game">

                        <div className="container-bamboo-title">
                            <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                            <span>Game</span>
                        </div>

                        <div className="container-bamboo-border">
                            <form className="container-bamboo-bg-color text-center padding-bottom-1">

                                <p>Let the games begin!!</p>

                                <Link to="/moveboat">
                                    <button className="form-button-play">
                                        <img src={require('../assets/images/buttonplay.svg')} alt="#" />
                                    </button>
                                </Link>

                            </form>
                        </div>
                    </div>

                    <div className="container-bamboo-home-item-status">

                        <div className="container-bamboo-title">
                            <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                            <span>Status</span>
                        </div>

                        <div className="container-bamboo-border">
                            <form className="container-bamboo-bg-color padding-bottom-1">

                                <table>

                                    <tr>
                                        <td className="table-first-col">
                                            <img className="user-capii-icon" src={require('../assets/images/capiiiconbrown.svg')} alt="capivara foto" />
                                        </td>
                                        <td>
                                            Capii
                                        </td>
                                    </tr>

                                    <tr>
                                        <td className="table-first-col">
                                            Life
                                        </td>
                                        <td>
                                            7
                                        </td>
                                    </tr>

                                    <tr>
                                        <td className="table-first-col">
                                            Score
                                        </td>
                                        <td>
                                            100
                                        </td>
                                    </tr>
                                    <tr>
                                        <td className="table-first-col">
                                            &nbsp;
                                        </td>
                                        <td>
                                            &nbsp;
                                        </td>
                                    </tr>

                                    <tr>
                                        <td className="table-first-col">
                                            Wins
                                        </td>
                                        <td>
                                            10
                                        </td>
                                    </tr>

                                    <tr>
                                        <td className="table-first-col">
                                            Losses
                                        </td>
                                        <td>
                                            1
                                        </td>
                                    </tr>

                                    <tr>
                                        <td className="table-first-col">
                                            Draws
                                        </td>
                                        <td>
                                            5
                                        </td>
                                    </tr>

                                </table>

                            </form>
                        </div>
                    </div>

                </div>

            </div>
        );
    }
}

//export and allow redirect by "this.props.history"
export default withRouter(Home);