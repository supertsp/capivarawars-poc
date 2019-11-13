import React, { Component } from "react";
import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faMinus, faPlus } from "@fortawesome/free-solid-svg-icons";

import "./styles.css";

import imagemMar from "../../assets/images/imagem-mar.jpg";
import capivaraLogo from "../../assets/images/CapivaraWars-logo.png";

class NumberPlayers extends Component {
  constructor(props) {
    super(props);

    this.state = {
      numberPlayers: 2
    };

    this.valuePlus = () => {
      this.setState({numberPlayers: this.state.numberPlayers + 1});
    };

    this.valueMin = () => {
      if (this.state.numberPlayers > 2) {
        this.setState({numberPlayers: this.state.numberPlayers - 1});
      }
    };
  }

  render() {

    const { numberPlayers } = this.state

    return (
      <div>
        <img src={imagemMar} className="background"></img>
        <div className="container">
          <div className="container">
            <div className="row">
              <img
                src={capivaraLogo}
                className="img-fluid img-fluid-num img-thumbnail img-thumbnail-num"
              ></img>
            </div>
            <div className="row">
              <div className="col-md-12">
                <div className="card">
                  <div className="card-body card-body-num">
                    <div className="row">
                      <FontAwesomeIcon
                        icon={faMinus}
                        onClick={this.valueMin}
                        className="number"
                      ></FontAwesomeIcon>
                      <h1 className="number">{numberPlayers}</h1>
                      <FontAwesomeIcon
                        icon={faPlus}
                        onClick={this.valuePlus}
                        className="number"
                      ></FontAwesomeIcon>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default NumberPlayers;
