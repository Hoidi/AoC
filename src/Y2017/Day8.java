package Y2017;

import java.util.*;

public class Day8 {

    public static void main(String[] args) {
        List<String> input = createInput();

        int result1 = biggestValue(input);

        System.out.println(result1);

        //6088 is too high

    }

    private static int biggestValue(List<String> list) {
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        final int nameIndex = 0;
        final int doThisIndex = 1;
        final int numberIndex = 2;
        final int compareNameIndex = 4;
        final int compareIndex = 5;
        final int compareNumberIndex = 6;
        int bigNumber = 0;


        for(int i = 0; i < list.size(); i++) {
            String[] currentText = list.get(i).split(" ");
            String nameText = currentText[nameIndex];
            String doThisText = currentText[doThisIndex];
            String numberText = currentText[numberIndex];
            String compareNameText = currentText[compareNameIndex];
            String compareText = currentText[compareIndex];
            String compareNumberText = currentText[compareNumberIndex];

            if(!myMap.containsKey(nameText)) {  // Does the name already exist in map?
                myMap.put(nameText,0);
            }
            if(!myMap.containsKey(compareNameText)) {    // Next thing is not in map
                myMap.put(compareNameText, 0);
            }
            // Now both elements are in map for sure

            if(compareText.equals("<")) {
                if(myMap.get(compareNameText) < Integer.parseInt(compareNumberText)) {
                    if(doThisText.equals("inc")) {
                        myMap.put(nameText, myMap.get(nameText) + Integer.parseInt(numberText));
                    } else {
                        myMap.put(nameText, myMap.get(nameText) - Integer.parseInt(numberText));
                    }
                }
            }else if(compareText.equals(">")) {
                if(myMap.get(compareNameText) > Integer.parseInt(compareNumberText)) {
                    if(doThisText.equals("inc")) {
                        myMap.put(nameText, myMap.get(nameText) + Integer.parseInt(numberText));
                    } else {
                        myMap.put(nameText, myMap.get(nameText) - Integer.parseInt(numberText));
                    }
                }
            }else if(compareText.equals("<=")) {
                if(myMap.get(compareNameText) <= Integer.parseInt(compareNumberText)) {
                    if(doThisText.equals("inc")) {
                        myMap.put(nameText, myMap.get(nameText) + Integer.parseInt(numberText));
                    } else {
                        myMap.put(nameText, myMap.get(nameText) - Integer.parseInt(numberText));
                    }
                }
            }else if(compareText.equals(">=")) {
                if(myMap.get(compareNameText) >= Integer.parseInt(compareNumberText)) {
                    if(doThisText.equals("inc")) {
                        myMap.put(nameText, myMap.get(nameText) + Integer.parseInt(numberText));
                    } else {
                        myMap.put(nameText, myMap.get(nameText) - Integer.parseInt(numberText));
                    }
                }
            }else if(compareText.equals("==")) {
                if(myMap.get(compareNameText) == Integer.parseInt(compareNumberText)) {
                    if(doThisText.equals("inc")) {
                        myMap.put(nameText, myMap.get(nameText) + Integer.parseInt(numberText));
                    } else {
                        myMap.put(nameText, myMap.get(nameText) - Integer.parseInt(numberText));
                    }
                }
            }else if(compareText.equals("!=")) {
                if(myMap.get(compareNameText) != Integer.parseInt(compareNumberText)) {
                    if(doThisText.equals("inc")) {
                        myMap.put(nameText, myMap.get(nameText) + Integer.parseInt(numberText));
                    } else {
                        myMap.put(nameText, myMap.get(nameText) - Integer.parseInt(numberText));
                    }
                }
            }else {
                System.out.println("Something went wrong");
            }

            if (myMap.get(nameText) > bigNumber) {
                bigNumber = myMap.get(nameText);
            }

        }
        System.out.println("bop" + bigNumber);

        return findBiggestValue(myMap);
    }

    private static int findBiggestValue(Map<String, Integer> map) {
        int biggestValue = 0;

        for (Integer value : map.values()) {
            if (value > biggestValue) {
                biggestValue = value;
            }
        }

        return biggestValue;
    }

