import React, { Component } from "react";
import { Link } from "react-router-dom";

import imagemMar from "../../assets/images/imagem-mar.jpg";
import imgLogo from "../../assets/images/CapivaraWars-logo.png";
import imgPlayer from "../../assets/images/capii-spy-silencio-01_1080x1590.png";

import "./styles.css";

class Game extends Component {
  constructor(props) {
    super(props);
    this.state = {
      boat: [1, 2, 3, 4, 0, 0, 0, 0, 0, 0],
      shoot: [1, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    };
  }

  handleClick(value) {
    if (value === "back") {
      if (this.state.boat[0] === 0) {
        this.state.boat.push(0);
        this.state.boat.shift();
        this.setState({ boat: this.state.boat });
      }
    }
    if (value === "next") {
      if (this.state.boat[this.state.boat.length - 1] !== 4) {
        this.state.boat.unshift(0);
        this.state.boat.pop();
        this.setState({ boat: this.state.boat });
      }
    }
  }

  render() {
    return (
      <div>
        <img src={imagemMar} alt={imagemMar} className="background" />
        <div className="container">
          <div className="row">
            <div className="col-md-4">
              <img
                src={imgLogo}
                alt={imgLogo}
                className="img-fluid img-thumbnail img-options"
              />
            </div>
            <div className="col-md-8">
              <ul className="components">
                <li>
                  <img
                    src={imgPlayer}
                    alt={imgPlayer}
                    className="img-fluid img-thumbnail img-player"
                  />
                </li>
                <li>1000 pontos</li>
              </ul>
            </div>
          </div>
          <div className="row">
            <div className="col-md-12">
              <div className="card">
                <div className="card-body card-body-game">
                  <ul className="card-body-game-list">
                    {this.state.boat.map((item, index) => (
                      <li
                        key={index}
                        className={item !== 0 ? "boat" : "water"}
                      ></li>
                    ))}
                  </ul>

                  <button
                    className="btn btn-primary mt-2 mr-2"
                    onClick={(e) => this.handleClick("back", e)}
                  >
                    Back
                  </button>
                  <button
                    className="btn btn-success mt-2"
                    onClick={(e) => this.handleClick("next", e)}
                  >
                    Next
                  </button>
                  <button className="btn btn-warning mt-2 shootBtn">
                      Mover
                  </button>
                  <Link to="/lose" className="btn btn-danger mt-2 loseBtn">
                      Desistir
                  </Link>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Game;
