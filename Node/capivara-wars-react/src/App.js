import React, { Component } from 'react';

//CSS FILES
import './pages/assets/css/normalize.css';
import './pages/assets/css/geral.css';

//Routes
import Routes from './Routes'

//Others
import AxiosRest from './tool/AxiosRest';
import Validator from './tool/Validator';

export default class App extends Component {

    constructor(props) {
        super(props);

        AxiosRest.addApiConnection('http://localhost:8082/api/v1/playerservice', 'playerService');
        AxiosRest.addApiConnection('http://localhost:8083/api/v1/capybaraservice', 'capybaraService');

        AxiosRest.executeNamedGET('playerService', `player/nick/tiagos`)
            .then((response) => {
                console.log(typeof (response));
                console.log(response);
                // console.log(typeof (response.data));
                // console.log(response.data);
            })
            .catch((error) => {

                if (error.response) {
                    console.log(`[if 1] ${error}`);
                    console.log(`[if 1] ${JSON.stringify(error)}`);
                    // console.log(`[if 2] ${Validator.isUndefined(error.data)}`)
                    // console.log(`[if 3] ${error.data}`)

                }
                else {
                    console.log(`[else] error`);
                    console.log(typeof (error));
                    console.log(error);
                    // console.log(`[else] ${error}`);
                    console.log(`[else] ${JSON.stringify(error)}`)
                }

            });

    }

    render() {
        // return <Routes />;
        return <h4>:)</h4>
    }

}