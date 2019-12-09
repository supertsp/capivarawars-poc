const Validator = require("./tool/Validator");
const Console = require("./tool/Console");
const Canoa = require("./gamecore/Canoa");
const Rio = require("./gamecore/Rio");
const Capivara = require("./gamecore/Capivara");
const Jogador = require("./gamecore/Jogador");
const BarraDeVida = require("./gamecore/BarraDeVida");
const Partida = require("./gamecore/Partida");




//Console.write(new Canoa());
//Console.log("oi");
//
////Console.readString("Digite algo: ");
//
//
//Console.write("\n\n");
//
////sync code
//console.log('Hello');
//console.log('Hi');
//
//
//const readline = require('readline');
//
//const rl = readline.createInterface({
//  input: process.stdin,
//  output: process.stdout
//});
//
//rl.question('What do you think of Node.js? ', (answer) => {
//  // TODO: Log the answer in a database
//  console.log(`Thank you for your valuable feedback: ${answer}`);
//
//  rl.close();
//});
//
//
////async code
//setTimeout(() => {
//    console.log('Timer is done');
//}, 2000);
//
//
//console.log('new');
//console.log('kkkk');

//let canoa = new Canoa(4);
//let rio = new Rio(10, canoa);console.log(rio);console.log("-------------------------------------------------\n");
//let capivara = new Capivara();
//console.log(capivara);

//console.log("\n\n Iniciando Rio \n");
//console.log(rio);
//
//console.log("\n\n Movendo Canoa para 5 \n");
//rio.moverCanoa(5);
//console.log(rio);
//
//console.log("\n\n Recebendo Tiro em 5 \n");
//rio.receberTiro(5);
//console.log(rio);
//
//console.log("\n\n Movendo Canoa para 2 \n");
//rio.moverCanoa(2);
//console.log(rio);
//
//console.log("\n\n Recebendo Tiro em 4 \n");
//rio.receberTiro(4);
//console.log(rio);
//
//console.log("\n\n Movendo Canoa para 10 \n");
//rio.moverCanoa(10);
//console.log(rio);
//
//console.log("\n\n Recebendo Tiro em 2 \n");
//rio.receberTiro(2);
//console.log(rio);
//
//console.log("\n\n Movendo Canoa para 9 \n");
//rio.moverCanoa(9);
//console.log(rio);
//
//console.log("\n\n Recebendo Tiro em 9 \n");
//rio.receberTiro(9);
//console.log(rio);

//let barraDeVida = new BarraDeVida();
//let valor = 0;
//console.log(barraDeVida);
//
//valor = 8;
//console.log(`\n\n Decrementando em ${valor} \n`);
//barraDeVida.diminuir();
//console.log(barraDeVida);
//
//valor = 10;
//console.log(`\n\n Incrementando em ${valor} \n`);
//barraDeVida.aumentar(valor);
//console.log(barraDeVida);

//let capivara = new Capivara();
//console.log(capivara);
//
//console.log(`\n\n Decrementando vida em 1 \n`);
//capivara.receberDano();
//console.log(capivara);
//
//console.log(`\n\n Decrementando vida em 1 \n`);
//capivara.receberDano();
//console.log(capivara);
//
//console.log(`\n\n Decrementando vida em 1 \n`);
//capivara.receberDano();
//console.log(capivara);
//
//console.log(`\n\n Decrementando vida em 1 \n`);
//capivara.receberDano();
//console.log(capivara);
//
//console.log(`\n\n Decrementando vida em 1 \n`);
//capivara.receberDano();
//console.log(capivara);
//
//console.log(`\n\n Decrementando vida em 1 \n`);
//capivara.receberDano();
//console.log(capivara);
//
//console.log(`\n\n Decrementando vida em 1 \n`);
//capivara.receberDano();
//console.log(capivara);
//
//console.log(`\n\n Decrementando vida em 1 \n`);
//capivara.receberDano();
//console.log(capivara);
//
//console.log(`\n\n Decrementando vida em 1 \n`);
//capivara.receberDano();
//console.log(capivara);
//
//console.log(`\n\n Decrementando vida em 1 \n`);
//capivara.receberDano();
//console.log(capivara);
//
//console.log(`\n\n Decrementando vida em 1 \n`);
//capivara.receberDano();
//console.log(capivara);
//
//console.log(`\n\n Decrementando vida em 1 \n`);
//capivara.receberDano();
//console.log(capivara);
//
//console.log(`\n\n Regenerando 1 ponto \n`);
//capivara.regenerarPontoDeVida();
//console.log(capivara);
//
//console.log(`\n\n Regenerando \n`);
//capivara.regenerar();
//console.log(capivara);

