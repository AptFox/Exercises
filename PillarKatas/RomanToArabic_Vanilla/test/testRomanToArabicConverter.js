let converter = require('../RomanToArabicConverter.js');
let assert = require('assert');

describe('RomanToArabicConverter', function() {
    describe('convertSingleNumeralsToArabic', function() {
        it('should return zero when called with empty args', function() {
            assert.strictEqual(converter.convertToArabic(), "");
        });
        it('should return 1 when called with "I"', function() {
            assert.strictEqual(converter.convertToArabic("I"), "1");
        });
        it('should return 5 when called with "V"', function() {
            assert.strictEqual(converter.convertToArabic("V"), "5");
        });
        it('should return 10 when called with "X"', function() {
            assert.strictEqual(converter.convertToArabic("X"), "10");
        });
        it('should return 50 when called with "L"', function() {
            assert.strictEqual(converter.convertToArabic("L"), "50");
        });
        it('should return 50 when called with "C"', function() {
            assert.strictEqual(converter.convertToArabic("C"), "100");
        });
        it('should return 500 when called with "D"', function() {
            assert.strictEqual(converter.convertToArabic("D"), "500");
        });
        it('should return 1000 when called with "M"', function() {
            assert.strictEqual(converter.convertToArabic("M"), "1000");
        });
    });

    describe('convertMultipleNumeralsToArabic', function() {
        describe('pureSubtraction', function() {
            it('should return 4 when called with "IV"', function() {
                assert.strictEqual(converter.convertToArabic("IV"), "4");
            });
            it('should return 9 when called with "IX"', function() {
                assert.strictEqual(converter.convertToArabic("IX"), "9");
            });
            it('should return 40 when called with "XL"', function() {
                assert.strictEqual(converter.convertToArabic("XL"), "40");
            });
            it('should return 90 when called with "XC"', function() {
                assert.strictEqual(converter.convertToArabic("XC"), "90");
            });
            it('should return 400 when called with "CD"', function() {
                assert.strictEqual(converter.convertToArabic("CD"), "400");
            });
            it('should return 900 when called with "CM"', function() {
                assert.strictEqual(converter.convertToArabic("CM"), "900");
            });
        });
        describe('pureAddition', function() {
            it('should return 3 when called with "III"', function() {
                assert.strictEqual(converter.convertToArabic("III"), "3");
            });
            it('should return 30 when called with "XXX"', function() {
                assert.strictEqual(converter.convertToArabic("XXX"), "30");
            });
            it('should return 300 when called with "CCC"', function() {
                assert.strictEqual(converter.convertToArabic("CCC"), "300");
            });
            it('should return 6 when called with "VI"', function() {
                assert.strictEqual(converter.convertToArabic("VI"), "6");
            });
            it('should return 8 when called with "VIII"', function() {
                assert.strictEqual(converter.convertToArabic("VIII"), "8");
            });
            it('should return 1066 when called with "MLXVI"', function() {
                assert.strictEqual(converter.convertToArabic("MLXVI"), "1066");
            });
        });
        describe.skip('additionAndSubtraction', function() {
            it('should return 2019 when called with "MMXIX"', function() {
                assert.strictEqual(converter.convertToArabic("MMXIX"), "2019");
            });
        });
    });
});