import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";

import apiAuth from "../../services/apiAuth";

import imagemMar from "../../assets/images/imagem-mar.jpg";
import capivaraLogo from "../../assets/images/CapivaraWars-logo.png";
import gameOver from "../../assets/images/game-over.png";
import capivaraLoading from "../../assets/images/CapivaraLoading.png";

import "./styles.css";

class Victory extends Component{

render() {
    return (
    <div>
        <img src={imagemMar} alt={imagemMar} className="background"></img>
         <div className = "container container-victory">
            <div className="row">
                <div className="col-md-12">
              <img
                src={capivaraLogo}
                alt={capivaraLogo}
                className="img-fluid img-fluid-login img-thumbnail img-thumbnail-victory"
              ></img>
            </div>
          </div>
            <img
                src={victory}
                alt={victory}
                className="img-fluid img-fluid-login img-thumbnail img-victory-victory"
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

    export default withRouter(Victory);