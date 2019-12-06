import Validator from './Validator';
import axios from 'axios';

//https://www.npmjs.com/package/axios
//JS Documentation: https://dev.to/paulasantamaria/document-your-javascript-code-with-jsdoc-2fbf

export default class AxiosRest {

    connections;
    connectionsName;

    static lengthOfConnections() {
        return this.connections.length;
    }

    static addApiConnection(baseUrl, connectionName) {
        if (Validator.isUndefined(this.connections)) {
            this.connections = [];
            this.connectionsName = [];
        }

        if (Validator.isString(baseUrl) && Validator.isString(connectionName)) {
            const newCon = axios.create({
                baseURL: baseUrl
            });

            this.connections.push(newCon);
            this.connectionsName.push(connectionName);

            return true;
        }

        return false;
    }

    static getApiConnection(indexOfConnection) {
        if (Validator.isIntegerBetweenInterval(indexOfConnection, 0, this.lengthOfConnections())) {
            return this.connections[indexOfConnection];
        }

        return null;
    }

    static getNamedApiConnection(nameOfConnection) {
        if (Validator.isString(nameOfConnection)) {
            for (let index = 0; index < this.lengthOfConnections(); index++) {
                if (this.connectionsName[index] === nameOfConnection) {
                    return this.connections[index];
                }
            }
        }

        return null;
    }

    /**
     * Executes the GET method of the HTTP protocol
     * @param {integer} indexOfConnection 
     * @param {string} pathToEndpoint 
     * @param {JSON} configs JSON of extra Axios settings
     * @returns {Response|Error} A Promise containing an JSON with 'Response' or 'Error' format
     */
    static async executeGET(indexOfConnection, pathToEndpoint, configs) {
        if (Validator.isIntegerBetweenInterval(indexOfConnection, 0, this.lengthOfConnections())
            && Validator.isString(pathToEndpoint)
            && Validator.isUndefined(configs)) {

            return await this.getApiConnection(indexOfConnection).get(pathToEndpoint);
        }

        if (Validator.isIntegerBetweenInterval(indexOfConnection, 0, this.lengthOfConnections())
            && Validator.isString(pathToEndpoint)
            && !Validator.isUndefined(configs)) {

            return await this.getApiConnection(indexOfConnection).get(pathToEndpoint, configs);
        }

        return null;
    }

    /**
     * Executes the GET method of the HTTP protocol. 
     * 
     * @example const response = await AxiosRest.executeNamedGET('myApi', `products/${idProduct}`);
     * if (response.status === 200 && response.data) {}
     * 
     * @param {string} nameOfConnection 
     * @param {string} pathToEndpoint 
     * @param {JSON} configs JSON of extra Axios settings
     * @returns {Response|Error|null} A Promise containing an JSON with 'Response'/'Error' format or null
     */
    static async executeNamedGET(nameOfConnection, pathToEndpoint, configs) {
        if (Validator.isString(nameOfConnection)
            && Validator.isString(pathToEndpoint)
            && Validator.isUndefined(configs)) {

            let errorX;
            this.getNamedApiConnection(nameOfConnection).get(pathToEndpoint)
                .then((response) => {
                    console.log("RESPONSE  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx...");

                    return response;
                })
                .catch((error) => {
                    errorX = { ...error.response };
                    // console.log("errorX: " + errorX);

                    return errorX;
                    // console.log("errorX: " + JSON.stringify(errorX));
                    // console.log("errorX: " + JSON.parse(errorX));

                    console.log("ERROR... xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx...");
                    // return error.response;

                });

            console.log("errorX: " + errorX);

            return "oi";
            // return errorX;
        }

        if (Validator.isString(nameOfConnection)
            && Validator.isString(pathToEndpoint)
            && !Validator.isUndefined(configs)) {

            // const response = await this.getNamedApiConnection(nameOfConnection).get(pathToEndpoint, configs);

            // console.log("ixxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx...");
            // if (response.data) {
            //     console.log("if again...");
            //     return response;
            // }
            // else {
            //     console.log("else again...");
            //     const subresponse = response.response;
            //     return subresponse;
            // }
        }

        return 'oi :0';
    }

    static async executePOST(indexOfConnection, pathToEndpoint, data, configs) {
        if (Validator.isIntegerBetweenInterval(indexOfConnection, 0, this.lengthOfConnections())
            && Validator.isString(pathToEndpoint)
            && !Validator.isUndefined(data)
            && Validator.isUndefined(configs)) {

            return await this.getApiConnection(indexOfConnection).post(pathToEndpoint, data);
        }

        if (Validator.isIntegerBetweenInterval(indexOfConnection, 0, this.lengthOfConnections())
            && Validator.isString(pathToEndpoint)
            && !Validator.isUndefined(data)
            && !Validator.isUndefined(configs)) {

            return await this.getApiConnection(indexOfConnection).post(pathToEndpoint, data, configs);
        }

        return null;
    }

    static async executeNamedPOST(nameOfConnection, pathToEndpoint, data, configs) {
        if (Validator.isString(nameOfConnection)
            && Validator.isString(pathToEndpoint)
            && !Validator.isUndefined(data)
            && Validator.isUndefined(configs)) {

            return await this.getNamedApiConnection(nameOfConnection).post(pathToEndpoint, data);
        }

        if (Validator.isString(nameOfConnection)
            && Validator.isString(pathToEndpoint)
            && !Validator.isUndefined(data)
            && !Validator.isUndefined(configs)) {

            return await this.getNamedApiConnection(nameOfConnection).post(pathToEndpoint, data, configs);
        }

        return null;
    }

}