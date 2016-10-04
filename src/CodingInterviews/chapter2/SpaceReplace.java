package CodingInterviews.chapter2;

/**
 * 空格替换
 */
public class SpaceReplace {
    public static char[] replace(char[] a) {
        if (a == null)
            return new char[0];

        int num = 0;
        for (char i : a) {
            if (i == ' ')
                num++;
        }
        char[] result = new char[a.length + 2 * num];
        System.arraycopy(a, 0, result, 0, a.length);

        int endIn = a.length - 1;
        int endOut = result.length - 1;
        // 索引不同即可结束
        while (endIn >= 0 & endOut > endIn) {
            if (a[endIn] != ' ')
                result[endOut--] = a[endIn];
            else {
                result[endOut--] = '0';
                result[endOut--] = '2';
                result[endOut--] = '%';
            }
            endIn--;
        }

        System.out.println("替换前:" + String.valueOf(a));
        System.out.println("替换后:" + String.valueOf(result));
        return result;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = " hello new   world ";
        String s3 = "   ";
        String s4 = null;

        System.out.println(replace(s3.toCharArray()));

    }
}
