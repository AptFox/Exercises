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
    });

    describe('convertMultipleNumeralsToArabic', function() {
        describe('subtraction', function() {
            it('should return 4 when called with "IV"', function() {
                assert.strictEqual(converter.convertToArabic("IV"), "4");
            });
        });
        describe('addition', function() {
            it('should return 6 when called with "VI"', function() {
                assert.strictEqual(converter.convertToArabic("VI"), "6");
            });
            it('should return 8 when called with "VIII"', function() {
                assert.strictEqual(converter.convertToArabic("VIII"), "8");
            });
        });
    });
});