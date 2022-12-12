package com.leetcode;

public class MaxBalloons {
    public static void main(String[] args) {
//        System.out.println(new MaxBalloons().maxNumberOfBalloons("nlaebolko"));//1
//        System.out.println(new MaxBalloons().maxNumberOfBalloons("loonbalxballpoon"));//2
//        System.out.println(new MaxBalloons().maxNumberOfBalloons("test"));//0
        System.out.println(new MaxBalloons().maxNumberOfBalloons("krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw"));//0
    }

    public int maxNumberOfBalloons(String text) {
        String balloon = "balloon";
        int bCounter = 0;
        int aCounter = 0;
        int lCounter = 0;
        int oCounter = 0;
        int nCounter = 0;

        if (text.length() < balloon.length()) {
            return 0;
        }

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if(c == 'b') {
                bCounter++;
            } else if(c == 'a') {
                aCounter++;
            } else if(c == 'l') {
                lCounter++;
            } else if(c == 'o') {
                oCounter++;
            } else if(c == 'n') {
                nCounter++;
            }
        }

        boolean stop = false;
        int count = 0;

        System.out.println(bCounter);
        System.out.println(aCounter);
        System.out.println(lCounter);
        System.out.println(oCounter);
        System.out.println(nCounter);

        while (!stop) {
            if(bCounter != 0 && aCounter != 0 && lCounter > 1 && oCounter > 1 && nCounter != 0) {
                bCounter--;
                aCounter--;
                lCounter-=2;
                oCounter-=2;
                nCounter--;
                count++;
            } else {
                stop = true;
            }
        }

        return count;
    }
}
