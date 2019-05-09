package com.bignum.andrey.bignumcalculator.feature;

public class Multiplication {
    static String multiplicate(String num1, String num2){
        String tempnum1 = num1;
        String tempnum2 = num2;
        if(num1.charAt(0) == '-' && num2.charAt(0)!='-')
        {
            num1 = num1.substring(1);
        }
        else if(num1.charAt(0) != '-' && num2.charAt(0) == '-')
        {
            num2 = num2.substring(1);
        }
        else if(num1.charAt(0) == '-' && num2.charAt(0) == '-')
        {
            num1 = num1.substring(1);
            num2 = num2.substring(1);
        }
        String s1 = new StringBuffer(num1).reverse().toString();
        String s2 = new StringBuffer(num2).reverse().toString();

        int[] m = new int[s1.length()+s2.length()];

        // Go from right to left in num1
        for (int i = 0; i < s1.length(); i++)
        {
            // Go from right to left in num2
            for (int j = 0; j < s2.length(); j++)
            {
                m[i+j] = m[i+j]+(s1.charAt(i)-'0')*(s2.charAt(j)-'0');

            }
        }


        StringBuilder product = new StringBuilder();
        // Multiply with current digit of first number
        // and add result to previously stored product
        // at current position.
        for (int i = 0; i < m.length; i++)
        {
            int digit = m[i]%10;
            int carry = m[i]/10;
            if(i+1<m.length)
            {
                m[i+1] = m[i+1] + carry;
            }
            product.insert(0, digit);

        }

        // ignore '0's from the right
        while(product.length()>1 && product.charAt(0) == '0')
        {
            product = new StringBuilder(product.substring(1));
        }

        // Check condition if one string is negative
        if(tempnum1.charAt(0) == '-' && tempnum2.charAt(0)!='-')
        {
            product = new StringBuilder(new StringBuffer(product.toString()).insert(0, '-').toString());
        }
        else if(tempnum1.charAt(0) != '-' && tempnum2.charAt(0) == '-')
        {
            product = new StringBuilder(new StringBuffer(product.toString()).insert(0, '-').toString());
        }
        else if(tempnum1.charAt(0) == '-' && tempnum2.charAt(0) == '-')
        {
            product = new StringBuilder(product.toString());
        }
        return product.toString();
    }
}
