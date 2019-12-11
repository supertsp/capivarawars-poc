import React, { Component } from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';

//import pages
import Home from './pages/home/Home';
import MatchResult from './pages/matchresult/MatchResult';
import MoveAim from './pages/moveaim/MoveAim';
import MoveBoat from './pages/moveboat/MoveBoat';
import Register from './pages/register/Register';
import Signin from './pages/signin/Signin';
import TurnStatus from './pages/turnstatus/TurnStatus';
import Welcome from './pages/welcome/Welcome';
import Loading from './pages/loading/Loading';

export default class Routes extends Component {
    render() {
        return (
            <BrowserRouter>
                <Switch>
                    <Route exact path="/" component={Welcome} />

                    <Route path="/home" component={Home} />
                    <Route path="/matchresult" component={MatchResult} />
                    <Route path="/moveaim" component={MoveAim} />
                    <Route path="/moveboat" component={MoveBoat} />
                    <Route path="/register" component={Register} />
                    <Route path="/signin" component={Signin} />
                    <Route path="/turnstatus" component={TurnStatus} />
                    <Route path="/welcome" component={Welcome} />
                    <Route path="/loading" component={Loading} />

                    <Route path="*" component={Welcome} />
                </Switch>
            </BrowserRouter>
        );
    }
}
