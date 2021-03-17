package com.wei.code;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * java Stream流操作
 * 中间操作: filter() map() sorted() peek()
 * 终端操作: allMatch() anyMatch() noneMatch() forEach() collect() count()
 * <p>
 * 串行流: stream()
 * 并行流: parallelStream()
 * 1) 任务是否需要并行
 * 2) 任务之间是否独立 也就是一个任务不能依赖另一个任务
 * 3) 结果是否取决于调用顺序 如果任务顺序变了 结果是否改变
 *
 * <p>
 * Consumer  顾名思义，Consumer的意思就是消费，默认方法是 void accept(T t)【代表了接受一个输入参数并且无返回的操作】，流操作forEach() 就用到
 * Function  功能或者函数  ，默认方法是 R apply(T t)【接受一个输入参数，返回一个结果】  ，在流操作map()用到
 * Predicate  断言，默认方法是boolean test(T t)【接受一个输入参数，返回一个布尔值结果】，流操作filter() 用到
 * Supplier  提供、供应，默认方法是T get()【无参数，返回一个结果】
 * BiConsumer<T,U>   代表了一个接受两个输入参数的操作，并且不返回任何结果
 * BiFunction<T,U,R> 代表了一个接受两个输入参数的方法，并且返回一个结果
 * IntConsumer  接受一个int类型的输入参数，无返回值
 * IntToDoubleFunction  接受一个int类型输入，返回一个double类型结果
 * ToIntFunction  接受一个输入参数，返回一个int类型结果。
 */
public class JavaStream {

    @Test
    public void streamTest() {
        // 查询年龄大于20岁的所有的姓名
        List<String> nameList = studentList.stream().filter(m -> m.getAge() > 20).map(Student::getName).collect(Collectors.toList());
        System.out.println(nameList);
        // 查询年龄前2名的学生
        List<Student> list = studentList.stream().sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        }).limit(2).collect(Collectors.toList());
        System.out.println(list);
        // 查询性别是男的所有的数量
        long count = studentList.stream().filter(m -> "男".equals(m.getSex())).count();
        System.out.println(count);
        //打印所有的学生
        studentList.stream().forEach(System.out::println);
    }

    @Test
    public void parallelStreamTest() {
        // 并行流输出顺序改变了
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream()
                .forEach(System.out::print);
        System.out.println("");
        System.out.println("=========================");

        // 并行流时间 1037
        long start = System.currentTimeMillis();
        studentList.parallelStream().forEach(m -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("=========================");


        //串行流时间 4002
        start = System.currentTimeMillis();
        studentList.stream().forEach(m -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void optionalTest(){
        //Optional.orElse 如果不存在 那么取另一个 如果存在 返回value
        Student student = studentList.stream().filter(m ->"唱歌1".equals(m.getHobby())).findFirst().orElse(new Student());
        System.out.println(student);
        //如果value是空的 那么抛出异常NoSuchElementException
        System.out.println(studentList.stream().filter(m ->"唱歌".equals(m.getHobby())).findFirst().get());
    }

    public List<Student> studentList = new ArrayList() {
        {
            add(new Student() {
                {
                    setId(1);
                    setName("张三");
                    setAge(18);
                    setHobby("篮球");
                    setSex("男");
                }
            });
            add(new Student() {
                {
                    setId(2);
                    setName("李四");
                    setAge(20);
                    setHobby("唱歌");
                    setSex("男");
                }
            });
            add(new Student() {
                {
                    setId(3);
                    setName("王五");
                    setAge(25);
                    setHobby("跑步");
                    setSex("女");
                }
            });
            add(new Student() {
                {
                    setId(4);
                    setName("赵六");
                    setAge(17);
                    setHobby("喝水");
                    setSex("女");
                }
            });
        }
    };

    public class Student {
        private int id;
        private String name;
        private int age;
        private String sex;
        private String hobby;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", sex='" + sex + '\'' +
                    ", hobby='" + hobby + '\'' +
                    '}';
        }
    }
}
