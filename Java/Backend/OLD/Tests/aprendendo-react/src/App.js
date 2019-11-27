import React, { Component } from 'react';
import Home from './pages/home/Home';
import Signup from './pages/singup/Signup';
import Step1 from './pages/singup/step1/Step1';

import './template/assets/css/normalize.css';
import './template/assets/css/template.css';
import './template/assets/css/style.css';
import Routes from './Routes'

export default class App extends Component {

    render() {
        // return <Home />
        // return <Step1 />
        // return <Signup />
        // return <NotFound />
        return <Routes />;
    }

}