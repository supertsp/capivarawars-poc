import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globlas & Tools
import Globals from "../../Globals";
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';

//Import GameCore
import Jogador from '../../gamecore/Jogador';

//Import Pages
import Header from '../components/Header';


class TurnStatus extends Component {

    render() {

        Globals.criarPartida();

        return (
            <div>

                <Header />

                <div className="container-bamboo-no-capii">

                    <div className="container-bamboo-title">
                        <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                        <span>Turn Status</span>
                    </div>

                    <div className="container-bamboo-border">
                        <form className="container-bamboo-bg-color text-center padding-bottom-1">

                            <p>How is the game going?</p>

                            <table className="turn-status-table">
                                <tr>
                                    <td colspan="2" className="turn-status-table-title">
                                        Michael' Status
                                    </td>
                                    <td className="turn-status-table-white-space">
                                        &nbsp;
                                    </td>
                                    <td colspan="2" className="turn-status-table-title">
                                        John's Status
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <img className="user-capii-icon" src={require('../assets/images/capii-icon-brown.svg')} alt="capivara foto" />
                                    </td>
                                    <td className="turn-status-table-capivara-nane">
                                        Minerva
                                    </td>

                                    <td className="turn-status-table-white-space">
                                        &nbsp;
                                    </td>

                                    <td>
                                        <img className="user-capii-icon" src={require('../assets/images/capii-icon-pink.svg')} alt="capivara foto" />
                                    </td>
                                    <td className="turn-status-table-capivara-nane">
                                        Rose
                                    </td>
                                </tr>

                                <tr>
                                    <td colspan="2">
                                        <span className="current-boat-size">
                                            <span className="current-boat-size-piece"></span>
                                            <span className="current-boat-size-piece"></span>
                                            <span className="current-boat-size-piece"></span>
                                        </span>
                                    </td>

                                    <td className="turn-status-table-white-space">
                                        &nbsp;
                                    </td>

                                    <td colspan="2">
                                        <span className="current-boat-size">
                                            <span className="current-boat-size-piece"></span>
                                            <span className="current-boat-size-piece"></span>
                                            <span className="current-boat-size-piece"></span>
                                            <span className="current-boat-size-piece"></span>
                                        </span>
                                    </td>
                                </tr>


                            </table>

                            <div>

                                <Link to="/matchresult">
                                    <button className="form-button">Next</button>
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
export default withRouter(TurnStatus);