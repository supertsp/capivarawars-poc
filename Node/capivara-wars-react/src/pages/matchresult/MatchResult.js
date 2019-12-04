import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globals
import Globals from '../../Globals';

//Import Pages


class MatchResult extends Component {

    render() {

        Globals.criarPartida();

        return (
            <div className="geral mainBackground">
                MatchResult
            </div>
        );
    }
}

//export and allow redirect by "this.props.history"
export default withRouter(MatchResult);