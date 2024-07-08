package net.dunice.advancedjavaprojectacademy.tasks.block2;

import java.util.*;

import static java.lang.Integer.bitCount;

public class Block2 implements Block2Interface{
    @Override
    public <T> Collection<T> getWithoutDublicates(Collection<T> collection) {
        HashSet h = new HashSet(collection);
        return (Collection<T>) List.of(h);
    }

    @Override
    public <T> T[] arrayIterator(T[] array) {
        for (var value : array){
            System.out.println(value);
        }
        return null;
    }

    @Override
    public Integer countNumber(Integer number) {
        int twoCount = 0;

        while (number !=0 ) {
            if (number % 10 == 2) {
                twoCount ++;
            }
        number /= 10;
        }

        return twoCount;
    }

    @Override
    public boolean isPermutationStrings(String str1, String str2) {
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
        for (var letter : charSource){
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

        int j = charGivenString.length - 1;
        boolean validString = true;
        for (int i = 0; i < charGivenString.length; i++) {
            if (charGivenString[i] == '(') {
                validString = false;
                while (j > -1) {
                    if(charGivenString[j] == ')') {
                        validString = true;
                        charGivenString[j] = ' ';
                        charGivenString[i] = ' ';
                        j--;
                        break;
                    }
                    j--;
                }
                if (validString == false) {
                    break;
                }
            }
            if (charGivenString[i] == ')') {
                validString = false;
                break;
            }
        }

        return validString;
    }

    @Override
    public String getModifyingString(String noBracketsString) {
        char charNoBracketsString[] = noBracketsString.toCharArray();
        int j = charNoBracketsString.length - 1;
        int i = 0;
        String bracketsStringBegin = "";
        while (i < ((charNoBracketsString.length + 1) / 2)) {
            bracketsStringBegin += "(" + charNoBracketsString[i];
            i++;
        }
        if(charNoBracketsString.length % 2 == 0) {
            bracketsStringBegin += charNoBracketsString[i];
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
        return outString;
    }

    @Override
    public int numberOfIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
