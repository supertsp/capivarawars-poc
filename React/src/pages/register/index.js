import React, {Component} from "react";
import {Link} from "react-router-dom";

import imagemMar from "../../public/images/imagem-mar.jpg";
import capivaraLogo from "../../public/images/CapivaraWars-logo.png";
import molduraBambu from "../../public/images/moldura-bambu.png";
import "./styles.css";

class Register extends Component {
  render() {
    return (
      <div>
        <img src={imagemMar} className=" fundoAgua">
          {" "}
        </img>{" "}
        <img src={capivaraLogo} className=" logo">
          {" "}
        </img>
        <div>
          <div className="container  container1">
            <img src={molduraBambu} className=" bambu1">
              {" "}
            </img>{" "}
            <div className="card card1">
              <div className="card-body">
                <div className="row nome01">
                  <div className="col">
                    <div className="form-group">
                      <label for="name1" className=" texto corText texto">
                        Insira seu nome completo{" "}
                      </label>{" "}
                      <input
                        type="name"
                        className="form-control"
                        id="name1"
                        placeholder="Nome completo"
                      ></input>{" "}
                    </div>{" "}
                  </div>{" "}
                  <div className="col">
                    <div className="form-group">
                      <label
                        for="example-date-input"
                        className="texto corText texto"
                      >
                        Data de nascimento{" "}
                      </label>{" "}
                      <input
                        className="form-control"
                        type="date"
                        value="2011-08-19"
                        id="example-date-input"
                      ></input>{" "}
                    </div>{" "}
                  </div>{" "}
                </div>{" "}
              </div>{" "}
              <div className="row nickName">
                <div className="col">
                  <div className="form-group">
                    <label for="nickName1" className=" texto corText texto">
                      Nick name do jogador{" "}
                    </label>{" "}
                    <input
                      type="name"
                      className="form-control"
                      id="nickName1"
                      placeholder="Nick name"
                    ></input>{" "}
                  </div>{" "}
                </div>{" "}
                <div className="col">
                  <div className="form-group">
                    <label
                      for="example-email-input"
                      className="texto corText texto"
                    >
                      Digite seu E - mail{" "}
                    </label>{" "}
                    <input
                      className="form-control"
                      type="email"
                      placeholder="capivara@canoa.com"
                      id="example-email-input"
                    ></input>{" "}
                  </div>{" "}
                </div>{" "}
              </div>{" "}
            </div>{" "}
            <div className="row senha">
              <div className="col">
                <div className="form-group">
                  <label for="nickName1" className=" texto corText texto">
                    Senha{" "}
                  </label>{" "}
                  <input
                    type="password"
                    className="form-control"
                    id="senha1"
                    placeholder="Senha"
                  ></input>{" "}
                </div>{" "}
              </div>{" "}
              <div className="col">
                <div className="form-group">
                  <label
                    for="example-email-input"
                    className="texto corText texto"
                  >
                    Confirme sua senha{" "}
                  </label>{" "}
                  <input
                    className="form-control"
                    type="password"
                    placeholder="Confirme sua senha"
                    id="confirmeSenha"
                  ></input>{" "}
                </div>{" "}
              </div>{" "}
            </div>{" "}
            <div>
              <div className="row sexo">
                <div className="col">
                  <div className="form-check">
                    <label for="example-email-input" className="texto corText">
                      Informe seu sexo{" "}
                    </label>{" "}
                    <input
                      className="form-check-input radio1 "
                      type="radio"
                      name="exampleRadios"
                      id="exampleRadios1"
                      value="option1"
                      checked
                    ></input>{" "}
                    <label
                      className="form-check-label radio1"
                      for="exampleRadios1"
                    >
                      Masculino{" "}
                    </label>{" "}
                  </div>{" "}
                  <div className="form-check">
                    <input
                      className="form-check-input"
                      type="radio"
                      name="exampleRadios"
                      id="exampleRadios2"
                      value="option2"
                    ></input>{" "}
                    <label className="form-check-label" for="exampleRadios2">
                      Feminino{" "}
                    </label>{" "}
                  </div>{" "}
                </div>{" "}
                <div className="col foto">
                  <div>
                    <div>
                      <label for="exampleFormControlFile1" className="">
                        Escolha uma foto sua{" "}
                      </label>{" "}
                      <input
                        type="file"
                        className="form-control-file "
                        id="exampleFormControlFile1"
                      ></input>{" "}
                    </div>{" "}
                  </div>{" "}
                </div>{" "}
              </div>{" "}
              <button
                type="submit"
                className="btn btn-primary botaoSub cadastro"
              >
                Finalizar cadastro{" "}
              </button>{" "}
            </div>{" "}
          </div>{" "}
        </div>{" "}
      </div>
    );
  }
}

export default Register;
