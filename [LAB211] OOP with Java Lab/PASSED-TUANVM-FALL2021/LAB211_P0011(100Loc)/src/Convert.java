
import java.math.BigInteger;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 */
class Convert {

    final String valueHex = "0123456789ABCDEF";

    String convertValue(String valueInput, int baseInput, int baseOutput) {
        String result = "";
        switch (baseInput) {
            case 10:
                result = convertDecToOther(valueInput, baseOutput);
                break;
            case 2:
                result = convertBinToOther(valueInput, baseOutput);
                break;
            case 16:
                result = convertHexToOther(valueInput, baseOutput);
                break;
        }
        return result;
    }

    private String convertDecToOther(String valueInput, int baseOutput) {
        BigInteger numberIn = new BigInteger(valueInput);
        StringBuilder result = new StringBuilder();
        BigInteger outputBase = new BigInteger(Integer.toString(baseOutput));
        do {
            BigInteger remain = numberIn.remainder(outputBase);
            char hexValue = valueHex.charAt(remain.intValue());
            //compare value of numberIn with 0
            if (!numberIn.equals(new BigInteger("0"))) {
                result = result.append(hexValue);
                numberIn = numberIn.divide(outputBase);
            } else {
                break;
            }
        } while (true);
        return result.reverse().toString();
    }

    private String convertBinToOther(String valueInput, int baseOutput) {
        BigInteger numberIn = new BigInteger(valueInput);
        BigInteger inputBase = new BigInteger("2");
        BigInteger outputBase = new BigInteger(Integer.toString(baseOutput));
        String result = "";
        switch (baseOutput) {
            case 10:
                BigInteger valueByConvert = new BigInteger("0");
                //loop use to access each character of string from begining to the end
                for (int i = 0; i < valueInput.length(); i++) {
                    String digit = Character.toString(valueInput.charAt(i));
                    BigInteger coefficient = new BigInteger(digit);
                    valueByConvert = valueByConvert.add(
                            coefficient.multiply(inputBase.pow(valueInput.length() - 1 - i)));
                }
                result = valueByConvert.toString();
                break;
            case 16:
                HashMap<String, String> BinToHex = new HashMap<String, String>();
                BinToHex.put("0000", "0");
                BinToHex.put("0001", "1");
                BinToHex.put("0010", "2");
                BinToHex.put("0011", "3");
                BinToHex.put("0100", "4");
                BinToHex.put("0101", "5");
                BinToHex.put("0110", "6");
                BinToHex.put("0111", "7");
                BinToHex.put("1000", "8");
                BinToHex.put("1001", "9");
                BinToHex.put("1010", "A");
                BinToHex.put("1011", "B");
                BinToHex.put("1100", "C");
                BinToHex.put("1101", "D");
                BinToHex.put("1110", "E");
                BinToHex.put("1111", "F");
                //check remain of length of valueInput divided by 4 equal 0 or not
                while (valueInput.length() % 4 != 0) {
                    valueInput = "0" + valueInput;
                }
                //loop use to access each substring with length = 4 
                //of string from begining to the end
                for (int i = 0; i < valueInput.length(); i+=4) {
                    String key = valueInput.substring(i, i+4);
                    result += BinToHex.get(key);
                }
                break;
        }
        return result;
    }

    private String convertHexToOther(String valueInput, int baseOutput) {
        BigInteger inputBase = new BigInteger("16");
        BigInteger outputBase = new BigInteger(Integer.toString(baseOutput));
        String result = "";
        switch(baseOutput){
            case 2:
                HashMap<String, String> HexToBin = new HashMap<String, String>();
                HexToBin.put("0", "0000");
                HexToBin.put("1", "0001");
                HexToBin.put("2", "0010");
                HexToBin.put("3", "0011");
                HexToBin.put("4", "0100");
                HexToBin.put("5", "0101");
                HexToBin.put("6", "0110");
                HexToBin.put("7", "0111");
                HexToBin.put("8", "1000");
                HexToBin.put("9", "1001");
                HexToBin.put("A", "1010");
                HexToBin.put("B", "1011");
                HexToBin.put("C", "1100");
                HexToBin.put("D", "1101");
                HexToBin.put("E", "1110");
                HexToBin.put("F", "1111");
                //loop use to access each character of string from begining to the end
                for (int i = 0; i < valueInput.length(); i++) {
                    String key = Character.toString(valueInput.charAt(i));
                    result += HexToBin.get(key);
                }
                break;
            case 10:
                BigInteger valueByConvert = new BigInteger("0");
                //loop use to access each character of string from begining to the end
                for (int i = 0; i < valueInput.length(); i++) {
                    int digit = valueHex.indexOf(Character.toString(valueInput.charAt(i)));
                    BigInteger coefficient = new BigInteger(Integer.toString(digit));
                    valueByConvert = valueByConvert.add(
                            coefficient.multiply(inputBase.pow(valueInput.length() - 1 - i)));
                }
                result = valueByConvert.toString();
        }
        return result;
    }

}
