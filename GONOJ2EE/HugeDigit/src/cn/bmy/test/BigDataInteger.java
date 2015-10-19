package cn.bmy.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BigDataInteger {
    private List<Integer> value;
    
    public BigDataInteger(String val) {
        // ȡ���ֲ���
        String v = val.charAt(0) == '-' ? val.substring(1) : val;
        // ÿ�Ă���Ԫ������һ�� int
        value = new ArrayList<>();
        for(int i = v.length() - 4; i > -4; i -= 4) {
            value.add(Integer.parseInt(v.substring(i >= 0 ? i : 0, i + 4)));
        }
        // �aλ��λ���� 8 ���λ
        int valueLength = (value.size() / 8 + 1) * 8;
        for(int i = value.size(); i < valueLength; i++) {
            value.add(0);
        }
        // ؓ���D�a����ʾ
        value = val.charAt(0) == '-' ? toComplement(value) : value;        
    }

    private BigDataInteger(List<Integer> value) {
        this.value = value;
    }
    
    public BigDataInteger add(BigDataInteger that) {
        if(isNegative(that.value)) {
            return subtract(new BigDataInteger(toComplement(that.value)));
        }
        // ���Rλ��
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
        
        if(carry == 1) { // ��λ̎��
            if(isPositive(op1)) { result.add(1); } 
            else { result.clear(); } // ؓ���ӷ��\����λ���� 0
            for(int i = 0; i < 8; i++) { result.add(0); } // �Ԅ����� 8 λ��
        } else { // �aλ�������a 0��ؓ���a 9999
            result.add(isPositive(op1) ? 0 : 9999);
        }
        return new BigDataInteger(result);
    }
    
    public BigDataInteger subtract(BigDataInteger that) {
        if(isNegative(that.value)) {
            return add(new BigDataInteger(toComplement(that.value)));
        }
        // ���Rλ��
        int length = Math.max(value.size(), that.value.size());
        List<Integer> op1 = copyOf(value, length);
        List<Integer> op2 = copyOf(that.value, length);
        List<Integer> result = new ArrayList<>();
        
        int borrow = 0;
        for(int i = 0; i < length - 1; i++) { 
            int c = op1.get(i) - op2.get(i) - borrow; 
            if(c > -1) {
                borrow = 0;
            } else { // ��λ 
                c += 10000; 
                borrow = 1; 
            }
            result.add(c);
        }
        
        if(borrow == 1) { // ��λ̎��
            if(isNegative(op1)) { result.add(9998); } 
            else { result.clear(); } // �����p���\����λ���� 0
            for(int i = 0; i < 8; i++) { result.add(9999); } // �Ԅ����� 8 λ��
        } else {  // �aλ��ؓ���a 9999�������a 0
            result.add(isNegative(op1) ? 9999 : 0);
        }
        
        return new BigDataInteger(result);
    }

    // ���\��Ԫ�� int �r�ĳ˷��\�㣬�Ȳ�ʹ�ã��ɂ��\��Ԫ��Ҫ������
    private BigDataInteger multiply(int val, int shift) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < shift; i++) { result.add(0); } // λ���a 0
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
        // �D������ʾ
        BigDataInteger op1 = isNegative(value) ? 
                           new BigDataInteger(toComplement(value)) : this;
        List<Integer> op2 = isNegative(that.value) ? 
                                      toComplement(that.value) : that.value;
        // ��λ�\��
        List<BigDataInteger> rs = new ArrayList<>();
        for(int i = 0; i < op2.size() - 1; i++) {
            rs.add(op1.multiply(op2.get(i), i));
        }
        // ����λ�\��Y���ӿ�
        BigDataInteger result = rs.get(0);
        for(int i = 1; i < rs.size(); i++) {
            result = result.add(rs.get(i));
        }
        // �Д���ؓ��
        return getLast(value) + getLast(that.value) == 9999 ? 
            new BigDataInteger(toComplement(result.value)) : result;
    }
    
    public boolean greaterOrEquals(BigDataInteger that) {
        return isNegative(subtract(that).value) ? false : true;
    }
    
    private boolean islessOrEqualsToQuotient(BigDataInteger op1, BigDataInteger op2) {
        return op1.greaterOrEquals(multiply(op2)) ? true : false;
    }
    
    // ���\��Ԫ�� int �r�ĳ����\�㣬�Ȳ�ʹ�ã��ɂ��\��Ԫ��Ҫ������
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
        // һ������������ʾ
        BigDataInteger op1 = isNegative(value) ? 
                             new BigDataInteger(toComplement(value)) : this;
        BigDataInteger op2 = isNegative(that.value) ? 
                             new BigDataInteger(toComplement(that.value)) : that;
        
        BigDataInteger one = new BigDataInteger("1");
        BigDataInteger left = new BigDataInteger("0");
        BigDataInteger right = op1;

        // ���ַ��ь� x.islessOrEqualsToQuotient(op1, op2) �� true ����� x ֵ
        while(right.greaterOrEquals(left)) {
            BigDataInteger x = left.add(right).divide(2);
            if(x.islessOrEqualsToQuotient(op1, op2)) {
                left = x.add(one);
            } else {
                right = x.subtract(one);
            }
        }
        BigDataInteger result = left.subtract(one);

        // �Д���ؓ��
        return getLast(value) + getLast(that.value) == 9999 ? 
            new BigDataInteger(toComplement(result.value)) : result;
    }
    
    public String toString() {
        // һ����������ʾ
        List<Integer> v = isNegative(value) ? toComplement(value) : value;
        StringBuilder builder = new StringBuilder();
        for(int i = v.size() - 1; i > -1; i--) {
            builder.append(String.format("%04d", v.get(i)));
        }
        // ��ȥǰ�˵� 0��ؓ���a̖ؓ
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