import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";

//Import Globlas & Tools
import Globals from "../../Globals";
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';

//Import GameCore
import Player from '../../gamecore/Player';

//Import Components
import Header from '../components/Header';


class Welcome extends Component {

    componentDidMount() {
        Notification.requestPermission().then(function (result) {
            console.log("Notification Permissons: " + result);
        });
    }

    spawnNotification = (theBody, theIcon, theTitle) => {
        var options = {
            body: theBody,
            icon: theIcon
        }
        var n = new Notification(theTitle, options);
        setTimeout(n.close.bind(n), 4000);
    }

    render() {
        return (
            <div>

                <Header />

                <div className="container-area-welcome">

                    <div className="capii-animation"></div>

                    <div className="container-bamboo-welcome">
                        <div className="container-bamboo-title">
                            <img src={require("../assets/images/borderbambootitle.svg")} alt="título da área de conteúdo" />
                            <span>Welcome</span>
                        </div>

                        {
                            this.spawnNotification(
                                "Capivara Wars presents: :)",
                                "../ assets / images / borderbambootitle.svg",
                                "Capivara Wars"
                            )
                        }

                        <div className="container-bamboo-border">
                            <form className="container-bamboo-bg-color text-center padding-bottom-1">
                                <p>Choose your Side in this War!</p>

                                <span className="form-group-button">
                                    <Link to="/register">
                                        <button className="form-button margin-left-right-1">register</button>
                                    </Link>

                                    <Link to="/signin">
                                        <button className="form-button-confirm margin-left-right-1">sign in</button>
                                    </Link>
                                </span>
                            </form>
                        </div>
                    </div>

                </div>

            </div>
        );
    }
}

//export and allow redirect by "this.props.history"
export default withRouter(Welcome);
