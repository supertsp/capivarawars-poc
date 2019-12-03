import React, { Component } from 'react';
import Navbar from '../../components/Navbar';

export default class Step2 extends Component {

    constructor(props) {
        super(props);

        this.state = {
            email: '',
            passwd: '',
            confirmPasswd: ''
        }
    }

    handleChange = (event) => {
        const state = Object.assign({}, this.state);
        let field = event.target.id;
        state[field] = event.target.value;

        this.setState(state);
    }

    render() {

        console.log(this.state);

        return (
            <div className="mainNoColor geral">

                <Navbar />

                <section id="formSection">

                    <div className="header">
                        <p>Você está em
                            Página inicial/Abertura de conta</p>
                        <p className="bold">Dados pessoais</p>
                    </div>

                    <div className="formContainer">
                        <form onSubmit={() => this.props.change(2, this.state)}>
                            <label className="cursorP" htmlFor="email">Email</label>
                            <input onChange={(evt) => this.handleChange(evt)} id="email" type="text" placeholder="you@example.com.br" />

                            <label className="cursorP" htmlFor="passwd">Senha</label>
                            <input onChange={(evt) => this.handleChange(evt)} id="passwd" type="password" placeholder="***************" />

                            <label className="cursorP" htmlFor="confirmPasswd">Confirme a senha</label>
                            <input onChange={(evt) => this.handleChange(evt)} id="confirmPasswd" type="password" placeholder="***************" />

                            <div>
                                <button className="btnBlue" type="submit">Continuar</button>
                            </div>
                        </form>
                    </div>

                </section>

                <section id="infoContainer">
                    <p>Beleza, agora defina como você irá </p>
                    <p className="boldBlue">acessar</p>
                    <p>sua conta.</p>
                </section>

            </div>
        );
    }
}