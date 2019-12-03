import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import Navbar from '../../components/Navbar';

export default class Congrats extends Component {

    constructor(props) {
        super(props);

        this.state = {
            finished: true
        }
    }

    render() {

        console.log(this.props);

        return (
            <div className="geral mainBackground">

                <Navbar />

                <section>
                    <span>Parabéns {this.props.name}, sua conta está pronta para uso.</span>

                    <Link to="/">
                        <button className="itensHovered btnOutline btnDefault">Voltar</button>
                    </Link>

                </section>
            </div>
        );
    }
}