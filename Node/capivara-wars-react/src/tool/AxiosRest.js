import Validator from './Validator';
import axios from 'axios';

//https://www.npmjs.com/package/axios

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

    static async executeNamedGET(nameOfConnection, pathToEndpoint, configs) {
        if (Validator.isString(nameOfConnection)
            && Validator.isString(pathToEndpoint)
            && Validator.isUndefined(configs)) {

            return await this.getNamedApiConnection(nameOfConnection).get(pathToEndpoint);
        }

        if (Validator.isString(nameOfConnection)
            && Validator.isString(pathToEndpoint)
            && !Validator.isUndefined(configs)) {

            return await this.getNamedApiConnection(nameOfConnection).get(pathToEndpoint, configs);
        }

        return null;
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