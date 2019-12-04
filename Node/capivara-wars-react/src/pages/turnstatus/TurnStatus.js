import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globals
import Globals from '../../Globals';

//Import Pages


class TurnStatus extends Component {

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
                                        <img className="user-capii-icon" src={require('../assets/images/capiiiconbrown.svg')} alt="capivara foto" />
                                    </td>
                                    <td className="turn-status-table-capivara-nane">
                                        Minerva
                                    </td>

                                    <td className="turn-status-table-white-space">
                                        &nbsp;
                                    </td>

                                    <td>
                                        <img className="user-capii-icon" src={require('../assets/images/capiiiconpink.svg')} alt="capivara foto" />
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