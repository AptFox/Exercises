let converter = {};

converter.convertToArabic = function(numeral) { //function name
    var convertedString;
    if (numeral === undefined) {
        convertedString = "";
    }
    if(numeral === "I"){
        convertedString = "1";
    }
    return convertedString;
};

module.exports = converter;