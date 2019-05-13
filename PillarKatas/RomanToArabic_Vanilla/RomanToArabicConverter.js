let converter = {};
let numeralMap = new Map([[undefined, ""],["I", 1],["V",5],["X",10],["L",50],["C",100],["D",500],["M",1000]]);

converter.convertToArabic = function(numeral) {
    let convertedString = numeral;
    let numeralIsDefined = typeof numeral === 'undefined';
    if(numeralIsDefined){
        convertedString = "";
    }
    else{
        let numeralArray = convertNumeralsToNums(numeral);
        let largestPos = findLargestNumberPos(numeralArray);
        let modifiedArr = calculateSubtractions(numeralArray, largestPos);
        convertedString  = addAllArrayValues (modifiedArr, largestPos);
    }
    return convertedString.toString();
};

function findLargestNumberPos(numeralArray){
    let largest = 0;
    for(let i = 0; i < numeralArray.length; i++){
        if(numeralArray[i] > largest){
            largest =  numeralArray[i];
        }
    }
    return numeralArray.indexOf(largest);
}

function convertNumeralsToNums(numeral){
    let numeralArray = numeral.split("");
    for(let i = 0; i < numeralArray.length; i++){
        numeralArray[i] = numeralMap.get(numeralArray[i]);
    }
    return numeralArray;
}

function addAllArrayValues (array, largestPos){
    let addVal = array[largestPos];
    for(let i = largestPos+1; i < array.length; i++){
        addVal += array[i];
    }
    return addVal;
}

function calculateSubtractions (array, largestPos){
    let subtractionArray = array.slice();
    for(let i = largestPos, j = largestPos-1; i < subtractionArray.length; i++, j++){
        if(subtractionArray[j] < subtractionArray[i]){
            subtractionArray[i] -= subtractionArray[j];
            subtractionArray[j] = 0;
        }
    }
    return subtractionArray;
}

module.exports = converter;