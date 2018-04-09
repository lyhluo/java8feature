package m3_stream.f01;

import java.util.ArrayList;
import java.util.List;

/**
 ﻿Stream表示数据流，它没有数据结构，本身也不存储元素，其操作也不会改变源Stream，而是生成新Stream.作为一种操作数据的接口，它提供了过滤、排序、映射、规约等多种操作方法，这些方法按照返回类型被分为两类：凡是返回Stream类型的方法，称之为中间方法（中间操作），其余的都是完结方法（完结操作）。完结方法返回一个某种类型的值，而中间方法则返回新的Stream。中间方法的调用通常是链式的，该过程会形成一个管道，当完结方法被调用时会导致立即从管道中消费值，这里我们要记住：Stream的操作尽可能以“延迟”的方式运行，也就是我们常说的“懒操作”，这样有助于减少资源占用，提高性能。对于所有的中间操作（除sorted外）都是运行在延迟模式下。
 Stream不但提供了强大的数据操作能力，更重要的是Stream既支持串行也支持并行，并行使得Stream在多核处理器上有着更好的性能。
 Stream的使用过程有着固定的模式：
 1 创建Stream
 2 通过中间操作，对原始Stream进行“变化”并生成新的Stream
 3 使用完结操作，生成最终结果
 也就是
   创建——>变化——>完结
 */
public class demo01 {

    public static void main(String[] args) {
        //
        List<String> list = new ArrayList<>();
        list.add("a1");
        list.add("b2");
        list.add("c3");
        list.add("d4");
        list.add("e5");


        /**
         * 中间方法1 之过滤器Filter
         */
//        list.m3_stream().filter(s -> s.startsWith("1")).forEach(System.out::println);

        /**
         * 中间方法2 之排序sorted
         */
            // 默认排序
//        list.m3_stream().sorted().forEach(System.out::println);
            // 自定义排序
        list.stream().sorted((p1, p2) -> p2.compareTo(p1)).forEach(System.out::println);

        /**
         * 中间方法3 之映射map
         * 结合function接口, 该操作能将流对象中的每个元素映射为另一种元素, 实现元素类型的转换
         */
//        list.stream().map()
    }

}
