import React, { Component } from "react";
import { Link } from "react-router-dom";

import imagemMar from "../../public/images/imagem-mar.jpg";
import capivaraLogo from "../../public/images/CapivaraWars-logo.png";
import molduraBambu from "../../public/images/moldura-bambu.png";
import "./styles.css";

class GameScreen extends Component {
  render() {
    return (
      <div>
      <img src={imagemMar} className=" fundoAgua">
        {" "}
      </img>{" "}
      <img src={capivaraLogo} className=" logo">
        {" "}
      </img>
      <div className="canvasGame">
        <img src={molduraBambu} className=" bambu1">
          {" "}
        </img>{" "}
        <canvas
          id="myCanvas"
          width="200"
          height="100"
          style="border:1px solid #000000;"
        ></canvas>{" "}
      </div>
      </div>
    );
  }
}
