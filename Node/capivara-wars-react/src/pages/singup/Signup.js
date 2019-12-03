import React, { Component } from 'react';
import Step1 from './step1/Step1';
import Step2 from './step2/Step2';
import Congrats from './congrats/Congrats';

export default class Signup extends Component {

    constructor(props) {
        super(props);

        this.state = {
            actualPage: 0,
            info: []
        }
    }

    handleActualPage = () => {
        switch (this.state.actualPage) {
            case 1:
                return <Step2 change={this.handleChangePage} />

            case 2:
                return <Congrats name={this.state.info[0].name} />

            default:
                return <Step1 change={this.handleChangePage} />
        }
    }

    handleChangePage = (page, data) => {
        const state = Object.assign({}, this.state);
        state.actualPage = page;
        state.info.push(data);
        this.setState(state);
    }

    render() {
        console.log(this.state);
        return this.handleActualPage();
    }
}