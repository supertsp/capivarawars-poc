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

class MoveBoat extends Component {

    render() {

        Globals.criarPartida();

        return (
            <div>

                <Header />

                <div className="container-area-moveboat">

                    <div className="container-bamboo-title">
                        <img src={require('../assets/images/borderbambootitle.svg')} alt="título da área de conteúdo" />
                        <span>Move</span>
                    </div>

                    <div className="container-bamboo-border">
                        <form className="container-bamboo-bg-color text-center padding-bottom-1">

                            <p>Choose a new position for your boat! <br />
                                Come on! Move! Move! Move!!!</p>

                            <div className="boat-area">

                                <input type="button" className="form-button-back" value="-" />

                                <span className="boat-area-all-pieces">
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="0" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="1" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="2" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="3" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="4" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="5" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="6" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="7" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="8" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                    <label className="boat-area-piece">
                                        <input type="radio" name="chosenMovement" value="9" />
                                        <span className="boat-area-piece-box"></span>
                                    </label>
                                </span>

                                <input type="button" className="form-button-back" value="+" />
                            </div>

                            <div className="statistics-area">
                                <div className="statistics-area-title">Your Boat Status</div>
                                <span className="current-boat-size">
                                    <span className="current-boat-size-piece"></span>
                                    <span className="current-boat-size-piece"></span>
                                    <span className="current-boat-size-piece"></span>
                                    <span className="current-boat-size-piece"></span>
                                </span>
                                <span className="current-boat-size-number">
                                    4
                                </span>
                            </div>

                            <div className="confirmation-area">

                                <Link to="/moveaim">
                                    <button className="form-button">Move!</button>
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
export default withRouter(MoveBoat);