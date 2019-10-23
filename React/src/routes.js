import React from 'react';
import Login from './pages/login/index';
import Register from './pages/register/index';


import { BrowserRouter, Switch, Route } from 'react-router-dom';

const Routes = () => (
    <BrowserRouter>
        <Switch>
            <Route exact path="/" component={Login} />
            <Route path="/register" component={Register} />
        </Switch>
    </BrowserRouter>
);

export default Routes;