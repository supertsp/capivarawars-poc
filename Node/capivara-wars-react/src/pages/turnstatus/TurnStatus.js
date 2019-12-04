import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globals
import Globals from '../../Globals';

//Import Pages


class TurnStatus extends Component {

    render() {

        Globals.criarPartida();

        return (
            <div className="geral mainBackground">
                TurnStatus
            </div>
        );
    }
}

//export and allow redirect by "this.props.history"
export default withRouter(TurnStatus);