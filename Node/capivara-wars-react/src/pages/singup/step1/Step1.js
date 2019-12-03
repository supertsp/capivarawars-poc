import React, { Component } from 'react';
import Navbar from '../../components/Navbar';

export default class Step1 extends Component {

    constructor(props) {
        super(props);

        this.state = {
            name: '',
            date: '',
            cpf: '',
            agree: false
        }
    }

    handleChange = (event) => {
        const state = Object.assign({}, this.state);
        let field = event.target.id;
        state[field] = event.target.value;

        this.setState(state);
    }

    isChecked = () => {
        this.setState(prevState => ({
            agree: !prevState.agree
        }))
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
                        <form onSubmit={() => this.props.change(1, this.state)}>
                            <label className="cursorP" htmlFor="name">Nome</label>
                            <input onChange={(evt) => this.handleChange(evt)} id="name" type="text" placeholder="Roberto Silva" />
                            <label onChange={(evt) => this.handleChange(evt)} className="cursorP" htmlFor="date">Data de nascimento</label>
                            <input onChange={(evt) => this.handleChange(evt)} id="date" type="text" placeholder="11/06/1993" />
                            <label onChange={(evt) => this.handleChange(evt)} className="cursorP" htmlFor="cpf">CPF</label>
                            <input onChange={(evt) => this.handleChange(evt)} id="cpf" type="text" placeholder="444.444.444-90" />
                            <div>
                                <input onChange={(evt) => this.isChecked(evt)} id="agree" type="checkbox" />
                                <label className="cursorP" htmlFor="agree">Li e concordo com os termos.</label>
                                <button className="btnBlue itensHovered" type="submit">Continuar</button>
                            </div>
                        </form>
                    </div>

                </section>

                <section id="infoContainer">
                    <p>Primeiro precisamos te conhecer.</p>
                    <p className="boldBlue">Vamos lá?</p>
                </section>

            </div>
        );
    }
}