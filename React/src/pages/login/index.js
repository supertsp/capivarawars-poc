import React, { Component } from "react";
import { Link } from "react-router-dom";

import imagemMar from "../../public/images/imagem-mar.jpg";
import capivaraLogo from "../../public/images/CapivaraWars-logo.png";
import molduraBambu from "../../public/images/moldura-bambu.png"

import "./styles.css";

class Login extends Component {
  render() {
    return (
      <div>
        <img src={imagemMar} className=" fundoAgua"></img>
        <div className=" imagemCap"></div>

        <div>
          <img src={capivaraLogo} className=" Imagem"></img>

          <div className="container pag1">
            <img src={molduraBambu} className=" bambu"></img>
            <div className="card pag4">
              <div className="card-body">
                <div className="form-group">
                  <label for="nickName1" className=" texto corText">
                    Digite seu Nick name
                  </label>
                  <input
                    type="name"
                    className="form-control"
                    id="nickName1"
                    placeholder="Nick name"
                  ></input>
                </div>

                <div className="form-group">
                  <label for="senha1" className=" texto corText">
                    Digite sua senha
                  </label>
                  <input
                    type="password"
                    className="form-control"
                    id="senha1"
                    placeholder="Senha"
                  ></input>
                  <button type="submit" className="btn btn-primary pag2">
                    Login
                  </button>
                </div>

                <div className="form-group">
                  <small id="emailHelp" className="form-text text-muted ">
                    Não tem uma conta? Então clieque no botão cadastrar.
                  </small>
                  <button type="submit" className="btn btn-primary pag3">
                    Cadastrar
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Login;