    private static List<String> createInput() {
        String start = "oui inc 550 if p <= 3\n" +
                "abh inc -189 if g == 0\n" +
                "kq inc 164 if znl != 7\n" +
                "kq dec 827 if oui == 550\n" +
                "z inc 469 if znl != -9\n" +
                "ey inc 685 if tk == 0\n" +
                "kq dec 388 if y > -7\n" +
                "kq inc 468 if tk < 4\n" +
                "oui inc 831 if un <= -5\n" +
                "tk inc -676 if tx >= -8\n" +
                "z inc 418 if kq <= -576\n" +
                "id inc -316 if p >= -2\n" +
                "y inc 943 if g <= -2\n" +
                "g inc -646 if h <= 4\n" +
                "tx inc 47 if tx <= -10\n" +
                "un inc 486 if l < 9\n" +
                "id inc -796 if l < 3\n" +
                "ekl dec 269 if id < -1109\n" +
                "ekl dec -503 if tk > -685\n" +
                "oqg inc -704 if lb < 1\n" +
                "hpz dec -256 if c >= -1\n" +
                "y dec 320 if kq <= -577\n" +
                "znl dec -741 if g != -644\n" +
                "lb inc 584 if id > -1103\n" +
                "p dec -280 if p >= 7\n" +
                "z dec -389 if oqg < -698\n" +
                "a inc 61 if p == 0\n" +
                "hpz dec -184 if id > -1118\n" +
                "id dec -33 if ehe <= 6\n" +
                "oui inc 994 if l <= 9\n" +
                "a dec -548 if ey >= 676\n" +
                "p inc -434 if h != -8\n" +
                "un dec 464 if lb != 0\n" +
                "xj inc 285 if oqg <= -702\n" +
                "h inc -758 if a < 601\n" +
                "tx inc 465 if tk < -674\n" +
                "hpz dec 393 if ekl == 236\n" +
                "id dec 0 if tk < -667\n" +
                "znl dec 802 if ey == 685\n" +
                "l inc 617 if ehe <= 7\n" +
                "c inc 699 if g <= -642\n" +
                "tk inc 27 if c != 691\n" +
                "ehe inc 213 if kq <= -581\n" +
                "x dec 550 if l > 608\n" +
                "c dec -503 if znl >= -61\n" +
                "oqg inc 304 if lb > -7\n" +
                "a inc 262 if un == 486\n" +
                "tx inc 475 if znl != -65\n" +
                "z inc -802 if g != -645\n" +
                "oui inc 301 if lb >= -4\n" +
                "id inc -642 if a != 881\n" +
                "xj dec 394 if kq > -587\n" +
                "y dec -685 if l == 617\n" +
                "id dec -55 if kq != -583\n" +
                "id dec 402 if ehe > 215\n" +
                "h inc 120 if lb >= -3\n" +
                "id dec 492 if ehe <= 216\n" +
                "tk inc 591 if hpz != 441\n" +
                "c inc -790 if h < 128\n" +
                "kq dec 281 if ekl >= 225\n" +
                "p inc 300 if ey > 675\n" +
                "h inc -822 if z > 478\n" +
                "oqg inc -187 if l == 617\n" +
                "kq inc -625 if l == 617\n" +
                "ehe inc 706 if g != -655\n" +
                "oqg inc -489 if c < 409\n" +
                "g dec 603 if kq <= -1486\n" +
                "h dec -903 if ekl < 236\n" +
                "a inc 447 if a >= 868\n" +
                "a inc 448 if l >= 609\n" +
                "oui dec 542 if h == 1023\n" +
                "a inc -377 if lb < 8\n" +
                "oqg dec 417 if oqg == -587\n" +
                "oui dec -348 if y <= 370\n" +
                "x dec 21 if id < -2205\n" +
                "znl inc 206 if znl >= -67\n" +
                "znl dec -230 if xj <= -106\n" +
                "znl inc 913 if c != 412\n" +
                "znl dec 544 if c <= 405\n" +
                "a dec -72 if p < -127\n" +
                "kq dec 495 if tx != 936\n" +
                "h dec -203 if l != 608\n" +
                "hpz dec -764 if a >= 1459\n" +
                "xj dec 57 if lb > -3\n" +
                "znl dec 437 if x > -579\n" +
                "lb inc -473 if ehe >= 916\n" +
                "c dec 354 if y <= 365\n" +
                "h dec -764 if z != 474\n" +
                "lb inc -77 if tk == -58\n" +
                "ey inc 942 if abh != -182\n" +
                "id dec 21 if y > 369\n" +
                "y dec 589 if lb <= -549\n" +
                "hpz inc 792 if lb < -541\n" +
                "c dec 630 if tk >= -60\n" +
                "oqg inc -491 if ehe != 919\n" +
                "x dec -153 if z == 474\n" +
                "lb inc -240 if a == 1461\n" +
                "lb inc -620 if ehe > 917\n" +
                "ey inc 751 if id > -2221\n" +
                "oui inc 896 if h >= 1226\n" +
                "kq inc 531 if ekl >= 231\n" +
                "a dec -381 if znl >= -69\n" +
                "znl dec 659 if tk < -49\n" +
                "xj dec 26 if p == -134\n" +
                "kq dec 929 if oui < 2539\n" +
                "y dec 880 if c < -573\n" +
                "un inc 737 if tk <= -68\n" +
                "ehe dec 497 if l < 622\n" +
                "g inc -193 if kq <= -1453\n" +
                "a dec 695 if l < 618\n" +
                "h inc 526 if ey >= 2388\n" +
                "y dec 769 if g == -1442\n" +
                "znl dec 923 if ey < 2379\n" +
                "x dec -167 if ekl < 235\n" +
                "ekl dec 652 if xj < -192\n" +
                "c dec -352 if z >= 467\n" +
                "abh dec -251 if xj > -202\n" +
                "tk inc -214 if z < 475\n" +
                "x dec 393 if hpz < 2006\n" +
                "hpz dec -941 if xj >= -182\n" +
                "x dec 980 if ekl <= 243\n" +
                "hpz dec 886 if g >= -1447\n" +
                "a inc 157 if oui >= 2540\n" +
                "id dec -694 if ehe >= 413\n" +
                "id dec 137 if y > -999\n" +
                "h dec -24 if a == 1304\n" +
                "id inc 68 if oui <= 2552\n" +
                "p inc -863 if tx <= 944\n" +
                "x inc 221 if h == 1250\n" +
                "l dec 700 if l >= 616\n" +
                "a inc -360 if tx != 939\n" +
                "y dec 797 if x != -1401\n" +
                "c dec -25 if y >= -1798\n" +
                "c dec 401 if lb >= -1409\n" +
                "c dec -164 if znl <= -1647\n" +
                "ekl inc 494 if y == -1787\n" +
                "un dec -432 if oqg >= -1010\n" +
                "c inc 399 if a <= 947\n" +
                "un dec -738 if c <= 204\n" +
                "l inc -863 if y >= -1797\n" +
                "abh inc -125 if znl < -1636\n" +
                "a dec -376 if id > -1592\n" +
                "a inc 392 if z > 470\n" +
                "x inc 281 if h >= 1241\n" +
                "lb inc -264 if kq >= -1458\n" +
                "ekl dec 310 if a >= 1704\n" +
                "hpz inc 132 if lb > -1670\n" +
                "znl inc -870 if xj <= -198\n" +
                "x dec -276 if g >= -1439\n" +
                "abh inc 684 if hpz != 1110\n" +
                "lb inc -214 if l < -945\n" +
                "oui dec -135 if ekl != -76\n" +
                "un dec 188 if ey > 2375\n" +
                "hpz dec -72 if tk != -278\n" +
                "y inc -141 if kq >= -1443\n" +
                "x inc 174 if kq != -1462\n" +
                "ekl inc 325 if h == 1256\n" +
                "c inc 534 if oui == 2547\n" +
                "oui inc 781 if z == 474\n" +
                "lb dec -733 if h == 1250\n" +
                "h inc -441 if un != 1467\n" +
                "id dec -16 if oqg < -1005\n" +
                "ekl dec 842 if ey >= 2369\n" +
                "g inc -995 if a < 1718\n" +
                "oqg inc 313 if tk == -272\n" +
                "a dec -707 if oui >= 3319\n" +
                "hpz inc 957 if y <= -1797\n" +
                "h dec 270 if hpz < 1183\n" +
                "lb inc -632 if g > -2432\n" +
                "c inc -96 if abh < -62\n" +
                "a dec -305 if z != 474\n" +
                "y dec 679 if oui == 3328\n" +
                "tk inc 949 if oui < 3332\n" +
                "x dec 53 if abh < -54\n" +
                "g dec 55 if l > -953\n" +
                "xj inc -327 if abh > -64\n" +
                "abh inc 643 if abh < -55\n" +
                "lb inc -146 if y <= -2461\n" +
                "l dec 763 if y >= -2473\n" +
                "oui dec -787 if a < 2422\n" +
                "p inc 419 if l == -1709\n" +
                "l dec -307 if x >= -1009\n" +
                "c dec 731 if x != -996\n" +
                "y inc 150 if oqg != -682\n" +
                "tx dec -673 if g > -2498\n" +
                "kq inc -895 if l == -1402\n" +
                "xj dec -817 if un == 1468\n" +
                "ey inc 482 if z == 474\n" +
                "h inc -475 if ekl <= -921\n" +
                "hpz inc 526 if l > -1407\n" +
                "znl inc 956 if tk < 680\n" +
                "lb dec -922 if lb > -1304\n" +
                "ekl dec 533 if y >= -2314\n" +
                "g dec -727 if xj >= 291\n" +
                "un dec -7 if ehe == 422\n" +
                "x inc -587 if g == -1765\n" +
                "un inc -786 if c != -83\n" +
                "l inc -238 if h != 542\n" +
                "un inc 267 if znl == -688\n" +
                "z inc -500 if ey <= 2850\n" +
                "l dec 673 if ekl > -921\n" +
                "ey dec 562 if z < 477\n" +
                "hpz dec -179 if oui != 4119\n" +
                "un dec 486 if hpz == 1887\n" +
                "oui inc 649 if tx != 1613\n" +
                "x dec -124 if z >= 472\n" +
                "y inc 807 if z <= 482\n" +
                "y inc 145 if ekl <= -910\n" +
                "xj inc 477 if p > -579\n" +
                "znl inc -472 if tk < 678\n" +
                "y inc 955 if z > 480\n" +
                "znl dec 399 if abh > 576\n" +
                "znl inc -452 if znl <= -1557\n" +
                "z dec 204 if id > -1580\n" +
                "hpz dec -475 if z < 478\n" +
                "id dec -449 if abh <= 576\n" +
                "lb dec 59 if ey <= 2288\n" +
                "lb inc 304 if id != -1587\n" +
                "kq dec 192 if l <= -2309\n" +
                "abh inc 861 if id > -1598\n" +
                "kq inc -240 if p == -578\n" +
                "l dec 246 if a <= 2422\n" +
                "g dec 356 if c > -82\n" +
                "tx dec -341 if tk == 677\n" +
                "hpz dec -325 if h != 535\n" +
                "c dec 377 if l >= -2559\n" +
                "ehe inc 826 if znl == -2011\n" +
                "c dec 989 if xj <= 777\n" +
                "h dec 376 if ehe != 1254\n" +
                "oqg inc -268 if id != -1578\n" +
                "lb inc 816 if ekl >= -921\n" +
                "znl dec 131 if hpz >= 2692\n" +
                "un inc 859 if tk >= 674\n" +
                "p inc 972 if h != 167\n" +
                "tk inc -69 if g == -1765\n" +
                "l inc -787 if oqg == -954\n" +
                "oqg inc -649 if x != -1460\n" +
                "p dec 188 if c > -1459\n" +
                "un dec 411 if xj != 770\n" +
                "kq inc -658 if a > 2415\n" +
                "g dec 396 if y != -1362\n" +
                "ekl inc -220 if znl != -2004\n" +
                "lb inc 711 if lb <= 736\n" +
                "id dec 80 if a <= 2424\n" +
                "z dec -808 if g <= -2152\n" +
                "z dec -201 if p <= 209\n" +
                "a inc -309 if g <= -2161\n" +
                "oui dec -254 if hpz >= 2687\n" +
                "h inc 504 if un < 924\n" +
                "lb inc -231 if y < -1361\n" +
                "id inc 482 if ehe <= 1248\n" +
                "x inc -651 if oqg != -1612\n" +
                "abh inc 516 if tk <= 608\n" +
                "xj inc 30 if ekl > -1140\n" +
                "znl dec -912 if id < -1178\n" +
                "abh dec 419 if z > 1473\n" +
                "kq dec -944 if h <= 672\n" +
                "tk dec 685 if ekl <= -1135\n" +
                "c inc -272 if ehe < 1258\n" +
                "ekl inc 287 if h > 666\n" +
                "oqg inc -993 if ekl > -853\n" +
                "p inc 726 if h >= 674\n" +
                "oui dec -557 if kq >= -2502\n" +
                "tk inc -742 if tk != -81\n" +
                "oqg inc -797 if h == 667\n" +
                "oqg dec -107 if znl < -1093\n" +
                "tk inc 497 if g == -2161\n" +
                "c dec -226 if c == -1727\n" +
                "tx dec 817 if oqg <= -3283\n" +
                "y dec 719 if ey >= 2296\n" +
                "oui dec 42 if y == -2086\n" +
                "y dec -231 if y <= -2078\n" +
                "p inc -190 if ekl <= -842\n" +
                "c dec -533 if znl == -1099\n" +
                "y dec -678 if z >= 1474\n" +
                "hpz inc 591 if ekl != -848\n" +
                "p dec 47 if h <= 676\n" +
                "p inc 729 if tx >= 1136\n" +
                "ey dec -36 if c <= -962\n" +
                "oqg inc -554 if ey <= 2338\n" +
                "tx dec 648 if hpz <= 3281\n" +
                "ey dec -746 if xj <= 805\n" +
                "kq inc -14 if x <= -2106\n" +
                "abh dec 931 if lb != 509\n" +
                "xj inc -230 if p != 697\n" +
                "id inc 458 if l == -2559\n" +
                "l dec -143 if ehe <= 1250\n" +
                "oui inc 411 if y <= -1172\n" +
                "c dec 292 if id < -723\n" +
                "z inc 649 if tk > -326\n" +
                "g inc 161 if abh <= 610\n" +
                "oui inc 23 if c == -1260\n" +
                "xj dec -478 if ehe == 1248\n" +
                "id dec -153 if a < 2112\n" +
                "x dec -616 if tk == -322\n" +
                "xj dec -194 if znl >= -1106\n" +
                "tx dec 220 if ekl < -855\n" +
                "x inc 139 if z != 2141\n" +
                "a inc 777 if abh <= 609\n" +
                "oui inc 151 if x == -1360\n" +
                "g inc 69 if id <= -575\n" +
                "ekl inc 860 if xj <= 1256\n" +
                "x dec 309 if x != -1367\n" +
                "znl inc -405 if y >= -1184\n" +
                "lb inc 428 if tx == 489\n" +
                "znl inc -676 if tx != 497\n" +
                "oqg dec 780 if ey != 3080\n" +
                "un inc 476 if xj > 1240\n" +
                "c dec -982 if l != -2422\n" +
                "x inc 667 if y > -1186\n" +
                "kq dec 277 if tk > -324\n" +
                "oqg dec -271 if kq >= -2792\n" +
                "lb dec 960 if a > 2877\n" +
                "ehe dec 532 if x < -1011\n" +
                "lb inc 619 if x == -1002\n" +
                "hpz inc -585 if tk == -322\n" +
                "p dec 553 if id != -569\n" +
                "h dec 279 if c > -287\n" +
                "oui inc 832 if oui > 5471\n" +
                "kq dec -828 if ey != 3082\n" +
                "xj inc -229 if ehe == 1257\n" +
                "p inc -505 if id != -575\n" +
                "y dec -94 if xj <= 1252\n" +
                "h dec 885 if g > -1923\n" +
                "c dec -38 if kq != -1964\n" +
                "oui inc 19 if l <= -2415\n" +
                "ehe dec 543 if oqg > -3580\n" +
                "lb inc -394 if l >= -2420\n" +
                "tx dec -673 if hpz != 2695\n" +
                "h dec -436 if oui > 5495\n" +
                "znl inc 826 if oui < 5480\n" +
                "znl inc -134 if ey <= 3082\n" +
                "c dec 808 if kq >= -1957\n" +
                "tx inc -45 if abh <= 613\n" +
                "x dec 30 if hpz != 2686\n" +
                "a dec 440 if znl == -2314\n" +
                "c inc -504 if z <= 2140\n" +
                "tx inc 435 if y <= -1075\n" +
                "x dec 256 if ehe < 706\n" +
                "c inc 187 if p != 145\n" +
                "ey dec -323 if id > -576\n" +
                "hpz dec 174 if y >= -1080\n" +
                "oui dec 455 if un == 1394\n" +
                "oqg inc -804 if a <= 2447\n" +
                "abh dec 741 if l == -2416\n" +
                "y dec -566 if z != 2127\n" +
                "kq inc 919 if id >= -575\n" +
                "id dec 220 if znl < -2319\n" +
                "g inc -15 if lb >= 197\n" +
                "abh inc -968 if ey != 3395\n" +
                "xj inc 873 if l != -2415\n" +
                "x dec -367 if x == -1288\n" +
                "un inc -62 if g == -1946\n" +
                "h inc -400 if tk < -325\n" +
                "xj inc -623 if h > 397\n" +
                "a dec 49 if un < 1341\n" +
                "ekl inc 491 if id >= -582\n" +
                "tk inc 171 if ey >= 3405\n" +
                "hpz inc -265 if ekl != 500\n" +
                "ehe dec -811 if lb <= 212\n" +
                "ehe inc 477 if hpz != 2702\n" +
                "oqg dec 137 if ekl <= 500\n" +
                "z dec -601 if ekl == 500\n" +
                "ehe dec -696 if y >= -510\n" +
                "ehe dec -616 if oui > 5038\n" +
                "p inc 584 if xj == 2120\n" +
                "abh inc -131 if z < 2734\n" +
                "a inc 62 if kq >= -1046\n" +
                "ekl dec -26 if oui >= 5030\n" +
                "abh dec -64 if lb == 203\n" +
                "xj dec 356 if tk < -320\n" +
                "un inc 270 if hpz <= 2702\n" +
                "l dec -632 if oqg != -4521\n" +
                "x dec 69 if tx != 1555\n" +
                "kq inc -685 if hpz == 2693\n" +
                "id inc -655 if p > 729\n" +
                "tx inc -763 if znl >= -2310\n" +
                "c inc 250 if y <= -508\n" +
                "kq inc 738 if l == -1784\n" +
                "tk dec -548 if znl < -2310\n" +
                "z dec -757 if ey >= 3403\n" +
                "ehe dec -969 if tk == 226\n" +
                "g inc 312 if lb <= 206\n" +
                "l inc 218 if hpz > 2685\n" +
                "h dec -500 if ey > 3400\n" +
                "a inc 612 if ekl > 522\n" +
                "oqg dec 134 if c == -1302\n" +
                "tk dec -622 if oqg < -4641\n" +
                "p inc -715 if ekl < 522\n" +
                "hpz dec -862 if abh <= -1166\n" +
                "kq dec 183 if a == 3069\n" +
                "a dec -934 if p >= 722\n" +
                "oui inc -474 if ey <= 3403\n" +
                "id dec 36 if ey != 3403\n" +
                "z dec 285 if x == -990\n" +
                "z dec 924 if g <= -1626\n" +
                "oqg inc -564 if xj <= 1755\n" +
                "kq dec -597 if ehe <= 2952\n" +
                "h inc 312 if y != -517\n" +
                "kq inc -911 if ekl <= 528\n" +
                "ehe dec 871 if l == -1566\n" +
                "a dec 35 if c == -1302\n" +
                "hpz dec 812 if g >= -1632\n" +
                "lb inc 674 if ey <= 3406\n" +
                "oui dec -729 if tk == 848\n" +
                "z inc 11 if xj != 1766\n" +
                "abh dec 35 if znl == -2314\n" +
                "y inc -62 if abh != -1211\n" +
                "g inc -480 if oqg == -4649\n" +
                "tx dec 224 if l <= -1563\n" +
                "tk dec -639 if un == 1602\n" +
                "ehe dec 825 if kq != -1904\n" +
                "tk dec -520 if c == -1302\n" +
                "un inc 560 if id >= -581\n" +
                "id dec -68 if c != -1296\n" +
                "kq dec -722 if ehe <= 1271\n" +
                "h inc 629 if l == -1558\n" +
                "znl inc 447 if ehe >= 1264\n" +
                "ehe inc -375 if x > -999\n" +
                "abh inc 135 if ekl <= 528\n" +
                "abh inc -532 if c != -1303\n" +
                "ey dec -898 if oqg != -4659\n" +
                "tx inc 149 if ekl > 523\n" +
                "z inc 140 if un != 2166\n" +
                "y inc -737 if znl != -1874\n" +
                "id inc -858 if lb >= 874\n" +
                "l inc -444 if oui != 5296\n" +
                "x inc -401 if xj <= 1772\n" +
                "un dec 422 if y != -1325\n" +
                "x inc -459 if hpz > 3545\n" +
                "x inc 671 if l == -2010\n" +
                "oui dec -26 if ekl > 534\n" +
                "z dec 813 if ekl <= 534\n" +
                "tx dec -172 if c == -1298\n" +
                "ey dec 544 if g == -2114\n" +
                "c inc -700 if c == -1302\n" +
                "l inc -951 if un != 1740\n" +
                "id dec 446 if ehe <= 881\n" +
                "tk dec -758 if z > 1615\n" +
                "x inc -854 if xj < 1770\n" +
                "a dec -739 if y != -1322\n" +
                "lb dec 564 if tx >= 1468\n" +
                "hpz inc 526 if id == -1359\n" +
                "ey dec -759 if kq > -1178\n" +
                "ey inc -765 if ey > 4513\n" +
                "ekl inc 354 if oui <= 5289\n" +
                "c inc -66 if tx >= 1472\n" +
                "h inc 9 if ekl != 888\n" +
                "ekl inc -247 if x > -2036\n" +
                "x inc 832 if xj != 1770\n" +
                "abh inc -867 if znl <= -1858\n" +
                "c inc 564 if l < -2005\n" +
                "xj dec 936 if lb <= 309\n" +
                "l inc 762 if x >= -1210\n" +
                "ey dec -862 if oqg == -4650\n" +
                "tx inc -136 if ey != 3760\n" +
                "oui inc -928 if x <= -1193\n" +
                "lb dec 325 if p == 728\n" +
                "a dec -157 if x != -1204\n" +
                "lb dec -832 if lb != 315\n" +
                "a inc -802 if h == 897\n" +
                "x inc -882 if id <= -1358\n" +
                "kq inc -98 if kq == -1174\n" +
                "oqg dec 64 if ey != 3751\n" +
                "hpz inc -582 if z > 1614\n" +
                "h dec 335 if ehe != 888\n" +
                "ey dec -137 if znl <= -1862\n" +
                "id dec 491 if a <= 4067\n" +
                "z inc -747 if z >= 1617\n" +
                "un inc -429 if un > 1735\n" +
                "tx inc 536 if un <= 1312\n" +
                "tk inc 360 if xj != 1764\n" +
                "tx inc 723 if l < -1242\n" +
                "ehe dec -74 if tx <= 2604\n" +
                "c inc 326 if a > 4072\n" +
                "lb dec -178 if z <= 874\n" +
                "a dec -218 if abh >= -2471\n" +
                "p inc 204 if z < 877\n" +
                "id dec 496 if id <= -1855\n" +
                "oqg inc 1 if x == -2083\n" +
                "abh inc 84 if un <= 1314\n" +
                "znl dec 396 if abh < -2380\n" +
                "x dec -94 if ekl >= 629\n" +
                "ekl inc 741 if un <= 1311\n" +
                "l inc -187 if y > -1321\n" +
                "un inc 576 if hpz <= 2976\n" +
                "p dec 334 if ehe > 956\n" +
                "hpz dec 2 if x > -1993\n" +
                "oqg dec -150 if g <= -2106\n" +
                "lb dec -290 if x > -1982\n" +
                "kq dec -16 if oqg >= -4502\n" +
                "ekl inc -135 if un >= 1882\n" +
                "id dec -491 if z <= 879\n" +
                "z dec 311 if h > 556\n" +
                "g inc -942 if tx <= 2606\n" +
                "oui dec 917 if lb != 1329\n" +
                "tk dec 650 if a == 4283\n" +
                "abh dec -623 if y > -1312\n" +
                "x dec 645 if c == -1504\n" +
                "un dec 335 if id <= -1861\n" +
                "ekl dec -160 if z < 570\n" +
                "tk inc 968 if ekl != 1406\n" +
                "g dec -298 if un >= 1545\n" +
                "kq inc -814 if id >= -1852\n" +
                "ehe inc -766 if y < -1314\n" +
                "h dec 540 if z != 555\n" +
                "x dec 683 if xj == 1771\n" +
                "x inc -258 if ehe == 199\n" +
                "l inc 452 if oui != 3451\n" +
                "hpz inc -294 if y != -1310\n" +
                "tk inc -785 if un <= 1552\n" +
                "a dec -752 if c < -1502\n" +
                "un inc 529 if ekl != 1403\n" +
                "xj inc -551 if l == -992\n" +
                "y inc 135 if znl > -2266\n" +
                "tk inc -439 if x == -2892\n" +
                "l dec 195 if x <= -2888\n" +
                "hpz dec 683 if l > -1182\n" +
                "z dec -486 if tk == 1859\n" +
                "a inc 858 if a > 5035\n" +
                "c inc 683 if abh < -2376\n" +
                "h inc -93 if oqg != -4498\n" +
                "id dec -46 if x != -2890\n" +
                "un inc 181 if a > 5037\n" +
                "abh inc -798 if y < -1184\n" +
                "id dec -912 if oui < 3449\n" +
                "a dec 526 if z <= 1037\n" +
                "ey inc 510 if id >= -909\n" +
                "l inc 930 if hpz != 1987\n" +
                "id inc -640 if ehe >= 196\n" +
                "xj inc -318 if lb == 1315\n" +
                "oui dec -797 if x <= -2889\n" +
                "hpz inc -563 if y == -1187\n" +
                "lb inc -77 if tk <= 1858\n" +
                "id dec 692 if un <= 2088\n" +
                "tk inc -45 if znl > -2266\n" +
                "abh inc 802 if hpz < 2002\n" +
                "abh dec 262 if h < 31\n" +
                "id dec 547 if tx != 2600\n" +
                "h inc -48 if p != 599\n" +
                "x dec -424 if ey == 4398\n" +
                "kq dec 584 if oui == 4240\n" +
                "lb dec -899 if kq > -1846\n" +
                "tk dec 417 if a != 5045\n" +
                "x dec 988 if oui != 4250\n" +
                "ehe inc 423 if hpz <= 2000\n" +
                "tk dec 497 if p == 599\n" +
                "a dec 201 if tk != 895\n" +
                "abh dec -140 if abh == -1844\n" +
                "id inc 455 if oqg == -4498\n" +
                "p inc 447 if xj == 1764\n" +
                "l inc -653 if p != 1046\n" +
                "a inc 226 if l != -245\n" +
                "a inc 491 if c < -827\n" +
                "x inc 942 if hpz < 2001\n" +
                "tx dec 52 if h <= 26\n" +
                "a dec 962 if kq < -1836\n" +
                "tk inc 980 if id > -1781\n" +
                "hpz inc 655 if un <= 2088\n" +
                "kq inc -389 if oui >= 4236\n" +
                "znl dec 334 if z >= 1040\n" +
                "c inc -985 if p < 1045\n" +
                "lb dec -597 if g == -2768\n" +
                "tk dec -356 if ekl != 1399\n" +
                "id dec -953 if g < -2755\n" +
                "oqg inc 400 if oui >= 4233\n" +
                "tk dec 14 if p <= 1050\n" +
                "ehe dec -657 if a > 4089\n" +
                "oqg inc -902 if x >= -2520\n" +
                "un inc -276 if tx != 2543\n" +
                "ey inc 734 if tk < 1875\n" +
                "znl inc -685 if ey > 5125\n" +
                "lb inc 959 if oui > 4242\n" +
                "xj inc 84 if ekl > 1393\n" +
                "xj dec 355 if oqg < -4995\n" +
                "a inc -711 if oqg > -5007\n" +
                "c dec 488 if p >= 1043\n" +
                "znl inc 222 if g >= -2752\n" +
                "z dec -169 if un < 1811\n" +
                "tx inc -379 if abh < -1696\n" +
                "znl inc 435 if un > 1803\n" +
                "oqg inc 342 if id >= -834\n" +
                "c inc -760 if ey <= 5127\n" +
                "id dec 750 if z > 1208\n" +
                "xj inc -994 if g != -2755\n" +
                "ehe inc 499 if y > -1188\n" +
                "oqg inc 643 if xj == 499\n" +
                "hpz dec 85 if y > -1186\n" +
                "abh inc -174 if un >= 1802\n" +
                "g dec 898 if ekl >= 1390\n" +
                "g inc -590 if a > 3384\n" +
                "znl inc 486 if id >= -1585\n" +
                "lb dec -650 if y != -1182\n" +
                "ehe dec -634 if id == -1577\n" +
                "tx inc -150 if un != 1805\n" +
                "hpz dec -610 if l > -250\n" +
                "l inc -648 if z <= 1216\n" +
                "y inc 607 if abh != -1881\n" +
                "ey inc 747 if oui > 4230\n" +
                "tk dec 125 if g > -4256\n" +
                "g inc 511 if a >= 3384\n" +
                "tx inc -751 if hpz != 3178\n" +
                "z inc -928 if ehe >= 2409\n" +
                "lb inc -278 if kq >= -2236\n" +
                "un inc -336 if c >= -1304\n" +
                "id dec -908 if znl <= -2354\n" +
                "y dec -183 if tk < 1733\n" +
                "tk dec -92 if h <= 24\n" +
                "kq dec -34 if hpz != 3174\n" +
                "x inc -991 if oui > 4247\n" +
                "l inc -644 if oqg < -4013\n" +
                "hpz dec -690 if y >= -568\n" +
                "ehe inc 171 if ekl <= 1399\n" +
                "a inc -253 if g == -3735\n" +
                "id inc 281 if tx > 1409\n" +
                "z inc 835 if tk <= 1841\n" +
                "znl inc -647 if y != -574\n" +
                "znl dec -991 if ehe == 2583\n" +
                "oqg dec -706 if ekl == 1399\n" +
                "p dec -870 if lb == 2596\n" +
                "un dec 293 if x <= -2513\n" +
                "z inc 418 if z >= 1117\n" +
                "tk dec -61 if tx < 1422\n" +
                "oui dec -569 if ey < 5871\n" +
                "znl inc -335 if g <= -3729\n" +
                "ehe dec 509 if hpz > 3175\n" +
                "oqg dec -24 if tk == 1894\n" +
                "id dec 73 if a != 3138\n" +
                "un dec 220 if y != -574\n" +
                "z inc 707 if ekl < 1405\n" +
                "p inc 238 if tk != 1893\n" +
                "p inc 667 if lb >= 2592\n" +
                "l dec -927 if ey == 5875\n" +
                "ehe inc -787 if z != 2248\n" +
                "znl inc 82 if znl == -1705\n" +
                "abh dec 839 if a <= 3142\n" +
                "ekl dec 22 if ekl > 1396\n" +
                "z dec 402 if y == -574\n" +
                "ey inc -732 if kq != -2229\n" +
                "x dec 869 if ey < 5888\n" +
                "lb dec 137 if y >= -582\n" +
                "a inc 204 if z == 1846\n" +
                "h inc 280 if hpz == 3181\n" +
                "ehe dec 876 if id != -459\n" +
                "l dec -156 if oui == 4248\n" +
                "oui dec 670 if hpz >= 3170\n" +
                "id dec -485 if z > 1842\n" +
                "z dec 40 if p > 1946\n" +
                "kq dec 671 if ey > 5872\n" +
                "a dec 745 if tx <= 1420\n" +
                "y dec 985 if tk == 1894\n" +
                "y inc 668 if l == -1540\n" +
                "g inc -231 if hpz == 3174\n" +
                "znl inc -481 if p > 1948\n" +
                "hpz inc -14 if kq < -2900\n" +
                "ekl dec 372 if oqg <= -3285\n" +
                "ehe dec -176 if abh == -2717\n" +
                "l inc 865 if p >= 1942\n" +
                "tx inc -587 if g <= -3962\n" +
                "a dec -679 if h <= 27\n" +
                "ey inc -261 if hpz != 3165\n" +
                "l dec -486 if tx > 829\n" +
                "ehe dec 913 if z > 1804\n" +
                "ey dec -431 if x == -3383\n" +
                "g dec 998 if y == -891\n" +
                "a inc -720 if hpz <= 3176\n" +
                "un dec 753 if hpz < 3174\n" +
                "l inc 740 if l < -182\n" +
                "oui inc -212 if oui <= 3578\n" +
                "oqg inc 363 if tx > 824\n" +
                "x dec 296 if p <= 1956\n" +
                "oqg dec 480 if oui == 3358\n" +
                "x inc -178 if abh <= -2724\n" +
                "x inc -579 if tx > 830\n" +
                "lb dec -188 if tx == 831\n" +
                "ekl dec 544 if un >= 1512\n" +
                "ekl inc 284 if c != -1304\n" +
                "id dec -418 if oui > 3365\n" +
                "a inc 12 if h < 19\n" +
                "lb dec 73 if ekl != 745\n" +
                "c inc 594 if id >= 24\n" +
                "g inc -118 if xj <= 506\n" +
                "id inc 274 if x >= -4263\n" +
                "x dec -248 if oui != 3350\n" +
                "ehe inc -431 if abh >= -2719\n" +
                "y inc -740 if y < -885\n" +
                "p inc -842 if znl <= -2095\n" +
                "g dec -101 if tx != 831\n" +
                "un inc -708 if id == 298\n" +
                "id inc 788 if id <= 302\n" +
                "ehe dec -4 if oqg <= -3399\n" +
                "h dec 904 if ekl >= 736\n" +
                "oui dec -828 if tx >= 823\n" +
                "z dec 309 if tk != 1894\n" +
                "ey inc 744 if tk > 1901\n" +
                "znl inc 133 if ehe <= 550\n" +
                "a inc -908 if z != 1810\n" +
                "tk inc -464 if h != -889\n" +
                "h inc 59 if ey > 6042\n" +
                "x inc -841 if l == 551\n" +
                "abh inc 293 if ey > 6047\n" +
                "tx inc 410 if un <= 813\n" +
                "z inc 218 if ehe >= 538\n" +
                "xj inc -875 if a >= 1635\n" +
                "kq inc -793 if abh < -2415\n" +
                "oqg dec 361 if h == -823\n" +
                "tx inc -847 if xj >= -378\n" +
                "hpz dec 725 if a <= 1641\n" +
                "lb dec -740 if h < -830\n" +
                "hpz dec 259 if h < -818\n" +
                "id inc 353 if kq != -3687\n" +
                "oui inc 540 if p == 1109\n" +
                "lb dec -235 if tx > 392\n" +
                "hpz dec -601 if h > -826\n" +
                "oqg dec 287 if oqg == -3763\n" +
                "oqg dec -965 if abh < -2433\n" +
                "id inc 172 if oui > 4722\n" +
                "z dec -226 if ey <= 6054\n" +
                "kq dec -173 if x >= -4859\n" +
                "y inc -123 if un > 798\n" +
                "lb inc 522 if kq < -3514\n" +
                "abh dec 543 if znl != -1973\n" +
                "id inc -418 if hpz == 3516\n" +
                "tk dec -115 if abh <= -2966\n" +
                "x dec 501 if ehe > 533\n" +
                "oui dec -460 if kq > -3524\n" +
                "l dec -712 if g == -5084\n" +
                "c inc -239 if tx < 398\n" +
                "abh dec 956 if oqg < -4041\n" +
                "x dec 357 if id != 1201\n" +
                "un dec 45 if tx == 394\n" +
                "z inc -123 if ekl != 748\n" +
                "g inc 479 if p > 1099\n" +
                "a inc 942 if id >= 1186\n" +
                "id inc -788 if oqg >= -4057\n" +
                "tk dec -821 if y > -1762\n" +
                "g dec -672 if tk < 2371\n" +
                "ey inc 647 if oui > 5179\n" +
                "x inc -382 if lb == 3402\n" +
                "id inc 742 if lb >= 3394\n" +
                "hpz inc 631 if x >= -6097\n" +
                "h dec -368 if p > 1101\n" +
                "ekl inc 44 if ehe == 543\n" +
                "p dec -420 if l > 549\n" +
                "y inc -539 if tk < 2365\n" +
                "abh dec -516 if tx < 395\n" +
                "ey dec -752 if hpz != 4147\n" +
                "z inc 970 if tk == 2362\n" +
                "y inc 698 if g < -3933\n" +
                "ey inc -131 if l != 541\n" +
                "tx inc -663 if c < -954\n" +
                "z inc -161 if l >= 544\n" +
                "kq inc -616 if g >= -3931\n" +
                "tk inc -915 if oui <= 5188\n" +
                "ey dec 978 if id == 1141\n" +
                "y dec -430 if ehe <= 541\n" +
                "kq dec -129 if tk <= 1448\n" +
                "y dec -319 if x == -6091\n" +
                "znl inc -192 if x < -6086\n" +
                "oqg dec 560 if ey <= 6565\n" +
                "ehe dec 531 if ey == 6565\n" +
                "abh dec -732 if xj < -372\n" +
                "xj inc 421 if kq < -4135\n" +
                "x inc 85 if un >= 755\n" +
                "c dec -26 if oqg != -4602\n" +
                "oqg dec 943 if a != 2576\n" +
                "ey dec -370 if oqg == -5560\n" +
                "oqg dec 620 if ey <= 6561\n" +
                "tx dec -308 if oqg == -5553\n" +
                "znl inc 123 if ehe <= 19\n" +
                "ehe inc 848 if a >= 2577\n" +
                "tk dec 679 if z < 1970\n" +
                "c inc -339 if z > 1963\n" +
                "id inc 349 if lb <= 3407\n" +
                "x inc -88 if oui > 5177\n" +
                "hpz dec 617 if oui <= 5185\n" +
                "oqg dec 696 if z > 1964\n" +
                "oqg dec -984 if z != 1966\n" +
                "lb dec -904 if un > 767\n" +
                "oqg inc -480 if p > 1534\n" +
                "c inc 496 if un < 769\n" +
                "g dec -564 if oqg > -6256\n" +
                "ehe inc -874 if abh > -2674\n" +
                "l inc -20 if l == 551\n" +
                "lb inc 962 if ey != 6575\n" +
                "hpz dec 99 if ekl <= 792\n" +
                "l dec 941 if y != -1443\n" +
                "ey dec 621 if g <= -3361\n" +
                "xj dec -474 if oui >= 5183\n" +
                "xj inc 807 if g != -3364\n" +
                "abh inc -75 if a < 2593\n" +
                "kq dec 57 if c <= -770\n" +
                "hpz dec 274 if p != 1529\n" +
                "oqg inc -927 if ey == 5944\n" +
                "c dec 171 if g > -3372\n" +
                "p inc 54 if xj == 1326\n" +
                "ehe dec 249 if oui >= 5184\n" +
                "ehe dec 315 if un < 765\n" +
                "lb dec 545 if y < -1429\n" +
                "znl dec 998 if hpz > 4049\n" +
                "z inc -122 if hpz <= 4057\n" +
                "znl inc 620 if kq > -4197\n" +
                "oqg inc -349 if un == 759\n" +
                "tk dec -186 if h == -455\n" +
                "oui inc 717 if ekl <= 798\n" +
                "xj dec 701 if h >= -456\n" +
                "un inc -50 if tx < 709\n" +
                "lb dec -784 if h < -452\n" +
                "tx inc 175 if tx < 710\n" +
                "tk dec -575 if ey != 5944\n" +
                "oui dec 856 if lb < 4604\n" +
                "ehe dec 179 if abh > -2746\n" +
                "hpz dec 537 if xj < 622\n" +
                "ey inc -862 if y <= -1427\n" +
                "oqg inc 104 if abh <= -2744\n" +
                "kq dec 453 if p == 1583\n" +
                "ekl dec -587 if tk == 958\n" +
                "tk dec 309 if tx == 877\n" +
                "oui dec -628 if y < -1425\n" +
                "kq dec 509 if x >= -6096\n" +
                "xj dec 953 if oqg != -7412\n" +
                "lb dec -435 if lb != 4595\n" +
                "c dec 341 if id == 1496\n" +
                "x inc 796 if x < -6093\n" +
                "hpz inc 401 if g > -3365\n" +
                "znl inc -36 if x > -5303\n" +
                "h inc 282 if oqg != -7419\n" +
                "ekl dec 802 if z >= 1838\n" +
                "c inc 586 if ehe != 305\n" +
                "p dec -293 if g < -3371\n" +
                "ey inc 125 if kq > -5158\n" +
                "ekl inc -108 if abh != -2753\n" +
                "ekl inc -848 if xj != -324\n" +
                "oui dec 801 if ey > 5211\n" +
                "x inc 704 if abh == -2750\n" +
                "z inc -759 if ehe == 296\n" +
                "g inc -964 if ehe < 301\n" +
                "ehe inc 307 if xj > -330\n" +
                "c inc -272 if ehe == 603\n" +
                "ey dec -497 if un != 700\n" +
                "lb dec 533 if c >= -978\n" +
                "y inc 864 if z == 1085\n" +
                "ekl inc -895 if x < -4590\n" +
                "abh inc -424 if xj != -324\n" +
                "lb dec -756 if l == -418\n" +
                "xj inc 23 if g == -4328\n" +
                "znl inc 716 if g >= -4322\n" +
                "h dec -669 if l <= -409\n" +
                "oui dec -305 if lb >= 4498\n" +
                "un dec 664 if id <= 1493\n" +
                "hpz dec 706 if g == -4331\n" +
                "ey inc 920 if lb <= 4512\n" +
                "l inc 858 if c < -968\n" +
                "tx dec -357 if ey >= 6631\n" +
                "oui inc 344 if znl != -1466\n" +
                "tx dec 549 if znl > -1466\n" +
                "tx dec 748 if h > 491\n" +
                "znl dec 544 if xj >= -332\n" +
                "oqg inc -626 if y > -576\n" +
                "kq inc -28 if a == 2585\n" +
                "ekl inc -895 if tx == -420\n" +
                "oqg inc 770 if ekl < -2173\n" +
                "g inc 712 if kq == -5155\n" +
                "ey dec 809 if a > 2578\n" +
                "znl dec -8 if c >= -972\n" +
                "oui dec 360 if p >= 1580\n" +
                "l dec 231 if znl != -1992\n" +
                "hpz dec 307 if l > 443\n" +
                "oqg dec -152 if x <= -4594\n" +
                "y dec -153 if id >= 1488\n" +
                "oui inc -122 if l < 456\n" +
                "xj inc -818 if id != 1493\n" +
                "un inc -819 if a != 2594\n" +
                "abh dec 518 if ekl < -2169\n" +
                "znl inc 873 if y < -412\n" +
                "ekl dec -431 if h == 496\n" +
                "x dec 498 if x > -4595\n" +
                "ehe inc 133 if z > 1093\n" +
                "tx dec 293 if g != -3619\n" +
                "kq dec -29 if znl <= -1118\n" +
                "tx dec 621 if un > -120\n" +
                "p dec 494 if z >= 1089\n" +
                "h dec -40 if l < 457\n" +
                "z dec -430 if lb == 4501\n" +
                "tk dec -339 if kq == -5126\n" +
                "y inc 616 if oui != 5834\n" +
                "kq inc -28 if z == 1091\n" +
                "abh inc 267 if ey < 5808\n" +
                "hpz dec -100 if h <= 536\n" +
                "p dec 883 if kq < -5120\n" +
                "tx inc 516 if p >= 699\n" +
                "l inc 183 if oui != 5846\n" +
                "kq dec 230 if znl >= -1120\n" +
                "znl dec 595 if ekl > -1742\n" +
                "oqg dec -408 if g <= -3614\n" +
                "y dec -796 if c >= -977\n" +
                "id dec 414 if lb != 4514\n" +
                "ekl inc 845 if abh <= -3685\n" +
                "c inc 193 if p <= 699\n" +
                "xj dec -590 if oui == 5842\n" +
                "z dec 899 if kq <= -5349\n" +
                "kq dec 616 if kq <= -5365\n" +
                "g dec 371 if ey == 5815\n" +
                "lb inc -922 if y <= 1003\n" +
                "hpz dec 592 if a != 2576\n" +
                "xj dec -548 if ehe == 603\n" +
                "lb inc 867 if oqg < -7495\n" +
                "x inc -162 if l >= 628\n" +
                "ekl dec 926 if un <= -116\n" +
                "ey inc -661 if oui != 5851\n" +
                "z inc -44 if a != 2588\n" +
                "kq inc 929 if h >= 529\n" +
                "p dec 373 if oqg != -7496\n" +
                "oqg inc 629 if g >= -3996\n" +
                "kq inc -667 if a <= 2579\n" +
                "p inc 620 if ekl <= -891\n" +
                "xj inc -169 if x >= -5249\n" +
                "tk inc -327 if g > -3996\n" +
                "h inc 96 if oqg > -6860\n" +
                "c inc 362 if c != -963\n" +
                "tk dec -861 if un == -110\n" +
                "ekl dec -765 if x != -5259\n" +
                "a dec 844 if g != -3980\n" +
                "oui dec -549 if l == 631\n" +
                "c dec 753 if p > 937\n" +
                "a inc 661 if y <= 1001\n" +
                "a dec -315 if oqg < -6853\n" +
                "znl inc -538 if p == 947\n" +
                "un inc -894 if tx < -515\n" +
                "abh inc 958 if a > 2711\n" +
                "xj inc 806 if tk < 1527\n" +
                "abh inc -317 if z >= 136\n" +
                "tk inc 75 if un <= -997\n" +
                "x inc -171 if a <= 2718\n" +
                "z inc -339 if ekl >= -139\n" +
                "oqg dec 743 if un == -1004\n" +
                "znl inc 942 if abh != -3058\n" +
                "y inc 195 if un != -1014\n" +
                "oqg inc -289 if z > -192\n" +
                "un dec 253 if un >= -1006\n" +
                "ey dec 426 if hpz < 2542\n" +
                "ehe dec -877 if c >= -1364\n" +
                "z dec -399 if ey >= 5147\n" +
                "znl inc 224 if un > -1267\n" +
                "h dec -1 if x != -5427\n" +
                "oui inc -541 if abh != -3047\n" +
                "h dec -48 if id <= 1085\n" +
                "oui inc -841 if y >= 1191\n" +
                "ekl inc 880 if xj < 805\n" +
                "xj dec 804 if z <= 210\n" +
                "xj dec 91 if h >= 690\n" +
                "ey dec -355 if oqg == -7601\n" +
                "tx inc -508 if znl > -1089\n" +
                "xj dec 948 if ekl != 754\n" +
                "p inc 675 if z > 201\n" +
                "c inc -872 if p < 1624\n" +
                "un inc -470 if znl <= -1081\n" +
                "oui inc -672 if z >= 202\n" +
                "c dec -191 if l > 628\n" +
                "p dec -603 if y <= 1196\n" +
                "un dec 283 if id != 1086\n" +
                "un inc -942 if znl != -1096\n" +
                "tk inc 553 if tk < 1604\n" +
                "l inc -644 if ey < 5515\n" +
                "y inc 845 if g != -3985\n" +
                "oui dec -883 if un != -2947\n" +
                "ehe dec 449 if p <= 2226\n" +
                "kq inc -410 if oui > 6052\n" +
                "hpz dec 97 if ey > 5509\n" +
                "znl inc -892 if hpz != 2539\n" +
                "oqg dec 585 if znl != -1971\n" +
                "z inc 257 if tk == 2150\n" +
                "a dec 445 if oui >= 6053\n" +
                "oqg dec -745 if oui == 6061\n" +
                "ekl inc 631 if oui <= 6064\n" +
                "un dec 401 if znl == -1978\n" +
                "oqg dec 289 if kq < -4835\n" +
                "oqg dec -867 if xj != -954\n" +
                "h inc -764 if ehe == 1031\n" +
                "y inc 63 if z < 468\n" +
                "id inc 750 if tx != -1037\n" +
                "z dec -142 if a != 2269\n" +
                "x dec -497 if x >= -5423\n" +
                "ekl inc 27 if x > -5427\n" +
                "ehe inc 458 if kq <= -4829\n" +
                "oqg inc -20 if un > -3355\n" +
                "l inc -512 if znl != -1982\n" +
                "ehe inc 684 if znl != -1977\n" +
                "ekl dec 834 if x <= -5427\n" +
                "p inc 563 if l == -525\n" +
                "znl inc 178 if ehe > 2173\n" +
                "y dec 396 if ehe < 2181\n" +
                "p dec -55 if ey == 5515\n" +
                "id dec 670 if znl >= -1981\n" +
                "z inc -718 if lb >= 3581\n" +
                "c dec 976 if tk < 2152\n" +
                "g inc -118 if ehe != 2179\n" +
                "xj dec -150 if x == -5425\n" +
                "ekl dec -332 if xj != -806\n" +
                "id dec -692 if ekl == 1739\n";

        String[] arr = start.split("\n");

        return fromArrToList(arr);
    }

    private static List<String> fromArrToList(String[] arr) {
        List<String> list = new ArrayList<String>();

        list.addAll(Arrays.asList(arr));

        return list;
    }

}