package common;

public class Validation {
    public static boolean checkName(String name) {
        String regex = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]{3,30}$";
        return name.matches(regex);
    }
    public static boolean checkEmail(String email){
        String regex ="^[\\w-\\.]+@gmail(\\.)+[\\w-]{2,4}$";
        return email.matches(regex);
    }

    public static boolean checkPhone(String phone){
        String regex = "(((\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})\\b";

        return phone.matches(regex);
    }

    public static boolean checkIdCard(String idCard){
        String regex = "[0-9]{9,12}";
        return idCard.matches(regex);
    }

    public static boolean checkNumber(String num){
        String regex = "^\\d*(\\.\\d+)?$";
        return num.matches(regex);
    }
}