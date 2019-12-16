import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

//Import Globlas & Tools
import Globals from "../../Globals";
import Validator from '../../tool/Validator';
import AxiosRest from '../../tool/AxiosRest';

//Import GameCore
import Player from '../../gamecore/Player';


export default class IconCapybara extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <span>

                <img src={
                    this.props.color === 'brown' ?
                        require('../assets/images/capii-icon-brown.svg') :
                        this.props.color === 'green' ?
                            require('../assets/images/capii-icon-green.svg') :
                            this.props.color === 'blue' ?
                                require('../assets/images/capii-icon-blue.svg') :
                                this.props.color === 'red' ?
                                    require('../assets/images/capii-icon-red.svg') :
                                    this.props.color === 'yellow' ?
                                        require('../assets/images/capii-icon-yellow.svg') :
                                        this.props.color === 'purple' ?
                                            require('../assets/images/capii-icon-purple.svg') :
                                            this.props.color === 'pink' ?
                                                require('../assets/images/capii-icon-pink.svg') :
                                                this.props.color === 'black' ?
                                                    require('../assets/images/capii-icon-black.svg') :
                                                    this.props.color === 'white' ?
                                                        require('../assets/images/capii-icon-white.svg') :
                                                        this.props.color === 'hotdog' ?
                                                            require('../assets/images/capii-icon-hotdog.svg') :
                                                            require('../assets/images/capii-icon-brown.svg')
                }
                    className={this.props.specialClass} alt="capivara icon" />

            </span>
        );
    }
}
