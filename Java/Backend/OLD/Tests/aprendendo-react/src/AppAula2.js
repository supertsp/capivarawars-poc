import React, { Component } from 'react';

// Requisições default no React = "fetch"
//  o melhor jeito é usar o pacote Node "axios"

class MeuH1 extends Component{
  render(){
    return (
      <h1>Você clicou: {this.props.titulo}</h1>
    );
  }
}

class MeuBtn extends Component{
  render(){
    return (
      <button onClick={()=>this.props.change(this.props.texto)}>{this.props.texto}</button>
    );
  }
}


export default class App extends Component {

  constructor(props){
    super(props);
    this.state = {
      estadoDoBotao: ''
    }
  }

  handleChange = (name) =>{
    this.setState({ //por defautl é assincrono, mas para fazer sincrono basta colocar um callback
      estadoDoBotao: name
    });
  }

  render() {
    // console.log(this.state); //debug do state
    return (
      <>
        <h1>oi</h1>
        <h1>oidddd</h1>
        <MeuH1 titulo={this.state.estadoDoBotao} />
        <MeuBtn change={this.handleChange} texto="clique-me 1"/>
        <MeuBtn change={this.handleChange} texto="clique-me 2"/>
        <MeuBtn change={this.handleChange} texto="clique-me 3"/>
      </>
    );
  }

}