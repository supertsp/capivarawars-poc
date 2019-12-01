import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";

import apiAuth from "../../services/apiAuth";

import imagemMar from "../../assets/images/imagem-mar.jpg";
import capivaraLogo from "../../assets/images/CapivaraWars-logo.png";
import gameOver from "../../assets/images/game-over.png";
import capivaraLoading from "../../assets/images/CapivaraLoading.png";

import "./styles.css";

class Lose extends Component{

render() {
    return (
    <div>
        <img src={imagemMar} alt={imagemMar} className="background"></img>
         <div className = "container container-lose">
            <div className="row">
                <div className="col-md-12">
              <img
                src={capivaraLogo}
                alt={capivaraLogo}
                className="img-fluid img-fluid-login img-thumbnail img-thumbnail-lose"
              ></img>
            </div>
          </div>
            <img
                src={gameOver}
                alt={gameOver}
                className="img-fluid img-fluid-login img-thumbnail img-gameOver-lose"
            ></img>
            <img
                src={capivaraLoading}
                alt={capivaraLoading}
                className="img-fluid img-fluid-capLoading"
                ></img>
            </div>
        </div>
    );
    }
        }

    export default withRouter(Lose);