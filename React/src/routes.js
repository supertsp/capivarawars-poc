import React from 'react';
import Login from './pages/login/index';
import Register from './pages/register/index';
import Home from './pages/home/index'


import { BrowserRouter, Switch, Route } from 'react-router-dom';

const Routes = () => (
    <BrowserRouter>
        <Switch>
            <Route exact path="/" component={Login} />
            <Route path="/register" component={Register} />
            <Route path="/home" component={Home} />
        </Switch>
    </BrowserRouter>
);

export default Routes;