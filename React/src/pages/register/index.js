import React, {Component} from "react";
import {Link} from "react-router-dom";

import imagemMar from "../../assets/images/imagem-mar.jpg";
import capivaraLogo from "../../assets/images/CapivaraWars-logo.png";
import "./styles.css";

class Register extends Component {
  render() {
    return (
      <div>
        <img src={imagemMar} className="background"></img>
        <div className="container container-register">
          <div className="row">
            <div className="col-md-12">
              <img src={capivaraLogo} className="img-fluid img-thumbnail img-fluid-register img-thumbnail-register"></img>
            </div>
          </div>
          <div className="row">
            <div className="card card-register">
              <div className="card-body card-body-register">
                <div className="row">
                  <div className="col-md-6">
                    <div className="form-group">
                      <label for="name">Insira seu nome completo:</label>
                      <input type="text" className="form-control" id="name" placeholder="Nome completo"></input>
                    </div>
                    <div className="form-group">
                      <label for="nick">Nickname do jogador</label>
                      <input type="text" className="form-control" id="nick" placeholder="nickname"></input>
                    </div>
                    <div className="form-group">
                      <label for="password">Senha:</label>
                      <input type="password" className="form-control" id="password" placeholder="senha"></input>
                    </div>
                    <div className="form-group">
                      <label>informe seu sexo:</label>
                      <div className="form-check">
                        <input className="form-check-input" type="radio" name="sex"></input>
                        <label className="form-check-label" for="male">Masculino</label>
                      </div>
                      <div className="form-check">
                        <input className="form-check-input" type="radio" name="sex"></input>
                        <label className="form-check-label" for="female">Feminino</label>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-6">
                    
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

export default Register;