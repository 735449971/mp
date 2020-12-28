//import org.junit.Test;
//
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class streamTest {
//
//    @Test
//    public static void main(String[] args) {
////        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
////        //遍历输出符合条件的元素
////        list.stream().filter(x -> x >6).forEach(System.out::println);
////
////        //匹配第一个
////        Optional<Integer> first = list.stream().filter(x -> x > 6).findFirst();
////
////        //匹配任意
////        Optional<Integer> any = list.parallelStream().filter(x -> x>0).findAny();
////
////        //是否包含符合特定条件的元素
////        boolean b = list.stream().anyMatch(x -> x < 6);
////
////
////        System.out.println("匹配第一个值：" + first.get());
////
////        System.out.println("匹配任意一个值：" + any.get());
////
////        System.out.println("是否存在大于6的值：" + b);
//
//
//        //案例一：筛选出Integer集合中大于7的元素，并打印出来
//
//        List<Integer> list = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
//        Stream<Integer> stream = list.stream();
//        stream.filter(x -> x > 7).forEach(System.out::println);
//
//
//        //案例二： 筛选员工中工资高于8000的人，并形成新的集合。 形成新集合依赖collect（收集），后文有详细介绍。
//
//        List<Person> personList = new ArrayList<Person>();
//        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
//        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
//        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
//        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
//        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
//        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
//
//
//        List<String> stringList = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
//        System.out.println("高于8000的员工姓名"+stringList);
//
//        //3.3 聚合（max/min/count)
//        //max、min、count这些字眼你一定不陌生，没错，在mysql中我们常用它们进行数据统计。Java stream中也引入了这些概念和用法，极大地方便了我们对集合、数组的数据统计工作。
//        //案例一：获取String集合中最长的元素。
//        List<String> strings = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
//
//        Optional<String> max = strings.stream().max(Comparator.comparing(String::length));
//
//        System.out.println("最长的字符串" +max.get());
//
//        //案例二：获取Integer集合中的最大值。
//        List<Integer> list3 = Arrays.asList(7, 6, 9, 4, 11, 6);
//        //自然排序
//        Optional<Integer> max1 = list3.stream().max(Integer::compareTo);
//
//        //自定义排序
//        list3.stream().max(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//
//                return o1.compareTo(o2);
//            }
//        });
//
//        System.out.println("自然排序的最大值"+max1.get());
//
//        System.out.println("自定义排序的最大值"+max1.get());
//
//        //案例三：获取员工工资最高的人。
//        Optional<Person> maxP = personList.stream().max(Comparator.comparingInt(Person::getSalary));
//
//        System.out.println("员工工资最大值："+maxP.get().getSalary());
//
//        long count = list.stream().filter(x -> x >= 6).count();
//
//        System.out.println("list 中大于等于6的元素个数："+ count);
//
//
//        //案例一：英文字符串数组的元素全部改为大写。整数数组每个元素+3。
//        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
//        List<String> collect = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
//
//        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
//        List<Integer> collect1 = intList.stream().map(x -> x + 3).collect(Collectors.toList());
//
//        System.out.println("每个元素大写"+collect);
//        System.out.println("原数组"+intList+"每个元素+3"+collect1);
//
//        //案例二：将员工的薪资全部增加10000。
//
//
//        // 不改变原来员工集合的方式
//        List<Person> personListNew = personList.stream().map(person -> {
//            Person personNew = new Person(person.getName(), 0, 0, null, null);
//            personNew.setSalary(person.getSalary() + 10000);
//            return personNew;
//        }).collect(Collectors.toList());
//
//        System.out.println("一次改动前"+personList.get(0).getName()+"----->"+personList.get(0).getSalary());
//        System.out.println("一次改动后"+personListNew.get(0).getName()+"----->"+personListNew.get(0).getSalary());
//
//
//        //改变原来员工集合的方式
//        List<Person> personListNew2 = personList.stream().map(person -> {
//            person.setSalary(person.getSalary() + 10000);
//            return person;
//        }).collect(Collectors.toList());
//        System.out.println("二次改动前"+personList.get(0).getName()+"-->"+personList.get(0).getSalary());
//        System.out.println("二次改动后"+personListNew2.get(0).getName()+"-->"+personListNew2.get(0).getSalary());
//
//        //案例三：将两个字符数组合并成一个新的字符数组。
//        List<String> liststr  = Arrays.asList("m,k,l,a", "1,3,5,7");
//        List<String> listNew  = liststr.stream().flatMap(s -> {
//            //将每个元素转换成一个stream
//            String[] split = s.split(",");
//            Stream<String> s2 = Arrays.stream(split);
//            return s2;
//        }).collect(Collectors.toList());
//
//        System.out.println("处理前的集合：" + liststr);
//        System.out.println("处理后的集合：" + listNew);
//
//
//        //3.5 归约(reduce) 归约，也称缩减，顾名思义，是把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操作。
//
//        //案例一：求Integer集合的元素之和、乘积和最大值。
//        List<Integer> listsn = Arrays.asList(1, 3, 2, 8, 11, 4);
//
//        //求和方式1
//        Optional<Integer> sum = listsn.stream().reduce((x, y) -> x + y);
//        //求和方式2
//        Optional<Integer> sum2 = listsn.stream().reduce(Integer::sum);
//        //求和方式3
//        Integer sum3 = listsn.stream().reduce(0, Integer::sum);
//
//
//        // 求乘积
//        Optional<Integer> product = listsn.stream().reduce((x, y) -> x * y);
//
//        // 求最大值方式1
//        Optional<Integer> max3 = listsn.stream().reduce((x, y) -> x > y ? x : y);
//
//        // 求最大值写法2
//        Integer max2 = listsn.stream().reduce(1, Integer::max);
//
//        System.out.println("listsn求和：" + sum.get() + "," + sum2.get() + "," + sum3);
//        System.out.println("listsn求积：" + product.get());
//        System.out.println("listsn求和：" + max3.get() + "," + max2);
//
//        // 求工资之和方式1：
//        Optional<Integer> sumSalary = personList.stream().map(Person::getSalary).reduce(Integer::sum);
//
//        //求工资之和方式2：
////        personList.stream().reduce(0,(sum,p)-> sum +p.getSalary(),(sum1,sum2) ->sum1+sum2);
//
//    }
//}
