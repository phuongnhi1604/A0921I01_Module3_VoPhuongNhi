public class Calculator {

    public static float calculator(float num1, float num2, char pheptinh) {
        switch (pheptinh) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new RuntimeException("Khong the chia het cho 0");
                }
            default:
                throw new RuntimeException("Nhap sai phep tinh");
        }
    }
}
