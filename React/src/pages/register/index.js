import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";

import apiAuth from "../../services/apiAuth";

import imagemMar from "../../assets/images/imagem-mar.jpg";
import capivaraLogo from "../../assets/images/CapivaraWars-logo.png";
import "./styles.css";

class Register extends Component {
  constructor(props) {
    super(props);

    this.state = {
      nick: "",
      password: "",
      email: "",
      avatarUrl: "...",
      fullName: "",
      gender: "",
      birthday: "",
      errorMessage: ""
    };
  }

  handleChange = (event) => {
    const state = Object.assign({}, this.state);
    let field = event.target.id;
    state[field] = event.target.value;

    this.setState(state);
  };

  validateForm = async (state) => {
    if (
      this.state.nick !== "" &&
      this.state.password !== "" &&
      this.state.email !== "" &&
      this.state.fullName !== "" &&
      this.state.birthday
    ) {
      return await true;
    }

    return await false;
  };

  Register = async () => {
    try {
      if (this.validateForm(this.state)) {
        const response = await apiAuth.post("/api/v1/playerservice/player", {
          nick: this.state.nick,
          password: this.state.password,
          email: this.state.email,
          avatarUrl: "...",
          fullName: this.state.fullName,
          gender: this.state.gender,
          birthday: this.state.birthday
        });

        if (response.status === 200) {
          this.props.history.push("/");
        }
      }
    } catch (response) {
      this.setState({ errorMessage: "Erro ao tentar cadastrar" });
    }
  };

  render() {
    return (
      <div>
        <img src={imagemMar} alt={imagemMar} className="background"></img>
        <div className="container container-register">
          <div className="row">
            <div className="col-md-12">
              <Link to={"/"}>
                <img
                  src={capivaraLogo}
                  alt={capivaraLogo}
                  className="img-fluid img-thumbnail img-fluid-register img-thumbnail-register"
                ></img>
              </Link>
            </div>
          </div>
          <div className="row">
            <div className="card card-register">
              <div className="card-body card-body-register">
                <div className="row">
                  <div className="col-md-6">
                    <div className="form-group">
                      <label for="name">Insira seu nome completo:</label>
                      <input
                        type="text"
                        className="form-control"
                        id="fullName"
                        placeholder="Nome completo"
                        onChange={(evt) => this.handleChange(evt)}
                      ></input>
                    </div>
                    <div className="form-group">
                      <label for="nick">Nickname do jogador:</label>
                      <input
                        type="text"
                        className="form-control"
                        id="nick"
                        placeholder="nick"
                        onChange={(evt) => this.handleChange(evt)}
                      ></input>
                    </div>
                    <div className="form-group">
                      <label for="password">Senha:</label>
                      <input
                        type="password"
                        className="form-control"
                        id="password"
                        placeholder="senha"
                        onChange={(evt) => this.handleChange(evt)}
                      ></input>
                    </div>
                    <div className="form-group">
                      <label>Informe seu sexo:</label>
                      <div className="form-check">
                        <input
                          className="form-check-input"
                          id="gender"
                          type="radio"
                          name="gender"
                          value="m"
                          onChange={(evt) => this.handleChange(evt)}
                        ></input>
                        <label className="form-check-label" for="male">
                          Masculino
                        </label>
                      </div>
                      <div className="form-check">
                        <input
                          className="form-check-input"
                          id="gender"
                          type="radio"
                          name="gender"
                          value="f"
                          onChange={(evt) => this.handleChange(evt)}
                        ></input>
                        <label className="form-check-label" for="female">
                          Feminino
                        </label>
                      </div>
                    </div>
                  </div>
                  <div className="col-md-6">
                    <div className=" input-data">
                      <label
                        htmlFor="example-date-input"
                        class="col-2 col-form-label"
                      >
                      Data Nasc.
                      </label>
                      <input
                        class="form-control"
                        type="date"
                        id="birthday"
                        placeholder="01/12/2019"
                        onChange={(evt) => this.handleChange(evt)}
                      ></input>
                    </div>
                    <div className=" input-email">
                      <label
                        htmlFor="email"
                        class="col-2 col-form-label"
                      >
                        Email
                      </label>
                      <input
                        class="form-control"
                        type="email"
                        id="email"
                        placeholder="capivara@canoa.com"
                        onChange={(evt) => this.handleChange(evt)}
                      ></input>
                    </div>
                    <div className=" input-confirm-senha">
                      <label for="password">Confirm sua senha:</label>
                      <input
                        type="password"
                        className="form-control"
                        id="password"
                        placeholder="Confirme sua senha"
                        onChange={(evt) => this.handleChange(evt)}
                      ></input>
                    </div>
                    <div className="botao-cadastrar">
                      <input
                        type="submit"
                        class="btn btn-primary"
                        value="Confirmar cadastro"
                        onClick={this.Register}
                      ></input>
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

export default withRouter(Register);
