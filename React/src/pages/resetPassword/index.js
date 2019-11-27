import React, { Component } from "react";
import { Link } from "react-router-dom";

import imagemMar from "../../assets/images/imagem-mar.jpg";
import capivaraLogo from "../../assets/images/CapivaraWars-logo.png";
import "./styles.css";

class ResetPassword extends Component {
  render() {
    return (
      <div>
        <img src={imagemMar} alt={imagemMar} className="background"></img>
        <div className="container container-reset">
          <div className="row">
            <div className="col-md-12">
              <Link to={"/"}>
                <img
                  src={capivaraLogo}
                  alt={capivaraLogo}
                  className="img-fluid img-thumbnail img-fluid-reset img-thumbnail-reset"
                ></img>
              </Link>
            </div>
          </div>
          <div className="row">
            <div className="col-md-12">
              <div className="card card-reset">
                <div className="card-body card-body-reset">
                  <div className="container">
                    <div className="row">
                      <div className="col-md-12">
                        <div className="form-group">
                          <label for="">
                            Perdeu sua senha, digite seu e-mail abaixo:
                          </label>
                        </div>
                      </div>
                    </div>
                    <div className="row">
                      <div className="col-md-12">
                        <div className="form-group">
                          <input type="text" className="form-control" name=""></input>
                        </div>
                      </div>
                    </div>
                    <div className="row">
                      <div className="col-md-12">
                        <input
                          type="submit"
                          className="btn btn-primary"
                        ></input>
                      </div>
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

export default ResetPassword;
