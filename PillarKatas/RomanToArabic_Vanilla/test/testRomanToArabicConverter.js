let converter = require('../RomanToArabicConverter.js');
let assert = require('assert');

describe('RomanToArabicConverter', function() {
    describe('convertToArabic', function() {
        it('should return zero when called with empty args', function() {
            assert.strictEqual(converter.convertToArabic(), "");
        });
    });
});