import React, { Component } from "react";
import { Link } from "react-router-dom";

import "./styles.css";

import imagemMar from "../../assets/images/imagem-mar.jpg";
import capivaraLogo from "../../assets/images/CapivaraWars-logo.png";

class NumberPlayers extends Component {
    constructor(props) {
        super(props);

        this.state = {

        }
    }

    render() {
        return (
            <div>
                <img src={imagemMar} className="background"></img>
                <div className="container">
                    <div className=" logo-cap">
                        <img src={capivaraLogo} className="img-fluid img-thumbnail"></img>
                    </div>
                    <div className="card-num">
                        <div className="card-body">
                            <ul>
                                <li><button type="button" class="btn btn-primary">Adicionar</button></li>
                                <li>Número</li>
                                <li><button type="button" class="btn btn-primary">Retirar</button></li>
                                <button type="button" class="btn btn-primary botao-continuar">Continuar</button>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default NumberPlayers;