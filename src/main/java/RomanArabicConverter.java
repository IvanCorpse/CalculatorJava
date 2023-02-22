class RomanArabicConverter {
    int romanToArabic(String romanNumber) throws Exception {
        String[] romanNumsArray = romanNumber.split("");
        int lastIndex = romanNumsArray.length - 1;
        int result = getArabic(romanNumsArray[lastIndex]);
        for (int i = lastIndex - 1; i >= 0; i--) {
            if (getArabic(romanNumsArray[i]) >= getArabic(romanNumsArray[i + 1])) {
                result += getArabic(romanNumsArray[i]);
            } else {
                result -= getArabic(romanNumsArray[i]);
            }
        }
        return result;
    }

    int getArabic(String romanDigit) throws Exception {
        String[] romanArray = {"I", "V", "X", "L", "C", "D", "M"};
        int[] arabicArray = {1,5,10,50,100,500,1000};
        for (int i = 0; i < romanArray.length; i++) {
            if (romanDigit.equals(romanArray[i])) {
                return arabicArray[i];
            }
        }
        throw new Exception("Не является римским числом.");
    }

    String arabicToRoman(int arabicNumber) throws Exception {
        if (arabicNumber < 1) {
            throw new Exception("Римские числа могут быть только положительными.");
        } else if (arabicNumber > 3999) {
            throw new Exception("Число больше 3999.");
        } else {
            String arabicString = Integer.toString(arabicNumber);
            String[] arabicArray = arabicString.split("");
            int numberPlace = arabicArray.length - 1;
            String result = "";
            for (int i = numberPlace, j = 0; i >= 0; i--, j++) {
                result += getRoman(arabicArray[j], i);
            }
            return result;
        }
    }

    String getRoman(String arabicNumber, int numberPlace) {
        int arabicNum = Integer.parseInt(arabicNumber);
        String[] romanUnits = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] romanTens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] romanHundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] romanThousands = {"", "M", "MM", "MMM"};
        String[][] romanDigits = new String[4][];
        romanDigits[0] = romanUnits;
        romanDigits[1] = romanTens;
        romanDigits[2] = romanHundreds;
        romanDigits[3] = romanThousands;
        return romanDigits[numberPlace][arabicNum];
    }
}