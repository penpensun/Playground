package leetcode468validateipaddress;

public class Solution {
    public String validIPAddress(String IP){
        if(isIPv4(IP))
            return "IPv4";
        else if(isIPv6(IP))
            return "IPv6";
        return "Neither";

    }

    public boolean isIPv4(String ip){
        if(!ip.contains("."))
            return false;
        if(ip.startsWith(".") || ip.endsWith("."))
            return false;
        String tokens[] = ip.split("\\.");
        if(tokens.length != 4)
            return false;
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].startsWith("-"))
                return false;
            // System.out.println(tokens[i]);
            if(tokens[i].startsWith("0") && tokens[i].length() > 1)
                return false;
            if(tokens[i].isEmpty())
                return false;
            int intToken;
            try{
                intToken = Integer.parseInt(tokens[i]);
            }catch(Exception e){
                return false;
            }
            if (intToken <-1 || intToken > 255)
                return false;
        }
        return true;
    }

    public boolean isIPv6(String ip){
        if(!ip.contains(":"))
            return false;
        if(ip.startsWith(":") || ip.endsWith(":"))
            return false;
        String tokens[] = ip.split(":");
        if(tokens.length !=8 )
            return false;
        for (int i=0;i<tokens.length;i++){
            if(tokens[i].length()>4)
                return false;
            if(tokens[i].isEmpty())
                return false;
            for(int j=0;j<tokens[i].length();j++)
                if(!isHexadecimalDigit(tokens[i].charAt(j)))
                    return false;
        }
        return true;
    }


    public boolean isHexadecimalDigit(char c){
        if ((c>='0' && c<='9') ||
                (c>='a' && c<='f') ||
                (c>='A' && c<='F'))
            return true;
        else return false;
    }


    public static void main(String args[]){
        String test1 = "0.0.0.-0";
        String test2 = "421.23.4.1";
        String test3 = "255.255.255.255";
        String test4 = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        String test5 = "172.16.254.1";
        String test6 = "256.256.256.256";

        System.out.print(test1+"  ");
        System.out.println(new Solution().validIPAddress(test1));
        System.out.print(test2+"  ");
        System.out.println(new Solution().validIPAddress(test2));
        System.out.print(test3+"  ");
        System.out.println(new Solution().validIPAddress(test3));
        System.out.print(test4+"  ");
        System.out.println(new Solution().validIPAddress(test4));
        System.out.print(test5+"  ");
        System.out.println(new Solution().validIPAddress(test5));
        System.out.print(test6+"  ");
        System.out.println(new Solution().validIPAddress(test6));
    }
}
