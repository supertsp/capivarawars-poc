const readline = require('readline');
const Validator = require('./Validator');

/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 01/12/2019, 04:02:05
 * Last update: -
 * Tips: https://blog.fullstacktraining.com/capturing-user-input-in-a-node-js-application/
 * https://medium.com/javascript-in-plain-english/how-to-read-test-cases-from-stdin-and-files-using-readline-in-node-js-cf5ef37e6b5e
 * https://nodejs.org/api/readline.html
 */


//console.log(process.stdin);

class Console{
	
	static log(variable){
		console.log(variable);
	}
	
	static write(variable){
		console.log(variable);
	}
	
	//under construction
	static readString(message){
		console.log(message);
		
//		const tempReadLine = readline.createInterface({
//			input: process.stdin // readable Stream: stdin
//		});
		
//		fetch(
//			tempReadLine.on('line', (line) => {
//				console.log(line);				
//			}))
//			.then(tempReadLine.close()
//		);
		
//		tempReadLine.on('line', (line) => {
//			process.
//			
//			console.log(line);
//			
//			tempReadLine.close();
//		});
		
		
	}
	
	
	
}

module.exports = Console;