//let hexaNumber = '#a05a2cff';
//console.log(Validator.isRgbaValue(hexaNumber));

//let jogador1 = new Jogador('tiago', 'feliceta', 10, 4);
//jogador1.setId(1);
////console.log(jogador1);
//
////let jogador2 = new Jogador('joshua', 'tres', 10, 4);
//let jogador2 = new Jogador();
//jogador2.setId(2);
////console.log(jogador2);
//
//
//console.log( `\n`
//	+ `================================================================ \n`
//	+ `Player ${jogador1.getId()} - ${jogador1.getNick()} \n`
//	+ `  Capivara '${jogador1.getCapivara().getNome()}': ${jogador1.getVidaCapivara()}HP,  Está morta? ${jogador1.isCapivaraMorta()} \n`
//	+ `  Rio (${jogador1.getRio().getTamanhoAtual()}): ${jogador1.getRio().partes} \n`
//	+ `  Canoa (${jogador1.getCanoa().getTamanhoAtual()}): ${jogador1.getCanoa().pedacos} \n`
//	+ `  isCanoaDestruida? ${jogador1.isCanoaDestruida()} \n`
//	+ `  -------------------------------------------------------------- \n`
//	+ `Player ${jogador2.getId()} - ${jogador2.getNick()} \n`
//	+ `  Capivara '${jogador2.getCapivara().getNome()}': ${jogador2.getVidaCapivara()}HP,  Está morta? ${jogador2.isCapivaraMorta()} \n`
//	+ `  Rio (${jogador2.getRio().getTamanhoAtual()}): ${jogador2.getRio().partes} \n`
//	+ `  Canoa (${jogador2.getCanoa().getTamanhoAtual()}): ${jogador2.getCanoa().pedacos} \n`
//	+ `  isCanoaDestruida? ${jogador2.isCanoaDestruida()} \n`
//	+ `================================================================ \n\n`
//);
//
//let posicaoNoRio = 0;
//let posicaoDoTiro = 0;
//
//
////TURNO #1
//console.log("=== TURNO #" + 1 + " ========================================================================\n");
//posicaoNoRio = 4;
//console.log(` >>> MOVENDO (${posicaoNoRio}) >>> Player ${jogador1.getId()} - ${jogador1.getNick()}`);
//jogador1.moverCanoa(posicaoNoRio);
//
//posicaoNoRio = 7;
//console.log(` >>> MOVENDO (${posicaoNoRio}) >>> Player ${jogador2.getId()} - ${jogador2.getNick()}`);
//jogador2.moverCanoa(posicaoNoRio);
//
//posicaoDoTiro = 0;
//console.log(`\n >>> ATIRANDO (${posicaoDoTiro}) >>> Player ${jogador1.getId()} - ${jogador1.getNick()}`);
//console.log(`        Sucesso? ${jogador1.atirarNoInimigo(posicaoDoTiro, jogador2)} \n`);
//
//posicaoDoTiro = 5;
//console.log(` >>> ATIRANDO (${posicaoDoTiro}) >>> Player ${jogador2.getId()} - ${jogador2.getNick()}`);
//console.log(`        Sucesso? ${jogador2.atirarNoInimigo(posicaoDoTiro, jogador1)} \n`);
//
//console.log( ``
//	+ `~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n`
//	+ `Player ${jogador1.getId()} - ${jogador1.getNick()} \n`
//	+ `  Capivara '${jogador1.getCapivara().getNome()}': ${jogador1.getVidaCapivara()}HP,  Está morta? ${jogador1.isCapivaraMorta()} \n`
//	+ `  Rio (${jogador1.getRio().getTamanhoAtual()}): ${jogador1.getRio().partes} \n`
//	+ `  Canoa (${jogador1.getCanoa().getTamanhoAtual()}): ${jogador1.getCanoa().pedacos} \n`
//	+ `  isCanoaDestruida? ${jogador1.isCanoaDestruida()} \n`
//	+ `  -------------------------------------------------------------- \n`
//	+ `Player ${jogador2.getId()} - ${jogador2.getNick()} \n`
//	+ `  Capivara '${jogador2.getCapivara().getNome()}': ${jogador2.getVidaCapivara()}HP,  Está morta? ${jogador2.isCapivaraMorta()} \n`
//	+ `  Rio (${jogador2.getRio().getTamanhoAtual()}): ${jogador2.getRio().partes} \n`
//	+ `  Canoa (${jogador2.getCanoa().getTamanhoAtual()}): ${jogador2.getCanoa().pedacos} \n`
//	+ `  isCanoaDestruida? ${jogador2.isCanoaDestruida()} \n`
//	+ `~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n\n`
//);
//
//
////TURNO #2
//console.log("=== TURNO #" + 2 + " ========================================================================\n");
//posicaoNoRio = 2;
//console.log(` >>> MOVENDO (${posicaoNoRio}) >>> Player ${jogador1.getId()} - ${jogador1.getNick()}`);
//jogador1.moverCanoa(posicaoNoRio);
//
//posicaoNoRio = 3;
//console.log(` >>> MOVENDO (${posicaoNoRio}) >>> Player ${jogador2.getId()} - ${jogador2.getNick()}`);
//jogador2.moverCanoa(posicaoNoRio);
//
//posicaoDoTiro = 4;
//console.log(`\n >>> ATIRANDO (${posicaoDoTiro}) >>> Player ${jogador1.getId()} - ${jogador1.getNick()}`);
//console.log(`        Sucesso? ${jogador1.atirarNoInimigo(posicaoDoTiro, jogador2)} \n`);
//
//posicaoDoTiro = 4;
//console.log(` >>> ATIRANDO (${posicaoDoTiro}) >>> Player ${jogador2.getId()} - ${jogador2.getNick()}`);
//console.log(`        Sucesso? ${jogador2.atirarNoInimigo(posicaoDoTiro, jogador1)} \n`);
//
//console.log( ``
//	+ `~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n`
//	+ `Player ${jogador1.getId()} - ${jogador1.getNick()} \n`
//	+ `  Capivara '${jogador1.getCapivara().getNome()}': ${jogador1.getVidaCapivara()}HP,  Está morta? ${jogador1.isCapivaraMorta()} \n`
//	+ `  Rio (${jogador1.getRio().getTamanhoAtual()}): ${jogador1.getRio().partes} \n`
//	+ `  Canoa (${jogador1.getCanoa().getTamanhoAtual()}): ${jogador1.getCanoa().pedacos} \n`
//	+ `  isCanoaDestruida? ${jogador1.isCanoaDestruida()} \n`
//	+ `  -------------------------------------------------------------- \n`
//	+ `Player ${jogador2.getId()} - ${jogador2.getNick()} \n`
//	+ `  Capivara '${jogador2.getCapivara().getNome()}': ${jogador2.getVidaCapivara()}HP,  Está morta? ${jogador2.isCapivaraMorta()} \n`
//	+ `  Rio (${jogador2.getRio().getTamanhoAtual()}): ${jogador2.getRio().partes} \n`
//	+ `  Canoa (${jogador2.getCanoa().getTamanhoAtual()}): ${jogador2.getCanoa().pedacos} \n`
//	+ `  isCanoaDestruida? ${jogador2.isCanoaDestruida()} \n`
//	+ `~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n\n`
//);
//
//
//
////TURNO #3
//console.log("=== TURNO #" + 3 + " ========================================================================\n");
//posicaoNoRio = 9;
//console.log(` >>> MOVENDO (${posicaoNoRio}) >>> Player ${jogador1.getId()} - ${jogador1.getNick()}`);
//jogador1.moverCanoa(posicaoNoRio);
//
//posicaoNoRio = 12;
//console.log(` >>> MOVENDO (${posicaoNoRio}) >>> Player ${jogador2.getId()} - ${jogador2.getNick()}`);
//jogador2.moverCanoa(posicaoNoRio);
//
//posicaoDoTiro = 5;
//console.log(`\n >>> ATIRANDO (${posicaoDoTiro}) >>> Player ${jogador1.getId()} - ${jogador1.getNick()}`);
//console.log(`        Sucesso? ${jogador1.atirarNoInimigo(posicaoDoTiro, jogador2)} \n`);
//
//posicaoDoTiro = 2;
//console.log(` >>> ATIRANDO (${posicaoDoTiro}) >>> Player ${jogador2.getId()} - ${jogador2.getNick()}`);
//console.log(`        Sucesso? ${jogador2.atirarNoInimigo(posicaoDoTiro, jogador1)} \n`);
//
//console.log( ``
//	+ `~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n`
//	+ `Player ${jogador1.getId()} - ${jogador1.getNick()} \n`
//	+ `  Capivara '${jogador1.getCapivara().getNome()}': ${jogador1.getVidaCapivara()}HP,  Está morta? ${jogador1.isCapivaraMorta()} \n`
//	+ `  Rio (${jogador1.getRio().getTamanhoAtual()}): ${jogador1.getRio().partes} \n`
//	+ `  Canoa (${jogador1.getCanoa().getTamanhoAtual()}): ${jogador1.getCanoa().pedacos} \n`
//	+ `  isCanoaDestruida? ${jogador1.isCanoaDestruida()} \n`
//	+ `  -------------------------------------------------------------- \n`
//	+ `Player ${jogador2.getId()} - ${jogador2.getNick()} \n`
//	+ `  Capivara '${jogador2.getCapivara().getNome()}': ${jogador2.getVidaCapivara()}HP,  Está morta? ${jogador2.isCapivaraMorta()} \n`
//	+ `  Rio (${jogador2.getRio().getTamanhoAtual()}): ${jogador2.getRio().partes} \n`
//	+ `  Canoa (${jogador2.getCanoa().getTamanhoAtual()}): ${jogador2.getCanoa().pedacos} \n`
//	+ `  isCanoaDestruida? ${jogador2.isCanoaDestruida()} \n`
//	+ `~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n\n`
//);
//
//
////TURNO #4
//console.log("=== TURNO #" + 4 + " ========================================================================\n");
//posicaoNoRio = 0;
//console.log(` >>> MOVENDO (${posicaoNoRio}) >>> Player ${jogador1.getId()} - ${jogador1.getNick()}`);
//jogador1.moverCanoa(posicaoNoRio);
//
//posicaoNoRio = 5;
//console.log(` >>> MOVENDO (${posicaoNoRio}) >>> Player ${jogador2.getId()} - ${jogador2.getNick()}`);
//jogador2.moverCanoa(posicaoNoRio);
//
//posicaoDoTiro = 6;
//console.log(`\n >>> ATIRANDO (${posicaoDoTiro}) >>> Player ${jogador1.getId()} - ${jogador1.getNick()}`);
//console.log(`        Sucesso? ${jogador1.atirarNoInimigo(posicaoDoTiro, jogador2)} \n`);
//
//posicaoDoTiro = 3;
//console.log(` >>> ATIRANDO (${posicaoDoTiro}) >>> Player ${jogador2.getId()} - ${jogador2.getNick()}`);
//console.log(`        Sucesso? ${jogador2.atirarNoInimigo(posicaoDoTiro, jogador1)} \n`);
//
//console.log( ``
//	+ `~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n`
//	+ `Player ${jogador1.getId()} - ${jogador1.getNick()} \n`
//	+ `  Capivara '${jogador1.getCapivara().getNome()}': ${jogador1.getVidaCapivara()}HP,  Está morta? ${jogador1.isCapivaraMorta()} \n`
//	+ `  Rio (${jogador1.getRio().getTamanhoAtual()}): ${jogador1.getRio().partes} \n`
//	+ `  Canoa (${jogador1.getCanoa().getTamanhoAtual()}): ${jogador1.getCanoa().pedacos} \n`
//	+ `  isCanoaDestruida? ${jogador1.isCanoaDestruida()} \n`
//	+ `  -------------------------------------------------------------- \n`
//	+ `Player ${jogador2.getId()} - ${jogador2.getNick()} \n`
//	+ `  Capivara '${jogador2.getCapivara().getNome()}': ${jogador2.getVidaCapivara()}HP,  Está morta? ${jogador2.isCapivaraMorta()} \n`
//	+ `  Rio (${jogador2.getRio().getTamanhoAtual()}): ${jogador2.getRio().partes} \n`
//	+ `  Canoa (${jogador2.getCanoa().getTamanhoAtual()}): ${jogador2.getCanoa().pedacos} \n`
//	+ `  isCanoaDestruida? ${jogador2.isCanoaDestruida()} \n`
//	+ `~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n\n`
//);
//
//
//
////TURNO #5
//console.log("=== TURNO #" + 5 + " ========================================================================\n");
//posicaoNoRio = 9;
//console.log(` >>> MOVENDO (${posicaoNoRio}) >>> Player ${jogador1.getId()} - ${jogador1.getNick()}`);
//jogador1.moverCanoa(posicaoNoRio);
//
//posicaoNoRio = 8;
//console.log(` >>> MOVENDO (${posicaoNoRio}) >>> Player ${jogador2.getId()} - ${jogador2.getNick()}`);
//jogador2.moverCanoa(posicaoNoRio);
//
//posicaoDoTiro = 8;
//console.log(`\n >>> ATIRANDO (${posicaoDoTiro}) >>> Player ${jogador1.getId()} - ${jogador1.getNick()}`);
//console.log(`        Sucesso? ${jogador1.atirarNoInimigo(posicaoDoTiro, jogador2)} \n`);
//
//posicaoDoTiro = 1;
//console.log(` >>> ATIRANDO (${posicaoDoTiro}) >>> Player ${jogador2.getId()} - ${jogador2.getNick()}`);
//console.log(`        Sucesso? ${jogador2.atirarNoInimigo(posicaoDoTiro, jogador1)} \n`);
//
//console.log( ``
//	+ `~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n`
//	+ `Player ${jogador1.getId()} - ${jogador1.getNick()} \n`
//	+ `  Capivara '${jogador1.getCapivara().getNome()}': ${jogador1.getVidaCapivara()}HP,  Está morta? ${jogador1.isCapivaraMorta()} \n`
//	+ `  Rio (${jogador1.getRio().getTamanhoAtual()}): ${jogador1.getRio().partes} \n`
//	+ `  Canoa (${jogador1.getCanoa().getTamanhoAtual()}): ${jogador1.getCanoa().pedacos} \n`
//	+ `  isCanoaDestruida? ${jogador1.isCanoaDestruida()} \n`
//	+ `  -------------------------------------------------------------- \n`
//	+ `Player ${jogador2.getId()} - ${jogador2.getNick()} \n`
//	+ `  Capivara '${jogador2.getCapivara().getNome()}': ${jogador2.getVidaCapivara()}HP,  Está morta? ${jogador2.isCapivaraMorta()} \n`
//	+ `  Rio (${jogador2.getRio().getTamanhoAtual()}): ${jogador2.getRio().partes} \n`
//	+ `  Canoa (${jogador2.getCanoa().getTamanhoAtual()}): ${jogador2.getCanoa().pedacos} \n`
//	+ `  isCanoaDestruida? ${jogador2.isCanoaDestruida()} \n`
//	+ `~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n\n`
//);

