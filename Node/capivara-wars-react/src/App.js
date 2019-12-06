import React, { Component } from 'react';

//CSS FILES
import './pages/assets/css/normalize.css';
import './pages/assets/css/geral.css';

//Routes
import Routes from './Routes'

//Others
import AxiosRest from './tool/AxiosRest';

export default class App extends Component {

    constructor(props) {
        super(props);

        AxiosRest.addApiConnection('http://localhost:8082/api/v1/playerservice', 'playerService');
        AxiosRest.addApiConnection('http://localhost:8083/api/v1/capybaraservice', 'capybaraService');
    }

    render() {
        return <Routes />;
    }

}