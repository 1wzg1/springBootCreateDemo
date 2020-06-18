package myTest;

public class IfElseTransform {

        public static String judge( String roleName ) {
            String result = "";
            if (roleName.equals("ROLE_ROOT_ADMIN")) { // 系统管理员有A权限
                result = "ROLE_ROOT_ADMIN: " + "has AAA permission";
            } else if ( roleName.equals("ROLE_ORDER_ADMIN") ) { // 订单管理员有B权限
                result = "ROLE_ORDER_ADMIN: " + "has BBB permission";
            } else if ( roleName.equals("ROLE_NORMAL") ) { // 普通用户有C权限
                result = "ROLE_NORMAL: " + "has CCC permission";
            } else {
                result = "XXX";
            }
            return result;
        }

        public static String judge2(String roleName) {
            // 一行代码搞定！之前的if/else没了！
            return RoleEnum.valueOf(roleName).op();
        }


        public static void main(String[] args) {
            //使用if/else
            //System.out.println(judge("ROLE_ROOT_ADMIN"));
            //使用enum
            //System.out.println(judge2("ROLE_ROOT_ADMIN"));
            //使用工厂模式

        }

}
