let converter = {};
var numeralMap = new Map([[undefined, ""],["I", 1],["V",5],["X",10]]);

converter.convertToArabic = function(numeral) { //function name
    var convertedString = numeral;
    var numeralIsDefined = typeof numeral !== 'undefined';

    if(!numeralIsDefined){
        convertedString = "";
    }
    else if(numeralIsDefined && numeral.length === 1){
        convertedString = numeralMap.get(numeral);
    }else{
        //split string into an array
        var numeralArray = numeral.split("");
        //convert each pos of array to arabic
        var largest = 0;
        for(let i = 0; i < numeralArray.length; i++){
            numeralArray[i] = numeralMap.get(numeralArray[i]);
            //find largest pos
            if(numeralArray[i] > largest){
                largest =  numeralArray[i];
            }
        }
        var largestPos = numeralArray.indexOf(largest);
        if(largestPos > 0){
            var subtractVal = numeralArray[largestPos-1];
            convertedString = largest - subtractVal;
/*            for(let i = largestPos-1; i > 0; i--){
                //each iteration works in two's
                //get positive val for right pos1
                //subtract left val from pos1
                subtractVal -= numeralArray[i];
            }*/
        }
        else if (largestPos < numeralArray.length){
            var addVal = numeralArray[largestPos];
            for(let i = largestPos+1; i < numeralArray.length; i++){
                addVal += numeralArray[i];
            }
            convertedString  = addVal;
        }
    }
    return convertedString.toString();
};

//store each char from string in an array
    //iterate through array and convert each position to arabic equivalent
    //find the largest element in the array
    //add up all element to the left and subtract from largest
    //add up all elements to the right and add to largest
//return (this might work with recursion)

module.exports = converter;