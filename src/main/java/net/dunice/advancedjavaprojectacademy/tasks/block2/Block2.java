package net.dunice.advancedjavaprojectacademy.tasks.block2;

import java.util.*;

public class Block2 implements Block2Interface {
    @Override
    public <T> Collection<T> getWithoutDublicates(Collection<T> collection) {
        return new HashSet(collection);
    }

    @Override
    public <T> T[] arrayIterator(T[] array) {
        for (var value : array) {
            System.out.println(value);
        }
        return array;
    }

    @Override
    public Integer countNumber(Integer number) {
        int twoCount = 0;
        int nowNumber;
        for (int i = 2; i <= number; i++) {
            nowNumber = i;
            while (nowNumber != 0) {
                if (nowNumber % 10 == 2) {
                    twoCount++;
                }
                nowNumber /= 10;
            }
        }
        return twoCount;
    }

    @Override
    public boolean isPermutationStrings(String str1, String str2) {
        if (str1.isEmpty() && str2.isEmpty()) {
            return false;
        }

        char Array1[] = str1.toCharArray();
        Arrays.sort(Array1);
        char Array2[] = str2.toCharArray();
        Arrays.sort(Array2);

        str2 = String.valueOf(Array2);
        str1 = String.valueOf(Array1);
        return str1.equals(str2);
    }

    @Override
    public String getCompressedString(String noCompressedString) {
        char charArrayCommpressing[] = noCompressedString.toCharArray();
        String compressingString = "";
        if(noCompressedString.isEmpty()) {
            return "";
        }
        if (noCompressedString.equals(" ")) {
            return " ";
        }
        for (int i = 0; i != noCompressedString.length() - 1; i++) {
            int j = i;
            int count = 0;
            if (charArrayCommpressing[i] == charArrayCommpressing[i + 1]) {
                compressingString += charArrayCommpressing[i];
                while (charArrayCommpressing[j] == charArrayCommpressing[j + 1]) {
                    count ++;
                    j++;
                    if (j + 1 == noCompressedString.length()-1) {
                        count++;
                        break;
                    }
                }
                i = j;
                compressingString += ++count;
            }else {
                compressingString += charArrayCommpressing[i] + "1";
            }
        }

        if (compressingString.length() <= noCompressedString.length()) {
            return compressingString;
        } else {
            return noCompressedString;
        }
    }

    @Override
    public Character getFrequencyCharacter(String source) {
        char charSource[] = source.toCharArray();
        LinkedHashMap<Character, Integer> mapSource = new LinkedHashMap<>();
        for (var letter : charSource) {
            if (mapSource.containsKey(letter) == false) {
                mapSource.put(letter, 1);
            }
            else {
                int p = mapSource.get(letter) + 1;
                mapSource.put(letter,p);
            }
        }

        Character maxLetter = 'a';
        int maxCount = 0;
        for(var mapSourceElement :  mapSource.entrySet()){
            if (maxCount < mapSource.get(mapSourceElement.getKey())){
                maxCount = mapSourceElement.getValue();
                maxLetter = mapSourceElement.getKey();
            }
        }
        return maxLetter;
    }

    @Override
    public boolean isStringValid(String givenString) {
        char charGivenString[] = givenString.toCharArray();
        Stack<Character> validStack = new Stack<>();
        char value1 = 0;
        for (var value :charGivenString){
            if (value == '(' || value == '[' || value == '{') {
                validStack.push(value);
            }
            if (value == ')'|| value == '}' || value == ']') {
                if(validStack.isEmpty()) {
                    return false;
                }else if ( (value == ')' && validStack.get(validStack.size()-1) == '(') ||
                        (value == ']' && validStack.get(validStack.size()-1) == '[') ||
                        (value == '}' && validStack.get(validStack.size()-1) == '{')) {
                    validStack.pop();
                }
            }
        }
        if (validStack.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String getModifyingString(String noBracketsString) {
        char charNoBracketsString[] = noBracketsString.toCharArray();
        int j = charNoBracketsString.length - 1;
        int i = 0;
        String bracketsStringBegin = "";
        if(noBracketsString.isEmpty()) {
            return "()";
        }
        while (i < ((charNoBracketsString.length + 1) / 2)) {
            bracketsStringBegin += "(" + charNoBracketsString[i];
            i++;
        }
        if(charNoBracketsString.length % 2 == 0) {
            bracketsStringBegin += "()" + charNoBracketsString[i];
            i++;
        }
        while (i < charNoBracketsString.length ) {
            bracketsStringBegin += ")" + charNoBracketsString[i];
            i++;
        }
        return bracketsStringBegin + ")";
    }

    @Override
    public String getValidStringNoSpaces(String string) {
        char charString[] = string.toCharArray();
        String outString = "";
        for (int i = 0; i < charString.length; i++) {
            if (charString.length != i + 1 && charString[i] == ' ' && charString[i + 1] == ' ') {
                continue;
            }
            outString += charString[i];
        }
        return outString.trim();
    }

    @Override
    public int numberOfIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]){
                    count++;
                }
            }
        }
        return count;
    }
}