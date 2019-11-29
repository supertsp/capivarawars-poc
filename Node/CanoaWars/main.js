const Canoa = require('./gamecore/Canoa');

let canoa = new Canoa(4);

console.log(canoa);
console.log(canoa.getPedaco(10));
console.log(canoa.lengthOfPedacos());

canoa.destruirPedaco(2);

console.log(canoa.tamanho);
console.log(canoa.lengthOfPedacos());
console.log(canoa);

canoa.reiniciarCanoa();
console.log(canoa);
