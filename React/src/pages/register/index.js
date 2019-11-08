import React, {Component} from "react";
import {Link} from "react-router-dom";

import imagemMar from "../../assets/images/imagem-mar.jpg";
import capivaraLogo from "../../assets/images/CapivaraWars-logo.png";
import "./styles.css";

class Register extends Component {
  render() {
    return (
      <div>
        <img src={imagemMar} className=" fundoAgua"></img>
        <img src={capivaraLogo} className=" logo"></img>
        <div>
          <div className="container  container1">
            <div className="card card1">
              <div className="card-body">
                <div className="row nome01">
                  <div className="col">
                    <div className="form-group">
                      <label htmlFor="name1" className=" texto corText texto">
                        Insira seu nome completo
                      </label>
                      <input
                        type="text"
                        className="form-control"
                        id="name1"
                        placeholder="Nome completo"
                      ></input>
                    </div>
                  </div>
                  <div className="col">
                    <div className="form-group">
                      <label
                        htmlFor="example-date-input"
                        className="texto corText texto"
                      >
                        Data de nascimento
                      </label>
                      <input
                        className="form-control"
                        type="date"
                        value="2011-08-19"
                        id="example-date-input"
                      ></input>
                    </div>
                  </div>
                </div>
              </div>
              <div className="row nickName">
                <div className="col">
                  <div className="form-group">
                    <label htmlFor="nickName1" className=" texto corText texto">
                      Nick name do jogador
                    </label>
                    <input
                      type="text"
                      className="form-control"
                      id="nickName1"
                      placeholder="Nick name"
                    ></input>
                  </div>
                </div>
                <div className="col">
                  <div className="form-group">
                    <label
                      htmlFor="example-email-input"
                      className=" corText texto">
                      Digite seu E - mail
                    </label>
                    <input
                      className="form-control"
                      type="text"
                      placeholder="capivara@canoa.com"
                      id="example-email-input"
                    ></input>
                  </div>
                </div>
              </div>
            </div>
            <div className="row senha">
              <div className="col">
                <div className="form-group">
                  <label htmlFor="nickName1" className=" texto corText texto">
                    Senha
                  </label>
                  <input
                    type="password"
                    className="form-control"
                    id="senha1"
                    placeholder="Senha"
                  ></input>
                </div>
              </div>
              <div className="col">
                <div className="form-group">
                  <label
                    htmlFor="example-email-input"
                    className="texto corText texto"
                  >
                    Confirme sua senha
                  </label>
                  <input
                    className="form-control"
                    type="password"
                    placeholder="Confirme sua senha"
                    id="confirmeSenha"
                  ></input>
                </div>
              </div>
            </div>
            <div>
              <div className="row sexo">
                <div className="col">
                  <div className="form-check">
                    <label htmlFor="example-email-input" className="texto corText">
                      Informe seu sexo
                    </label>
                    <input
                      className="form-check-input radio1 "
                      type="radio"
                      name="exampleRadios"
                      id="exampleRadios1"
                      value="option1"
                      checked
                    ></input>
                    <label
                      className="form-check-label radio1"
                      htmlFor="exampleRadios1"
                    >
                      Masculino
                    </label>
                  </div>
                  <div className="form-check">
                    <input
                      className="form-check-input"
                      type="radio"
                      name="exampleRadios"
                      id="exampleRadios2"
                      value="option2"
                    ></input>
                    <label className="form-check-label" htmlFor="exampleRadios2">
                      Feminino
                    </label>
                  </div>
                </div>
                <div className="col foto">
                  <div>
                    <div>
                      <label htmlFor="exampleFormControlFile1" className=" escolha-foto">
                        Escolha sua foto
                      </label>
                      <input
                        type="file"
                        className="form-control-file "
                        id="exampleFormControlFile1"
                      ></input>
                    </div>
                  </div>
                </div>
              </div>
              <button
                type="submit"
                className="btn btn-primary cadastro"
              >
                <Link to={'../login'}  className=" corFonte"></Link>
                Finalizar cadastro
              </button>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Register;
