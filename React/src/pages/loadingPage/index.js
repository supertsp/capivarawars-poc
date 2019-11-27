import React, { Component } from "react";
import { Redirect } from "react-router-dom";

import imagemMar from "../../assets/images/imagem-mar.jpg";
import capivaraLogo from "../../assets/images/CapivaraWars-logo.png";
import capivaraLoading from "../../assets/images/CapivaraLoading.png";

import "./styles.css";

class Loading extends Component {
  constructor(props) {
    super(props);

    this.state = {
      time: 5,
      redirect: false
    };
  }

  componentDidMount() {
    this.timer();
  }

  timer = () => {
    let { time } = this.state;
    setInterval(() => {
      if (time > 0) {
        this.setState({ time: time-- });
      } else {
        time = 0;
        this.setState({ redirect: true });
      }
    }, 1000);
  };

  renderRedirect = () => {
    if (this.state.redirect) {
      return <Redirect to="/game" />;
    }
  };

  render() {
    const { time } = this.state;

    return (
      <div>
        {this.renderRedirect()}
        <img src={imagemMar} alt={imagemMar} className="background"></img>
        <div className="container container-loading">
          <div className="row">
            <div className="col-md-12">
              <img
                src={capivaraLogo}
                alt={capivaraLogo}
                className="img-fluid img-fluid-loading img-thumbnail img-thumbnail-loading"
              ></img>
            </div>
          </div>
          <div className="row">
            <div className="col-md-12">
              <div className="card">
                <div className="card-body card-body-loading">
                  <h1 id="time" className="align-timer">
                    {time}
                  </h1>
                  <img
                    src={capivaraLoading}
                    alt={capivaraLoading}
                    className="img-fluid img-fluid-capLoading"
                  ></img>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Loading;