let stringStatusJogo = "";
let posicaoNoRio = 0;
let posicaoDoTiro = 0;
let indiceJogadorInimigo = 0;

let partida = new Partida(7);
partida.iniciar();
//console.log(partida);

partida
  .addJogador(new Jogador("tiago", "feliceta", 10, 4).setId(1))
  .addJogador(new Jogador("joshua", "tres", 10, 4).setId(2))
  .addJogador(new Jogador("matheus", "miku", 10, 4).setId(3))
  .addJogador(new Jogador("leonardo", "nino", 10, 4).setId(4))
  .addJogador(new Jogador("Alex", "Mimi", 10, 4).setId(5))
  .addJogador(new Jogador("juliana", "harry", 10, 4).setId(5))
  .addJogador(new Jogador("kaline", "Fofi", 10, 4).setId(5));

partida.iniciar();

do {
  //TURNO
  console.log(
    "=== TURNO #" +
    partida.getTurnoAtual() +
    " ========================================================================"
  );

  //movendo jogadores
  for (
    let contJogador = 0;
    contJogador < partida.getQtdAtualDeJogadores();
    contJogador++
  ) {
    posicaoNoRio = parseInt(Math.random() * 10);
    console.log(
      ` >>> MOVENDO (${posicaoNoRio}) >>> Player ${partida
        .getJogadorAtual()
        .getId()} - ${partida.getJogadorAtual().getNick()}`
    );
    partida.moverCanoaDoJogadorAtual(posicaoNoRio);
  }

  //atirando no inimigo
  for (
    let contJogador = 0;
    contJogador < partida.getQtdAtualDeJogadores();
    contJogador++
  ) {
    posicaoDoTiro = parseInt(Math.random() * 10);

    do {
      indiceJogadorInimigo = parseInt(
        Math.random() * partida.getQtdAtualDeJogadores()
      );
    } while (indiceJogadorInimigo == partida.getIndiceJogadorAtual());

    console.log(
      `\n >>> ATIRANDO na posição ${posicaoDoTiro} >>> '${partida
        .getJogadorAtual()
        .getNick()} escolheu ${partida
          .getJogador(indiceJogadorInimigo)
          .getNick()}` +
      `        Sucesso? ${partida.atirarNoInimigoDoJogadorAtual(
        posicaoDoTiro,
        partida.getJogador(indiceJogadorInimigo)
      )}`
    );
  }

  //EXIBINDO STATUS DO JOGO
  stringStatusJogo =
    `` +
    `\n====[PARTIDA]======[TURNO: ${partida.getTurnoAtual()}]============[Iniciou? ${partida.isIniciou()}]====[Terminou? ${partida.isTerminou()}]================ \n`;
  for (
    let contJogador = 0;
    contJogador < partida.getQtdAtualDeJogadores();
    contJogador++
  ) {
    stringStatusJogo +=
      `` +
      `${partida.getJogador(contJogador).toString()}\n` +
      `  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n`;
  }
  console.log(stringStatusJogo);
} while (!partida.isTerminou());

console.log(
  "\n\n=========================FIM DE JOGO ==============================================="
);

if (partida.isEmpatou()) {
  console.log("\nEMPATOU!!!!");
  const empatantes = partida.getEmpatantes();

  for (let contJogador = 0; contJogador < empatantes.length; contJogador++) {
    console.log(`   ${empatantes[contJogador].getNick()}`);
  }
} else {
  console.log("\n TEVE 1 VENCEDOR :) >>> " + partida.getVencedor().getNick());
}

