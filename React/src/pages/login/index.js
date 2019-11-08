import React, { Component } from "react";

import imagemMar from "../../assets/images/imagem-mar.jpg";
import capivaraLogo from "../../assets/images/CapivaraWars-logo.png";

import "./styles.css";

class Login extends Component {
  constructor(props) {
    super(props);

    this.state = {
      nick: '',
      password: ''
    }
  }

  handleChange = (event) => {
    const state = Object.assign({}, this.state);
    let field = event.target.id;
    state[field] = event.target.value;

    this.setState(state);
  }

  validateForm = (state) => {
    if(this.state.name !== '' || this.state.name != null && 
      this.state.password !== '' || this.state.password != null){
        return true;
      }

    return false;
  }

  render() {
    console.log(this.state)
    return (
      <div>
        <img src={imagemMar} className="background"></img>
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <img src={capivaraLogo} className="img-fluid img-thumbnail"></img>
            </div>
          </div>
          <div className="row">
            <div className="col-md-12">
              <div className="card">
                <div className="card-body">
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
                      className="btn btn-primary"
                      value="Login"
                    ></input>
                  </div>
                  <label>Não tem uma conta? Então clique em cadastrar</label>
                  <div>
                    <button className="btn btn-primary">Cadastrar</button>
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

export default Login;
