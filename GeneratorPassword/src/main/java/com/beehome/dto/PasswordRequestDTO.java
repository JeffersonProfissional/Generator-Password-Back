package com.beehome.dto;

public class PasswordRequestDTO {
    private int length;
    private boolean upperCase;
    private boolean lowerCase;
    private boolean numbers;
    private boolean specialChars;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isUpperCase() {
        return upperCase;
    }

    public void setUpperCase(boolean upperCase) {
        this.upperCase = upperCase;
    }

    public boolean isLowerCase() {
        return lowerCase;
    }

    public void setLowerCase(boolean lowerCase) {
        this.lowerCase = lowerCase;
    }

    public boolean isNumbers() {
        return numbers;
    }

    public void setNumbers(boolean numbers) {
        this.numbers = numbers;
    }

    public boolean isSpecialChars() {
        return specialChars;
    }

    public void setSpecialChars(boolean specialChars) {
        this.specialChars = specialChars;
    }
}
