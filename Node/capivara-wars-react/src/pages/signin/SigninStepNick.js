import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globlas & Tools
import Globals from "../../Globals";
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';

//Import GameCore
import Jogador from '../../gamecore/Jogador';

//Import Pages
import Header from '../components/Header';


class SigninStepNick extends Component {

    state = {
        formNick: ''
    }

    constructor(props) {
        super(props);
    }

    onChangeFormNick = (event) => {
        this.setState({ formNick: event.target.value })
    }

    render() {
        return (
            <div>
                <p>First enter your nick</p>

                <span className="form-input-text-field padding-bottom-1">
                    <label className="form-input-text-title" htmlFor="nick">Nick</label>
                    <input
                        className="form-input-text-original"
                        type="text"
                        name="nick"
                        value={this.state.formNick}
                        onChange={this.onChangeFormNick} />
                </span>

                {
                    this.props.nickErrorStatus === true &&
                    <span className="error-message display-block">Unfortunately this Nick does not Exist :(</span>
                }

                <span className="form-group-button">

                    <Link to="/">
                        <button className="form-button-back margin-left-right-3">back</button>
                    </Link>

                    <button
                        onClick={this.searchPlayerByNickOnApi}
                        className="form-button margin-left-right-3"
                        type="submit">
                        next
                    </button>

                </span>

            </div>
        );
    }
}

//export and allow redirect by "this.props.history"
export default withRouter(SigninStepNick);