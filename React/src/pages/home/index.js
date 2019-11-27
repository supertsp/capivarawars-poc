import React, { Component } from "react";
import { Link } from "react-router-dom";

import "./styles.css";

import imgLogo from "../../assets/images/CapivaraWars-logo.png";
import imgPlayer from "../../assets/images/capii-spy-silencio-01_1080x1590.png";

class Home extends Component {
  render() {
    return (
      <div>
        <div className="container">
          <div className="row">
            <div className="col-md-4">
              <img
                src={imgLogo}
                alt={imgLogo}
                className="img-fluid img-thumbnail img-options"
              ></img>
            </div>
            <div className="col-md-8">
              <ul className="components">
                <li>
                  <img
                    src={imgPlayer}
                    alt={imgPlayer}
                    className="img-fluid img-thumbnail img-player"
                  ></img>
                </li>
                <li>1000 pontos</li>
              </ul>
            </div>
          </div>
          <div className="row">
            <div className="col-md-8">
              <div className="card card-options">
                <div className="card-body">Teste</div>
              </div>
            </div>
            <div className="col-md-4">
              <div className="card card-options">
                <div className="card-body">Teste</div>
              </div>
            </div>
          </div>
          <div className="row">
            <div className="col-md-8">
              <div className="card card-options">
                <div className="card-body">Teste</div>
              </div>
            </div>
            <div className="col-md-4">
              <div className="card card-options">
                <div className="card-body">Teste</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Home;
