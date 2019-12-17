import Validator from './Validator';

//https://github.com/chrisdavidmills/emogotchi
//JS Documentation: https://developer.mozilla.org/pt-BR/docs/Web/API/notificacoes

export default class PushNotification {

    /**
     * Prompts the user for permission to view push notifications.
     * However, calling the show () method already does it automatically.
     * @returns result
     */
    static async requestPermission() {
        Notification.requestPermission().then(function (result) {
            console.log("Notification Permissons: " + result);
            return result;
        });
    }


    /**
     * Displays a push notification.
     *
     * @example PushNotification.show(
     *      'Welcome :)',
     *      'My Website',
     *       require("../assets/images/site.png"),
     *       7.6
     * );        
     *
     * @param {string} message The `message` to user
     * @param {string} title The `title` of message
     * @param {string} imageIconUrl The path to the desired icon
     * @param {number} timeInSeconds The durations of message
     */
    static async show(message, title, imageIconUrl, timeInSeconds) {
        if (Validator.isString(message)
            && Validator.isString(title)
            && Validator.isString(imageIconUrl)
            && Validator.isFloat(timeInSeconds)) {

            Notification.requestPermission().then(function (result) {
                console.log("Notification Permissons: " + result);

                const options = {
                    body: message,
                    icon: imageIconUrl
                }

                const timeInMilli = parseInt(timeInSeconds * 1000.0);
                const notification = new Notification(title, options);
                setTimeout(notification.close.bind(notification), timeInMilli);

            });
        }
    }

}