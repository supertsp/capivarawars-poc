import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import Navbar from '../components/Navbar';

export default class NotFound extends Component {
    render() {
        return (
            <div className="geral mainBackground">
                <Navbar />
                <section>
                    <span>Ops!!! Pagina não encontrada :(</span>

                    <Link to="/">
                        <button className="itensHovered btnOutline btnDefault">Voltar</button>
                    </Link>
                </section>
            </div>
        );
    }
}