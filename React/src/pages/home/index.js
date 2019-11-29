import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";

import api from "../../services/apiAuth";

import "./styles.css";

import imgLogo from "../../assets/images/CapivaraWars-logo.png";
import imgPlayer from "../../assets/images/user.jpg";
import imgJoy from "../../assets/images/joystick.jpeg";
import imgCapivara from "../../assets/images/capii-spy-silencio-01_1080x1590.png";
import imgCoracao from "../../assets/images/coracao.png";

class Home extends Component {
  logout = async () => {
    const response = await api.post(
      `/api/v1/playerservice/logout/${localStorage.getItem("user")}`
    );
    if (response.status === 200) {
      localStorage.removeItem("user");
      this.props.history.push("/");
    }
  };

  render() {
    return (
      <div>
        <div className="container">
          <div className="row">
            <div className="col-md-4">
              <img
                src={imgLogo}
                alt={imgLogo}
                className="img-fluid img-thumbnail img-options"
              ></img>
            </div>
            <div className="col-md-8">
              <ul className="components">
                <li>
                  <img
                    src={imgPlayer}
                    alt={imgPlayer}
                    className="img-fluid img-thumbnail img-player"
                  ></img>
                </li>
                <li>1000 pontos</li>
                <li>
                  <input
                    type="submit"
                    className="btn btn-primary"
                    value="Logout"
                    onClick={this.logout}
                  ></input>
                </li>
              </ul>
            </div>
          </div>
          <div className="row">
            <div className="col-md-8">
              <div className="card card-options">
                <div className="card-body">Teste</div>
              </div>
            </div>
            <div className="col-md-4">
              <div className="card card-options">
                <div className="card-body">
                  <img
                    src={imgCapivara}
                    alt={imgCapivara}
                    className="img-fluid img-thumbnail img-thumbnail-login img-capi"
                  ></img>
                </div>
              </div>
            </div>
          </div>
          <div className="row">
            <div className="col-md-8">
              <div className="card card-options">
                <div className="card-body">
                  <Link to={"/loading"}>
                    <img
                      src={imgJoy}
                      alt={imgJoy}
                      className="img-fluid img-thumbnail img-thumbnail-login img-joy"
                    ></img>
                  </Link>
                </div>
              </div>
            </div>
            <div className="col-md-4">
              <div className="card card-options">
                <div className="card-body">
                  <ul>
                    <li className="list-pts">
                      <img
                        src={imgCoracao}
                        alt={imgCoracao}
                        className="img-fluid img-coracao"
                      ></img>
                    </li>
                    <li className="list-pts">
                      <label>HP: 7pts</label>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default withRouter(Home);
