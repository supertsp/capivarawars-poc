import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globlas & Tools
import Globals from "../../Globals";
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';

//Import GameCore
import Player from '../../gamecore/Jogador';

//Import Pages
import Header from '../components/Header';


class SigninStepPass extends Component {

    state = {
        formPassword: ''
    }

    constructor(props) {
        super(props);
    }

    onChangeFormPassword = (event) => {
        this.setState({ formPassword: event.target.value });
    }

    render() {
        return (
            <div>
                <p>Now enter your password</p>

                <span className="form-input-text-field padding-bottom-1">
                    <label className="form-input-text-title" htmlFor="password">password</label>
                    <input className="form-input-text-original" type="password" name="password"
                        value={this.state.formPassword} onChange={this.onChangeFormPassword} />
                </span>

                {
                    this.props.passwordErrorStatus &&
                    <span className="error-message display-block">Unfortunately your Password is Wrong: 0</span>
                }

                <span className="form-group-button">

                    <Link to="/">
                        <button className="form-button-back margin-left-right-3">back</button>
                    </Link>

                    <button
                        onClick={() => this.props.parentAction(this.state.formPassword)}
                        className="form-button margin-left-right-3"
                        type="submit">
                        enter
                    </button>

                </span>
            </div>
        );
    }
}

//export and allow redirect by "this.props.history"
export default withRouter(SigninStepPass);