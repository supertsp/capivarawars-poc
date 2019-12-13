import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globlas & Tools
import Globals from "../../Globals";
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';

//Import GameCore
import Player from '../../gamecore/Player';

//Import Pages
import Header from '../components/Header';


class MoveAim extends Component {

    render() {

        Globals.criarPartida();

        return (
            <div>

                <Header isLoginOk="true" userType={Globals.getJogadorLogado().getGenero()} />

                <div className="container-area-moveaim">

                    <div className="container-bamboo-title">
                        <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                        <span>Aim</span>
                    </div>

                    <div className="container-bamboo-border">
                        <form className="container-bamboo-bg-color text-center padding-bottom-1">

                            <p>Aim at a part of the Enemy River!</p>

                            <div className="aim-area">

                                <input type="button" className="form-button-back" value="-" />

                                <span className="aim-area-all-pieces">
                                    <label className="aim-area-piece">
                                        <input type="radio" name="chosenAim" value="0" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input type="radio" name="chosenAim" value="1" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input type="radio" name="chosenAim" value="2" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input type="radio" name="chosenAim" value="3" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input type="radio" name="chosenAim" value="4" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input type="radio" name="chosenAim" value="5" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input type="radio" name="chosenAim" value="6" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input type="radio" name="chosenAim" value="7" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input type="radio" name="chosenAim" value="8" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                    <label className="aim-area-piece">
                                        <input type="radio" name="chosenAim" value="9" />
                                        <span className="aim-area-piece-box"></span>
                                    </label>
                                </span>

                                <input type="button" className="form-button-back" value="+" />
                            </div>

                            <div className="statistics-area">

                                <span>My Foto</span>

                                <div className="statistics-area-title">John's Boat Status</div>
                                <span className="current-boat-size">
                                    <span className="current-boat-size-piece"></span>
                                    <span className="current-boat-size-piece"></span>
                                    <span className="current-boat-size-piece"></span>
                                </span>
                                <span className="current-boat-size-number">
                                    3
                                </span>
                            </div>

                            <div className="confirmation-area">

                                <Link to="/turnstatus">
                                    <button className="form-button">Fire!</button>
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
export default withRouter(MoveAim);