import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";

import apiAuth from "../../services/apiAuth";

import imagemMar from "../../assets/images/imagem-mar.jpg";
import capivaraLogo from "../../assets/images/CapivaraWars-logo.png";

import "./styles.css";

class Login extends Component {
  constructor(props) {
    super(props);

    this.state = {
      nick: "",
      password: "",
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
    if (this.state.name !== "" && this.state.password !== "") {
      return await true;
    }
    return await false;
  };

  signIn = async () => {
    try {
      if (this.validateForm(this.state)) {
        const user = await apiAuth.get(`/api/v1/playerservice/player/nick/${this.state.nick}`);

        const response = await apiAuth.post("/api/v1/playerservice/login", {
          nick: this.state.nick,
          password: this.state.password
        });

        console.log(user)
        
        if (response.status === 200) {
          localStorage.setItem('user', user.data.idPlayer)
          this.props.history.push("/home");
        }
      }
    } catch (response) {
      console.log(response);
      this.setState({ errorMessage: "Erro ao tentar acessar" });
    }
  };

  render() {
    console.log(this.state);
    return (
      <div>
        <img src={imagemMar} alt={imagemMar} className="background"></img>
        <div className="container container-login">
          <div className="row">
            <div className="col-md-12">
              <img
                src={capivaraLogo}
                alt={capivaraLogo}
                className="img-fluid img-fluid-login img-thumbnail img-thumbnail-login"
              ></img>
            </div>
          </div>
          <div className="row">
            <div className="col-md-12">
              <div className="card">
                <div className="card-body card-body-login">
                  <div className="form-group">
                    <label for="nick">Digite seu nickname:</label>
                    <input
                      onChange={(evt) => this.handleChange(evt)}
                      type="text"
                      className="form-control"
                      id="nick"
                      placeholder="nickname"
                    ></input>
                  </div>
                  <div className="form-group">
                    <label for="password">Digite sua senha:</label>
                    <input
                      onChange={(evt) => this.handleChange(evt)}
                      type="password"
                      className="form-control"
                      id="password"
                      placeholder="senha"
                    ></input>
                  </div>
                  <div className="form-group">
                    <input
                      type="submit"
                      className="btn btn-primary botao-login"
                      value="Login"
                      onClick={this.signIn}
                    ></input>
                  </div>
                  <label>Não tem uma conta? Então clique em cadastrar</label>
                  <div>
                    <Link
                      className="btn btn-primary botao-cadastro"
                      to={"/register"}
                    >
                      Cadastrar
                    </Link>
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

export default withRouter(Login);
