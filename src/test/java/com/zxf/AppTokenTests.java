package com.zxf;

import com.auth0.jwt.interfaces.Claim;
import com.zxf.entities.Student;
import com.zxf.jwttoken.JwtToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTokenTests {

    @Test
    public void contextLoads() throws Exception {

    }

    @Test
    public void test() throws Exception {
        String token = JwtToken.creatToken();
        System.out.println("token=" + token);

        Map<String, Claim> claims = JwtToken.verifyToken(token);
        String name = claims.get("name").asString();
        String age = claims.get("age").asString();
        String org = claims.get("org").asString();
        System.out.println("name=" + name + "------" + "age=" + age + "------" + "org=" + org);

        // 测试过期凭证
        String expireToken = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJvcmciOiLogZTlj4vnp5HmioAiLCJuYW1lIjoienhmZW5nIiwiZXhwIjoxNTg1MTA4Mzc2LCJpYXQiOjE1ODUxMDgzMTYsImFnZSI6IjI1In0.EQ3q1qK9nYUQrCg1009v1ph-MV8edMl_nZbpZaad6X4";
        JwtToken.verifyToken(expireToken);
    }

    @Test
    public void testList() throws Exception {
        List<Student> stuList = new ArrayList<Student>();
        stuList.add(new Student("S001", "张三", "女"));
        stuList.add(new Student("S002", "李四", "男"));
        stuList.add(new Student("S001", "张三", "女"));
        stuList.add(new Student("S002", "李四", "男"));
        stuList.add(new Student("S003", "王五", "男"));
        stuList.add(new Student("S004", "赵六", "女"));

        /**
         * 方法一：遍历实体类的每一个属性，
         */
        List<Student> newStus = new ArrayList<Student>();
        for (Student stu : stuList) {
            if (ObjectUtils.isEmpty(stuList)) {
                newStus.add(stu);
            }
            boolean isSame = false;
            for (Student s : newStus) {
                if (s.getStuId().equals(stu.getStuId()) && s.getStuName().equals(stu.getStuName()) && s.getSex().equals(stu.getSex())) {
                    isSame = true;
                    break;
                }
            }
            if (isSame == false) {
                newStus.add(stu);
            }
        }

        System.out.println(newStus);

        /**
         * 方法二：利用list中contains方法去重
         */
        List<Student> newList0 = new ArrayList<Student>();
        //使用contain判断，是否有相同的元素
        for (Student s : stuList) {
            if (!newList0.contains(s)) {
                newList0.add(s);
            }
        }
        //输出结果
        System.out.println(newList0);

        /**
         * 方法三：java 8中流式去重操作
         */
        List<Student> newList1 = stuList.stream().distinct().collect(Collectors.toList());
        //输出结果
        System.out.println(newList1.toString());
        /**
         * 方法四：HashSet去重
         */
        List<Student> newList2 = new ArrayList<Student>();
        //set去重
        HashSet<Student> set = new HashSet<>(stuList);
        newList2.addAll(set);
        System.out.println(newList2.toString());
    }

    /**
     * 冒泡排序
     *
     * @throws Exception
     */
    @Test
    public void bubbleSort() throws Exception {
        int[] a = {2, 7, 4, 6, 0, 8, 5, 1, 3, 9, 10};
        int i, j;
        for (i = 0; i < a.length; i++) {//表示 n 次排序过程。
            for (j = 1; j < a.length - i; j++) {
                if (a[j - 1] > a[j]) {//前面的数字大于后面的数字就交换
                    //交换 a[j-1]和a[j]
                    int temp;
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int v : a) {
            System.out.print(v + " ");
        }
    }

    @Test
    public void insertSort() throws Exception {
        int[] arr = {2, 7, 4, 6, 0, 8, 5, 1, 3, 9, 10};
        for (int i = 1; i < arr.length; i++) {
            //插入的数
            int insertVal = arr[i];
            //被插入的位置(准备和前一个数比较)
            int index = i - 1;
            //如果插入的数比被插入的数小
            while (index >= 0 && insertVal < arr[index]) {
                //将把arr[index] 向后移动
                arr[index + 1] = arr[index];
                //让 index 向前移动
                index--;
            }
            //把插入的数放入合适位置
            arr[index + 1] = insertVal;
        }
        for (int k : arr) {
            System.out.print(k + " ");
        }
    }

}
