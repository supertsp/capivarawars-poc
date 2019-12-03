import React, { Component } from 'react';

export default class Navbar extends Component {
    render() {
        return (
            <nav>
                <div id="logo"></div>
                <input type="text" placeholder="O que você está procurando" />
                <div id="signin">
                    <a className="itensHovered" href="">Entrar</a>
                </div>
            </nav>
        );
    }
}