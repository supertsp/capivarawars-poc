import React, { Component } from "react";
import { Link } from "react-router-dom";

import imagemMar from "../../assets/images/imagem-mar.jpg";
import capivaraLogo from "../../assets/images/CapivaraWars-logo.png";
import "./styles.css";

class ResetPassword extends Component {
  render() {
    return (
      <div>
        <img src={imagemMar} className="background"></img>
        <div className="container container-reset">
          <div className="row">
            <div className="col-md-12">
              <img
                src={capivaraLogo}
                className="img-fluid img-thumbnail img-fluid-reset img-thumbnail-reset"
              ></img>
            </div>
          </div>
          <div className="row">
            <div className="col-md-12">
              <div className="card card-resertPassword">
                <div className="card-body card-body-reset"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default ResetPassword;
