import React, { Component } from "react";

import imagemMar from "../../assets/images/imagem-mar.jpg";
import imgLogo from "../../assets/images/CapivaraWars-logo.png";
import imgPlayer from "../../assets/images/capii-spy-silencio-01_1080x1590.png";

import "./styles.css";
class Game extends Component {
  constructor(props) {
    super(props);

    this.state = {
      boat: [1, 2, 3, 4, 0, 0, 0, 0, 0, 0],
      boatVisible: true
    };
  }

  componentDidMount() {
    this.printBoat();
    console.log('document: ', document.querySelector('table'))
  }

  printBoat = () => {
    for (let i = 0; i < this.state.boat.length; i++) {
      if (this.state.boat[i] !== 0) {
        
      }
    }
  };

  boatMovimentLeft = () => {};

  render() {
    return (
      <div>
        <img src={imagemMar} className="background"></img>
        <div className="container">
          <div className="row">
            <div className="col-md-4">
              <img
                src={imgLogo}
                className="img-fluid img-thumbnail img-options"
              ></img>
            </div>
            <div className="col-md-8">
              <ul className="components">
                <li>
                  <img
                    src={imgPlayer}
                    className="img-fluid img-thumbnail img-player"
                  ></img>
                </li>
                <li>1000 pontos</li>
              </ul>
            </div>
          </div>
          <div className="row">
            <div className="col-md-12">
              <div className="card">
                <div className="card-body card-body-game">
                  <table>
                    <tbody>
                      <tr>
                        <td id="boat1" className={'boat'}>
                          1
                        </td>
                        <th id="boat2" className="boat">
                          2
                        </th>
                        <th id="boat3" className="boat">
                          3
                        </th>
                        <th id="boat4" className="boat">
                          4
                        </th>
                        <th id="boat5" className="boat">
                          5
                        </th>
                        <th id="boat6" className="boat">
                          6
                        </th>
                        <th id="boat7" className="boat">
                          7
                        </th>
                        <th id="boat8" className="boat">
                          8
                        </th>
                        <th id="boat9" className="boat">
                          9
                        </th>
                        <th id="boat10" className="boat">
                          10
                        </th>
                      </tr>
                    </tbody>
                  </table>
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
