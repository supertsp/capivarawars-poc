import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import Navbar from '../components/Navbar';


class Home extends Component {

    //métodos de ciclo de vida do React

    //qdo o componete está pronto para renderizar
    componentDidMount() {
        console.log("props", this.props);
        this.props.history.push('/signup');
    }

    render() {
        return (
            <div className="geral mainBackground">
                <Navbar />
                <section>
                    <span>A conta Banco Digital te dá acesso a um novo patamar de produtos e serviços bancários. Bem vindo ao
                futuro.</span>

                    <Link to="/signup">
                        <button className="itensHovered btnOutline btnDefault">Continuar</button>
                    </Link>
                </section>
            </div>
        );
    }
}

export default withRouter(Home);