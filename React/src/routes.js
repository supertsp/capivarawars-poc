import React from 'react';

import Login from './pages/login/index';
import Register from './pages/register/index';
import Home from './pages/home/index'
import NumberPlayers from './pages/numberPlayers/index';
import ResetPassword from './pages/resetPassword/index';
import Loading from './pages/loadingPage/index';
import Game from './pages/gameScreen/index';
import lose from './pages/lose';

import { BrowserRouter, Switch, Route } from 'react-router-dom';



const Routes = () => (
    <BrowserRouter>
        <Switch>
            <Route exact path="/" component={Login} />
            <Route path="/register" component={Register} />
            <Route path="/home" component={Home} />
            <Route path="/numberPlayers" component={NumberPlayers} />
            <Route path="/resetPassword" component={ResetPassword} />
            <Route path="/loading" component={Loading} />
            <Route path="/game" component={Game} />
            <Route path="/lose" component={lose} />
        </Switch>
    </BrowserRouter>
);

export default Routes;