import React, { Component } from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import Home from './pages/home/Home';
import Signup from './pages/singup/Signup';
import NotFound from './pages/notfound/NotFound';

export default class Routes extends Component {
    render() {
        return (
            <BrowserRouter>
                <Switch>
                    <Route exact path="/" component={Home} />
                    <Route path="/signup" component={Signup} />
                    <Route path="*" component={NotFound} />
                </Switch>
            </BrowserRouter>
        );
    }
}
