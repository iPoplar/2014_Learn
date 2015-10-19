package cn.bmy.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BigDataInteger {
    private List<Integer> value;
    
    public BigDataInteger(String val) {
        // 取數字部份
        String v = val.charAt(0) == '-' ? val.substring(1) : val;
        // 每四個字元剖析為一個 int
        value = new ArrayList<>();
        for(int i = v.length() - 4; i > -4; i -= 4) {
            value.add(Integer.parseInt(v.substring(i >= 0 ? i : 0, i + 4)));
        }
        // 補位，位數以 8 為單位
        int valueLength = (value.size() / 8 + 1) * 8;
        for(int i = value.size(); i < valueLength; i++) {
            value.add(0);
        }
        // 負數轉補數表示
        value = val.charAt(0) == '-' ? toComplement(value) : value;        
    }

    private BigDataInteger(List<Integer> value) {
        this.value = value;
    }
    
    public BigDataInteger add(BigDataInteger that) {
        if(isNegative(that.value)) {
            return subtract(new BigDataInteger(toComplement(that.value)));
        }
        // 對齊位數
        int length = Math.max(value.size(), that.value.size());
        List<Integer> op1 = copyOf(value, length);
        List<Integer> op2 = copyOf(that.value, length);
        List<Integer> result = new ArrayList<>();
        
        int carry = 0;
        for(int i = 0; i < length - 1; i++) {
            int c = op1.get(i) + op2.get(i) + carry;
            if(c < 10000) {
                carry = 0;
            } else {
                c -= 10000;
                carry = 1;
            }
            result.add(c);
        }
        
        if(carry == 1) { // 溢位處理
            if(isPositive(op1)) { result.add(1); } 
            else { result.clear(); } // 負數加法運算溢位就是 0
            for(int i = 0; i < 8; i++) { result.add(0); } // 自動增加 8 位數
        } else { // 補位，正數補 0，負數補 9999
            result.add(isPositive(op1) ? 0 : 9999);
        }
        return new BigDataInteger(result);
    }
    
    public BigDataInteger subtract(BigDataInteger that) {
        if(isNegative(that.value)) {
            return add(new BigDataInteger(toComplement(that.value)));
        }
        // 對齊位數
        int length = Math.max(value.size(), that.value.size());
        List<Integer> op1 = copyOf(value, length);
        List<Integer> op2 = copyOf(that.value, length);
        List<Integer> result = new ArrayList<>();
        
        int borrow = 0;
        for(int i = 0; i < length - 1; i++) { 
            int c = op1.get(i) - op2.get(i) - borrow; 
            if(c > -1) {
                borrow = 0;
            } else { // 借位 
                c += 10000; 
                borrow = 1; 
            }
            result.add(c);
        }
        
        if(borrow == 1) { // 溢位處理
            if(isNegative(op1)) { result.add(9998); } 
            else { result.clear(); } // 正數減法運算溢位就是 0
            for(int i = 0; i < 8; i++) { result.add(9999); } // 自動增加 8 位數
        } else {  // 補位，負數補 9999，正數補 0
            result.add(isNegative(op1) ? 9999 : 0);
        }
        
        return new BigDataInteger(result);
    }

    // 右運算元為 int 時的乘法運算，內部使用，兩個運算元都要是正數
    private BigDataInteger multiply(int val, int shift) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < shift; i++) { result.add(0); } // 位移補 0
        int carry = 0;
        for(int i = 0; i < value.size() - 1; i++) {
            int tmp = value.get(i) * val + carry;
            result.add(tmp % 10000);
            carry = tmp / 10000;
        }
        if(carry != 0) {
            result.add(carry);
            for(int i = 0; i < 8; i++) { result.add(0); }
        } else { result.add(0); }

        return new BigDataInteger(result);
    }
    
    public BigDataInteger multiply(BigDataInteger that) {
        // 轉正數表示
        BigDataInteger op1 = isNegative(value) ? 
                           new BigDataInteger(toComplement(value)) : this;
        List<Integer> op2 = isNegative(that.value) ? 
                                      toComplement(that.value) : that.value;
        // 逐位運算
        List<BigDataInteger> rs = new ArrayList<>();
        for(int i = 0; i < op2.size() - 1; i++) {
            rs.add(op1.multiply(op2.get(i), i));
        }
        // 對逐位運算結果加總
        BigDataInteger result = rs.get(0);
        for(int i = 1; i < rs.size(); i++) {
            result = result.add(rs.get(i));
        }
        // 判斷正負數
        return getLast(value) + getLast(that.value) == 9999 ? 
            new BigDataInteger(toComplement(result.value)) : result;
    }
    
    public boolean greaterOrEquals(BigDataInteger that) {
        return isNegative(subtract(that).value) ? false : true;
    }
    
    private boolean islessOrEqualsToQuotient(BigDataInteger op1, BigDataInteger op2) {
        return op1.greaterOrEquals(multiply(op2)) ? true : false;
    }
    
    // 右運算元為 int 時的除法運算，內部使用，兩個運算元都要是正數
    private BigDataInteger divide(int that) {
        List<Integer> result = new ArrayList<>();
        int remain = 0;
        for(int i = value.size() - 1; i > -1; i--) {
            int tmp = value.get(i) + remain;
            result.add(tmp / that);
            remain = (tmp % that) * 10000;
        }
        Collections.reverse(result);
        for(int i = 0; i < 8 - (result.size() % 8); i++) {
            result.add(0);
        }
        return new BigDataInteger(result);
    }

    public BigDataInteger divide(BigDataInteger that) {
        // 一律先以正數表示
        BigDataInteger op1 = isNegative(value) ? 
                             new BigDataInteger(toComplement(value)) : this;
        BigDataInteger op2 = isNegative(that.value) ? 
                             new BigDataInteger(toComplement(that.value)) : that;
        
        BigDataInteger one = new BigDataInteger("1");
        BigDataInteger left = new BigDataInteger("0");
        BigDataInteger right = op1;

        // 二分法搜尋 x.islessOrEqualsToQuotient(op1, op2) 為 true 的最大 x 值
        while(right.greaterOrEquals(left)) {
            BigDataInteger x = left.add(right).divide(2);
            if(x.islessOrEqualsToQuotient(op1, op2)) {
                left = x.add(one);
            } else {
                right = x.subtract(one);
            }
        }
        BigDataInteger result = left.subtract(one);

        // 判斷正負數
        return getLast(value) + getLast(that.value) == 9999 ? 
            new BigDataInteger(toComplement(result.value)) : result;
    }
    
    public String toString() {
        // 一律以正數表示
        List<Integer> v = isNegative(value) ? toComplement(value) : value;
        StringBuilder builder = new StringBuilder();
        for(int i = v.size() - 1; i > -1; i--) {
            builder.append(String.format("%04d", v.get(i)));
        }
        // 移去前端的 0，負數補負號
        while(builder.length() > 0 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }
        return builder.length() == 0 ? "0" : 
                   isNegative(value) ? builder.insert(0, '-').toString() : 
                       builder.toString();
    }
        
    private static List<Integer> toComplement(List<Integer> v) {
        List<Integer> comp = new ArrayList<>();
        for(Integer i : v) { comp.add(9999 - i); }
        comp.set(0, comp.get(0) + 1);
        return comp;
    }
    
    private static List<Integer> copyOf(
                List<Integer> original, int newLength) {
        List<Integer> v = new ArrayList<>(original);
        for(int i = v.size(); i < newLength; i++) {
            v.add(isPositive(original) ? 0 : 9999);
        }
        return v;
    }
    
    private static Integer getLast(List<Integer> list) {
        return list.get(list.size() - 1);
    }
    
    private static boolean isNegative(List<Integer> list) {
        return getLast(list) == 9999;
    }
    
    private static boolean isPositive(List<Integer> list) {
        return getLast(list) == 0;
    }
    
    private static boolean isZero(List<Integer> list) {
        for(Integer i : list) if(i != 0) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        BigDataInteger a = new BigDataInteger("9999999999999999999999");
        BigDataInteger b = new BigDataInteger("111111111111111");
        System.out.println(a.add(b)+"+");//out.println(a.add(b));       // 9999999999999999999999999997
        System.out.println(a.subtract(b)+"-");
        System.out.println(a.multiply(b)+"*");
        System.out.println(a.divide(b)+"/");
        /*out.println(a.subtract(b));  // 10000000000000000000000000001
        out.println(a.multiply(b));  // -19999999999999999999999999998
        out.println(a.divide(b));  */  // -4999999999999999999999999999
    }
}