/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 30/11/2019, 19:48:17
 * Last update: -
 */

class Validator {

	static isString(variable) {
		return typeof (variable) === 'string';
	}

	static isNumber(variable) {
		return typeof (variable) === 'number';
	}

	static isInteger(variable) {
		return Number.isInteger(variable);
	}

	static isIntegerBetweenInterval(variable, firstLimit, lastLimit) {
		return this.isInteger(variable) &&
			this.isInteger(firstLimit) &&
			this.isInteger(lastLimit) &&
			variable >= firstLimit &&
			variable <= lastLimit;
	}

	static isIntegerBetweenExclusiveInterval(variable, firstLimit, lastLimit) {
		return this.isInteger(variable) &&
			this.isInteger(firstLimit) &&
			this.isInteger(lastLimit) &&
			variable > firstLimit &&
			variable < lastLimit;
	}

	static isIntegerOutOfInterval(variable, firstLimit, lastLimit) {
		return this.isInteger(variable) &&
			this.isInteger(firstLimit) &&
			this.isInteger(lastLimit) &&
			variable < firstLimit &&
			variable > lastLimit;
	}

	static isIntegerOutOfInclusiveInterval(variable, firstLimit, lastLimit) {
		return this.isInteger(variable) &&
			this.isInteger(firstLimit) &&
			this.isInteger(lastLimit) &&
			variable <= firstLimit &&
			variable >= lastLimit;
	}

	static isFloat(variable) {
		return this.isNumber(variable)
			&& !this.isInteger(parseFloat(variable));
	}

	static isFloatBetweenInterval(variable, firstLimit, lastLimit) {
		return this.isFloat(variable) &&
			this.isFloat(firstLimit) &&
			this.isFloat(lastLimit) &&
			variable >= firstLimit &&
			variable <= lastLimit;
	}

	static isFloatBetweenExclusiveInterval(variable, firstLimit, lastLimit) {
		return this.isFloat(variable) &&
			this.isFloat(firstLimit) &&
			this.isFloat(lastLimit) &&
			variable > firstLimit &&
			variable < lastLimit;
	}

	static isFloatOutOfInterval(variable, firstLimit, lastLimit) {
		return this.isFloat(variable) &&
			this.isFloat(firstLimit) &&
			this.isFloat(lastLimit) &&
			variable < firstLimit &&
			variable > lastLimit;
	}

	static isFloatOutOfInclusiveInterval(variable, firstLimit, lastLimit) {
		return this.isFloat(variable) &&
			this.isFloat(firstLimit) &&
			this.isFloat(lastLimit) &&
			variable <= firstLimit &&
			variable >= lastLimit;
	}

	static isHexaNumber(variable) {
		return this.isString(variable) && /^[0-9a-fA-F]+$/.test(variable);
	}

	static isRgbValue(variable) {
		return this.isString(variable)
			&&
			(variable.length === 6 || variable.length === 7)
			&&
			(/^[0-9a-fA-F]+$/.test(variable)
				|| /^[0-9a-fA-F-#]+$/.test(variable));
	}

	static isRgbaValue(variable) {
		return this.isString(variable)
			&&
			(variable.length === 9 || variable.length === 10)
			&&
			(/^[0-9a-fA-F]+$/.test(variable)
				|| /^[0-9a-fA-F-#]+$/.test(variable));
	}

	static isBoolean(variable) {
		return typeof (variable) === 'boolean';
	}

	static isObjectOf(type, variable) {
		return variable instanceof type;
	}

	static isUndefined(variable) {
		return typeof (variable) === 'undefined';
	}

}

module.exports = Validator;