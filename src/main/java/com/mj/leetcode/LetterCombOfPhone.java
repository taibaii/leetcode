package com.mj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.util.StringUtils;

/**
 * @author onlineGenerator-by wuxm4
 * @version V1.0
 * @Title:
 * @Description:
 * @date 2020-1-28
 */
public class LetterCombOfPhone {
    private static List<String> list = Arrays.asList("abc","def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");

    private  List<Integer> filterDigits (String digits, int digLen) {
        // 重新计算过滤0和1后输入的数字字符串长度
        List<Integer> intArr = new ArrayList<Integer>();
        for(int a=0;a<digLen;a++){
            int num = digits.charAt(a)-'0';
            // 过滤输入0和1的空映射
            if(num==1 || num==0){
                continue;
            }
            intArr.add(num);
        }
        return  intArr;
    }

    public List<String> letterCombinations(String digits) {
        List<String> resList = new ArrayList<>();
        if(StringUtils.isEmpty(digits)) {
            return resList;
        }

        int digLen = digits.length();
        List<Integer> intArr = filterDigits(digits,digLen);
        digLen=intArr.size();
        if(digLen>0) {
            String str = list.get(intArr.get(0)-2);
            int strLen =str.length();
            for(int i=0;i<strLen;i++){
                if(digLen>1){
                    resList.addAll(joinStr(String.valueOf(str.charAt(i)),intArr,1, digLen));
                }else{
                    resList.add(String.valueOf(str.charAt(i)));
                }
            }
        }else{
            return resList;
        }
        return resList;
    }

    private List<String> joinStr(String str,  List<Integer> intArr, int cursor,int digLen) {
        List<String> subList = new ArrayList<String>();
        String cur =   list.get(intArr.get(cursor )-2);
        int len= cur.length();//3
        for(int i=0;i<len;i++){
            if(digLen-cursor -1>0){
                subList.addAll(joinStr(str+cur.charAt(i),intArr,cursor+1,digLen));
            }else {
                subList.add(str + cur.charAt(i));
            }
        }
        return subList;
    }
}
